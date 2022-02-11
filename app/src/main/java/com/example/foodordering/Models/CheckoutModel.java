package com.example.foodordering.Models;

public class CheckoutModel {

    private String foodtitle;
    private int foodprice;
    private int qantity;
    private double itemtotal;
    private int delivery;
    private double tax;
    private double grandtotal;

    public CheckoutModel(String foodtitle, int foodprice, int qantity, double itemtotal, int delivery, double tax, double grandtotal) {
        this.foodtitle = foodtitle;
        this.foodprice = foodprice;
        this.qantity = qantity;
        this.itemtotal = itemtotal;
        this.delivery = delivery;
        this.tax = tax;
        this.grandtotal = grandtotal;
    }

    public CheckoutModel() {
    }

    public int getFoodprice() {
        return foodprice;
    }

    public void setFoodprice(int foodprice) {
        this.foodprice = foodprice;
    }

    public String getFoodtitle() {
        return foodtitle;
    }

    public void setFoodtitle(String foodtitle) {
        this.foodtitle = foodtitle;
    }

    public int getQantity() {
        return qantity;
    }

    public void setQantity(int qantity) {
        this.qantity = qantity;
    }

    public double getItemtotal() {
        return itemtotal;
    }

    public void setItemtotal(double itemtotal) {
        this.itemtotal = itemtotal;
    }

    public int getDelivery() {
        return delivery;
    }

    public void setDelivery(int delivery) {
        this.delivery = delivery;
    }

    public double getTax() {
        return tax;
    }

    public void setTax(double tax) {
        this.tax = tax;
    }

    public double getGrandtotal() {
        return grandtotal;
    }

    public void setGrandtotal(double grandtotal) {
        this.grandtotal = grandtotal;
    }
}
