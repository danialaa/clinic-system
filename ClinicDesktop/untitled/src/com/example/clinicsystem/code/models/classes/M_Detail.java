package com.example.clinicsystem.code.models.classes;

public class M_Detail {
    protected int detailID, parentID;

    public M_Detail(int detailID, int parentID) {
        this.detailID = detailID;
        this.parentID = parentID;
    }

    public M_Detail() {
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
