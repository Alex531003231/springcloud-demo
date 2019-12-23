package com.lhb.hutoolexceldemo.domain;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * @author: Created By haibo.li01@hand-china.com
 * @time: 2019/12/6  17:25;
 * @description:
 */
public class Person {
    String name;
    Integer age;
    LocalDateTime time;

    public Person() {
    }

    public Person(String name, Integer age, LocalDateTime time) {
        this.name = name;
        this.age = age;
        this.time = time;
    }

    public Person(LocalDateTime time) {
        this.time = time;
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

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }
}
