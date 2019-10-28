package com.example.msadentistryclinic.models.classes;

public class CLink {
    private int linkID;
    private String linkName, physicalLink;

    public CLink(int linkID, String linkName, String physicalLink) {
        this.linkID = linkID;
        this.linkName = linkName;
        this.physicalLink = physicalLink;
    }

    public CLink() {
    }

    public int getLinkID() {
        return linkID;
    }

    public void setLinkID(int linkID) {
        this.linkID = linkID;
    }

    public String getLinkName() {
        return linkName;
    }

    public void setLinkName(String linkName) {
        this.linkName = linkName;
    }

    public String getPhysicalLink() {
        return physicalLink;
    }

    public void setPhysicalLink(String physicalLink) {
        this.physicalLink = physicalLink;
    }
}
