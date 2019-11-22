package com.map.domain;

import com.map.util.ContactInfo;
import com.map.util.Entity;

public class Professor extends Entity<Integer> {
    private ContactInfo contactInfo;


    @Override
    public String toString() {
        return contactInfo.toString();
    }
}
