package com.example.clinicsystem.models.enums;

public enum EquipmentType {
    DRUG("Drug"),
    DENTAL_ENGINE("Dental Engine"),
    OPERATIONAL_TOOL("Operational Tool"),
    STERLIZATION_TOOL("Sterlization Tool");

    private final String name;

    EquipmentType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static EquipmentType getConstant(String name) {
        for(EquipmentType equipmentType : EquipmentType.values()) {
            if(equipmentType.getName().equals(name)) {
                return equipmentType;
            }
        }
        return null;
    }
}
