package com.example.foodordering.FoodActivity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.foodordering.Activity.CartActivity;
import com.example.foodordering.Adapters.NorthAdapter;
import com.example.foodordering.Interface.UpdateSelectedItemsInterface;
import com.example.foodordering.Models.NorthModel;
import com.example.foodordering.Models.SouthModel;
import com.example.foodordering.R;

import java.util.ArrayList;

public class NorthActivity extends AppCompatActivity {

    UpdateSelectedItemsInterface updateSelectedItemsInterface;
    ImageView cart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_north);

        cart = (ImageView) findViewById(R.id.cart7);

        cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(NorthActivity.this, CartActivity.class);
                startActivity(intent);
            }
        });

        getSupportActionBar().hide();
        recycleviewNorth();
    }

    private void recycleviewNorth() {

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false);
        RecyclerView recyclerViewnorth = (RecyclerView) findViewById(R.id.rv_north);
        recyclerViewnorth.setLayoutManager(linearLayoutManager);

        ArrayList<NorthModel> northlist = new ArrayList<>();

        northlist.add(new NorthModel("Chole bhature",R.drawable.nothcholebhature,
                "A combination of chana masala and bhatura/puri",45,5,15,79));
        northlist.add(new NorthModel("Dal Makhani",R.drawable.northdalmakhani,
                "Dish made by simmering whole black lentils & red kidney beans with spices, butter & cream.",70,4,22,90));
        northlist.add(new NorthModel("Chana masala",R.drawable.nothchola,
                "Ingredient is a variety of chickpea called chana or kala chana",70,4,20,88));
        northlist.add(new NorthModel("Butter Masala ",R.drawable.northbutterroti,
                "A combination of Butter masala and rotis.",80,5,15,110));
        northlist.add(new NorthModel("Pulao",R.drawable.northpulov,
                "Pulao is a one pot rice dish made by cooking fragrant basmati rice with aromatic spices, herbs & sometimes stock",70,4,13,80));
        northlist.add(new NorthModel("Sabji Roti ",R.drawable.northroti,
                "A combination of Veggies and rotis.",35,4,5,39));
        northlist.add(new NorthModel("Thali ",R.drawable.northmeals,
                "From Rajasthan To Andhra.",135,4,19,130));

        NorthAdapter adapter = new NorthAdapter(northlist,NorthActivity.this,updateSelectedItemsInterface);
        recyclerViewnorth.setAdapter(adapter);
    }
}