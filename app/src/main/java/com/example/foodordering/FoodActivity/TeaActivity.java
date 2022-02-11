package com.example.foodordering.FoodActivity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.foodordering.Activity.CartActivity;
import com.example.foodordering.Adapters.PizzaAdapter;
import com.example.foodordering.Adapters.TeaAdapter;
import com.example.foodordering.Interface.UpdateSelectedItemsInterface;
import com.example.foodordering.Models.PizzaModel;
import com.example.foodordering.Models.TeaModel;
import com.example.foodordering.R;

import java.util.ArrayList;

public class TeaActivity extends AppCompatActivity {

    UpdateSelectedItemsInterface updateSelectedItemsInterface;
    ImageView cart;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tea);

        cart = (ImageView) findViewById(R.id.cart11);

        cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TeaActivity.this, CartActivity.class);
                startActivity(intent);
            }
        });
        getSupportActionBar().hide();

        recycleviewtea();

    }

    private void recycleviewtea() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false);
        RecyclerView recyclerViewtea = (RecyclerView) findViewById(R.id.rv_tea);
        recyclerViewtea.setLayoutManager(linearLayoutManager);

        ArrayList<TeaModel> tealist = new ArrayList<>();

        tealist.add(new TeaModel("Green Tea",R.drawable.tea,
                "Britain's favourite green tea.",90,5,10,25));
        tealist.add(new TeaModel("Coffee",R.drawable.teacoffe,
                "A cup of coffee can complete your day.",60,5,8,35));
        tealist.add(new TeaModel("Bubble Tea",R.drawable.teabubble,
                "consists of tea accompanied by chewy tapioca balls",75,5,15,50));
        tealist.add(new TeaModel("Milk Shake",R.drawable.teamilkshake,
                "A sweet drink made by blending milk, ice cream, and flavorings or sweeteners such as butterscotch, caramel sauce",150,5,10,75));
        tealist.add(new TeaModel("Ice Tea",R.drawable.tecice,
                "Tea that has been chilled or cooled",50,5,10,30));
        tealist.add(new TeaModel("Latte ",R.drawable.tealatte,
                "Coffee drink of Italian origin made with espresso and steamed milk",170,5,15,45));
        tealist.add(new TeaModel("Indian Chai ",R.drawable.teaindian,
                "Term chai means a mix of spices steeped into a tea-like beverage",20,5,5,10));
        tealist.add(new TeaModel("Water",R.drawable.teawater,
                "Happens ! ",10,5,2,0));

        TeaAdapter adapter = new TeaAdapter(tealist,TeaActivity.this,updateSelectedItemsInterface);
        recyclerViewtea.setAdapter(adapter);
    }
}