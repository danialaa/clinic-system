package com.example.clinicsystem.models.classes;

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
}
