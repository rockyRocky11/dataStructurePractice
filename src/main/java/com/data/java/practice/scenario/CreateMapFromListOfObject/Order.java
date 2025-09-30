package com.data.java.practice.scenario.CreateMapFromListOfObject;

import java.time.*;
import java.util.*;
public class Order {
    public String orderID;
    public List<Product> products;

    public double totalValue;

    public LocalTime orderTime;

    public Order(String orderID, List<Product> products, double totalValue, LocalTime orderTime) {
        this.orderID = orderID;
        this.products = products;
        this.totalValue = totalValue;
        this.orderTime = orderTime;
    }
}
