package com.example.foodordering.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.foodordering.Adapters.CartActivityAdapter;
import com.example.foodordering.ApplicationMain;
import com.example.foodordering.Interface.UpdateSelectedItemsInterface;
import com.example.foodordering.Models.CheckoutModel;
import com.example.foodordering.Models.OrderListModel;
import com.example.foodordering.Models.UserinfoModel;
import com.example.foodordering.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.Objects;

public class CartActivity extends AppCompatActivity {

    RecyclerView rv_cart;
    CartActivityAdapter cartActivityAdapter;
    UpdateSelectedItemsInterface updateSelectedItemsInterface;

    private FirebaseUser user;
    FirebaseAuth auth;
    private String userid ;
    FirebaseDatabase database;
    private Task<Void> myRef;

    private ArrayList<OrderListModel> orderListModels;

    LinearLayout homebutton,profilebuttom,settingbutton;
    ConstraintLayout checkoutbutton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        rv_cart = (RecyclerView) findViewById(R.id.rv_cart);
        homebutton = (LinearLayout) findViewById(R.id.cart_btn_home);
        profilebuttom = (LinearLayout) findViewById(R.id.cart_profile_btn);
        settingbutton = (LinearLayout) findViewById(R.id.cart_btn_setting);
        checkoutbutton = (ConstraintLayout) findViewById(R.id.btn_checkout);

        homebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CartActivity.this, MainmenuActivity.class);
                startActivity(intent);
            }
        });

        profilebuttom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CartActivity.this, ProfileActivity.class);
                startActivity(intent);
            }
        });

        settingbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CartActivity.this, SettingActivity.class);
                startActivity(intent);
            }
        });

        checkoutbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new AlertDialog.Builder(CartActivity.this).setTitle("Thank you for Ordering ").setIcon(R.drawable.avatar).setMessage("Your food will be Delivered at your doorstep")
                        .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                finish();
                            }
                        }).setNeutralButton("Help", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(CartActivity.this, "You got no other way out without ordering !", Toast.LENGTH_SHORT).show();
                    }
                }).show();
            }
        });

        cartActivityAdapter = new CartActivityAdapter(CartActivity.this);
        rv_cart.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        rv_cart.setAdapter(cartActivityAdapter);

        orderListModels = ((UpdateSelectedItemsInterface) ApplicationMain.getMyContext()).getItems();



    }
}