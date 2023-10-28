// Файл: SystemBAdapter.java
package com.example.zxcvb;

public class SystemBAdapter implements SmartHomeAdapter {
    private SystemB systemB;

    public SystemBAdapter(SystemB systemB) {
        this.systemB = systemB;
    }

    @Override
    public void performAction(String action) {
        switch (action) {
            case "повыситьТемпературу":
                systemB.adjustTemperature(systemB.getTemperature() + 1);
                System.out.println("Система B: Температура увеличена до " + systemB.getTemperature() + "°C");
                break;
            case "понизитьТемпературу":
                systemB.adjustTemperature(systemB.getTemperature() - 1);
                System.out.println("Система B: Температура уменьшена до " + systemB.getTemperature() + "°C");
                break;
            case "включитьСвет":
                systemB.turnOnLight();
                break;
            case "выключитьСвет":
                systemB.turnOffLight();
                break;
            default:
                System.out.println("Неизвестное действие");
        }
    }
}
