package com.example.bankingapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.os.Bundle;

import com.example.bankingapp.db.BankAppDatabase;
import com.example.bankingapp.db.BankLogDAO;

import java.util.Arrays;
import java.util.List;

public class UserAccounts extends AppCompatActivity {

    private BankLogDAO mBankLogDAO;
    private List<AccountInfo> mAccountInfos;
    private String fullName;
    private int streetNum;
    private String addressStreet;
    private String email;
    private int userId;
    private String username;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_accounts);

        getDatabase();


        List<AccountInfo> getAllInfo = mBankLogDAO.getAllInfo();
        AccountInfo defaultUser = new AccountInfo("Mike Jones", 123, "Main St.", "mike@csumb.edu", 1234, "mjones");
        mBankLogDAO.insert(defaultUser);
        AccountInfo mjimenez = new AccountInfo("Miguel Jimenez", 2323, "Main Road", "mig@csumb.edu", 2323, "mjimenez");
        mBankLogDAO.insert(mjimenez);
        AccountInfo admin2 = new AccountInfo("admin2", 321, "Some St.", "admin2@csumb.edu", 1111, "admin2");
        mBankLogDAO.insert(admin2);
        AccountInfo daclink = new AccountInfo("Dr. C", 100, "Campus Dr.", "DrC@csumb.edu", 1010, "daclink");
        mBankLogDAO.insert(daclink);

        AccountInfo log = new AccountInfo(fullName,streetNum,addressStreet,email,userId,username);


    }
    private void getDatabase() {
        mBankLogDAO = Room.databaseBuilder(this, BankAppDatabase.class, BankAppDatabase.DB_NAME)
                .allowMainThreadQueries()
                .build()
                .getBankLogDAO();
    }
}