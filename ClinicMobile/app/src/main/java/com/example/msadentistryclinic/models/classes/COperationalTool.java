package com.example.msadentistryclinic.models.classes;

public class COperationalTool extends CEquipment {
    private boolean isSterlized, isReusable;

    public COperationalTool(int equipmentID, int quantity, int price, boolean isAvailable, String type, String name, boolean isSterlized, boolean isReusable) {
        super(equipmentID, quantity, price, isAvailable, type, name);
        this.isSterlized = isSterlized;
        this.isReusable = isReusable;
    }

    public COperationalTool() {
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
