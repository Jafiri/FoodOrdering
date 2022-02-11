package com.example.foodordering.Adapters;

import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.foodordering.Activity.MainmenuActivity;
import com.example.foodordering.FoodActivity.BiriyaniActivity;
import com.example.foodordering.FoodActivity.BowlActivity;
import com.example.foodordering.FoodActivity.BurgerActivity;
import com.example.foodordering.FoodActivity.CakeActivity;
import com.example.foodordering.FoodActivity.IceCreamActivity;
import com.example.foodordering.FoodActivity.KebabActivity;
import com.example.foodordering.FoodActivity.NorthActivity;
import com.example.foodordering.FoodActivity.PizzaActivity;
import com.example.foodordering.FoodActivity.RollActivity;
import com.example.foodordering.FoodActivity.SouthActivity;
import com.example.foodordering.FoodActivity.TeaActivity;
import com.example.foodordering.Models.CategoriesModel;
import com.example.foodordering.R;
import java.util.ArrayList;

public class CategoriesAdapter extends RecyclerView.Adapter<CategoriesAdapter.ViewHolder> {

    ArrayList<CategoriesModel> categorieslist;
    Context context;


    public CategoriesAdapter(ArrayList<CategoriesModel> categorieslist, Context context) {
        this.categorieslist = categorieslist;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_categories,parent,false);
        return  new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        CategoriesModel categoriesModel = categorieslist.get(position);

        holder.categoryTitle.setText(categoriesModel.getTitle());
        holder.categoryImage.setImageResource(categoriesModel.getImage());

    }

    @Override
    public int getItemCount() {
        return categorieslist.size();
    }



    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener  {

        TextView categoryTitle;
        ImageView categoryImage;
        ConstraintLayout category_constraint;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            categoryTitle = (TextView) itemView.findViewById(R.id.txt_cat_name);
            categoryImage = (ImageView) itemView.findViewById(R.id.img_cat);
            category_constraint = (ConstraintLayout) itemView.findViewById(R.id.cat_constraint);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
           // Log.d("Click from ViewHolder ","Clicked" );

            int position = getAdapterPosition();

            final Intent intent;
            switch (position){
                case 0:
                    intent =  new Intent(context, BiriyaniActivity.class);
                    break;

                case 1:
                    intent =  new Intent(context, PizzaActivity.class);
                    break;

                case 2:
                    intent =  new Intent(context, TeaActivity.class);
                    break;

                case 3:
                    intent =  new Intent(context, SouthActivity.class);
                    break;

                case 4:
                    intent =  new Intent(context, BurgerActivity.class);
                    break;

                case 5:
                    intent =  new Intent(context, NorthActivity.class);
                    break;

                case 6:
                    intent =  new Intent(context, IceCreamActivity.class);
                    break;

                case 7:
                    intent =  new Intent(context, CakeActivity.class);
                    break;

                case 8 :
                    intent = new Intent(context, RollActivity.class);
                    break;

                case 9 :
                    intent = new Intent(context, KebabActivity.class);
                    break;

                case 10 :
                    intent = new Intent(context, BowlActivity.class);
                    break;

                default:
                    intent =  new Intent(context, MainmenuActivity.class);
                    break;
            }
            context.startActivity(intent);

        }
    }
}
