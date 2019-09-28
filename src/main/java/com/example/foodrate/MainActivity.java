package com.example.foodrate;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private EditText username,emailid;
    private Button register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        username=(EditText)findViewById(R.id.UsernameID);
        emailid=(EditText)findViewById(R.id.EmailID);
        register=(Button)findViewById(R.id.angry_btn);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String u = username.getText().toString();
                String e =emailid.getText().toString();
                if(username.equals("Konka") && emailid.equals("pial")){
                    Intent intent = new Intent (MainActivity.this,Activity2.class);
                            startActivity(intent);
                }
            }
        });
    }
}
