package ss.week6.vote;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OkButtonListener implements ActionListener {
    VoteFrame voteFrame;

    public OkButtonListener(VoteFrame voteFrame){
        this.voteFrame = voteFrame;
    }

    @Override
    public void actionPerformed(ActionEvent arg0) {
        voteFrame.getChoice().select(0);
        voteFrame.getButton().setEnabled(false);
        voteFrame.getLabel().setText("Choose a party");
    }
}
