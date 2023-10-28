import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GameController {
    private ServerSocket serverSocket;
    private List<ClientHandler> clients = new ArrayList<>();

    public void startServer(int port) {
        try {
            serverSocket = new ServerSocket(port);
            System.out.println("Сервер запущен на порту " + port);

            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Новый клиент подключен: " + clientSocket);

                ClientHandler clientHandler = new ClientHandler(clientSocket, this);
                clients.add(clientHandler);
                new Thread(clientHandler).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void stopServer() {
        try {
            serverSocket.close();
            System.out.println("Сервер остановлен.");
            System.exit(0);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void kickPlayer(String nickname) {
        // Реализация кика игрока по никнейму
        // Например, можно использовать цикл для поиска игрока по никнейму в clients и отключить его
    }

    public void broadcastMessage(String message, ClientHandler sender) {
        // Рассылка сообщения всем клиентам, кроме отправителя
        for (ClientHandler client : clients) {
            if (client != sender) {
                client.sendMessage(message);
            }
        }
    }

    public void startConsoleInput() {
        Scanner scanner = new Scanner(System.in);
        String command;

        while (true) {
            System.out.println("Введите команду: start, stop, kick, quit");
            command = scanner.nextLine();

            switch (command) {
                case "start":
                    if (serverSocket == null || serverSocket.isClosed()) {
                        new Thread(() -> startServer(12345)).start();
                        System.out.println("Сервер запущен.");
                    } else {
                        System.out.println("Сервер уже запущен.");
                    }
                    break;
                case "stop":
                    stopServer();
                    break;
                case "kick":
                    System.out.println("Введите никнейм игрока для кика:");
                    String nicknameToKick = scanner.nextLine();
                    kickPlayer(nicknameToKick);
                    break;
                case "quit":
                    System.out.println("Выход из программы.");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Неверная команда.");
            }
        }
    }

    public static void main(String[] args) {
        GameController gameController = new GameController();

        // Запуск ввода команд из консоли в отдельном потоке
        new Thread(() -> {
            gameController.startConsoleInput();
        }).start();
    }
}
