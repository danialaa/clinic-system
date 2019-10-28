package com.example.msadentistryclinic.models.classes;

public class CSterilizationTools extends CEquipment {
    private String sterilizationType;

    public CSterilizationTools(int equipmentID, int quantity, int price, boolean isAvailable, String type, String name, String sterilizationType) {
        super(equipmentID, quantity, price, isAvailable, type, name);
        this.sterilizationType = sterilizationType;
    }

    public CSterilizationTools() {
    }

    public String getSterilizationType() {
        return sterilizationType;
    }

    public void setSterilizationType(String sterilizationType) {
        this.sterilizationType = sterilizationType;
    }
}
