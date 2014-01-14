package ss.week6.vote;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class PartyChoiceListener2 implements ItemListener {
    VoteFrame voteFrame;

    public PartyChoiceListener2(VoteFrame voteFrame){
        this.voteFrame = voteFrame;
    }

    @Override
    public void itemStateChanged(ItemEvent arg0) {
        int selection = voteFrame.getChoice().getSelectedIndex();
        if(selection != 0){
            voteFrame.getButton().setEnabled(true);
            voteFrame.getLabel().setText("Change selection or press OK");
        }
        else{
            voteFrame.getButton().setEnabled(false);
        }

    }
}
