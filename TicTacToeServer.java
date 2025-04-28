
import java.net.*;
import java.io.*;

public class TicTacToeServer {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(5001);
        System.out.println("Waiting for client to connect...");
        Socket socket = serverSocket.accept();
        System.out.println("Client connected!");

        DataInputStream in = new DataInputStream(socket.getInputStream());
        DataOutputStream out = new DataOutputStream(socket.getOutputStream());

        GameWindow game = new GameWindow("Server - You are X", 'X', true);

        game.setMoveListener(index -> {
            try {
                out.writeInt(index);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        while (true) {
            int move = in.readInt();
            game.receiveMove(move);
        }
    }
}
