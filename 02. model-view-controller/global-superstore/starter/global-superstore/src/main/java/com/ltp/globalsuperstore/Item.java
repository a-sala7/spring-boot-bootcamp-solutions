package com.ltp.globalsuperstore;

import java.util.Date;
import java.util.UUID;

import org.springframework.format.annotation.DateTimeFormat;

public class Item {
    private String id;
    private String category;
    private String name;
    private Double price;
    private Double discount;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date date;

    public Item() {
        this.id = UUID.randomUUID().toString();
    }

    public Item(String id, String category, String name, Double price, Double discount, Date date) {
        if(id == null || id.trim().equals("")){
            throw new IllegalArgumentException();
        }
        this.id = id;
        this.category = category;
        this.name = name;
        this.price = price;
        this.discount = discount;
        this.date = date;
    }

    public static Item fromItemForm(ItemForm itemForm){
        return new Item(itemForm.getId(), itemForm.getCategory(), itemForm.getName(), itemForm.getPrice(), itemForm.getDiscount(), itemForm.getDate());
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
    }
    public void setCategory(String category) {
        boolean found = false;
        for(String c : Constants.CATEGORIES){
            if(c.equals(category))
                found = true;
        }
        if(!found){
            throw new IllegalArgumentException("Invalid category for item");
        }
        this.category = category;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Double getPrice() {
        return price;
    }
    public void setPrice(Double price) {
        this.price = price;
    }
    public Double getDiscount() {
        return discount;
    }
    public void setDiscount(Double discount) {
        this.discount = discount;
    }
    public Date getDate() {
        return date;
    }
    public void setDate(Date date) {
        this.date = date;
    }
}
