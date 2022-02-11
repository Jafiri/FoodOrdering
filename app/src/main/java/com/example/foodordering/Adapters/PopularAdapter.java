package com.example.foodordering.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.foodordering.Models.PopularModel;
import com.example.foodordering.R;

import java.util.ArrayList;

public class PopularAdapter extends RecyclerView.Adapter<PopularAdapter.ViewHolder> {



    ArrayList<PopularModel> foodlist;
    Context context;

    public PopularAdapter(ArrayList<PopularModel> foodlist, Context context) {
        this.foodlist = foodlist;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_popular,parent,false);
        return  new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        PopularModel popularModel = foodlist.get(position);

        holder.image.setImageResource(popularModel.getImage());
        holder.title.setText(popularModel.getTitle());
        holder.fee.setText(String.valueOf("₹ "+ popularModel.getFee()));

    }

    @Override
    public int getItemCount() {

        return foodlist.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView image, plus_button;
        TextView title,fee;
        ConstraintLayout pop_layout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            image = (ImageView) itemView.findViewById(R.id.img_pop);
            plus_button = (ImageView) itemView.findViewById(R.id.btn_add);
            title = (TextView) itemView.findViewById(R.id.txt_title);
            fee = (TextView) itemView.findViewById(R.id.txt_fee);
            pop_layout = (ConstraintLayout) itemView.findViewById(R.id.pop_layout);

        }
    }
}
