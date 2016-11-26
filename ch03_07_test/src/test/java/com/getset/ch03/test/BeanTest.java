package com.getset.ch03.test;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * 测试类。
 * Created by Kang on 2016/11/26 0026.
 */
// 在Junit环境下提供Spring TestContext Framework的功能
@RunWith(SpringJUnit4ClassRunner.class)
// 用来加载配置ApplicationContext，classes属性用来加载配置类。
@ContextConfiguration(classes = {TestConfig.class})
// 声明活动的profile
@ActiveProfiles("dev")
public class BeanTest {
    // 注入Bean
    @Autowired
    private TestBean testBean;

    @Test
    public void devBeanShouldInjected() {
        String expected = "dev env.";
        String actual = testBean.getContent();
        Assert.assertEquals(expected, actual);
    }
}
