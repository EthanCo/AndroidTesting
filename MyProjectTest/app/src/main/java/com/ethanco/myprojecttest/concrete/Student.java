package com.ethanco.myprojecttest.concrete;

/**
 * Created by EthanCo on 2016/8/24.
 */
public class Student {
    public int id;
    public String name;

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
