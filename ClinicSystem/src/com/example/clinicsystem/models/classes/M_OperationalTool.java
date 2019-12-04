package com.example.clinicsystem.models.classes;

import com.example.clinicsystem.helpers.DatabaseConnection;
import com.example.clinicsystem.models.enums.EquipmentType;

public class M_OperationalTool extends M_Equipment {
    private boolean isSterlized, isReusable;

    public M_OperationalTool(String name, EquipmentType equipmentType, int price, int id, int quantity, boolean isAvailable, boolean isSterlized, boolean isReusable) {
        super(name, equipmentType, price, id, quantity, isAvailable);
        this.isSterlized = isSterlized;
        this.isReusable = isReusable;
    }

    public M_OperationalTool() {
    }

    public int addOperational() {
        DatabaseConnection databaseConnection = DatabaseConnection.getINSTANCE();

        int ster = 0, reuse = 0;

        if(this.isSterlized) {
            ster = 1;
        }
        if(this.isReusable) {
            reuse = 1;
        }

        return databaseConnection.insertInto("operational_tool", "(Equipment_ID, Operational_IsSterlized, Operational_IsReusable)",
                "('" + this.getId() + "', '" + ster + "', '" + reuse + "')");
    }

    public boolean isSterlized() {
        return isSterlized;
    }

    public void setSterlized(boolean sterlized) {
        isSterlized = sterlized;
    }

    public boolean isReusable() {
        return isReusable;
    }

    public void setReusable(boolean reusable) {
        isReusable = reusable;
    }
}
