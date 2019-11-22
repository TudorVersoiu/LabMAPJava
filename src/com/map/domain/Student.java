package com.map.domain;

import com.map.util.ContactInfo;
import com.map.util.Entity;

public class Student extends Entity<Integer> {
    private Integer group;
    private String supervisor_name;
    private ContactInfo contact_info;

    public Student(Integer id, java.lang.Integer group, String supervisor_name, ContactInfo contact_info) {
        this.group = group;
        this.supervisor_name = supervisor_name;
        this.setContact_info(contact_info);
        setId(id);
    }

    public Integer getGroup() {
        return this.group;
    }

    public String getSupervisorName() {
        return this.supervisor_name;
    }

    @Override
    public String toString() {
        return "STUDENT, ID: " + group +
                "Supervisor" + supervisor_name +
                "Contact: " + getContact_info();
    }

    @Override
    public int hashCode() {
        return toString().hashCode();
    }

    public ContactInfo getContact_info() {
        return contact_info;
    }

    public void setContact_info(ContactInfo contact_info) {
        this.contact_info = contact_info;
    }
}
