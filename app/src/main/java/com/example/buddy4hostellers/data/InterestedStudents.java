package com.example.buddy4hostellers.data;

public class InterestedStudents {

    private Student[] students;

    public InterestedStudents(){

    }

    public InterestedStudents(Student[] students) {
        this.students = students;
    }

    public Student[] getStudents() {
        return students;
    }

    public void setStudents(Student[] students) {
        this.students = students;
    }
}
