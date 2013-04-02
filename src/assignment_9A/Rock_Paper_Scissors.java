package assignment_9A;
import java.util.*;
public class Rock_Paper_Scissors {

    public static void main (String[] args) {
	int userScore = 0;
	int compScore = 0;
	String userMove, compMove;
	int winner;

	System.out.println("ROCK - PAPER - SCISSORS");
	System.out.println("This game plays 10 rounds.");
	
	// Loop once for each round of the game.
	for (int rnd=1; rnd<=10; rnd++) {
	    
	    // Get the moves for this round.
	    userMove = getUserMove();
	    compMove = getComputerMove();
	    System.out.println("Computer's move: " + compMove);

	    // Determine the winner of this round.
	    winner = determineRoundWinner(compMove, userMove);

	    // Print a message and add one to the score of the winner.
	    if (winner == 1) {
		System.out.println(compMove + " beats " + 
				   userMove + 
				   " the computer wins this round.");
		compScore++;
	    }
	    else if (winner == -1) {
		System.out.println(userMove + " beats " + 
				   compMove + 
				   " the user wins this round.");
		userScore++;
	    }
	    else {
		System.out.println(userMove + " ties " + 
				   compMove + 
				   " nobody wins this round.");
	    }
	    
	    System.out.println("Score: User=" + userScore + 
			       " Computer=" + compScore);
	    System.out.println();
	}
	
	// The ten rounds are over...
	// Print out the winner of the game.
	displayGameWinner(userScore, compScore);
    }

    /**
     * Read in a move from the user.  Valid
     * responses are Rock, Paper or Scissors.
     * Prompt until a valid move is entered.
     *
     * @return The user's move as one of: 
     *         Rock, Paper, Scissors
     */
    static String getUserMove() {
    	@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
	String userMove = "club";
	
	// Loop while the user has not entered a valid
	// move.  NOTE: The ==, != operators do not work
	// on String objects.  However, the String
	// object provides an equals method that returns
	// true if the String is equal to the argument.
	while (!userMove.equals("ROCK") &&
	       !userMove.equals("PAPER") &&
	       !userMove.equals("SCISSORS")) {

	    System.out.print("Enter your move " +
			       "[ROCK, PAPER, SCISSORS]: ");

	    // Read the user's move and convert it to 
	    // Uppercase to make the comparison easier.
	    userMove = input.nextLine();
	    userMove = userMove.toUpperCase();
	}

	return userMove;
    }

    /** 
     * Pick the computer's move at random.
     * 
     * @return The computer's move as one of:
     *         Rock, Paper, Scissors
     */
    static String getComputerMove() {
	int compMoveInt;
	String compMove;

	// Generate a random move for the 
	// computer.
	compMoveInt = randomInt(1,3);

	// Convert the random integer into a 
	// string that represents the computer's
	// move.
	if (compMoveInt == 1) {
	    compMove = "ROCK";
	}
	else if (compMoveInt == 2) {
	    compMove = "PAPER";
	}
	else {
	    compMove = "SCISSORS";
	}

	return compMove;
    }

    /**
     * Generate a random integer in the range [lowEnd...highEnd].
     *
     * @param lowEnd the low end of the range of possible numbers.
     * @param highEnd the high end of the range of possible numbers.
     * @return a random integer in [lowEnd...highEnd]
     */
    public static int randomInt(int lowEnd, int highEnd) {
        int theNum;

        // Pick a random double in the range [0...highEnd-lowEnd+1)
        // then truncate it to an integer and shift it up by lowEnd.
        theNum = (int)(Math.random() * (highEnd - lowEnd + 1)) + lowEnd;

        return theNum;
    }

    /**
     * Compare the user's move to the computer's
     * move to determine the winner of this round.
     *
     * @param userMove the user's move.
     * @param compMove the computer's move.
     * @return  1 if the computer wins.
     *          0 if it is a tie.
     *         -1 if the user wins.
     */
    static int determineRoundWinner(String userMove,
				    String compMove) {
	int winner;

	// Check for ties.
	if (compMove.equals(userMove)) {
	    winner = 0;
	}
	
	// if it is not a tie check for all the ways the
	// computer can win.
	// Rock smashes scissors...
	else if (compMove.equals("ROCK") && 
		 userMove.equals("SCISSORS")) {
	    winner = 1;
	}
	// Paper covers rock...
	else if (compMove.equals("PAPER") &&
		 userMove.equals("ROCK")) {
	    winner = 1;
	}
	// Scissors cut paper...
	else if (compMove.equals("SCISSORS") &&
		 userMove.equals("PAPER")) {
	    winner = 1;
	}
	// Its not a tie and the computer did not
	// win so the user must have won!
	else {
	    winner = -1;
	}

	return winner;
    }

   /**
     * Display a message showing the score of the game
     * and declaring the winner.
     *
     * @param userScore the user's score for the 10 rounds.
     * @param compScore the computer's score for the 10 rounds.
     */
    static void displayGameWinner(int userScore,
				  int compScore) {

	System.out.println("\n\nFinal Score:");
	System.out.println("       User=" + userScore + 
			   "   Computer=" + compScore);
	System.out.println();

	if (userScore > compScore) {
	    System.out.println("The user wins!");
	}
	else if (compScore > userScore) {
	    System.out.println("The computer wins!");
	}
	else {
	    System.out.println("Its a tie, nobody wins.");
	}
    }
}