package com.example.demo5;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class СистемаУведомленийОбОтправкеПочты extends JFrame {

    private JTextArea логТекста;

    public СистемаУведомленийОбОтправкеПочты() {
        super("Система уведомлений по электронной почте");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);

        логТекста = new JTextArea();
        логТекста.setEditable(false);

        JScrollPane scrollPane = new JScrollPane(логТекста);

        JButton подписатьсяКнопка = new JButton("Подписаться на уведомления");
        JButton отправитьПисьмоКнопка = new JButton("Отправить письмо");

        подписатьсяКнопка.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                подписатьсяНаУведомления();
            }
        });

        отправитьПисьмоКнопка.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                отправитьПисьмо();
            }
        });

        JPanel панельКнопок = new JPanel();
        панельКнопок.add(подписатьсяКнопка);
        панельКнопок.add(отправитьПисьмоКнопка);

        getContentPane().add(scrollPane, "Center");
        getContentPane().add(панельКнопок, "South");
    }

    private void подписатьсяНаУведомления() {
        String email = JOptionPane.showInputDialog(this, "Введите ваш адрес электронной почты:");
        if (email != null && !email.isEmpty()) {
            лог("Подписка на уведомления по адресу: " + email);
        } else {
            лог("Некорректный адрес электронной почты. Подписка не удалась.");
        }
    }

    private void отправитьПисьмо() {
        String получатель = JOptionPane.showInputDialog(this, "Введите адрес электронной почты получателя:");
        if (получатель != null && !получатель.isEmpty()) {

            boolean успех = симулироватьОтправкуПисьма(получатель);
            if (успех) {
                лог("Письмо успешно отправлено по адресу: " + получатель);
            } else {
                лог("Не удалось отправить письмо по адресу: " + получатель);
            }
        } else {
            лог("Некорректный адрес электронной почты получателя. Отправка письма не удалась.");
        }
    }

    private boolean симулироватьОтправкуПисьма(String получатель) {

        return true;
    }

    private void лог(String сообщение) {
        логТекста.append(сообщение + "\n");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new СистемаУведомленийОбОтправкеПочты().setVisible(true);
            }
        });
    }
}
