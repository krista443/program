import java.util.Scanner;

// Интерфейс для реализации различных виртуализационных систем
interface VirtualizationSystem {
    void startVirtualMachine();
    void stopVirtualMachine();
}

// Класс для управления виртуальными машинами через паттерн "мост"
abstract class VirtualMachine {
    protected VirtualizationSystem virtualizationSystem;

    public VirtualMachine(VirtualizationSystem virtualizationSystem) {
        this.virtualizationSystem = virtualizationSystem;
    }

    public abstract void start();
    public abstract void stop();
    public abstract void restart();
}

// Конкретные реализации виртуальных машин
class VMwareVirtualMachine extends VirtualMachine {
    public VMwareVirtualMachine(VirtualizationSystem virtualizationSystem) {
        super(virtualizationSystem);
    }

    @Override
    public void start() {
        virtualizationSystem.startVirtualMachine();
        System.out.println("VMware Virtual Machine started.");
    }

    @Override
    public void stop() {
        virtualizationSystem.stopVirtualMachine();
        System.out.println("VMware Virtual Machine stopped.");
    }

    @Override
    public void restart() {
        stop();
        start();
    }
}

class HyperVVirtualMachine extends VirtualMachine {
    public HyperVVirtualMachine(VirtualizationSystem virtualizationSystem) {
        super(virtualizationSystem);
    }

    @Override
    public void start() {
        virtualizationSystem.startVirtualMachine();
        System.out.println("Hyper-V Virtual Machine started.");
    }

    @Override
    public void stop() {
        virtualizationSystem.stopVirtualMachine();
        System.out.println("Hyper-V Virtual Machine stopped.");
    }

    @Override
    public void restart() {
        stop();
        start();
    }
}

// Классы для конкретных виртуализационных систем
class VMwareSystem implements VirtualizationSystem {
    @Override
    public void startVirtualMachine() {
        // Логика запуска виртуальной машины в VMware
        System.out.println("Starting VMware Virtual Machine...");
    }

    @Override
    public void stopVirtualMachine() {
        // Логика остановки виртуальной машины в VMware
        System.out.println("Stopping VMware Virtual Machine...");
    }
}

class HyperVSystem implements VirtualizationSystem {
    @Override
    public void startVirtualMachine() {
        // Логика запуска виртуальной машины в Hyper-V
        System.out.println("Starting Hyper-V Virtual Machine...");
    }

    @Override
    public void stopVirtualMachine() {
        // Логика остановки виртуальной машины в Hyper-V
        System.out.println("Stopping Hyper-V Virtual Machine...");
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Выбор виртуальной машины
        System.out.println("Выберите виртуальную машину:");
        System.out.println("1. VMware Virtual Machine");
        System.out.println("2. Hyper-V Virtual Machine");
        int vmChoice = scanner.nextInt();

        VirtualMachine virtualMachine = null;
        VirtualizationSystem virtualizationSystem = null;

        // Выбор виртуальной системы
        if (vmChoice == 1) {
            virtualizationSystem = new VMwareSystem();
            virtualMachine = new VMwareVirtualMachine(virtualizationSystem);
        } else if (vmChoice == 2) {
            virtualizationSystem = new HyperVSystem();
            virtualMachine = new HyperVVirtualMachine(virtualizationSystem);
        } else {
            System.out.println("Неправильный выбор виртуальной машины.");
            return;
        }

        // Выбор действия
        System.out.println("Выберите действие:");
        System.out.println("1. Включить виртуальную машину");
        System.out.println("2. Выключить виртуальную машину");
        System.out.println("3. Перезагрузить виртуальную машину");
        int actionChoice = scanner.nextInt();

        switch (actionChoice) {
            case 1:
                virtualMachine.start();
                break;
            case 2:
                virtualMachine.stop();
                break;
            case 3:
                virtualMachine.restart();
                break;
            default:
                System.out.println("Неправильный выбор действия.");
        }

        scanner.close();
    }
}
