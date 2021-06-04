package com.example.sqlite_1st.Model;

public class Person {
    private int mID;
    private String mName;
    private int mAge;
    private int mPhone;
    private String mAddress;

    public Person() {
    }

    public Person(int mID, String mName, int mAge, int mPhone, String mAddress) {
        this.mID = mID;
        this.mName = mName;
        this.mAge = mAge;
        this.mPhone = mPhone;
        this.mAddress = mAddress;
    }

    public Person(String mName, int mAge, int mPhone, String mAddress) {
        this.mName = mName;
        this.mAge = mAge;
        this.mPhone = mPhone;
        this.mAddress = mAddress;
    }

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

    public int getmAge() {
        return mAge;
    }

    public void setmAge(int mAge) {
        this.mAge = mAge;
    }

    public int getmPhone() {
        return mPhone;
    }

    public void setmPhone(int mPhone) {
        this.mPhone = mPhone;
    }

    public String getmAddress() {
        return mAddress;
    }

    public void setmAddress(String mAddress) {
        this.mAddress = mAddress;
    }
}
