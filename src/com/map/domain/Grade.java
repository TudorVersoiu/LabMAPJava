package com.map.domain;

import com.map.util.Entity;
import java.util.Date;


public class Grade extends Entity<Integer> {
    private Date date;
    private Student student;
    private Assignment assignment;
    private Integer value;

    public Grade(Date date, Student student, Assignment assignment, Integer value) {
        this.date = date;
        this.student = student;
        this.assignment = assignment;
        this.value = value;
    }
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Assignment getAssignment() {
        return assignment;
    }

    public void setAssignment(Assignment assignment) {
        this.assignment = assignment;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }
}
