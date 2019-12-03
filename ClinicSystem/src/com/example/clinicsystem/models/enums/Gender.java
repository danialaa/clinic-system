package com.example.clinicsystem.models.enums;

public enum Gender {
    FEMALE("Female", 2),
    MALE("Male", 1);

    private final String name;
    private final int id;

    Gender(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public static Gender getConstant(String name) {
        for (Gender gender : Gender.values()) {
            if (gender.getName().equals(name)) {
                return gender;
            }
        }

        return null;
    }
}
