package com.example.msadentistryclinic.models.classes;

import java.util.List;

public class CUserLink {
    private int userID, linkID;

    public CUserLink(int userID, int linkID) {
        this.userID = userID;
        this.linkID = linkID;
    }

    public CUserLink() {
    }

    public List<CLink> showUserLinks(CUserType userType) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
