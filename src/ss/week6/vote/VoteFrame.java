package ss.week6.vote;

import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class VoteFrame extends Frame {


    private Label label;
    private Button button;
    private Choice choice;

    public VoteFrame() {
        super("Hallo");
        init();
    }

    public Label getLabel(){
        return label;
    }

    public Button getButton(){
        return button;
    }

    public Choice getChoice(){
        return choice;
    }

    private void init() {
        setLayout(new FlowLayout());
        setSize(1000, 1000);
        setVisible(true);

        label = new Label("Make your choice");
        button = new Button("OK");
        choice = new Choice();

        choice.addItem("Choose a Party");
        choice.addItem("Christen-Democratisch Appèl");
        choice.addItem("Partij van de Arbeid");
        choice.addItem("Partij van de Vrijheid");

        button.setEnabled(false);

        add(label);
        add(choice);
        add(button);

        choice.addItemListener(new PartyChoiceListener(this));
        button.addActionListener(new OkButtonListener(this));

        /*choice.addItemListener(new ItemListener(){
            @Override
            public void itemStateChanged(ItemEvent e) {
                int selection = choice.getSelectedIndex();
                if(selection != 0){
                    button.setEnabled(true);
                    label.setText("Change selection or press OK");
                }
                else{
                    button.setEnabled(false);
                }
            }
        });*/
    }

    static public void main(String[] args) {
        VoteFrame v = new VoteFrame();
    }

    /*@Override
    public void itemStateChanged(ItemEvent arg0) {
        int selection = choice.getSelectedIndex();
        if(selection != 0){
            button.setEnabled(true);
            label.setText("Change selection or press OK");
        }
        else{
            button.setEnabled(false);
        }

    }
    @Override
    public void actionPerformed(ActionEvent arg0) {
        choice.select(0);
        button.setEnabled(false);
        label.setText("Choose a party");
    }*/
}

class PartyChoiceListener implements ItemListener {
    VoteFrame voteFrame;

    public PartyChoiceListener(VoteFrame voteFrame){
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

