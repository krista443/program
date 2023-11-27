package com.example.demo11;

import java.util.ArrayList;
import java.util.List;

public class Order implements Cloneable {
    private List<String> items;
    private String deliveryAddress;

    public Order() {
        this.items = new ArrayList<>();
    }

    public void addItem(String item) {
        items.add(item);
    }

    public List<String> getItems() {
        return new ArrayList<>(items);
    }

    public void setDeliveryAddress(String deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }

    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    @Override
    public Order clone() {
        Order clonedOrder = new Order();
        clonedOrder.items = new ArrayList<>(this.items);
        clonedOrder.deliveryAddress = this.deliveryAddress;
        return clonedOrder;
    }
}

