import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        GameSettingsManager settingsManager = new GameSettingsManager();

        // Попытка загрузить предыдущие настройки, если они есть
        GameSettings loadedSettings = settingsManager.loadSettings("settings.dat");

        // Выводим предыдущие настройки и предлагаем изменить их
        if (loadedSettings != null) {
            System.out.println("Предыдущие настройки:");
            System.out.println("Уровень графики: " + loadedSettings.getGraphicLevel());
            System.out.println("Клавиша для движения влево: " + loadedSettings.getMoveLeftKey());
            System.out.println("Клавиша для движения вправо: " + loadedSettings.getMoveRightKey());
            System.out.println("Клавиша для движения назад: " + loadedSettings.getMoveBackwardKey());
            System.out.println("Клавиша для движения вперед: " + loadedSettings.getMoveForwardKey());
            System.out.println("Клавиша для прыжка: " + loadedSettings.getJumpKey());
            System.out.println("Клавиша для действия: " + loadedSettings.getActionKey());
            System.out.println("Клавиша для открытия инвентаря: " + loadedSettings.getInventoryKey());

            // Предложение изменить настройки
            System.out.print("Хотите изменить настройки? (yes/no): ");
            Scanner scanner = new Scanner(System.in);
            String response = scanner.nextLine().toLowerCase();

            if (response.equals("yes")) {
                // Изменяем настройки управления
                loadedSettings = inputSettingsFromUser();

                // Сохраняем обновленные настройки
                settingsManager.saveSettings(loadedSettings, "settings.dat");

                System.out.println("Настройки сохранены.");
            }
        } else {
            // Если нет предыдущих настроек, создаем новые
            System.out.println("Новые настройки:");
            GameSettings newSettings = inputSettingsFromUser();
            settingsManager.saveSettings(newSettings, "settings.dat");
            System.out.println("Настройки сохранены.");
        }
    }

    public static GameSettings inputSettingsFromUser() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите уровень графики (1 - низкий, 2 - средний, 3 - высокий): ");
        int graphicLevel = scanner.nextInt();
        scanner.nextLine(); // Очищаем буфер после ввода числа
        System.out.println("Введите клавишу для движения влево: ");
        String moveLeftKey = scanner.nextLine();
        System.out.println("Введите клавишу для движения вправо: ");
        String moveRightKey = scanner.nextLine();
        System.out.println("Введите клавишу для движения назад: ");
        String moveBackwardKey = scanner.nextLine();
        System.out.println("Введите клавишу для движения вперед: ");
        String moveForwardKey = scanner.nextLine();
        System.out.println("Введите клавишу для прыжка: ");
        String jumpKey = scanner.nextLine();
        System.out.println("Введите клавишу для действия: ");
        String actionKey = scanner.nextLine();
        System.out.println("Введите клавишу для открытия инвентаря: ");
        String inventoryKey = scanner.nextLine();

        return new GameSettings(graphicLevel, moveLeftKey, moveRightKey,
                moveBackwardKey, moveForwardKey, jumpKey, actionKey, inventoryKey);
    }
}
