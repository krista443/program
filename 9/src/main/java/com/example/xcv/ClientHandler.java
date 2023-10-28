import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientHandler implements Runnable {
    private Socket clientSocket;
    private GameController gameController;
    private PrintWriter out;
    private BufferedReader in;
    private String nickname;

    public ClientHandler(Socket socket, GameController gameController) {
        this.clientSocket = socket;
        this.gameController = gameController;
        try {
            out = new PrintWriter(clientSocket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            out.println("Введите ваш никнейм:");
            nickname = in.readLine();
            out.println("Добро пожаловать, " + nickname + "!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getNickname() {
        return nickname;
    }

    public void sendMessage(String message) {
        out.println(message);
    }

    public void disconnect() {
        try {
            in.close();
            out.close();
            clientSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        try {
            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                System.out.println("Получено сообщение от игрока " + nickname + ": " + inputLine);
                if (inputLine.equalsIgnoreCase("quit")) {
                    gameController.kickPlayer(nickname);
                    break;
                } else if (inputLine.startsWith("/")) {
                    processCommand(inputLine);
                } else {
                    gameController.broadcastMessage(nickname + ": " + inputLine, this);
                }
            }

            disconnect();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void processCommand(String command) {
        if (command.equalsIgnoreCase("/stop")) {
            gameController.stopServer();
        } else {
            // Другие команды могут быть обработаны здесь
            // Например, /help, /list и так далее
        }
    }
}
