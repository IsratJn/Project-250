package com.example.foodrate;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText usernameedittext,emailidedittext,passwordedittext;
    private Button register;
    DatabaseHelper databaseHelper;
    UserDetails userDetails;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        databaseHelper = new DatabaseHelper(this);
        SQLiteDatabase sqLiteDatabase= databaseHelper.getWritableDatabase();


        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        usernameedittext=(EditText)findViewById(R.id.UsernameID);
        emailidedittext=(EditText)findViewById(R.id.EmailID);
        passwordedittext=(EditText)findViewById(R.id.passwordID);
        register=(Button)findViewById(R.id.angry_btn);


        userDetails = new UserDetails();
        register.setOnClickListener(this);

        databaseHelper = new DatabaseHelper(this);

    }


    @Override
    public void onClick(View view) {

        String username=usernameedittext.getText().toString();
        String email=emailidedittext.getText().toString();
        String password=passwordedittext.getText().toString();

        userDetails.setName(username);
        userDetails.setEmail(email);
        userDetails.setPassword(password);


        long rowId=databaseHelper.insertData(userDetails);
        if(rowId>0){
            Toast.makeText(getApplicationContext(),"Row "+rowId+" is inserted",Toast.LENGTH_LONG).show();
        }
        else{
            Toast.makeText(getApplicationContext(),"Row insertion failed",Toast.LENGTH_LONG).show();
        }

        if(view.getId()==R.id.angry_btn){
            Intent intent = new Intent(MainActivity.this,Activity2.class);
            startActivity(intent);
        }

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId()==android.R.id.home){
            this.finish();
        }
        return super.onOptionsItemSelected(item);
    }
}
