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
import com.example.foodordering.Models.BiriyaniModel;
import com.example.foodordering.Models.CakeModel;
import com.example.foodordering.Models.OrderListModel;
import com.example.foodordering.R;

import java.util.ArrayList;

public class CakeAdapter extends RecyclerView.Adapter<CakeAdapter.ViewHolder> {

    ArrayList<CakeModel> cakelist;
    Context context;
    Application activity;
    String name;
    int price,image;
    UpdateSelectedItemsInterface updateSelectedItemsInterface;

    public CakeAdapter(ArrayList<CakeModel> cakelist, Context context,UpdateSelectedItemsInterface updateSelectedItemsInterface) {
        this.cakelist = cakelist;
        this.context = context;
        this.updateSelectedItemsInterface = updateSelectedItemsInterface;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_food_card,parent,false);
        return  new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        CakeModel cakeModel = cakelist.get(position);

        holder.image.setImageResource(cakeModel.getImage());
        holder.title.setText(cakeModel.getTitle());
        holder.fee.setText(String.valueOf("₹ "+cakeModel.getFee()));



        holder.description.setText(cakeModel.getDescription());
        holder.time.setText(String.valueOf(cakeModel.getTime()));
        holder.calories.setText(String.valueOf(cakeModel.getCalories()));
        holder.star.setText(String.valueOf(cakeModel.getStar()));

        for (OrderListModel o : ((UpdateSelectedItemsInterface) ApplicationMain.getMyContext()).getItems()){
            if(o.getName().equals(cakeModel.getTitle())){
                holder.cart.setVisibility(View.INVISIBLE);
                holder.cartdone.setVisibility(View.VISIBLE);
            }
        }

        holder.cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                name = cakeModel.getTitle();
                price = cakeModel.getFee();
                image = cakeModel.getImage();

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
                        if (o.getName().equals(cakeModel.getTitle())) {
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
        return cakelist.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView image,cart,cartdone;
        TextView title,description,fee,star,time,calories,total_price;
        LinearLayout food_lineatlayout;
        ConstraintLayout food_constraintlayout_1,food_constraintlayout_2;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            image = (ImageView) itemView.findViewById(R.id.img_food);
            cart = (ImageView) itemView.findViewById(R.id.img_cart);
            cartdone = (ImageView) itemView.findViewById(R.id.img_cartdone);
            title =(TextView) itemView.findViewById(R.id.food_title);
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
