package com.map.domain;

import com.map.util.Entity;
import java.util.Date;


public class Grade extends Entity<Integer> {
    private Date date;
    private Integer studentID;
    private Integer assignmentID;
    private Integer professorID;
    private Integer value;

    public Grade(Date date, Integer studentID, Integer assignmentID, Integer professorID, Integer value) {
        this.date = date;
        this.studentID = studentID;
        this.assignmentID = assignmentID;
        this.professorID = professorID;
        this.value = value;
    }
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Integer getStudentID() {
        return studentID;
    }

    public void setStudentID(Integer studentID) {
        this.studentID = studentID;
    }

    public Integer getAssignmentID() {
        return assignmentID;
    }

    public void setAssignmentID(Integer assignmentID) {
        this.assignmentID = assignmentID;
    }

    public Integer getProfessorID() {
        return professorID;
    }

    public void setProfessorID(Integer professorID) {
        this.professorID = professorID;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }
}
