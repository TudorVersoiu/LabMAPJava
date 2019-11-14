package com.map.util;

/**
 * Class to handle id's within the elements in a repository
 * @param <ID> data type of identity
 */
public class Entity<ID> {
    private ID id;

    public ID getId() {
        return this.id;
    }

    public void setId(ID new_id) {
        this.id = new_id;
    }
}
