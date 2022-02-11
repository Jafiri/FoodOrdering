package com.example.foodordering.FoodActivity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.ImageView;

import com.example.foodordering.Activity.CartActivity;
import com.example.foodordering.Adapters.BiriyaniAdapter;
import com.example.foodordering.Interface.UpdateSelectedItemsInterface;
import com.example.foodordering.Models.BiriyaniModel;
import com.example.foodordering.R;

import java.util.ArrayList;

public class BiriyaniActivity extends AppCompatActivity {


    UpdateSelectedItemsInterface updateSelectedItemsInterface;
    ImageView cart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_biriyani);

        cart = (ImageView) findViewById(R.id.cart);

        cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(BiriyaniActivity.this, CartActivity.class);
                startActivity(intent);
            }
        });

        getSupportActionBar().hide();

        recycleViewBiriyani();


    }

    private void recycleViewBiriyani() {

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false);
        RecyclerView recyclerViewBiriyani = (RecyclerView) findViewById(R.id.rv_biriyani);
        recyclerViewBiriyani.setLayoutManager(linearLayoutManager);

        ArrayList<BiriyaniModel> biriyanilist = new ArrayList<>();

        biriyanilist.add(new BiriyaniModel("Mutton Biriyani",R.drawable.muttonbiriyani,
                "Mutton biryani is a classic dish made by layering rice over slow cooked mutton gravy.",180,4,15,381));
        biriyanilist.add(new BiriyaniModel("Chicken Biriyani",R.drawable.biryaniimg,
                "Chicken biryani is a classic dish made by layering rice over slow cooked chicken gravy.",150,4,13,300));
        biriyanilist.add(new BiriyaniModel("Pot Biriyani",R.drawable.potbiriyanii,
                "Pot biryani is a classic dish made by layering rice over slow cooked mutton gravy.",210,4,20,275));
        biriyanilist.add(new BiriyaniModel("Panner Biriyani",R.drawable.pannerbiriyani,
                "Panner biryani is a classic dish made by layering rice over slow cooked paneer gravy.",180,4,15,381));
        biriyanilist.add(new BiriyaniModel("Prawn Biriyani",R.drawable.prawnbiriyani,
                "Prawn biryani is a classic dish made by layering rice over slow cooked Prawn gravy.",250,5,17,200));
        biriyanilist.add(new BiriyaniModel("Egg Biriyani",R.drawable.eggbiriyani,
                "Egg biryani is a classic dish made by layering rice over slow cooked egg gravy.",110,4,15,180));
        biriyanilist.add(new BiriyaniModel("Veg Biriyani",R.drawable.vegbiriyani,
                "Veg biryani is a classic dish made by layering rice over slow cooked veg gravy.",130,3,10,150));

        BiriyaniAdapter adapter = new BiriyaniAdapter(biriyanilist,BiriyaniActivity.this,updateSelectedItemsInterface);
        recyclerViewBiriyani.setAdapter(adapter);

    }
}