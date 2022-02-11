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
import com.example.foodordering.Interface.UpdateSelectedItemsInterface;
import com.example.foodordering.Models.PizzaModel;
import com.example.foodordering.R;

import java.util.ArrayList;

public class PizzaActivity extends AppCompatActivity {

    UpdateSelectedItemsInterface updateSelectedItemsInterface;
    ImageView cart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pizza);


        cart = (ImageView) findViewById(R.id.cart8);

        cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PizzaActivity.this, CartActivity.class);
                startActivity(intent);
            }
        });

        getSupportActionBar().hide();

        recycleViewPizza();

    }

    private void recycleViewPizza() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false);
        RecyclerView recyclerViewPizza = (RecyclerView) findViewById(R.id.rv_pizza);
        recyclerViewPizza.setLayoutManager(linearLayoutManager);

        ArrayList<PizzaModel> pizzalist = new ArrayList<>();

        pizzalist.add(new PizzaModel("Olive Pizza",R.drawable.pizzaolive,
                "Goldern Corn, Black Olives, Capsicum & Red Paprika",250,4,15,350));
        pizzalist.add(new PizzaModel("Tomato Pizza",R.drawable.pizzatomato,
                "A pizza loaded with crunchy onions, crisp capsicum, juicy tomatoes",210,4,13,320));
        pizzalist.add(new PizzaModel("Pepperoni Pizza",R.drawable.pizzapepperoni,
                "It is hot. It is spicy. It is oh-so-Indian. Tandoori paneer with capsicum I red paprika I mint mayo",270,5,20,329));
        pizzalist.add(new PizzaModel("Extravaganza ",R.drawable.pizzaextravaganza,
                "A pizza that decidedly staggers under an overload of golden corn, exotic black olives, crunchy onions, crisp capsicum, succulent mushrooms, juicyfresh tomatoes and jalapeno",300,5,25,320));
        pizzalist.add(new PizzaModel("Panner Pizza",R.drawable.pizzapanner,
                "Paneer and Capsicum on Makhani Sauce",200,4,14,290));
        pizzalist.add(new PizzaModel("Mushroom Pizza",R.drawable.pizzamusroom,
                "Check out this mouth watering overload of crunchy, crisp capsicum, succulent mushrooms",235,4,15,333));
        pizzalist.add(new PizzaModel("Chocolate Pizza",R.drawable.chololatepizza,
                "Cheese I Chocolate | Cheese n Chocolate Pizza",320,5,25,400));

        PizzaAdapter adapter = new PizzaAdapter(pizzalist,PizzaActivity.this,updateSelectedItemsInterface);
        recyclerViewPizza.setAdapter(adapter);

    }
}