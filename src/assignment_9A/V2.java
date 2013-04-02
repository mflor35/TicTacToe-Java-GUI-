package assignment_9A;


	import java.util.Random;
	import java.util.Scanner;

	public class V2 {

	private int winner = 0;
	private String compsChoice = null;
	private String playersChoice = null;
	private String winnerStatment = null;

	private Random rand = new Random( System.currentTimeMillis( ) );

	public static final int NONE = -1;
	public static final int ROCK = 0;
	public static final int PAPER = 1;
	public static final int SCISSORS = 2;

	public static final int INVALID_INPUT = -1;
	public static final int DRAW = 0;
	public static final int PLAYER_WINS = 1;
	public static final int COMPUTER_WINS = 2;

	private int validatePlayersChoice( String choice){
	if( choice.equalsIgnoreCase( "R")){
	playersChoice = "Rock";
	return ROCK;
	}else if( choice.equalsIgnoreCase( "P")){
	playersChoice = "Paper";
	return PAPER;
	}else if( choice.equalsIgnoreCase( "S")){
	playersChoice = "Scissors";
	return SCISSORS;
	}
	return NONE;
	}

	private int getCompChoice(){
	return rand.nextInt( 3);
	}

	private void createWinningStatement( int winner){
	switch( winner){
	case ROCK: 
	winnerStatment = "<<Rock Breaks Scissors>>"; 
	break;
	case PAPER: 
	winnerStatment = "<<Paper Covers Rock>>"; 
	break;
	case SCISSORS: 
	winnerStatment = "<<Scissors Cuts Paper>>"; 
	break;
	case NONE:
	winnerStatment = "Game Draw!";
	break;
	}
	}

	public int playRoundWith( String playerChoice ) {
	int player = validatePlayersChoice( playerChoice );
	int comp = getCompChoice();
	int winnerSide = 0;

	if(player == NONE){
	return INVALID_INPUT;
	}

	//R-R, P-P, S-S
	if (player == comp) {
	createWinningStatement( NONE);
	compsChoice = playersChoice;
	return DRAW;
	} else {
	switch (comp) {
	case ROCK: //R-P, R-S
	compsChoice = "Rock";
	if(player == PAPER){
	winnerSide = PLAYER_WINS;
	}else if(player == SCISSORS){
	winnerSide = COMPUTER_WINS;
	}
	break;
	case PAPER: //P-R, P-S
	compsChoice = "Paper";
	if(player == ROCK){
	winnerSide = COMPUTER_WINS;
	}else if(player == SCISSORS){
	winnerSide = PLAYER_WINS;
	}
	break;
	case SCISSORS: //S-R, S-P
	compsChoice = "Scissors";
	if(player == ROCK){
	winnerSide = PLAYER_WINS;
	}else if(player == PAPER){
	winnerSide = COMPUTER_WINS;
	}
	break;
	}
	createWinningStatement( winnerSide == PLAYER_WINS ? player : comp);
	return winnerSide;
	}
	}

	public String toString() {
	return "player had " + playersChoice + "\n" + 
	"computer had " + compsChoice + "\n" + 
	winnerStatment + 
	(winner == DRAW ? "" :
	(winner == PLAYER_WINS ? "\nPlayer Wins!" : "\nComputer Wins!" ));
	}

	public static void main(String args[]) {
	Scanner consoleInput = new Scanner( System.in );
	V2 game = new V2();
	String userInput = null;

	System.out.println( ">>Rock-Paper-Scissors<<\n" );
	System.out.println( "R - Rock\tP - Paper\tS - Scissors\n" );

	do {
	if( userInput != null ){
	switch( game.playRoundWith( userInput )){
	case V2.DRAW:
	case V2.PLAYER_WINS:
	case V2.COMPUTER_WINS:
	System.out.println( );
	System.out.println( game );
	break;
	case V2.INVALID_INPUT:
	System.out.println( "ERROR - Invalid input try again" );
	break;
	}
	}
	System.out.print( "\npick your weapon(Q to quit): ");
	userInput = consoleInput.next();
	} while ( !userInput.equalsIgnoreCase( "Q" ) );
	System.out.println( "\nGood Bye!");
	}
	}