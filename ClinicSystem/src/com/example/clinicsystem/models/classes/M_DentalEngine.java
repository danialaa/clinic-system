package com.example.clinicsystem.models.classes;

import com.example.clinicsystem.helpers.DatabaseConnection;
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

    public int addEngine() {
        DatabaseConnection databaseConnection = DatabaseConnection.getINSTANCE();

        int main = 0, occu = 0;

        if(this.isMaintained) {
            main = 1;
        }
        if(this.isOccupied) {
            occu = 1;
        }

        return databaseConnection.insertInto("dental_engine", "(Equipment_ID, Engine_IsMaintained, Engine_IsOccupied, Engine_Room)",
                "('" + this.getId() + "', '" + main + "', '" + occu + "', '" + this.roomID + "')");
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
