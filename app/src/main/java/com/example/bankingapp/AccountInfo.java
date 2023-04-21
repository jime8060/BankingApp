package com.example.bankingapp;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.example.bankingapp.db.BankAppDatabase;

@Entity(tableName = BankAppDatabase.ACCOUNT_INFO)
public class AccountInfo {
    @PrimaryKey(autoGenerate = true)
    private int mAccountNum;

    public int getAccountNum() {
        return mAccountNum;
    }

    public void setAccountNum(int accountNum) {
        mAccountNum = accountNum;
    }

    private String mFullName;
    private int mStreetNum;
    private String mAddressStreet;

    private String mEmail;

    private int mUserId;

    private String mUsername;

    public AccountInfo(String fullName, int streetNum, String addressStreet, String email, int userId, String username) {
        mFullName = fullName;
        mStreetNum = streetNum;
        mAddressStreet = addressStreet;
        mEmail = email;
        mUserId = userId;
        mUsername = username;
    }



    public String getFullName() {
        return mFullName;
    }

    public void setFullName(String fullName) {
        mFullName = fullName;
    }

    public int getStreetNum() {
        return mStreetNum;
    }

    public void setStreetNum(int streetNum) {
        mStreetNum = streetNum;
    }

    public String getAddressStreet() {
        return mAddressStreet;
    }

    public void setAddressStreet(String addressStreet) {
        mAddressStreet = addressStreet;
    }

    public String getEmail() {
        return mEmail;
    }

    public void setEmail(String email) {
        mEmail = email;
    }

    public int getUserId() {
        return mUserId;
    }

    public void setUserId(int userId) {
        mUserId = userId;
    }

    public String getUsername() {
        return mUsername;
    }

    public void setUsername(String username) {
        mUsername = username;
    }

    @Override
    public String toString() {
        return "AccountInfo{" +
                "mFullName='" + mFullName + '\'' +
                ", mStreetNum=" + mStreetNum +
                ", mAddressStreet='" + mAddressStreet + '\'' +
                ", mEmail='" + mEmail + '\'' +
                ", mUserId=" + mUserId +
                ", mUsername='" + mUsername + '\'' +
                '}';
    }
}
