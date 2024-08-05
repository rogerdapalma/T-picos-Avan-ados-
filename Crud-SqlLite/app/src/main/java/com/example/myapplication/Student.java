package com.example.myapplication;


public class Student {
    private int id;
    private String name;
    private String cpf;
    private String phone;
    private int age;

    public Student(int id, String name, String cpf, String phone, int age) {
        this.id = id;
        this.name = name;
        this.cpf = cpf;
        this.phone = phone;
        this.age = age;
    }


public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
