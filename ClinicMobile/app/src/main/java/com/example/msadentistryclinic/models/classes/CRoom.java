package com.example.msadentistryclinic.models.classes;

import com.example.msadentistryclinic.models.enums.DentistryDepartment;

import java.util.List;

public class CRoom {
    private int roomID, patientCapacity, floor;
    private List<Integer> occupiedEngines;
    private String roomName;
    private DentistryDepartment department;

    public CRoom(int roomID, int patientCapacity, int floor, List<Integer> occupiedEngines, String roomName, DentistryDepartment department) {
        this.roomID = roomID;
        this.patientCapacity = patientCapacity;
        this.floor = floor;
        this.occupiedEngines = occupiedEngines;
        this.roomName = roomName;
        this.department = department;
    }

    public CRoom() {
    }

    public int getRoomID() {
        return roomID;
    }

    public void setRoomID(int roomID) {
        this.roomID = roomID;
    }

    public int getPatientCapacity() {
        return patientCapacity;
    }

    public void setPatientCapacity(int patientCapacity) {
        this.patientCapacity = patientCapacity;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public List<Integer> getOccupiedEngines() {
        return occupiedEngines;
    }

    public void setOccupiedEngines(List<Integer> occupiedEngines) {
        this.occupiedEngines = occupiedEngines;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public DentistryDepartment getDepartment() {
        return department;
    }

    public void setDepartment(DentistryDepartment department) {
        this.department = department;
    }

    public void addDentalEngine(CDentalEngine dentalEngine) {
    }
}
