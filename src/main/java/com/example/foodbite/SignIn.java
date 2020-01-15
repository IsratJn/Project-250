package com.example.foodbite;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class SignIn extends AppCompatActivity {
    private Button loginbtn;
    private TextView textview;
    private EditText email,password;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        mAuth=FirebaseAuth.getInstance();

        loginbtn=(Button)findViewById(R.id.login);
        textview=(TextView)findViewById(R.id.clickhere);
        email=(EditText)findViewById(R.id.Email);
        password=(EditText)findViewById(R.id.Password);

        loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String loginEmail =email.getText().toString();
                String loginPassword=password.getText().toString();

                if(!TextUtils.isEmpty(loginEmail) && !TextUtils.isEmpty(loginPassword)){
                 mAuth.signInWithEmailAndPassword(loginEmail,loginPassword).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                     @Override
                     public void onComplete(@NonNull Task<AuthResult> task) {
                          if(task.isSuccessful()){
                              Intent intent = new Intent(SignIn.this,Home.class);
                              startActivity(intent);
                              finish();
                          }
                          else{
                              String errorMessage = task.getException().getMessage();
                              Toast.makeText(SignIn.this,"Error:"+errorMessage,Toast.LENGTH_LONG).show();
                          }
                     }
                 });
                }

            }
        });


        textview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SignIn.this,SignUp.class);
                startActivity(intent);
            }
        });


    }

    @Override
    protected void onStart() {
        super.onStart();
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if(currentUser!=null)
        {
            Intent intent = new Intent(SignIn.this,Home.class);
            startActivity(intent);
            finish();
        }
    }
}
