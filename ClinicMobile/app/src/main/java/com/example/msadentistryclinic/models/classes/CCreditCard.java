package com.example.msadentistryclinic.models.classes;

public class CCreditCard {
    private int creditCardNumber, SVV;
    private String expirationDate, bankName;

    public CCreditCard(int creditCardNumber, int SVV, String expirationDate, String bankName) {
        this.creditCardNumber = creditCardNumber;
        this.SVV = SVV;
        this.expirationDate = expirationDate;
        this.bankName = bankName;
    }

    public CCreditCard() {
    }

    public int getCreditCardNumber() {
        return creditCardNumber;
    }

    public void setCreditCardNumber(int creditCardNumber) {
        this.creditCardNumber = creditCardNumber;
    }

    public int getSVV() {
        return SVV;
    }

    public void setSVV(int SVV) {
        this.SVV = SVV;
    }

    public String getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }
}
