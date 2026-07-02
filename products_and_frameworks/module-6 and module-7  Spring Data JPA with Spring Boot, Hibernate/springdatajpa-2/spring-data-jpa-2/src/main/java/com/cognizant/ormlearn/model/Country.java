package com.cognizant.ormlearn.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * Entity mapping for the 'country' table.
 * Used in Hands-on 1 - Query Methods on Country.
 */
@Entity
public class Country {

    @Id
    private String code;


    private String name;

    // ── Getters & Setters ─────────────────────────────────────────────────────

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Country{code='" + code + "', name='" + name + "'}";
    }
}
