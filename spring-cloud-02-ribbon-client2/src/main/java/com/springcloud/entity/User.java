package com.springcloud.entity;

/**
 * Created by yxf on 2017/9/10.
 */
public class User {

    private String id;
    private String age;
    private String name;

    public User() {
    }

    public User(String id, String age, String name) {
        this.id = id;
        this.age = age;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
