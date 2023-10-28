import java.io.*;

public class GameSettingsManager {
    public void saveSettings(GameSettings settings, String filePath) {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(filePath))) {
            outputStream.writeObject(settings);
            System.out.println("Настройки сохранены в файл: " + filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public GameSettings loadSettings(String filePath) {
        GameSettings settings = null;
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(filePath))) {
            settings = (GameSettings) inputStream.readObject();
            System.out.println("Настройки загружены из файла: " + filePath);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return settings;
    }
}
