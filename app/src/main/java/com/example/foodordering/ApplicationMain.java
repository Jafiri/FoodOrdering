package com.example.foodordering;

import android.app.Application;
import android.content.Context;

import com.example.foodordering.Adapters.CartActivityAdapter;
import com.example.foodordering.Interface.UpdateSelectedItemsInterface;
import com.example.foodordering.Models.OrderListModel;

import java.util.ArrayList;

public class ApplicationMain extends Application implements UpdateSelectedItemsInterface {

    private static Context context;
    ArrayList<OrderListModel> orderListModels;


    @Override
    public void onCreate() {
            super.onCreate();
            context = getApplicationContext();
            orderListModels = new ArrayList<>();
    }

    public static Context getMyContext(){
        return context;
    }

    @Override
    public void additem(String name, int price, int image) {
        orderListModels.add(new OrderListModel(name, price, image));
    }

    @Override
    public ArrayList<OrderListModel> getItems() {
        return orderListModels;
    }




}
