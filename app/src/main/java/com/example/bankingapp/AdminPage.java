package com.example.bankingapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.os.Bundle;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;
import android.view.View;
import android.widget.Toast;

import com.example.bankingapp.db.BankAppDatabase;
import com.example.bankingapp.db.BankLogDAO;

import java.util.List;

public class AdminPage extends AppCompatActivity {

    private BankLogDAO mBankLogDAO;
    private List<AccountInfo> mAccountInfos;
    Button buttonDeleteUser;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_page);

        getDatabase();

        mAccountInfos = mBankLogDAO.getAllInfo();

        List<AccountInfo> accountInfos = mBankLogDAO.getAllInfo();
        if(mAccountInfos.isEmpty()){
            AccountInfo defaultUser = new AccountInfo("Mike Jones", 123, "Main St.", "mike@csumb.edu", 1234, "mjones");
            mBankLogDAO.insert(defaultUser);
            AccountInfo mjimenez = new AccountInfo("Miguel Jimenez", 2323, "Main Road", "mig@csumb.edu", 2323, "mjimenez");
            mBankLogDAO.insert(mjimenez);
            AccountInfo admin2 = new AccountInfo("admin2", 321, "Some St.", "admin2@csumb.edu", 1111, "admin2");
            mBankLogDAO.insert(admin2);
            AccountInfo daclink = new AccountInfo("Dr. C", 100, "Campus Dr.", "DrC@csumb.edu", 1010, "daclink");
            mBankLogDAO.insert(daclink);
        }

        TextView textView = findViewById(R.id.userDisplay);
        StringBuilder sb = new StringBuilder();

        for(AccountInfo accountInfo : accountInfos){

            sb.append("List of accounts: " + "\n");
            sb.append("Username: " + accountInfo.getUsername() + "\n");
            sb.append("Full name: " + accountInfo.getFullName() + "\n");
            sb.append("Email: " + accountInfo.getEmail() + "\n");
            sb.append("Address: " + accountInfo.getStreetNum() + " " + accountInfo.getAddressStreet() + "\n");
            sb.append("Account: " + accountInfo.getAccountNum() + "\n\n" );
            sb.append("");
        }

        textView.setText(sb.toString());

        Button buttonDeleteUser = findViewById(R.id.buttonDeleteUser);
        buttonDeleteUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                deleteUser();

            }
        });


    }

    private void deleteUser(){
        User userToDelete = mBankLogDAO.getUserName("testuser1");
        mBankLogDAO.delete(userToDelete);
        Toast.makeText(AdminPage.this, "Account deleted", Toast.LENGTH_SHORT).show();
    }


    private void getDatabase() {
        mBankLogDAO = Room.databaseBuilder(this, BankAppDatabase.class, BankAppDatabase.DB_NAME)
                .allowMainThreadQueries()
                .build()
                .getBankLogDAO();
    }
}
