package com.kuce2k15.alert;

public class Friends {
    public Friends(String mName, String mPhone) {
        this.mName = mName;
        this.mPhone = mPhone;
    }

    public Friends() {
    }

    private int mID;
    private String mName;
    private String mPhone;

    public int getmID() {
        return mID;
    }

    public void setmID(int mID) {
        this.mID = mID;
    }

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public String getmPhone() {
        return mPhone;
    }

    public void setmPhone(String mPhone) {
        this.mPhone = mPhone;
    }

    public Friends(int mID, String mName, String mPhone) {
        this.mID = mID;
        this.mName = mName;
        this.mPhone = mPhone;
    }
}
