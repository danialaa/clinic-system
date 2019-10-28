package com.example.msadentistryclinic.models.classes;

public class CDentalEngine extends CEquipment {
    private boolean isMaintained, isOccupied;
    private int roomID;

    public CDentalEngine(int equipmentID, int quantity, int price, boolean isAvailable, String type, String name, boolean isMaintained, boolean isOccupied, int roomID) {
        super(equipmentID, quantity, price, isAvailable, type, name);
        this.isMaintained = isMaintained;
        this.isOccupied = isOccupied;
        this.roomID = roomID;
    }

    public CDentalEngine() {
    }

    public boolean isMaintained() {
        return isMaintained;
    }

    public void setMaintained(boolean maintained) {
        isMaintained = maintained;
    }

    public boolean isOccupied() {
        return isOccupied;
    }

    public void setOccupied(boolean occupied) {
        isOccupied = occupied;
    }

    public int getRoomID() {
        return roomID;
    }

    public void setRoomID(int roomID) {
        this.roomID = roomID;
    }
}
