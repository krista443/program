import java.util.Scanner;

// Абстрактный класс летательного аппарата
abstract class Aircraft {
    abstract void fly();
}

// Класс самолета
class Airplane extends Aircraft {
    @Override
    void fly() {
        System.out.println("Самолет летит по воздуху.");
    }
}

// Класс вертолета
class Helicopter extends Aircraft {
    @Override
    void fly() {
        System.out.println("Вертолет летит вертикально.");
    }
}

// Класс дирижабля
class Airship extends Aircraft {
    @Override
    void fly() {
        System.out.println("Дирижабль летит над землей.");
    }
}

// Абстрактная фабрика для создания летательных аппаратов
abstract class AircraftFactory {
    abstract Aircraft createAircraft();
}

// Фабрика для создания самолетов
class AirplaneFactory extends AircraftFactory {
    @Override
    Aircraft createAircraft() {
        return new Airplane();
    }
}

// Фабрика для создания вертолетов
class HelicopterFactory extends AircraftFactory {
    @Override
    Aircraft createAircraft() {
        return new Helicopter();
    }
}

// Фабрика для создания дирижаблей
class AirshipFactory extends AircraftFactory {
    @Override
    Aircraft createAircraft() {
        return new Airship();
    }
}

// Класс управления летательными аппаратами
class AircraftController {
    private AircraftFactory factory;

    AircraftController(AircraftFactory factory) {
        this.factory = factory;
    }

    void performAction(String action) {
        Aircraft aircraft = factory.createAircraft();
        if (action.equals("взлет")) {
            aircraft.fly();
        } else if (action.equals("посадка")) {
            System.out.println("Летательный аппарат садится на землю.");
        } else {
            System.out.println("Неверное действие.");
        }
    }
}

// Клиентский код
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Выберите тип летательного аппарата (самолет/вертолет/дирижабль):");
        String aircraftType = scanner.nextLine().toLowerCase();

        AircraftFactory aircraftFactory;
        if (aircraftType.equals("самолет")) {
            aircraftFactory = new AirplaneFactory();
        } else if (aircraftType.equals("вертолет")) {
            aircraftFactory = new HelicopterFactory();
        } else if (aircraftType.equals("дирижабль")) {
            aircraftFactory = new AirshipFactory();
        } else {
            System.out.println("Неверный тип летательного аппарата.");
            return;
        }

        AircraftController controller = new AircraftController(aircraftFactory);

        System.out.println("Выберите действие (взлет/посадка):");
        String action = scanner.nextLine().toLowerCase();

        controller.performAction(action);
    }
}
