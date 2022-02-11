package com.example.foodordering.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.foodordering.Models.UserinfoModel;
import com.example.foodordering.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

public class SignUpActivity extends AppCompatActivity {

    Button btn_register_signup;
    TextView txt_login_signup;
    EditText signupname,signupmobile,signupemail,signuppassword;

    FirebaseDatabase database;
    FirebaseAuth auth;
    ProgressDialog progressDialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        btn_register_signup = (Button) findViewById(R.id.btn_register_signup);
        txt_login_signup = (TextView) findViewById(R.id.txt_login_signup);
        signupname = (EditText) findViewById(R.id.signupusername);
        signupmobile = (EditText) findViewById(R.id.signupmobile);
        signupemail = (EditText) findViewById(R.id.signupemail);
        signuppassword = (EditText) findViewById(R.id.signuppassword);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        database = FirebaseDatabase.getInstance();
        auth = FirebaseAuth.getInstance();
        progressDialog = new ProgressDialog(SignUpActivity.this);
        progressDialog.setTitle("Creating Account");
        progressDialog.setMessage("We are creating your account");

        btn_register_signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                String username =signupname.getText().toString().trim();
                String email = signupemail.getText().toString().trim();
                String password = signuppassword.getText().toString().trim();
                String mobile = signupmobile.getText().toString().trim();


                if (TextUtils.isEmpty(username)) {
                    Toast.makeText(getApplicationContext(), "Enter username!", Toast.LENGTH_SHORT).show();
                    signupname.requestFocus();
                    return;
                }
                if (TextUtils.isEmpty(mobile)) {
                    Toast.makeText(getApplicationContext(), "Enter mobile!", Toast.LENGTH_SHORT).show();
                    signupmobile.requestFocus();
                    return;
                }
                if (TextUtils.isEmpty(email)) {
                    Toast.makeText(getApplicationContext(), "Enter email address!", Toast.LENGTH_SHORT).show();
                    signupemail.requestFocus();
                    return;
                }

                if (TextUtils.isEmpty(password)) {
                    Toast.makeText(getApplicationContext(), "Enter password!", Toast.LENGTH_SHORT).show();
                    signuppassword.requestFocus();
                    return;
                }

                if (password.length() < 6) {
                    Toast.makeText(getApplicationContext(), "Password too short, enter minimum 6 characters!", Toast.LENGTH_SHORT).show();
                    return;
                }

                progressDialog.show();
                    auth.createUserWithEmailAndPassword(signupemail.getText().toString(), signuppassword.getText().toString())
                            .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    progressDialog.dismiss();
                                    if (task.isSuccessful()) {

                                        UserinfoModel usermodel = new UserinfoModel(username, signupemail.getText().toString(), signuppassword.getText().toString(), signupmobile.getText().toString(),"");
                                        String id = task.getResult().getUser().getUid();
                                        database.getReference().child("Users").child(id).setValue(usermodel);
                                        Toast.makeText(SignUpActivity.this, "Account Created Successfully", Toast.LENGTH_SHORT).show();
                                        startActivity(new Intent(SignUpActivity.this, LoginActivity.class));
                                        finish();
                                    } else {
                                        Toast.makeText(SignUpActivity.this, task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                                    }
                                }
                            });


            }
        });



        txt_login_signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SignUpActivity.this, LoginActivity.class));
                finish();
            }
        });

    }
    @Override
    public void onBackPressed() {
        startActivity( new Intent(SignUpActivity.this , MainActivity.class));
        finish();
    }

//    @Override
//    protected void onDestroy() {
//        super.onDestroy();
//        finish();
//    }
}