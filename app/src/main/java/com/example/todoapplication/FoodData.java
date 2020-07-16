package com.example.todoapplication;

public class FoodData {

    String itemName;
    String itemDescription;
    String itemPrice;
    int itemImage;


    public FoodData(String itemName, String itemDescription, String itemPrice, int itemImage) {
        this.itemName = itemName;
        this.itemDescription = itemDescription;
        this.itemPrice = itemPrice;
        this.itemImage = itemImage;
    }

    public String getItemName() {
        return itemName;
    }

    public String getItemDescription() {
        return itemDescription;
    }

    public String getItemPrice() {
        return itemPrice;
    }

    public int getItemImage() {
        return itemImage;
    }
}