// Файл: SystemB.java
package com.example.4;

public class SystemB {
    private int temperature; // поле для хранения температуры
    private boolean isLightOn; // флаг для состояния света (включен/выключен)

    public void setTemperature(int temperature) {
        this.temperature = temperature;
    }

    public int getTemperature() {
        return temperature;
    }

    public void adjustTemperature(int temperature) {
        this.temperature = temperature;
        System.out.println("Температура установлена на " + temperature + "°C");
    }

    public void turnOnLight() {
        isLightOn = true;
        System.out.println("Свет включен");
    }

    public void turnOffLight() {
        isLightOn = false;
        System.out.println("Свет выключен");
    }

    // Другие методы вашего класса SystemB
}
