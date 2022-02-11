package com.example.foodordering.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
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

public class ProfileActivity extends AppCompatActivity {

    private FirebaseUser user;
    private DatabaseReference reference;
    private String userid ;

    TextView username,emailid,mobile,address;
    Button update;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        getSupportActionBar().setTitle("Profile");

        user = FirebaseAuth.getInstance().getCurrentUser();
        reference = FirebaseDatabase.getInstance().getReference("Users");
        userid = user.getUid();

        username = (TextView) findViewById(R.id.profile_username);
        emailid = (TextView) findViewById(R.id.profile_emailid);
        mobile = (TextView) findViewById(R.id.profile_mobile);
        address = (TextView) findViewById(R.id.profile_address);
        update = (Button) findViewById(R.id.btn_update);

        reference.child(userid).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                UserinfoModel userdata = snapshot.getValue(UserinfoModel.class);

                if(userdata != null){
                    String Pusername = userdata.username;
                    String Pemailid = userdata.email;
                    String Pphone = userdata.mobile;
                    String Paddress = userdata.address;

                    username.setText(Pusername);
                    emailid.setText(Pemailid);
                    mobile.setText(Pphone);
                    address.setText(Paddress);

                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

                Toast.makeText(ProfileActivity.this, error.toException().getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ProfileActivity.this,EditProfile.class);
                startActivity(intent);

            }
        });
    }
}