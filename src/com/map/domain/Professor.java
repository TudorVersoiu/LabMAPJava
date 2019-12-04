package com.map.domain;

import com.map.util.ContactInfo;
import com.map.util.Entity;

public class Professor extends Entity<Integer> {
    private ContactInfo contactInfo;

    Professor(Integer id, ContactInfo personalInfo) {
        contactInfo = personalInfo;
        setId(id);
    }

    Professor(Integer id, String name, String surname, String email) {
        contactInfo = new ContactInfo(name, surname, email);
        setId(id);
    }

    @Override
    public String toString() {
        return contactInfo.toString();
    }
}
