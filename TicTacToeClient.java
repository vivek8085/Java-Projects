
import java.net.*;
import java.io.*;

public class TicTacToeClient {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost", 5001); // Change "localhost" to server IP if remote
        System.out.println("Connected to server!");

        DataInputStream in = new DataInputStream(socket.getInputStream());
        DataOutputStream out = new DataOutputStream(socket.getOutputStream());

        GameWindow game = new GameWindow("Client - You are O", 'O', false);

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
