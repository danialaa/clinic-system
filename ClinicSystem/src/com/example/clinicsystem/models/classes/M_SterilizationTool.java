package com.example.clinicsystem.models.classes;

import com.example.clinicsystem.helpers.DatabaseConnection;
import com.example.clinicsystem.models.enums.EquipmentType;

public class M_SterilizationTool extends M_Equipment {
    private String sterilizationType;

    public M_SterilizationTool(String name, EquipmentType equipmentType, int price, int id, int quantity, boolean isAvailable, String sterilizationType) {
        super(name, equipmentType, price, id, quantity, isAvailable);
        this.sterilizationType = sterilizationType;
    }

    public M_SterilizationTool() {
    }

    public int addSterilization() {
        DatabaseConnection databaseConnection = DatabaseConnection.getINSTANCE();

        return databaseConnection.insertInto("sterilization_tool", "(Equipment_ID, Sterilization_Type)",
                "('" + this.getId() + "', '" + this.sterilizationType + "')");
    }

    public String getSterilizationType() {
        return sterilizationType;
    }

    public void setSterilizationType(String sterilizationType) {
        this.sterilizationType = sterilizationType;
    }
}
