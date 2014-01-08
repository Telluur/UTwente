package ss.week5.Strategy;

/**
 * Executable class for the game Tic Tac Toe. The game can be played against the
 * computer. Labassignment Module 2
 * 
 * @author Theo Ruys
 * @version $Revision: 1.4 $
 */
public class TicTacToe {
    // E{BKE-mens}
    /**
     * Creates a player based on the provided kind and mark.
     * <ul>
     * <li>If <code>s.equals("-N")</code> creates a naive computer player.
     * <li>If <code>s.equals("-S")</code> creates a smart computer player.
     * <li>If <code>s.equals("-P")</code> creates a perfect computer player.
     * <li>Otherwise creates a human player.
     * </ul>
     * 
     * @param s
     *            name / kind of player
     * @param m
     *            mark to be used by the player
     * @return the Player object
     */
    private static Player createPlayer(String s, Mark m) {
        if (s.equals("-N")) {
            return null;
            //return new ComputerPlayer(m, new NaiveStrategy());
        } else if (s.equals("-S")) {
            return new ComputerPlayer(m, new SmartStrategy());
        } else if (s.equals("-P")) {
            return new ComputerPlayer(m, new PerfectStrategy());
        } else {
            return new HumanPlayer(s, m);
        }
    }

    // B{BKE-mens}
    /** Creates top-level objects and starts the game. */
    public static void main(String[] args) {
        if (args.length == Game.NUMBER_PLAYERS) {
            System.out.println("Computer Tic Tac Toe");
            System.out.println("--------------------------");

            // E{BKE-mens}
            Player s1 = createPlayer(args[0], Mark.XX);
            Player s2 = createPlayer(args[1], Mark.OO);
            // B{BKE-mens}
            // I{BKE-mens} Speler s1 = new MensSpeler(args[0], Mark.XX);
            // I{BKE-mens} Speler s2 = new MensSpeler(args[1], Mark.OO);
            Game spel = new Game(s1, s2);
            spel.start();
        } else {
            System.out.println("usage: TicTacToe <name1> <nam2>");
        }
    }

}
