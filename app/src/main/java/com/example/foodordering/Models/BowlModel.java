package com.example.foodordering.Models;

public class BowlModel {

    private String title ;
    private int image;
    private String description;
    private int fee;
    private int star;
    private int time;
    private int calories;

    private boolean expandable ;

    public BowlModel(String title, int image, String description, int fee, int star, int time, int calories) {
        this.title = title;
        this.image = image;
        this.description = description;
        this.fee = fee;
        this.star = star;
        this.time = time;
        this.calories = calories;
    }


    public boolean isExpandable() {
        return expandable;
    }

    public void setExpandable(boolean expandable) {
        this.expandable = expandable;
    }




    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getFee() {
        return fee;
    }

    public void setFee(int fee) {
        this.fee = fee;
    }

    public int getStar() {
        return star;
    }

    public void setStar(int star) {
        this.star = star;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public int getCalories() {
        return calories;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }
}
