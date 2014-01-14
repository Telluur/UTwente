package ss.week6.ttt;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TTTController implements ActionListener {
    private TTTView tttView;
    private Game game;

    public TTTController(TTTView tttView, Game game){
        this.tttView = tttView;
        this.game = game;
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        Object source = event.getSource();
        JButton[] buttons = tttView.getButtons();
        for(int i = 0; i < buttons.length; i++){
            if(buttons[i] == source){
                game.takeTurn(i);
            }
        }

        if (tttView.getRestartButton() == source){
            game.reset();
        }
    }
}
