package ss.week5.Strategy;

import java.util.ArrayList;
import java.util.List;

public class PerfectStrategy implements Strategy {

    private int bestMove;
    private Quality bestQuality;

    @Override
    public String getName() {
        return "Perfect";
    }

    @Override
    public int determineMove(Board board, Mark mark) {
        bestMove = -1;
        bestQuality = Quality.LOSE;

        for (int field : getAvailableFields(board)) {
            Board copyBoard = board.deepCopy();
            copyBoard.setField(field, mark);
            getBestMove(true, field, copyBoard, mark);
        }
        return bestMove;
    }

    private void getBestMove(boolean player, int move, Board board, Mark mark) {
        //System.out.println("Best move so far: " + bestMove + ", with quality " + bestQuality.name());
        //Set default quality to lose so it won't be better.
        Quality quality = Quality.LOSE;
        //If board has a winner...
        if (board.hasWinner()) {
            //..and last move was made by player, set quality to win.
            if (player) {
                quality = Quality.WIN;
            }
            // If no moves are remaining, set quality to neutral.
        } else if (getAvailableFields(board).isEmpty()) {
            quality = Quality.NEUTRAL;
        } else {
            for (int field : getAvailableFields(board)) {
                Board copyBoard = board.deepCopy();
                copyBoard.setField(field, mark);
                getBestMove(!player, move, copyBoard, mark.other());
            }
        }

        //Check if quality is better than bestQuality
        if (isBetterQuality(bestQuality, quality)) {
            // If it is, replace bestQuality & bestMove
            bestQuality = quality;
            bestMove = move;
            System.out.println("Set quality to " + quality + " at move " + move);
        }
    }

    private boolean isBetterQuality(Quality oldQuality, Quality newQuality) {
        if (oldQuality == Quality.WIN) {
            return false;
        } else if (oldQuality == Quality.NEUTRAL) {
            if (newQuality == Quality.WIN) {
                return true;
            } else {
                return false;
            }
        } else {
            if (newQuality == Quality.WIN || newQuality == Quality.NEUTRAL) {
                return true;
            } else {
                return false;
            }
        }
    }

    private List<Integer> getAvailableFields(Board board) {
        List<Integer> availableFields = new ArrayList<>();
        for (int i = 0; i <= 8; i++) {
            if (board.isEmptyField(i)) {
                availableFields.add(i);
            }
        }
        return availableFields;
    }

    public enum Quality {
        LOSE, NEUTRAL, WIN
    }
}
