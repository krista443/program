package com.example.demo11;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class OrderSystemGUI extends JFrame {
    private OrderManager orderManager;

    private JTextArea orderTextArea;

    public OrderSystemGUI(OrderManager orderManager) {
        this.orderManager = orderManager;

        setTitle("Order Management System");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);

        initUI();

        setVisible(true);
    }

    private void initUI() {
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        orderTextArea = new JTextArea();
        orderTextArea.setEditable(false);
        panel.add(new JScrollPane(orderTextArea), BorderLayout.CENTER);

        JButton cloneButton = new JButton("Клонировать заказ");
        cloneButton.addActionListener(e -> cloneOrder());
        panel.add(cloneButton, BorderLayout.SOUTH);

        updateOrderTextArea();
        add(panel);
    }

    private void cloneOrder() {
        List<Order> orders = orderManager.getOrders();
        if (!orders.isEmpty()) {
            Order originalOrder = orders.get(orders.size() - 1);
            Order clonedOrder = originalOrder.clone();
            clonedOrder.setDeliveryAddress("Новый адрес");
            orderManager.addOrder(clonedOrder);
            updateOrderTextArea();
        }
    }

    private void updateOrderTextArea() {
        List<Order> orders = orderManager.getOrders();
        StringBuilder orderText = new StringBuilder();
        for (Order order : orders) {
            orderText.append("Адрес доставки: ").append(order.getDeliveryAddress()).append("\n");
            orderText.append("Предметы: ").append(order.getItems()).append("\n");
            orderText.append("\n");
        }
        orderTextArea.setText(orderText.toString());
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            OrderManager orderManager = new OrderManager();
            OrderSystemGUI orderSystemGUI = new OrderSystemGUI(orderManager);

            Order order1 = new Order();
            order1.addItem("Предмет1");
            order1.addItem("Предмет2");
            order1.setDeliveryAddress("Адрес1");
            orderManager.addOrder(order1);

            Order order2 = new Order();
            order2.addItem("Предмет3");
            order2.addItem("Предмет4");
            order2.setDeliveryAddress("Адрес2");
            orderManager.addOrder(order2);
        });
    }
}
