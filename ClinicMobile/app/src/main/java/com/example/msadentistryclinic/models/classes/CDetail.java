package com.example.msadentistryclinic.models.classes;

public class CDetail {
    protected int detailID, parentID;

    public CDetail(int detailID, int parentID) {
        this.detailID = detailID;
        this.parentID = parentID;
    }

    public CDetail() {
    }

    public int getDetailID() {
        return detailID;
    }

    public void setDetailID(int detailID) {
        this.detailID = detailID;
    }

    public int getParentID() {
        return parentID;
    }

    public void setParentID(int parentID) {
        this.parentID = parentID;
    }
}
