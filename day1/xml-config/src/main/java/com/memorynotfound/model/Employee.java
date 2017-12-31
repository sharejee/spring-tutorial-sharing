package com.memorynotfound.model;

/**
 * Created by : Ron Rith
 * Create Date: 12/31/2017.
 */
public class Employee {
    private Integer id;
    private String name;
    private Integer age;
    private String department;

    public Employee(Integer id, String name, Integer age, String department) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.department = department;
    }

    public Employee() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
}
