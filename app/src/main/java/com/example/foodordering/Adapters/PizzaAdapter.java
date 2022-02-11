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
import com.example.foodordering.Models.OrderListModel;
import com.example.foodordering.Models.PizzaModel;
import com.example.foodordering.R;

import java.util.ArrayList;

public class PizzaAdapter extends RecyclerView.Adapter<PizzaAdapter.ViewHolder> {

    ArrayList<PizzaModel> pizzalist;
    Context context;
    Application activity;
    String name;
    int price,image;
    UpdateSelectedItemsInterface updateSelectedItemsInterface;

    public PizzaAdapter(ArrayList<PizzaModel> pizzalist, Context context,UpdateSelectedItemsInterface updateSelectedItemsInterface) {
        this.pizzalist = pizzalist;
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

        PizzaModel pizzaModel = pizzalist.get(position);

        holder.image.setImageResource(pizzaModel.getImage());
        holder.title.setText(pizzaModel.getTitle());
        holder.fee.setText(String.valueOf("₹ "+pizzaModel.getFee()));

        holder.description.setText(pizzaModel.getDescription());
        holder.time.setText(String.valueOf(pizzaModel.getTime()));
        holder.calories.setText(String.valueOf(pizzaModel.getCalories()));
        holder.star.setText(String.valueOf(pizzaModel.getStar()));

        for (OrderListModel o : ((UpdateSelectedItemsInterface) ApplicationMain.getMyContext()).getItems()){
            if(o.getName().equals(pizzaModel.getTitle())){
                holder.cart.setVisibility(View.INVISIBLE);
                holder.cartdone.setVisibility(View.VISIBLE);
            }
        }

        holder.cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                name = pizzaModel.getTitle();
                price = pizzaModel.getFee();
                image = pizzaModel.getImage();

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
                        if (o.getName().equals(pizzaModel.getTitle())) {
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
        return pizzalist.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView image,cart,cartdone;;
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
