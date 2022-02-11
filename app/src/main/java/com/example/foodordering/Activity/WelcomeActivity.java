package com.example.foodordering.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.foodordering.R;

public class WelcomeActivity extends AppCompatActivity {

    TextView txt_getStarted;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        getSupportActionBar().hide();

        txt_getStarted = (TextView) findViewById(R.id.txt_getStarted);

        txt_getStarted.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(WelcomeActivity.this,MainmenuActivity.class));
                finish();
            }
        });



    }
}