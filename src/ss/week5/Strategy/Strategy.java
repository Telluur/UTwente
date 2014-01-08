package ss.week5.Strategy;

public interface Strategy {
    /**
     * Get the name of the stragey
     * @return name
     */
    public String getName();

    /**
     * Determine the next AI move
     * @param board
     * @param mark
     * @return
     */
    public int determineMove(Board board, Mark mark);
}
