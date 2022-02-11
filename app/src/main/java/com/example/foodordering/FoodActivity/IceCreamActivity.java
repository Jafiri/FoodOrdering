package com.example.foodordering.FoodActivity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.foodordering.Activity.CartActivity;
import com.example.foodordering.Adapters.IceCreamAdapter;
import com.example.foodordering.Interface.UpdateSelectedItemsInterface;
import com.example.foodordering.Models.IceCreamModel;
import com.example.foodordering.Models.NorthModel;
import com.example.foodordering.R;

import java.util.ArrayList;

public class IceCreamActivity extends AppCompatActivity {

    UpdateSelectedItemsInterface updateSelectedItemsInterface;
    ImageView cart;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ice_cream);

        cart = (ImageView) findViewById(R.id.cart5);

        cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(IceCreamActivity.this, CartActivity.class);
                startActivity(intent);
            }
        });

        getSupportActionBar().hide();
        recycleviewIce();
    }

    private void recycleviewIce() {

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false);
        RecyclerView recyclerViewIce = (RecyclerView) findViewById(R.id.rv_icecream);
        recyclerViewIce.setLayoutManager(linearLayoutManager);

        ArrayList<IceCreamModel> iceCreamlist = new ArrayList<>();

        iceCreamlist.add(new IceCreamModel("Chocolate Drizzle",R.drawable.icechocolatebind,
                "ice cream with chocolate drizzle",80,5,5,210));
        iceCreamlist.add(new IceCreamModel("Sundae ",R.drawable.icestrawberr,
                "ice cream with chocolate drizzle strawberry heaven",130,5,7,220));
        iceCreamlist.add(new IceCreamModel("Gelato Fudge",R.drawable.icegelato,
                "Heaven !",230,5,5,245));
        iceCreamlist.add(new IceCreamModel("Parfait Açaí palm",R.drawable.icepalm,
                "Sundae Knickerbocker glory Ice cream Parfait Açaí palm.",175,5,10,390));
        iceCreamlist.add(new IceCreamModel("Gelato Blueberry",R.drawable.iceblueberry,
                "Blueberry everywhere",190,5,5,220));
        iceCreamlist.add(new IceCreamModel("Choco n vanilla",R.drawable.icechocostick,
                "Double in one",65,5,5,199));
        iceCreamlist.add(new IceCreamModel("Oreo ",R.drawable.iceoreo,
                "Never the less Oreoooooo",135,5,5,265));

        IceCreamAdapter adapter= new IceCreamAdapter(iceCreamlist,IceCreamActivity.this,updateSelectedItemsInterface);
        recyclerViewIce.setAdapter(adapter);
    }
}