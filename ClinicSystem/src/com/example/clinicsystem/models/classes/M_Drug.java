package com.example.clinicsystem.models.classes;

import com.example.clinicsystem.helpers.DatabaseConnection;
import com.example.clinicsystem.models.enums.EquipmentType;

public class M_Drug extends M_Equipment {
    private String expiryDate, productionDate;

    public M_Drug(String name, EquipmentType equipmentType, int price, int id, int quantity, boolean isAvailable, String expiryDate, String productionDate) {
        super(name, equipmentType, price, id, quantity, isAvailable);
        this.expiryDate = expiryDate;
        this.productionDate = productionDate;
    }

    public M_Drug() {
    }

    public int addDrug() {
        DatabaseConnection databaseConnection = DatabaseConnection.getINSTANCE();

        return databaseConnection.insertInto("drug", "(Equipment_ID, Drug_ExpiryDate, Drug_ProductionDate)",
                "('" + this.getId() + "', '" + this.expiryDate + "', '" + this.productionDate + "')");
    }

    public String getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(String expiryDate) {
        this.expiryDate = expiryDate;
    }

    public String getProductionDate() {
        return productionDate;
    }

    public void setProductionDate(String productionDate) {
        this.productionDate = productionDate;
    }
}
