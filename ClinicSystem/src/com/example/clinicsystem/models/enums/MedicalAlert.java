package com.example.clinicsystem.models.enums;

public enum MedicalAlert {
    ALLERGIES("Allergies", 1),
    HYPERTENSION("Hypertension", 2),
    DIABETES("Diabetes", 3),
    BLEEDING_DISORDERS("Bleeding Disorders", 4),
    DRUGS("Drugs", 5),
    CARDIOVASCULAR_DISEASES("Cardiovascular Diseases", 6),
    ANEMIA("Anemia", 7),
    ASTHMA("Asthma", 8),
    CANCER("Cancer", 9),
    BLOOD_PRESSURE("Blood Pressure", 10);

    private final String name;
    private final int id;

    MedicalAlert(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public static MedicalAlert getConstant(String name) {
        for (MedicalAlert medicalAlert : MedicalAlert.values()) {
            if (medicalAlert.getName().equals(name)) {
                return medicalAlert;
            }
        }

        return null;
    }
}
