package com.example.clinicsystem.models.classes;

import com.example.clinicsystem.models.enums.EquipmentType;

public class M_DentalEngine extends M_Equipment {
    private boolean isMaintained, isOccupied;
    private int roomID;

    public M_DentalEngine(String name, EquipmentType equipmentType, int price, int id, int quantity,
                          boolean isAvailable, boolean isMaintained, boolean isOccupied, int roomID) {
        super(name, equipmentType, price, id, quantity, isAvailable);
        this.isMaintained = isMaintained;
        this.isOccupied = isOccupied;
        this.roomID = roomID;
    }

    public M_DentalEngine() {
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
