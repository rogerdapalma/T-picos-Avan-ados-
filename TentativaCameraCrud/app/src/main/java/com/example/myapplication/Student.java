package com.example.myapplication;

public class Student {
    private int id;
    private String name;
    private String cpf;
    private String phone;
    private String age;
    private String photo;

    // Construtor completo com ID (para update)
    public Student(int id, String name, String cpf, String phone, String age, String photo) {
        this.id = id;
        this.name = name;
        this.cpf = cpf;
        this.phone = phone;
        this.age = age;
        this.photo = photo;
    }

    // Construtor sem ID (para insert)
    public Student(String name, String cpf, String phone, String age, String photo) {
        this.name = name;
        this.cpf = cpf;
        this.phone = phone;
        this.age = age;
        this.photo = photo;
    }

    // Construtor vazio (caso seja necessário)
    public Student() {
    }

    // Getters e Setters
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

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }
}