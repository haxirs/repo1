package com.itheima.builder;

public class BuilderTest {
    public static void main(String[] args) {
        Student s = new Student.Builder().age(12).english("English").math("Math").build();

        System.out.println(s);
    }
}
