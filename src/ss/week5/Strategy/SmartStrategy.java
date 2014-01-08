package ss.week5.Strategy;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SmartStrategy implements Strategy {

    @Override
    public String getName() {
        return "Smart";
    }

    @Override
    public int determineMove(Board board, Mark mark) {
        if(board.isEmptyField(4)){
            // If center field is empty, pick that.
            return 4;
        } else {
            // Add all available fields to a list.
            List<Integer> availableFields = new ArrayList<>();
            for(int i = 0; i <= 8; i++){
                if(board.isEmptyField(i)){
                    availableFields.add(i);
                }
            }

            // Find a field which would instantly make the player win.
            for(int field : availableFields){
                Board copiedBoard = board.deepCopy();
                copiedBoard.setField(field, mark);
                if(copiedBoard.hasWinner()){
                    return field;
                }
            }


            // Find a field which would instantly make the opponent win.
            for(int field : availableFields){
                Board copiedBoard = board.deepCopy();
                copiedBoard.setField(field, mark.other());
                if(copiedBoard.hasWinner()){
                    return field;
                }
            }

            // Choose a random field.
            Random random = new Random();
            return availableFields.get(random.nextInt(availableFields.size()));
        }
    }
}
