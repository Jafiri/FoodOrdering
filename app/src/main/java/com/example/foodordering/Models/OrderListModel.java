package com.example.foodordering.Models;

public class OrderListModel {

    private  String name;
    private int price;
    private int qty;
    private int image;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }


    public OrderListModel(String name, int price, int image ) {
        this.name = name;
        this.price = price;
        this.image = image;

    }

    public OrderListModel() {
    }
    //
//
//
//    public String getName() {
//        return name;
//    }
//
//    public int getPrice() {
//        return price;
//    }
//
//    public int getImage() {
//        return image;
//    }

}
