package com.getset.ch04.mvcconfig.domain;

/**
 * SpringMVC数据对象
 * Created by Kang on 2017/2/12.
 */
public class DemoObj {
    private Long id;
    private String name;

    // jackson对对象和json做转换时必须有次空构造函数。
    public DemoObj() {
        super();
    }

    public DemoObj(Long id, String name) {
        super();
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
