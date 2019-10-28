package com.example.msadentistryclinic.models.classes;

import com.example.msadentistryclinic.models.interfaces.IAddDetail;

public class CInvoice implements IAddDetail {
    private int ledgerID, total, issuerID, holderID;
    private boolean isPaid;
    private String issuingDate, paymentMethod, dueDate;

    @Override
    public void addDetail(CDetail detail) {

    }

    public CInvoice(int ledgerID, int total, int issuerID, int holderID, boolean isPaid, String issuingDate, String paymentMethod, String dueDate) {
        this.ledgerID = ledgerID;
        this.total = total;
        this.issuerID = issuerID;
        this.holderID = holderID;
        this.isPaid = isPaid;
        this.issuingDate = issuingDate;
        this.paymentMethod = paymentMethod;
        this.dueDate = dueDate;
    }

    public CInvoice() {
    }

    public int getLedgerID() {
        return ledgerID;
    }

    public void setLedgerID(int ledgerID) {
        this.ledgerID = ledgerID;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getIssuerID() {
        return issuerID;
    }

    public void setIssuerID(int issuerID) {
        this.issuerID = issuerID;
    }

    public int getHolderID() {
        return holderID;
    }

    public void setHolderID(int holderID) {
        this.holderID = holderID;
    }

    public boolean isPaid() {
        return isPaid;
    }

    public void setPaid(boolean paid) {
        isPaid = paid;
    }

    public String getIssuingDate() {
        return issuingDate;
    }

    public void setIssuingDate(String issuingDate) {
        this.issuingDate = issuingDate;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }
}
