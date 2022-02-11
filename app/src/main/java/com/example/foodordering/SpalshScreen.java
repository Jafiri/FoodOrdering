package com.example.foodordering;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.foodordering.Activity.MainActivity;

public class SpalshScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.spalsh_screen);

        getSupportActionBar().hide();

        Thread thread = new Thread(){
            @Override
            public void run() {
                try {
                    sleep(2000);

                }
                catch (Exception exception){
                    exception.printStackTrace();
                }
                finally{
                    startActivity(new Intent(SpalshScreen.this, MainActivity.class));
                    finish();
                }

            }
        }; thread.start();
    }
}