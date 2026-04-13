package com.bai3.session7_bai3.model;

public class Food {
    private int id;
    private String name;
    private String category;
    private double price;
    private String imagePath;

    public Food() {}

    public Food(int id, String name, String category, double price, String imagePath) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.price = price;
        this.imagePath = imagePath;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public String getCategory() { return category; }
    public double getPrice() { return price; }
    public String getImagePath() { return imagePath; }

    public void setId(int id) { this.id = id; }
    public void setName(String name) { this.name = name; }
    public void setCategory(String category) { this.category = category; }
    public void setPrice(double price) { this.price = price; }
    public void setImagePath(String imagePath) { this.imagePath = imagePath; }
}
