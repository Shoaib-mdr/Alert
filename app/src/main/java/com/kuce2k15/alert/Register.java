package com.kuce2k15.alert;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Register extends AppCompatActivity {
    private EditText ET_Name, ET_Phone;
    private Button Btn_Add;
    private String mName, mPhone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        ET_Name=(EditText)findViewById(R.id.editTextName);
        ET_Phone=(EditText)findViewById(R.id.editTextPhone);
        Btn_Add=(Button)findViewById(R.id.button);
        Btn_Add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mName=ET_Name.getText().toString();
                mPhone=ET_Phone.getText().toString();
                InsertFriend();


            }
        });

    }

    private void InsertFriend() {
        DBHelper dbHelper=new DBHelper(this);
        dbHelper.addFriends(new Friends(mName,mPhone));
        Toast.makeText(this, "Saved", Toast.LENGTH_LONG).show();
        Intent intent=new Intent(this, MainActivity.class);
        startActivity(intent);

    }
}
