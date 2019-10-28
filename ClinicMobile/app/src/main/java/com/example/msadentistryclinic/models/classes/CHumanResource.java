package com.example.msadentistryclinic.models.classes;

import java.util.List;

public class CHumanResource extends CEmployee {
    public CHumanResource() {
    }

    public void writeInvoice(CInvoice invoice) {
    }

    public boolean isRefundable(int invoiceID) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void addTrip(CTrip trip) {
    }

    public List<CEquipment> searchEquipment() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public List<CInvoice> searchInvoice() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public List<CTrip> searchTrip() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
