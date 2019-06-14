package com.itheima.builder;

public class Student {
    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", sex='" + sex + '\'' +
                ", password='" + password + '\'' +
                ", math='" + math + '\'' +
                ", english='" + english + '\'' +
                ", grade='" + grade + '\'' +
                '}';
    }

    private String name;
    private int age;
    private String sex;
    private String password;
    private String math;
    private String english;
    private String grade;

    public Student() {
    }

    private Student(Student orgin){
        this.name = orgin.name;
        this.age = orgin.age;
        this.sex =orgin.sex;
        this.password = orgin.password;
        this.math = orgin.math;
        this.english = orgin.english;
        this.grade = orgin.grade;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getSex() {
        return sex;
    }

    public String getPassword() {
        return password;
    }

    public String getMath() {
        return math;
    }

    public String getEnglish() {
        return english;
    }

    public String getGrade() {
        return grade;
    }

    public static class Builder{
        private Student target;

        public Builder(){
            target = new Student();
        }

        public Builder name(String name){
            this.target.name = name;
            return this;
        }

        public Builder age(int age){
            this.target.age = age;
            return this;
        }

        public Builder sex(String sex){
            this.target.sex = sex;
            return this;
        }

        public Builder password(String password){
            this.target.password = password;
            return this;
        }

        public Builder math(String math){
            this.target.math = math;
            return this;
        }

        public Builder english(String english){
            this.target.english = english;
            return this;
        }

        public Builder grade(String grade){
            this.target.grade = grade;
            return this;
        }

        public Student build(){
            return new Student(target);
        }
    }
}
