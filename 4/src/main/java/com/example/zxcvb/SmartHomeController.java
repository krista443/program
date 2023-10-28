package com.example.4;
import java.util.Scanner;

public class SmartHomeController {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Managing Smart Home using System A Adapter:");
        System.out.println("Enter action: 1 - Увеличение температуры, 2 - Уменьшение температуры, 3 - Включить свет, 4 - Ввыключить свет");
        int action = scanner.nextInt();

        SmartHomeAdapter adapterA = new SystemAAdapter(new SystemA());
        System.out.println("Managing Smart Home using System A Adapter:");
        performAction(adapterA, action);

        SmartHomeAdapter adapterB = new SystemBAdapter(new SystemB());
        System.out.println("Managing Smart Home using System B Adapter:");
        performAction(adapterB, action);
    }

    private static void performAction(SmartHomeAdapter adapter, int action) {
        switch (action) {
            case 1:
                adapter.performAction("повыситьТемпературу");
                break;
            case 2:
                adapter.performAction("понизитьТемпературу");
                break;
            case 3:
                adapter.performAction("включитьСвет");
                break;
            case 4:
                adapter.performAction("выключитьСвет");
                break;
            default:
                System.out.println("Неизвестное действие");
        }
    }
}
