package ss.week5.Strategy;

public class ComputerPlayer extends Player {
    private Strategy strategy;

    public ComputerPlayer(Mark mark, Strategy strategy){
        super(strategy.getName() + "-" + mark.toString(), mark);
        this.strategy = strategy;

    }

    @Override
    public int determineMove(Board board) {
        return strategy.determineMove(board, mark);
    }
}
