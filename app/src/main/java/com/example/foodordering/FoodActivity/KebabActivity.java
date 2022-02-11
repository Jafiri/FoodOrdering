package com.example.foodordering.FoodActivity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.foodordering.Activity.CartActivity;
import com.example.foodordering.Adapters.KebabAdapter;
import com.example.foodordering.Interface.UpdateSelectedItemsInterface;
import com.example.foodordering.Models.KebabModel;
import com.example.foodordering.Models.RollModel;
import com.example.foodordering.R;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class KebabActivity extends AppCompatActivity {


    UpdateSelectedItemsInterface updateSelectedItemsInterface;
    ImageView cart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kebab);

        cart = (ImageView) findViewById(R.id.cart6);

        cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(KebabActivity.this, CartActivity.class);
                startActivity(intent);
            }
        });

        getSupportActionBar().hide();

        recycleViewKebab();

    }

    private void recycleViewKebab() {


        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false);
        RecyclerView recyclerViewKebab = (RecyclerView) findViewById(R.id.rv_kebab);
        recyclerViewKebab.setLayoutManager(linearLayoutManager);

        ArrayList<KebabModel> kebablist = new ArrayList<>();

        kebablist.add(new KebabModel("Turkish Bresaola",R.drawable.kebabbresaola,
                "BBQ on white plate, Shish Doner Turkish cuisine Bresaola Kebab",80,5,16,190));
        kebablist.add(new KebabModel("Russian Kebab",R.drawable.kebabrussian,
                "Two kebabs beside two slice tomatoes, Kebab Russian cuisine",95,5,15,200));
        kebablist.add(new KebabModel("Mediterranean",R.drawable.kebabmediterranean,
                "Shish kebab Barbecue Mediterranean cuisine",105,4,20,175));
        kebablist.add(new KebabModel("Skewer Kebab",R.drawable.kekbabsesese,
                "Shish kebab Barbecue Skewer Meat",100,5,20,220));
        kebablist.add(new KebabModel("Lyulya kebab",R.drawable.kebablyulya,
                "Shashlik Lyulya kebab Lamb and mutton",95,4,15,205));
        kebablist.add(new KebabModel("Shish kebab",R.drawable.kebabshish,
                "Shish kebab Tandoori chicken",90,5,17,185));

        KebabAdapter adapter = new KebabAdapter(kebablist,KebabActivity.this,updateSelectedItemsInterface);
        recyclerViewKebab.setAdapter(adapter);

    }
}