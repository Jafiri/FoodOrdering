package com.example.foodordering.Adapters;

import android.app.Application;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.foodordering.ApplicationMain;
import com.example.foodordering.Interface.UpdateSelectedItemsInterface;
import com.example.foodordering.Models.NorthModel;
import com.example.foodordering.Models.OrderListModel;
import com.example.foodordering.Models.PizzaModel;
import com.example.foodordering.R;

import java.util.ArrayList;

public class NorthAdapter extends RecyclerView.Adapter<NorthAdapter.VierHolder> {

    ArrayList<NorthModel> northlist;
    Context context;
    Application activity;
    String name;
    int price,image;
    UpdateSelectedItemsInterface updateSelectedItemsInterface;

    public NorthAdapter(ArrayList<NorthModel> northlist, Context context,UpdateSelectedItemsInterface updateSelectedItemsInterface) {
        this.northlist = northlist;
        this.context = context;
        this.updateSelectedItemsInterface = updateSelectedItemsInterface;
    }

    @NonNull
    @Override
    public VierHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_food_card,parent,false);
        return new VierHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull VierHolder holder, int position) {
        NorthModel northModel = northlist.get(position);

        holder.image.setImageResource(northModel.getImage());
        holder.title.setText(northModel.getTitle());
        holder.fee.setText(String.valueOf("₹ "+northModel.getFee()));



        holder.description.setText(northModel.getDescription());
        holder.time.setText(String.valueOf(northModel.getTime()));
        holder.calories.setText(String.valueOf(northModel.getCalories()));
        holder.star.setText(String.valueOf(northModel.getStar()));

        for (OrderListModel o : ((UpdateSelectedItemsInterface) ApplicationMain.getMyContext()).getItems()){
            if(o.getName().equals(northModel.getTitle())){
                holder.cart.setVisibility(View.INVISIBLE);
                holder.cartdone.setVisibility(View.VISIBLE);
            }
        }

        holder.cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                name = northModel.getTitle();
                price = northModel.getFee();
                image = northModel.getImage();

                ((UpdateSelectedItemsInterface) ApplicationMain.getMyContext()).additem(name, price,image);

                holder.cart.setVisibility(View.INVISIBLE);
                holder.cartdone.setVisibility(View.VISIBLE);

            }
        });

        holder.cartdone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                holder.cart.setVisibility(View.VISIBLE);
                holder.cartdone.setVisibility(View.INVISIBLE);
                try {
                    for (OrderListModel o : ((UpdateSelectedItemsInterface) ApplicationMain.getMyContext()).getItems()) {
                        if (o.getName().equals(northModel.getTitle())) {
                            ((UpdateSelectedItemsInterface) ApplicationMain.getMyContext()).getItems().remove(o);
                        }
                    }
                }catch (Exception e){

                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return northlist.size();
    }

    public class VierHolder extends RecyclerView.ViewHolder {

        ImageView image,cart,cartdone;
        TextView title,description,fee,star,time,calories,total_price;
        LinearLayout food_lineatlayout;
        ConstraintLayout food_constraintlayout_1,food_constraintlayout_2;
        public VierHolder(@NonNull View itemView) {
            super(itemView);

            image = (ImageView) itemView.findViewById(R.id.img_food);
            title =(TextView) itemView.findViewById(R.id.food_title);
            cart = (ImageView) itemView.findViewById(R.id.img_cart);
            cartdone = (ImageView) itemView.findViewById(R.id.img_cartdone);
            description =(TextView) itemView.findViewById(R.id.food_description);
            fee =(TextView) itemView.findViewById(R.id.food_fee);

            star =(TextView) itemView.findViewById(R.id.food_star);
            time =(TextView) itemView.findViewById(R.id.food_time);
            calories =(TextView) itemView.findViewById(R.id.food_calories);
            food_lineatlayout =(LinearLayout) itemView.findViewById(R.id.food_lineatlayout);
            food_constraintlayout_1 =(ConstraintLayout) itemView.findViewById(R.id.food_constraintlayout_1);




        }
    }
}
