package com.getset.jpa.specs;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.ReflectionUtils;
import org.springframework.util.StringUtils;

import javax.persistence.EntityManager;
import javax.persistence.criteria.*;
import javax.persistence.metamodel.Attribute;
import javax.persistence.metamodel.EntityType;
import javax.persistence.metamodel.SingularAttribute;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import static com.google.common.collect.Iterables.toArray;

/**
 * Specification.
 * Created by kang on 17-2-26.
 */
public class CustomSpecs {

    // 由于使用的是泛型，所以这个方法得到的Specification是可以用于任意实体类的。
    public static <T> Specification<T> byAuto(final EntityManager entityManager, final T example) {
        // 获得实体类对象的类型
        final Class<T> type = (Class<T>)example.getClass();
        return new Specification<T>() {
            @Override
            public Predicate toPredicate(Root<T> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                // 列表用于存储构造的查询条件
                List<Predicate> predicates = new ArrayList<>();

                // 获得实体类的EntityType，可以从中得到实体类的属性
                EntityType<T> entity = entityManager.getMetamodel().entity(type);

                // 对实体类的所有属性进行循环
                for (Attribute<T, ?> attr : entity.getDeclaredAttributes()) {
                    // 获得属性值
                    Object attrValue = getValue(example, attr);
                    if (attrValue != null) {
                        if (attr.getJavaType() == String.class) {
                            if (!StringUtils.isEmpty(attrValue)) {
                                predicates.add(criteriaBuilder.like(root.get(attribute(entity, attr.getName(), String.class)), pattern((String)attrValue)));
                            }
                        } else {
                            predicates.add(criteriaBuilder.equal(root.get(attribute(entity, attr.getName(), attrValue.getClass())), attrValue));
                        }
                    }
                }

                // 将条件列表转换成Predicate
                return predicates.isEmpty() ? criteriaBuilder.conjunction() : criteriaBuilder.and(toArray(predicates, Predicate.class));
            }

            /**
             * 通过反射获得实体类对象对应属性的值。
             * @param example
             * @param attr
             * @param <T>
             * @return
             */
            private <T> Object getValue(T example, Attribute<T, ?> attr) {
                return ReflectionUtils.getField((Field) attr.getJavaMember(), example);
            }

            /**
             * 获得实体类当前属性的SingularAttribute，其包含的是实体类的某个单独属性。
             * @param entity
             * @param fieldName
             * @param fieldClass
             * @param <E>
             * @param <T>
             * @return
             */
            private <E, T> SingularAttribute<T, E> attribute(EntityType<T> entity, String fieldName, Class<E> fieldClass) {
                return entity.getDeclaredSingularAttribute(fieldName, fieldClass);
            }

        };
    }


    /**
     * 构造like的查询模式，即前后加%。
     */
    static private String pattern(String str) {
        return "%" + str + "%";
    }
}
