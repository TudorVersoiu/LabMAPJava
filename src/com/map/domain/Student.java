package com.map.domain;

import com.map.util.ContactInfo;
import com.map.util.Entity;

public class Student<ID> extends Entity<ID> {
    private Integer group;
    private String supervisor_name;

    private ContactInfo contact_info;

    public Student(ID id, Integer group, String supervisor_name, ContactInfo contact_info) {
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
        return "STUDENT, ID: " + Integer.toString(group) +
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
