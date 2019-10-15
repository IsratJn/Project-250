package com.example.foodrate;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Activity2 extends AppCompatActivity implements View.OnClickListener {
    private EditText usernameedittext,passwordeddittext;
    private Button login;

    DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        usernameedittext=(EditText)findViewById(R.id.Username1);
        passwordeddittext=(EditText)findViewById(R.id.Password1);
        login = (Button)findViewById(R.id.angry_btn1);

        login.setOnClickListener(this);
        databaseHelper = new DatabaseHelper(this);



    }




    @Override
    public void onClick(View view) {

        String username=usernameedittext.getText().toString();
        String password=passwordeddittext.getText().toString();


        if(view.getId()== R.id.angry_btn1){

          //  Boolean result =  databaseHelper.findPassword(username,password);
          //  if(result == true){
                Intent intent = new Intent(Activity2.this,Navigator.class);
                startActivity(intent);
            //}
            //else{
             // Toast.makeText(getApplicationContext(),"username and password didn't match",Toast.LENGTH_LONG).show();
            //}


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
