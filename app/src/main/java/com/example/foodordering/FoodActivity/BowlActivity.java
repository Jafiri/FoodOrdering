package com.example.foodordering.FoodActivity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.foodordering.Activity.CartActivity;
import com.example.foodordering.Adapters.BowlAdapter;
import com.example.foodordering.Interface.UpdateSelectedItemsInterface;
import com.example.foodordering.Models.BowlModel;
import com.example.foodordering.Models.KebabModel;
import com.example.foodordering.R;

import java.util.ArrayList;

public class BowlActivity extends AppCompatActivity {

    UpdateSelectedItemsInterface updateSelectedItemsInterface;
    ImageView cart;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bowl);

        cart = (ImageView) findViewById(R.id.cart2);

        cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(BowlActivity.this, CartActivity.class);
                startActivity(intent);
            }
        });

        getSupportActionBar().hide();

        recycleViewBowl();
    }

    private void recycleViewBowl() {

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false);
        RecyclerView recyclerViewBowl = (RecyclerView) findViewById(R.id.rv_bowl);
        recyclerViewBowl.setLayoutManager(linearLayoutManager);

        ArrayList<BowlModel> bowlModels = new ArrayList<>();

        bowlModels.add(new BowlModel("Fruit salad",R.drawable.bowlfruit,
                "Fruit salad on bowl",220,5,16,50));
        bowlModels.add(new BowlModel("Mesclun Salad",R.drawable.bowlmesclun,
                " Mesclun Salad dressing Leaf vegetable",145,4,12,70));
        bowlModels.add(new BowlModel("Greek salad",R.drawable.bowlgreek,
                "Greek salad on bowl",165,5,10,40));
        bowlModels.add(new BowlModel("Caesar salad",R.drawable.bowlcaesar,
                "Caesar salad on bowl",125,4,5,55));
        bowlModels.add(new BowlModel("Romaine salad",R.drawable.bowlromaine,
                "Romaine lettuce salad on bowl",160,10,16,80));
        bowlModels.add(new BowlModel("Spinach salad",R.drawable.bowlspinach,
                "Spinach Fattoush salad on bowl",180,10,16,25));

        BowlAdapter adapter = new BowlAdapter(bowlModels,BowlActivity.this,updateSelectedItemsInterface);
        recyclerViewBowl.setAdapter(adapter);

    }
}