package com.example.msadentistryclinic.models.classes;

public class CInvoiceDetail extends CDetail {
    private int quantity, equipmentID;

    public CInvoiceDetail(int detailID, int parentID, int quantity, int equipmentID) {
        super(detailID, parentID);
        this.quantity = quantity;
        this.equipmentID = equipmentID;
    }

    public CInvoiceDetail() {
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getEquipmentID() {
        return equipmentID;
    }

    public void setEquipmentID(int equipmentID) {
        this.equipmentID = equipmentID;
    }

    public void addEquipment(CEquipment equipment) {
    }
}
