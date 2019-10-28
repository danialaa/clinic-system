package com.example.msadentistryclinic.models.classes;

public class CDrug extends CEquipment {
    private String expiryDate, productionDate;

    public CDrug(int equipmentID, int quantity, int price, boolean isAvailable, String type, String name, String expiryDate, String productionDate) {
        super(equipmentID, quantity, price, isAvailable, type, name);
        this.expiryDate = expiryDate;
        this.productionDate = productionDate;
    }

    public CDrug() {
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
