import java.util.Scanner;

// Интерфейс для всех игрушек
interface Toy {
    void play();
    void use();
    void action1();
    void action2();
    void action3();
}

// Реализации игрушек: мяч, кукла и конструктор
class Ball implements Toy {
    @Override
    public void play() {
        System.out.println("Играем с мячом");
    }

    @Override
    public void use() {
        System.out.println("Мяч используется для спорта");
    }

    @Override
    public void action1() {
        System.out.println("Мяч прыгает!");
    }

    @Override
    public void action2() {
        System.out.println("Мяч катится!");
    }

    @Override
    public void action3() {
        System.out.println("Мяч отскакивает!");
    }
}

class Doll implements Toy {
    @Override
    public void play() {
        System.out.println("Играем с куклой");
    }

    @Override
    public void use() {
        System.out.println("Кукла используется для ролевых игр");
    }

    @Override
    public void action1() {
        System.out.println("Кукла машет рукой!");
    }

    @Override
    public void action2() {
        System.out.println("Кукла смеется!");
    }

    @Override
    public void action3() {
        System.out.println("Кукла плачет!");
    }
}

class BuildingBlocks implements Toy {
    @Override
    public void play() {
        System.out.println("Играем с конструктором");
    }

    @Override
    public void use() {
        System.out.println("Конструктор используется для строительства");
    }

    @Override
    public void action1() {
        System.out.println("Конструктор строит дом!");
    }

    @Override
    public void action2() {
        System.out.println("Конструктор строит башню!");
    }

    @Override
    public void action3() {
        System.out.println("Конструктор строит мост!");
    }
}

// Фабричный метод для создания игрушек
interface ToyFactory {
    Toy createToy();
}

class BallFactory implements ToyFactory {
    @Override
    public Toy createToy() {
        return new Ball();
    }
}

class DollFactory implements ToyFactory {
    @Override
    public Toy createToy() {
        return new Doll();
    }
}

class BuildingBlocksFactory implements ToyFactory {
    @Override
    public Toy createToy() {
        return new BuildingBlocks();
    }
}

// Клиентский код
public class ToyStore {
    public static void main(String[] args) {
        // Создаем мяч с использованием фабрики мячей
        ToyFactory ballFactory = new BallFactory();
        Toy ball = ballFactory.createToy();

        // Создаем куклу с использованием фабрики кукол
        ToyFactory dollFactory = new DollFactory();
        Toy doll = dollFactory.createToy();

        // Создаем конструктор с использованием фабрики конструкторов
        ToyFactory buildingBlocksFactory = new BuildingBlocksFactory();
        Toy buildingBlocks = buildingBlocksFactory.createToy();

        // Выбор действий с игрушками
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            System.out.println("Выберите игрушку: ");
            System.out.println("1. Мяч");
            System.out.println("2. Кукла");
            System.out.println("3. Конструктор");
            System.out.println("0. Выход");

            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    ball.play();
                    System.out.println("Выберите действие для мяча:");
                    System.out.println("1. Прыгнуть");
                    System.out.println("2. Катиться");
                    System.out.println("3. Отскакивать");
                    int ballAction = scanner.nextInt();
                    performBallAction(ball, ballAction);
                    break;
                case 2:
                    doll.play();
                    System.out.println("Выберите действие для куклы:");
                    System.out.println("1. Махнуть рукой");
                    System.out.println("2. Смеяться");
                    System.out.println("3. Плакать");
                    int dollAction = scanner.nextInt();
                    performDollAction(doll, dollAction);
                    break;
                case 3:
                    buildingBlocks.play();
                    System.out.println("Выберите действие для конструктора:");
                    System.out.println("1. Построить дом");
                    System.out.println("2. Построить башню");
                    System.out.println("3. Построить мост");
                    int buildingBlocksAction = scanner.nextInt();
                    performBuildingBlocksAction(buildingBlocks, buildingBlocksAction);
                    break;
                case 0:
                    System.out.println("Программа завершена.");
                    break;
                default:
                    System.out.println("Неверный выбор. Попробуйте снова.");
                    break;
            }
        } while (choice != 0);
    }

    private static void performBallAction(Toy toy, int action) {
        switch (action) {
            case 1:
                toy.action1();
                break;
            case 2:
                toy.action2();
                break;
            case 3:
                toy.action3();
                break;
            default:
                System.out.println("Неверный выбор действия для мяча.");
        }
    }

    private static void performDollAction(Toy toy, int action) {
        switch (action) {
            case 1:
                toy.action1();
                break;
            case 2:
                toy.action2();
                break;
            case 3:
                toy.action3();
                break;
            default:
                System.out.println("Неверный выбор действия для куклы.");
        }
    }

    private static void performBuildingBlocksAction(Toy toy, int action) {
        switch (action) {
            case 1:
                toy.action1();
                break;
            case 2:
                toy.action2();
                break;
            case 3:
                toy.action3();
                break;
            default:
                System.out.println("Неверный выбор действия для конструктора.");
        }
    }
}