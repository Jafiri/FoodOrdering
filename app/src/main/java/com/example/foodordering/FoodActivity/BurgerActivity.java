package com.example.foodordering.FoodActivity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.foodordering.Activity.CartActivity;
import com.example.foodordering.Adapters.BurgerAdapter;
import com.example.foodordering.Interface.UpdateSelectedItemsInterface;
import com.example.foodordering.Models.BurgerModel;
import com.example.foodordering.Models.SouthModel;
import com.example.foodordering.R;

import java.util.ArrayList;

public class BurgerActivity extends AppCompatActivity {

    UpdateSelectedItemsInterface updateSelectedItemsInterface;
    ImageView cart;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_burger);

        cart = (ImageView) findViewById(R.id.cart3);

        cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(BurgerActivity.this, CartActivity.class);
                startActivity(intent);
            }
        });

        getSupportActionBar().hide();
        recycleviewBurger();
    }

    private void recycleviewBurger() {

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false);
        RecyclerView recyclerViewBurger = (RecyclerView) findViewById(R.id.rv_burger);
        recyclerViewBurger.setLayoutManager(linearLayoutManager);

        ArrayList<BurgerModel> burgerlist = new ArrayList<>();

        burgerlist.add(new BurgerModel("Regular Burger",R.drawable.burgerregular,
                "burger is topped with a tangy pickle, chopped onions, ketchup and mustard.",110,4,15,210));
        burgerlist.add(new BurgerModel("Ham Burger",R.drawable.burgerham,
                "The original burger starts with a 100% pure beef burger seasoned with just a pinch of salt and pepper.",150,4,20,350));
        burgerlist.add(new BurgerModel("Steak Burger",R.drawable.burgeronlysteak,
                "A bagel freshly toasted with real butter that holds a tender, juicy steak patty, a fluffy folded egg, melty American cheese and savory grilled onions.",210,5,20,680));
        burgerlist.add(new BurgerModel("Grilled Burger",R.drawable.burgergrill,
                "From juicy home-ground cheeseburgers to black bean burgers that even omnivores can appreciate",250,5,20,700));
        burgerlist.add(new BurgerModel("Double patte ",R.drawable.burgerdoublepatte,
                "Each Double Quarter Pounder with Cheese features two quarter pound* 100% .",220,5,20,720));
        burgerlist.add(new BurgerModel("Smoked Burger",R.drawable.burgersmoked,
                "The heat and the smoke can dry out the meat.",250,5,27,700));
        burgerlist.add(new BurgerModel("Mega Burger",R.drawable.burgervegmega,
                "Mouthwatering perfection starts with two 100% pure beef patties.",300,5,30,850));

        BurgerAdapter adapter = new BurgerAdapter(burgerlist,BurgerActivity.this,updateSelectedItemsInterface);
        recyclerViewBurger.setAdapter(adapter);
    }
}