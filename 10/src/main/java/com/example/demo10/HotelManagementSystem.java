package com.example.demo10;

import javax.swing.*;


class BookingSystem {
    public boolean isRoomAvailable(int roomNumber) {

        return true;
    }

    public void bookRoom(int roomNumber) {

        System.out.println("Номер " + roomNumber + " забронирован.");
    }

    public void payForStay(int roomNumber) {

        System.out.println("Оплата за номер " + roomNumber + " прошла успешно.");
    }
}


class HotelFacade {
    private BookingSystem bookingSystem;

    public HotelFacade(BookingSystem bookingSystem) {
        this.bookingSystem = bookingSystem;
    }

    public void bookAndPay(int roomNumber) {
        if (bookingSystem.isRoomAvailable(roomNumber)) {
            bookingSystem.bookRoom(roomNumber);
            bookingSystem.payForStay(roomNumber);
        } else {
            System.out.println("Извините, номер " + roomNumber + " недоступен.");
        }
    }
}


public class HotelManagementSystem {
    public static void main(String[] args) {
        BookingSystem bookingSystem = new BookingSystem();
        HotelFacade hotelFacade = new HotelFacade(bookingSystem);

        // Интерфейс Swing
        JFrame frame = new JFrame("Hotel Management System");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);

        JButton bookButton = new JButton("Забронировать и оплатить");
        bookButton.addActionListener(e -> {
            int roomNumber = Integer.parseInt(JOptionPane.showInputDialog("Введите номер комнаты:"));
            hotelFacade.bookAndPay(roomNumber);
        });

        frame.getContentPane().add(bookButton);
        frame.setVisible(true);
    }
}

