package com.example.msadentistryclinic.models.classes;

import com.example.msadentistryclinic.models.enums.Tooth;

public class CLabOrderDetail extends CDetail{
    private Tooth tooth;
    private String acrylicShade, dentureBaseMaterial, specialTray, biteBlock, acrylicDenture, tryIn, delivery;
    private boolean isNeedAcrylicRepair, isNeedDentureRelining;

    public CLabOrderDetail(int detailID, int parentID, Tooth tooth, String acrylicShade, String dentureBaseMaterial, String specialTray, String biteBlock, String acrylicDenture, String tryIn, String delivery, boolean isNeedAcrylicRepair, boolean isNeedDentureRelining) {
        super(detailID, parentID);
        this.tooth = tooth;
        this.acrylicShade = acrylicShade;
        this.dentureBaseMaterial = dentureBaseMaterial;
        this.specialTray = specialTray;
        this.biteBlock = biteBlock;
        this.acrylicDenture = acrylicDenture;
        this.tryIn = tryIn;
        this.delivery = delivery;
        this.isNeedAcrylicRepair = isNeedAcrylicRepair;
        this.isNeedDentureRelining = isNeedDentureRelining;
    }

    public CLabOrderDetail() {
    }

    public Tooth getTooth() {
        return tooth;
    }

    public void setTooth(Tooth tooth) {
        this.tooth = tooth;
    }

    public String getAcrylicShade() {
        return acrylicShade;
    }

    public void setAcrylicShade(String acrylicShade) {
        this.acrylicShade = acrylicShade;
    }

    public String getDentureBaseMaterial() {
        return dentureBaseMaterial;
    }

    public void setDentureBaseMaterial(String dentureBaseMaterial) {
        this.dentureBaseMaterial = dentureBaseMaterial;
    }

    public String getSpecialTray() {
        return specialTray;
    }

    public void setSpecialTray(String specialTray) {
        this.specialTray = specialTray;
    }

    public String getBiteBlock() {
        return biteBlock;
    }

    public void setBiteBlock(String biteBlock) {
        this.biteBlock = biteBlock;
    }

    public String getAcrylicDenture() {
        return acrylicDenture;
    }

    public void setAcrylicDenture(String acrylicDenture) {
        this.acrylicDenture = acrylicDenture;
    }

    public String getTryIn() {
        return tryIn;
    }

    public void setTryIn(String tryIn) {
        this.tryIn = tryIn;
    }

    public String getDelivery() {
        return delivery;
    }

    public void setDelivery(String delivery) {
        this.delivery = delivery;
    }

    public boolean isNeedAcrylicRepair() {
        return isNeedAcrylicRepair;
    }

    public void setNeedAcrylicRepair(boolean needAcrylicRepair) {
        isNeedAcrylicRepair = needAcrylicRepair;
    }

    public boolean isNeedDentureRelining() {
        return isNeedDentureRelining;
    }

    public void setNeedDentureRelining(boolean needDentureRelining) {
        isNeedDentureRelining = needDentureRelining;
    }
}
