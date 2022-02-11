package com.example.foodordering.Interface;

import com.example.foodordering.Models.OrderListModel;

import java.util.ArrayList;

public interface UpdateSelectedItemsInterface {

    void additem(String name, int price, int image);

    ArrayList<OrderListModel> getItems();



}
