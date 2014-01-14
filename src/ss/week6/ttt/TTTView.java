package ss.week6.ttt;

import javax.swing.*;
import java.awt.*;
import java.util.Observable;
import java.util.Observer;

public class TTTView extends JFrame implements Observer {
    private TTTController tttController;

    JButton[] buttons = new JButton[9];

    private JLabel status;
    private JButton restartButton;


    public static void main(String[] args) {
        new TTTView();
    }

    public TTTView() {
        super("Tic Tac Toe");
        Game game = new Game(this);
        tttController = new TTTController(this, game);
        initializeFrame();
    }

    public JButton[] getButtons() {
        return buttons;
    }

    public JButton getRestartButton() {
        return restartButton;
    }

    private void initializeFrame() {
        JPanel jpnlMain = new JPanel();
        JPanel jpnlMenu = new JPanel();

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setSize(800, 800);
        setVisible(true);

        jpnlMain.setLayout(new GridLayout(3, 3, 10, 10));
        jpnlMenu.setLayout(new GridLayout(2, 1, 10, 10));

        for (int i = 0; i < buttons.length; i++) {
            buttons[i] = new JButton("EMPTY");
            jpnlMain.add(buttons[i]);
            buttons[i].addActionListener(tttController);
        }

        status = new JLabel("XX's turn");
        jpnlMenu.add(status);

        restartButton = new JButton("Restart");
        jpnlMenu.add(restartButton);
        restartButton.setEnabled(false);
        restartButton.addActionListener(tttController);

        add(jpnlMain, BorderLayout.CENTER);
        add(jpnlMenu, BorderLayout.EAST);
    }

    @Override
    public void update(Observable observable, Object arg) {
        Game game = (Game) observable;
        Board board = game.getBoard();

        //Update buttons
        for (int i = 0; i < buttons.length; i++) {
            buttons[i].setText(board.getField(i).toString());
            if (board.getField(i) == Mark.EMPTY) {
                buttons[i].setEnabled(true);
            } else {
                buttons[i].setEnabled(false);
            }
        }

        //Update status label
        if (!board.gameOver()) {
            status.setText(game.getCurrent().toString() + "'s turn");
        } else {
            for (JButton button : buttons) {
                button.setEnabled(false);
            }
            if (!board.hasWinner()) {
                status.setText("Draw");
            } else if (board.isWinner(Mark.XX)) {
                status.setText("X has won");
            } else if (board.isWinner(Mark.OO)) {
                status.setText("O has won");
            }
        }

        //Update restart button
        if (board.gameOver()) {
            restartButton.setEnabled(true);
        } else {
            restartButton.setEnabled(false);
        }
    }
}
