package com.finartz.ticket.model;

/**
 * Created by promegalex on 12.03.2020 22:20
 */
public enum Gender {
    MALE("M"), FEMALE("F"), UNKNOWN("U");
    private String gender;

    Gender(String gender) {
        this.gender = gender;
    }

    public String getGender() {
        return this.gender;
    }
}
