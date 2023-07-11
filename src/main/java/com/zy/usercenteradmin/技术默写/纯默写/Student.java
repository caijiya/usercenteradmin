package com.zy.usercenteradmin.技术默写.纯默写;

import lombok.Data;

import java.util.Collections;
import java.util.HashSet;
import java.util.Objects;

@Data
public class Student {
    private String name;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(name, student.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    public static void main(String[] args) {
        Student s1 = new Student();
        s1.setName("zy1");
        Student s2 = new Student();
        s2.setName("zy1");
        System.out.println(s1.equals(s2));

        HashSet<Object> set = new HashSet<>();
        set.add(s1);
        set.add(s2);
        System.out.println(set.size());
    }
}
