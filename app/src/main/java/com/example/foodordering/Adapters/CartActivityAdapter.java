package com.example.foodordering.Adapters;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.foodordering.Activity.CartActivity;
import com.example.foodordering.Activity.MainmenuActivity;
import com.example.foodordering.ApplicationMain;
import com.example.foodordering.Interface.UpdateSelectedItemsInterface;
import com.example.foodordering.Models.CheckoutModel;
import com.example.foodordering.Models.OrderListModel;
import com.example.foodordering.R;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class CartActivityAdapter extends RecyclerView.Adapter<CartActivityAdapter.viewHolder> {

    private ArrayList<OrderListModel> orderListModels;

    Activity activity;

    public CartActivityAdapter ( Activity activity) {
        this.orderListModels = ((UpdateSelectedItemsInterface) ApplicationMain.getMyContext()).getItems();
        this.activity = activity;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_food_cart,parent,false);
        return  new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {

        OrderListModel orderListItem = orderListModels.get(position);

        holder.name.setText(orderListItem.getName());
        holder.price.setText(String.valueOf("₹ "+orderListItem.getPrice()));
        holder.image.setImageResource(orderListItem.getImage());
        holder.totalprice.setText("0");

        holder.plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int qty = Integer.parseInt(holder.qantity.getText().toString());
                qty++;
                orderListItem.setQty(qty);

                double price = orderListItem.getPrice() * orderListItem.getQty();
                holder.qantity.setText(String.valueOf(qty));
                holder.totalprice.setText(String.valueOf(price));

                orderListModels.set(position, orderListItem);

                double itemoverallPrice = 0.0;
                int deliveryprice = 30;
                double taxprice = 5.0;
                double tax;

                for(OrderListModel o : orderListModels){
                    itemoverallPrice += o.getPrice() * o.getQty() ;
                }
               tax =  itemoverallPrice *(taxprice/100);

               double grandtotal = (itemoverallPrice + tax + deliveryprice)*100/100;

                TextView itemsTotal = (TextView) activity.findViewById(R.id.itemTotaltxt);
                TextView pricetax  = (TextView) activity.findViewById(R.id.taxPricetxt) ;
                TextView pricedelivery  = (TextView) activity.findViewById(R.id.deleveryPricetxt) ;
                TextView totalgrand  = (TextView) activity.findViewById(R.id.overAllTxt) ;

                itemsTotal.setText(String.valueOf(itemoverallPrice+" ₹"));
                pricetax.setText(String.valueOf(taxprice+" %"));
                pricedelivery.setText(String.valueOf(deliveryprice+" ₹"));
                totalgrand.setText(String.valueOf(grandtotal+" ₹"));
            }
        });

        holder.minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int qty = Integer.parseInt(holder.qantity.getText().toString());
                if(qty>0){
                qty--;}

                orderListItem.setQty(qty);

                holder.qantity.setText(String.valueOf(qty));
                double price = orderListItem.getPrice() * orderListItem.getQty();
                holder.totalprice.setText(String.valueOf(price));

                orderListModels.set(position, orderListItem);

                double itemoverallPrice = 0.0;
                int deliveryprice = 30;
                double taxprice = 5.0;
                double tax;

                for(OrderListModel o : orderListModels){
                    itemoverallPrice += o.getPrice() * o.getQty() ;

                }
                tax =  itemoverallPrice *(taxprice/100);

                double grandtotal = (itemoverallPrice + tax + deliveryprice)*100/100;

                TextView itemsTotal = (TextView) activity.findViewById(R.id.itemTotaltxt);
                TextView pricetax  = (TextView) activity.findViewById(R.id.taxPricetxt) ;
                TextView pricedelivery  = (TextView) activity.findViewById(R.id.deleveryPricetxt) ;
                TextView totalgrand  = (TextView) activity.findViewById(R.id.overAllTxt) ;

                itemsTotal.setText(String.valueOf(itemoverallPrice+" ₹"));
                pricetax.setText(String.valueOf(taxprice+" %"));
                pricedelivery.setText(String.valueOf(deliveryprice+" ₹"));
                totalgrand.setText(String.valueOf(grandtotal+" ₹"));
            }
        });

        ConstraintLayout checkoutbutton = (ConstraintLayout) activity.findViewById(R.id.btn_checkout);

        checkoutbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new AlertDialog.Builder(activity).setTitle("Thank you for ordering").setIcon(R.drawable.avatar).setMessage("Your order will be delivered soon")
                       .show();            }
        });

    }

    @Override
    public int getItemCount() {
        return orderListModels.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder {

        TextView name, price, qantity, plus, minus, totalprice ;
        ImageView image ;

        public viewHolder(@NonNull View itemView) {
            super(itemView);
            name = (TextView) itemView.findViewById(R.id.cart_food_title);
            price = (TextView) itemView.findViewById(R.id.cart_food_fee);
            qantity = (TextView) itemView.findViewById(R.id.cart_txt_quantity);
            plus = (TextView) itemView.findViewById(R.id.cart_txt_plus);
            minus = (TextView) itemView.findViewById(R.id.cart_txt_minus);
            totalprice = (TextView) itemView.findViewById(R.id.cart_txt_total);
            image = (ImageView) itemView.findViewById(R.id.cart_img_food);

        }
    }


}
