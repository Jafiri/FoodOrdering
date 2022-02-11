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
import com.example.foodordering.R;

import java.util.ArrayList;

public class BiriyaniAdapter extends RecyclerView.Adapter<BiriyaniAdapter.Viewholder> {



    ArrayList<BiriyaniModel> biriyanilist;
    Context context;
    Application activity;
    String name;
    int price,image;
    UpdateSelectedItemsInterface updateSelectedItemsInterface;

    public BiriyaniAdapter(ArrayList<BiriyaniModel> biriyanilist, Context context, UpdateSelectedItemsInterface updateSelectedItemsInterface) {
        this.biriyanilist = biriyanilist;
        this.context = context;
        this.updateSelectedItemsInterface = updateSelectedItemsInterface;
    }

    @NonNull
    @Override
    public Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_food_card,parent,false);
        return  new Viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Viewholder holder, int position) {

        BiriyaniModel biriyaniModel = biriyanilist.get(position);

        holder.image.setImageResource(biriyaniModel.getImage());
       holder.title.setText(biriyaniModel.getTitle());
       holder.fee.setText(String.valueOf("₹ "+biriyaniModel.getFee()));

       holder.description.setText(biriyaniModel.getDescription());
       holder.time.setText(String.valueOf(biriyaniModel.getTime()));
       holder.calories.setText(String.valueOf(biriyaniModel.getCalories()));
       holder.star.setText(String.valueOf(biriyaniModel.getStar()));

       for (OrderListModel o : ((UpdateSelectedItemsInterface) ApplicationMain.getMyContext()).getItems()){
           if(o.getName().equals(biriyaniModel.getTitle())){
               holder.cart.setVisibility(View.INVISIBLE);
               holder.cartdone.setVisibility(View.VISIBLE);
           }
       }

       holder.cart.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {

               name = biriyaniModel.getTitle();
               price = biriyaniModel.getFee();
               image = biriyaniModel.getImage();

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
                       if (o.getName().equals(biriyaniModel.getTitle())) {
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
        return biriyanilist.size();
    }

    public class Viewholder extends RecyclerView.ViewHolder {

        ImageView image,cart,cartdone;
        TextView title,description,fee,star,time,calories,total_price;
        LinearLayout food_lineatlayout;
        ConstraintLayout food_constraintlayout_1,food_constraintlayout_2;


        public Viewholder(@NonNull View itemView) {
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
