package com.example.demo.Lab_3.Part1;


public class Student {
    Long  id;
    String name;
    String surname;
    int exam;
    String mark;

    public Student(Long id, String name, String surname, int exam, String mark){
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.exam = exam;
        this.mark = mark;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public int getExam() {
        return exam;
    }

    public String getMark() {
        return mark;
    }

}

