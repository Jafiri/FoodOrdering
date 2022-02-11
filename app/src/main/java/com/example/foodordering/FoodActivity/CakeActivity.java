package com.example.foodordering.FoodActivity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.foodordering.Activity.CartActivity;
import com.example.foodordering.Adapters.CakeAdapter;
import com.example.foodordering.Interface.UpdateSelectedItemsInterface;
import com.example.foodordering.Models.CakeModel;
import com.example.foodordering.Models.IceCreamModel;
import com.example.foodordering.R;

import java.util.ArrayList;

public class CakeActivity extends AppCompatActivity {

    UpdateSelectedItemsInterface updateSelectedItemsInterface;
    ImageView cart;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cake);

        cart = (ImageView) findViewById(R.id.cart4);

        cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CakeActivity .this, CartActivity.class);
                startActivity(intent);
            }
        });
        getSupportActionBar().hide();

        recycleViewCake();

    }

    private void recycleViewCake() {

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false);
        RecyclerView recyclerViewCake = (RecyclerView) findViewById(R.id.rv_cake);
        recyclerViewCake.setLayoutManager(linearLayoutManager);

        ArrayList<CakeModel> cakelist = new ArrayList<>();

        cakelist.add(new CakeModel("Choco brownie",R.drawable.cakeblavckforest,
                "Chocolate brownie Black Forest gateau Birthday cake",700,5,40,999));
        cakelist.add(new CakeModel("Torte Dripping",R.drawable.cakecandy,
                "Birthday cake Torte Dripping Ice cream cake",650,5,30,890));
        cakelist.add(new CakeModel("Strawberry Crepe",R.drawable.cakestrawberry,
                "Sponge Torte Strawberry crepe cake",750,5,35,799));
        cakelist.add(new CakeModel("Cupcake",R.drawable.cakecup,
                "Chocolate Icing, cup cake",150,4,10,200));
        cakelist.add(new CakeModel("Oreo Cake",R.drawable.cakeoreo,
                "Frozen Dessert Cream Chocolate Oreo Cake",850,5,45,1110));
        cakelist.add(new CakeModel("Raspberry cake",R.drawable.cakeresberry,
                "Slice of raspberry cake with raspberry toppings",55,5,5,210));
        cakelist.add(new CakeModel("Wedding cake",R.drawable.cakewedding,
                "Pink and white roses in white vase wedding cake ",1000,5,45,1350));

        CakeAdapter adapter = new CakeAdapter(cakelist,CakeActivity.this,updateSelectedItemsInterface);
        recyclerViewCake.setAdapter(adapter);


    }
}