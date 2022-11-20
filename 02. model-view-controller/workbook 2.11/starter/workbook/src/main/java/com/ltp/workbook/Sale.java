package com.ltp.workbook;

import java.math.BigDecimal;

public class Sale {
    private String item;
    private BigDecimal revenue;
    private BigDecimal cost;
    
    public Sale() {
    }

    public Sale(String item, BigDecimal revenue, BigDecimal cost) {
        this.item = item;
        this.revenue = revenue;
        this.cost = cost;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public BigDecimal getRevenue() {
        return revenue;
    }

    public void setRevenue(BigDecimal revenue) {
        this.revenue = revenue;
    }

    public BigDecimal getCost() {
        return cost;
    }

    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }
}
