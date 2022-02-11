package com.example.foodordering.FoodActivity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.foodordering.Activity.CartActivity;
import com.example.foodordering.Adapters.Southadapter;
import com.example.foodordering.Interface.UpdateSelectedItemsInterface;
import com.example.foodordering.Models.SouthModel;
import com.example.foodordering.Models.TeaModel;
import com.example.foodordering.R;

import java.util.ArrayList;

public class SouthActivity extends AppCompatActivity {

    UpdateSelectedItemsInterface updateSelectedItemsInterface;
    ImageView cart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_south);
        cart = (ImageView) findViewById(R.id.cart10);

        cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SouthActivity.this, CartActivity.class);
                startActivity(intent);
            }
        });

        getSupportActionBar().hide();
        recycleviewSouth();
    }

    private void recycleviewSouth() {

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false);
        RecyclerView recyclerViewsouth = (RecyclerView) findViewById(R.id.rv_south);
        recyclerViewsouth.setLayoutManager(linearLayoutManager);

        ArrayList<SouthModel> southlist = new ArrayList<>();

        southlist.add(new SouthModel("Dosa",R.drawable.southdosa,
                "From a fermented batter predominantly consisting of lentils and rice.",60,5,10,125));
        southlist.add(new SouthModel("Idli",R.drawable.southidlis,
                "The cakes are made by steaming a batter consisting of fermented black lentils and rice",40,4,5,45));
        southlist.add(new SouthModel("Samosa",R.drawable.southsamosa,
                " fried or baked pastry with a savory filling, including ingredients such as spiced potatoes, onions, peas",30,4,12,110));
        southlist.add(new SouthModel("Upma",R.drawable.southupma,
                "cooked as a thick porridge from dry-roasted semolina or coarse rice flour.",60,3,17,80));
        southlist.add(new SouthModel("Parotta",R.drawable.southpaprota,
                " Subcontinental layered flatbread made from Maida or Atta",40,5,10,79));
        southlist.add(new SouthModel("Idiyappam",R.drawable.southiidiyappam,
                "Britain's favourite green tea.Britain's favourite green tea.a rice noodle dish originating from the Indian states of Tamil Nadu",80,5,20,35));
        southlist.add(new SouthModel("Meals",R.drawable.vegmeals,
                "Typical main dishes, snacks, light meals, desserts, and drinks",150,4,17,100));

        Southadapter southadapter = new Southadapter(southlist,SouthActivity.this,updateSelectedItemsInterface);
        recyclerViewsouth.setAdapter(southadapter);

    }
}