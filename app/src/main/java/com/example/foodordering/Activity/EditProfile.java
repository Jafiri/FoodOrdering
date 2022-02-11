package com.example.foodordering.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.foodordering.Models.UserinfoModel;
import com.example.foodordering.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.BitSet;

public class EditProfile extends AppCompatActivity {

    private FirebaseUser user;
    private DatabaseReference reference;
    private String userid ;

    String Pusername,Pemailid,Pphone,Paddress;

    EditText username,address,phone,email;
    Button submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);

        username = (EditText) findViewById(R.id.editprofile_name);
        address = (EditText) findViewById(R.id.editprofile_address);
        phone = (EditText) findViewById(R.id.editprofile_phone);
        email = (EditText) findViewById(R.id.editprofile_email);

        submit = (Button) findViewById(R.id.editprofile_btn_submit);

       showalldata();

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                update();
            }
        });

    }

    private void showalldata() {
        user = FirebaseAuth.getInstance().getCurrentUser();
        reference = FirebaseDatabase.getInstance().getReference("Users");
        userid = user.getUid();

        reference.child(userid).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                UserinfoModel userBDdata = snapshot.getValue(UserinfoModel.class);

                if(userBDdata != null){
                    Pusername = userBDdata.username;
                    Pemailid = userBDdata.email;
                    Pphone = userBDdata.mobile;
                    Paddress = userBDdata.address;

                    username.setText(Pusername);
                    email.setText(Pemailid);
                    phone.setText(Pphone);
                    address.setText(Paddress);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(EditProfile.this, error.toException().getMessage(), Toast.LENGTH_SHORT).show();
            }
        });


    }

    public void update(){

        if(isNameChanged() || isEmaildChanged() || isPhoneChanged() || isAddressChanged()){
            Toast.makeText(EditProfile.this, "Data has been updated", Toast.LENGTH_SHORT).show();
        } else{
            Toast.makeText(EditProfile.this, "Data is same cannot be changed", Toast.LENGTH_SHORT).show();
        }

    }

    private boolean isNameChanged(){
        if(!Pusername.equals(username.getText().toString())){
            reference.child(userid).child("username").setValue(username.getText().toString());
            Pusername = username.getText().toString();
            return true;
        }else{
            return false;
        }
    }

    private boolean isEmaildChanged(){
        if(!Pemailid.equals(email.getText().toString())){
            reference.child(userid).child("email").setValue(email.getText().toString());
            Pemailid = email.getText().toString();
            return true;
        }else {
            return false;
        }
    }

    private boolean isPhoneChanged(){
        if(!Pphone.equals(phone.getText().toString())){
            reference.child(userid).child("mobile").setValue(phone.getText().toString());
            Pphone = phone.getText().toString();
            return true;
        }else {
            return false;
        }
    }

    private boolean isAddressChanged(){
        if(!Paddress.equals(address.getText().toString())){
            reference.child(userid).child("address").setValue(address.getText().toString());
            Paddress = address.getText().toString();
            return true;
        }else {
            return false;
        }
    }
}