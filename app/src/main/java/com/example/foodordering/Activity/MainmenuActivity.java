package com.example.foodordering.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.example.foodordering.Adapters.CategoriesAdapter;
import com.example.foodordering.Adapters.PopularAdapter;
import com.example.foodordering.Models.CategoriesModel;
import com.example.foodordering.Models.PopularModel;
import com.example.foodordering.Models.UserinfoModel;
import com.example.foodordering.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class MainmenuActivity extends AppCompatActivity  {

    private RecyclerView recycleviewcategorylist;
    private List<CategoriesModel> categorieslist;
    LinearLayout setting , profile ,cart;
    TextView greeting;

    private FirebaseUser user;
    private DatabaseReference reference;
    private String userid ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainmenu);

        getSupportActionBar().hide();

        setting = (LinearLayout) findViewById(R.id.cart_btn_setting);
        profile = (LinearLayout) findViewById(R.id.profile_btn);
        cart = (LinearLayout) findViewById(R.id.btn_cart);
        greeting = (TextView) findViewById(R.id.txt_hi_user);

        user = FirebaseAuth.getInstance().getCurrentUser();
        reference = FirebaseDatabase.getInstance().getReference("Users");
        userid = user.getUid();



          reference.child(userid).addValueEventListener(new ValueEventListener() {
              @Override
              public void onDataChange(@NonNull DataSnapshot snapshot) {
                  UserinfoModel userdata = snapshot.getValue(UserinfoModel.class);

                  if (userdata != null) {
                      String Pusername = userdata.username;

                      greeting.setText("Hi " + Pusername + " !");
                  }
              }

              @Override
              public void onCancelled(@NonNull DatabaseError error) {

                  Toast.makeText(MainmenuActivity.this, error.toException().getMessage(), Toast.LENGTH_SHORT).show();

              }
          });


        recycleviewcategory();
        recyclerViewPopularDish();

        setting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainmenuActivity.this,SettingActivity.class);
                startActivity(intent);

            }
        });

        cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainmenuActivity.this,CartActivity.class);
                startActivity(intent);

            }
        });

        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainmenuActivity.this,ProfileActivity.class);
                startActivity(intent);

            }
        });
    }

                private void recyclerViewPopularDish() {

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL,false);
        RecyclerView recyclerViewPopularDishlist = (RecyclerView) findViewById(R.id.rv_popular);
        recyclerViewPopularDishlist.setLayoutManager(linearLayoutManager);

        ArrayList<PopularModel> foodlist = new ArrayList<>();

        foodlist.add(new PopularModel("Mutton Biriyani",R.drawable.muttonbiriyani,
                "Mutton biryani is a classic dish made by layering rice over slow cooked mutton gravy.",180,4,15,381));
        foodlist.add(new PopularModel("Chocolate Pizza",R.drawable.chololatepizza,
                "Chocolate pizza is a type of pizza prepared using chocolate as a primary ingredient.",120,4,20,599));
        foodlist.add(new PopularModel("Plate Shawarma",R.drawable.plateshawarma,
                "A fool-proof sheet pan chicken shawarma plate that is packed with protein and veggies",110,5,13,515));
        foodlist.add(new PopularModel("North Meal",R.drawable.norththali,
                "The typical dishes of a North Indian Thali include dal (lentil), rice, vegetable curry, roti (flat bread), dahi (yogurt), papad, salad, a small amount of chutney or pickle and a sweet dish.",200,4,25,90));
        foodlist.add(new PopularModel("Chinese Noodles",R.drawable.chinesenoodles,
                "This noodle is made from wheat flour and eggs, similar to Italian pasta.",110,4,17,100));
        foodlist.add(new PopularModel("Kebab Tikka",R.drawable.kebabchickentikka,
                "Chicken Tikka Kebab is a delicious appetizer that is packed with flavor. It starts with chicken pieces marinated in yogurt along with lime juice and aromatic spices, then threaded onto skewers and cooked to create a delicious appetizer.",220,5,20,380));
        foodlist.add(new PopularModel("Grill Chicken",R.drawable.grillchicken,
                "Crispy skin on the outside, and juicy, tender chicken from the inside, nothing beats an easy to cook Juicy Whole Grilled Chicken! ",300,5,15,430));

        PopularAdapter adapter2 = new PopularAdapter(foodlist,MainmenuActivity.this);
        recyclerViewPopularDishlist.setAdapter(adapter2);

    }

                private void recycleviewcategory() {

        GridLayoutManager gridLayoutManager = new GridLayoutManager(this,2,GridLayoutManager.HORIZONTAL,false);
        recycleviewcategorylist = (RecyclerView) findViewById(R.id.rv_categories);
        recycleviewcategorylist.setLayoutManager(gridLayoutManager);

        ArrayList<CategoriesModel> categoryList = new ArrayList<>();

        categoryList.add(new CategoriesModel("Biriyani",R.drawable.biryaniimg));
        categoryList.add(new CategoriesModel("Pizza",R.drawable.pizza));
        categoryList.add(new CategoriesModel("Tea & Beverage",R.drawable.tea));
        categoryList.add(new CategoriesModel("South Meal",R.drawable.vegmeals));
        categoryList.add(new CategoriesModel("Burger",R.drawable.burger));
        categoryList.add(new CategoriesModel("North thali",R.drawable.northmeals));
        categoryList.add(new CategoriesModel("Ice Cream",R.drawable.icecream));
        categoryList.add(new CategoriesModel("Cakes",R.drawable.cake));
        categoryList.add(new CategoriesModel("Rolls",R.drawable.rolls));
        categoryList.add(new CategoriesModel("Kebab",R.drawable.kebab));
        categoryList.add(new CategoriesModel("Bowls",R.drawable.bowls));

        CategoriesAdapter adapter =new CategoriesAdapter(categoryList,MainmenuActivity.this);
        recycleviewcategorylist.setAdapter(adapter);


    }

                 @Override
                 public void onBackPressed() {
        new AlertDialog.Builder(MainmenuActivity.this).setTitle("Exit !").setIcon(R.drawable.sad).setMessage("Are you sure to exit ?")
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }
                }).setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        }).setNeutralButton("Help", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainmenuActivity.this, "You got no other way out without ordering !", Toast.LENGTH_SHORT).show();
            }
        }).show();
    }


}