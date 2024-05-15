import java.util.*;
import java.util.Scanner;

public class Main {
	// MAIN BOARD
	static char gameBoard[][] = {{' ', '|', ' ', '|', ' '},
                                 {'-', '+', '-', '+', '-'},
                                 {' ', '|', ' ', '|', ' '},
                                 {'-', '+', '-', '+', '-'},
                                 {' ', '|', ' ', '|', ' '},};
	// STORES PLAYER 1,2 PICKS & CHECKSDRAW
	static List<Character> picks1    = new ArrayList();
	static List<Character> picks2    = new ArrayList();
	static List<Character> checkDraw = new ArrayList();

	
	// MAIN METHOD
	public static void main(String[] args) {
		// INITALIZING VARIABLES
		String playerTwo = null;
		char symbolOne = 0;
		char symbolTwo = 0;
		char positionOne;
		char positionTwo;
       
		Scanner name = new Scanner(System.in);
		System.out.println("Pick from Player 1 = X or Player 2 = O ");
		String playerOne = name.nextLine();		
		
		
		if(playerOne.equalsIgnoreCase("Player 1")) {
			 playerTwo = "Player 2";
			 symbolTwo = 'O';
			 symbolOne = 'X';
		}
		else if(playerOne.equalsIgnoreCase("Player 2")) {
			 playerTwo = "Player 1";
			 symbolTwo = 'X';
			 symbolOne = 'O';
		}

		//MAIN LOOP
		while(true){ 
			// 1ST PLAYER 
				Scanner scan = new Scanner(System.in);
				System.out.println(playerOne+ " Pick a empty position");
				positionOne = (char) scan.nextByte();
			
			//CHECKS IF FIRST INPUT OVERLAPS WITH OTHER POSITIONS
			while(picks1.contains(positionOne) || picks2.contains(positionOne)) {
				Scanner scanner = new Scanner(System.in);
				System.out.println("Repeated input! Pick another positon"); 
				positionOne = (char) scanner.nextByte(); }
				//PLACES SYMBOL ON BOARD	
				placePiece(positionOne,playerOne,gameBoard);
				
				//INCREMENTS PICKS1,CHECKSDRAW
				picks1.add(positionOne);
				checkDraw.add(positionOne);
				
				
				if(checkDraw.size() == 9) {
					System.out.println("IT'S DRAW");
					newGameBoard(gameBoard);
					break;}
				 
				System.out.println();
				
				// IF WINNER = END GAME
				if(checkWinner(gameBoard,symbolOne,playerOne) == false){
					newGameBoard(gameBoard);
					break;} 
				newGameBoard(gameBoard);
				
				
				// 2ND PLAYER
				Scanner choice = new Scanner(System.in);
				System.out.println(playerTwo + " Pick a position from 1-9: ");
				positionTwo = (char) choice.nextByte();
				
				while(picks2.contains(positionTwo) || picks1.contains(positionTwo)) {
					Scanner choiceAgain = new Scanner(System.in);
					System.out.println("Repeated input! Pick another positon"); 
					positionTwo = (char) choiceAgain.nextByte(); }
				
				
				
				placePiece(positionTwo,playerTwo,gameBoard);
				picks2.add(positionTwo);
				checkDraw.add(positionTwo);
				

				
				if(checkDraw.size() == 9) {
					System.out.println("IT'S DRAW");
					newGameBoard(gameBoard);
					break;}
				
				
				
				System.out.println();
				
				if(checkWinner(gameBoard,symbolTwo,playerTwo) == false){
					newGameBoard(gameBoard);
					break;} 
				
				
				newGameBoard(gameBoard);
				
		 }


                   
		}  
	
		
		

		// started 15/10/2023
		
		//1. first, make a board 5x5  *DONE*
		//2. Method that loops through each index of the board and assigns ex. 1 to [0][0] *DONE*
		//3. use scanner method to get position out of user 1 and user 2 
		//4. method for taking in a board , "player" and position that assigns the pos to the board *DONE*
		//5. method for checking winner, ends game when one wins and ends loop with draw
		//6. this all should in a while loop to keep the game going 
		//7. figure out how to deal with the issue of overlapping 

		
		
	


		
    //FUNCTIONAL GAMEBOARD//
	private static void newGameBoard(char[][] board) {
		// we have a board , now use inner for loop
		for(int i = 0; i<board.length; i++) {
			System.out.println(board[i]);
		}

	}
	
	
	// PLACE X or O on BOARD//
	private static void placePiece(char position, String player, char[][] board) {
		if(player.equalsIgnoreCase("Player 2")) {
			char symbol = 'O';
			
			switch(position) {
				case 1:
					board[0][0] = symbol;
					break;
				case 2:
					board[0][2] = symbol;
					break;
				case 3:
					board[0][4] = symbol;
					break;
				case 4:
					board[2][0] = symbol;
					break;
				case 5:
					board[2][2] = symbol;
					break;
				case 6:
					board[2][4] = symbol;
					break;
				case 7:
					board[4][0] = symbol;
					break;
				case 8:
					board[4][2] = symbol;
					break;
				case 9:
					board[4][4] = symbol;
					break;
				default:
					System.out.println("something went wrong on placePiece method");
				
			}
		
			
			
			
		}
		else if(player.equalsIgnoreCase("Player 1")) {
			char symbol = 'X';
			
			switch(position) {
				case 1:
					board[0][0] = symbol;
					break;

				case 2:
					board[0][2] = symbol;
					break;

				case 3:
					board[0][4] = symbol;
					break;

				case 4:
					board[2][0] = symbol;
					break;

				case 5:
					board[2][2] = symbol;
					break;

				case 6:
					board[2][4] = symbol;
					break;

				case 7:
					board[4][0] = symbol;
					break;

				case 8:
					board[4][2] = symbol;
					break;

				case 9:
					board[4][4] = symbol;
					break;

				default:
					System.out.println("something went wrong on placePiece method");
				
			}
			
			
			
		}
		
	}


	
	// CHECKING WINNER
	private static boolean checkWinner(char[][] board, char symbol, String player) {
		// ACROSS	
			if(board[0][0] == symbol && board[0][2] == symbol && board[0][4] == symbol) {
				System.out.println(player + " is the winner");
				return false;
			}
			if(board[2][0] == symbol && board[2][2] == symbol && board[2][4] == symbol) {
				System.out.println(player + " is the Winner");
				return false;
			}
			if(board[4][0] == symbol && board[4][2] == symbol && board[4][4] == symbol) {
				System.out.println(player + " is the Winner");
				return false;}
				
	   // DOWN	
			if(board[0][0] == symbol && board[2][0] == symbol && board[4][0] == symbol) {
					System.out.println(player + " is the Winner");
					return false;
				}
			if(board[0][2] == symbol && board[2][2] == symbol && board[4][2] == symbol) {
					System.out.println(player + " is the Winner");
					return false;
				}
			if(board[0][4] == symbol && board[2][4] == symbol && board[4][4] == symbol) {
				System.out.println(player + " is the Winner");
				return false;}
			
	  // DIAGONAL 		
			if(board[0][0] == symbol && board[2][2] == symbol && board[4][4] == symbol) {
				System.out.println(player + " is the Winner");
				return false;}
			if(board[4][0] == symbol && board[2][2] == symbol && board[0][4] == symbol) {
				System.out.println(player + " is the Winner");
				return false;}
			
			return true;
	}		
}