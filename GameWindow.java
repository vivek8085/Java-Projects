
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GameWindow extends JFrame {
    private JButton[] buttons = new JButton[9];
    private boolean isMyTurn;
    private char mySymbol, opponentSymbol;
    private MoveListener moveListener;

    public GameWindow(String title, char symbol, boolean isMyTurn) {
        super(title);
        this.mySymbol = symbol;
        this.opponentSymbol = (symbol == 'X') ? 'O' : 'X';
        this.isMyTurn = isMyTurn;

        setLayout(new GridLayout(3, 3));
        initButtons();
        setSize(300, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    private void initButtons() {
        for (int i = 0; i < 9; i++) {
            final int index = i;
            buttons[i] = new JButton("");
            buttons[i].setFont(new Font("Arial", Font.BOLD, 40));
            buttons[i].addActionListener(e -> {
                if (isMyTurn && buttons[index].getText().equals("")) {
                    buttons[index].setText(String.valueOf(mySymbol));
                    isMyTurn = false;
                    if (moveListener != null) {
                        moveListener.onMove(index);
                    }
                }
            });
            add(buttons[i]);
        }
    }

    public void receiveMove(int index) {
        buttons[index].setText(String.valueOf(opponentSymbol));
        isMyTurn = true;
    }

    public void setMoveListener(MoveListener listener) {
        this.moveListener = listener;
    }

    public interface MoveListener {
        void onMove(int index);
    }
}
