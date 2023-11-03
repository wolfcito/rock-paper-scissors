package solutions.mundovirtual.infraestructure.printers;

import solutions.mundovirtual.domain.ScoreBoard;

public class printers {
	public static void gameRules() {
		System.out.println("Let's play Rock, Paper, Scissors!");
		System.out.println("Say \"Rock\", \"Paper\", or \"Scissors\" to indicate your choice. Otherwise say \"Quit\" to quit.");
	}

	public static void gameScoreBoard(ScoreBoard scoreBoard) {
		System.out.println("wins:" + scoreBoard.getWinnum() + "\nloses:" + scoreBoard.getLossnum() + "\nties:" + scoreBoard.getTienum()); //print out number of wins, ties, and loses
		System.out.println("Let's play again! \n \n"); //start game again
		System.out.println("Say \"Rock\", \"Paper\", or \"Scissors\" to indicate your choice. Otherwise say \"Quit\" to quit.");
	}
}
