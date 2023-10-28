// Файл: SystemAAdapter.java
package com.example.4;

public class SystemAAdapter implements SmartHomeAdapter {
    private SystemA systemA;

    public SystemAAdapter(SystemA systemA) {
        this.systemA = systemA;
    }

    @Override
    public void performAction(String action) {
        switch (action) {
            case "повыситьТемпературу":
                systemA.setTemperature(systemA.getTemperature() + 1);
                System.out.println("Система A: Температура увеличена до " + systemA.getTemperature() + "°C");
                break;
            case "понизитьТемпературу":
                systemA.setTemperature(systemA.getTemperature() - 1);
                System.out.println("Система A: Температура уменьшена до " + systemA.getTemperature() + "°C");
                break;
            case "включитьСвет":
                systemA.включитьСвет();
                break;
            case "выключитьСвет":
                systemA.выключитьСвет();
                break;
            default:
                System.out.println("Неизвестное действие");
        }
    }
}
