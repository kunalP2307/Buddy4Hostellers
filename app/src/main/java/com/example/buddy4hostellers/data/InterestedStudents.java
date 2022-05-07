package com.example.buddy4hostellers.data;

import java.io.Serializable;
import java.util.List;

public class InterestedStudents implements Serializable {

    private List<Student> students;

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public InterestedStudents(List<Student> students) {
        this.students = students;
    }

    public InterestedStudents(){

    }

}
