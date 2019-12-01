package com.example.clinicsystem.models.enums;

public enum DentistryDepartment {
    DIAGNOSIS("Diagnosis", 1),
    OPERATIVE("Operative", 2),
    ENDODONTICS("Endodontics", 3),
    REMOVABLE_PROSTH("Removable Prosth", 4),
    PERIODONTICS("Periodontics", 5),
    SURGERY("Surgery", 6),
    CROWN_AND_BRIDGE("Crown and Bridge", 7),
    PEDODONTICS("Pedodontics", 8),
    POST_GRADUATE("Post Graduate", 9);

    private final String name;
    private final int id;

    DentistryDepartment(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }
}
