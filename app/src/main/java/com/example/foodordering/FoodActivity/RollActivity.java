package com.example.foodordering.FoodActivity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.foodordering.Activity.CartActivity;
import com.example.foodordering.Adapters.RollAdapter;
import com.example.foodordering.Interface.UpdateSelectedItemsInterface;
import com.example.foodordering.Models.RollModel;
import com.example.foodordering.R;

import java.util.ArrayList;

public class RollActivity extends AppCompatActivity {

    UpdateSelectedItemsInterface updateSelectedItemsInterface;
    ImageView cart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_roll);

        cart = (ImageView) findViewById(R.id.cart9);

        cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RollActivity.this, CartActivity.class);
                startActivity(intent);
            }
        });

        getSupportActionBar().hide();

        recycleViewRoll();

    }

    private void recycleViewRoll() {

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false);
        RecyclerView recyclerViewRoll = (RecyclerView) findViewById(R.id.rv_roll);
        recyclerViewRoll.setLayoutManager(linearLayoutManager);

        ArrayList<RollModel> rolllist = new ArrayList<>();

        rolllist.add(new RollModel("Egg Roll",R.drawable.rollspring,
                "Popiah Crispy Egg Spring roll",80,4,15,190));
        rolllist.add(new RollModel("Tzatziki",R.drawable.rolltzatziki,
                "Shawarma Wrap Pita Chicken Tzatziki ",125,5,20,230));
        rolllist.add(new RollModel("Tandoori Wrap",R.drawable.rolltandoori,
                "Tandoori chicken Wrap Fast food Breakfast sandwich Kati roll",110,5,15,210));
        rolllist.add(new RollModel("Chicken Roll",R.drawable.rollchicken,
                "Shawarma Wrap Pita Cafe Small bread, Two chicken roll",100,4,17,225));
        rolllist.add(new RollModel("Vegetable burrito",R.drawable.rollburrito,
                "India Kati roll Spring roll Egg roll Paratha ",90,4,15,150));
        rolllist.add(new RollModel("kebab Dürüm",R.drawable.rollkebab,
                "hicken Doner kebab Dürüm Shawarma Ayran",140,5,15,215));
        rolllist.add(new RollModel("Grill roll ",R.drawable.rollgrill,
                "Grilled chicken wrap with high miyo",135,5,19,220));


        RollAdapter adapter = new RollAdapter(rolllist,RollActivity.this,updateSelectedItemsInterface);
        recyclerViewRoll.setAdapter(adapter);
    }
}