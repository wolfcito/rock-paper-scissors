package solutions.mundovirtual;

import solutions.mundovirtual.domain.GameOption;
import solutions.mundovirtual.domain.ScoreBoard;

import java.util.Random;
import java.util.Scanner;

public class LegacyGame {

	private Scanner input = new Scanner(System.in);
	private Random random = new Random();

	public void play() {
		gameRules();
		String choice = input.nextLine().toUpperCase();

		ScoreBoard scoreBoard = new ScoreBoard();

		while (!choice.equals("QUIT")) {
			GameOption choicenum = getChoiceNumber(choice);
			while (choicenum == null) {
				System.out.println("Sorry, it looks like you didn't enter a correct input. Try again.");
				choice = input.nextLine().toUpperCase();
				choicenum = getChoiceNumber(choice);
			}

			GameOption compnum = getChoiceComputer();

			getResult(choicenum, compnum, scoreBoard);
			printScoreBoard(scoreBoard);
			choice = input.nextLine().toUpperCase();
		}

	}

	private static void printScoreBoard(ScoreBoard scoreBoard) {
		System.out.println("wins:" + scoreBoard.getWinnum() + "\nloses:" + scoreBoard.getLossnum() + "\nties:" + scoreBoard.getTienum()); //print out number of wins, ties, and loses
		System.out.println("Let's play again! \n \n"); //start game again
		System.out.println("Say \"Rock\", \"Paper\", or \"Scissors\" to indicate your choice. Otherwise say \"Quit\" to quit.");
	}

	private static void getResult(GameOption choicenum, GameOption compnum, ScoreBoard scoreBoard) {
		if (choicenum == compnum) //tie cases
		{
			ties(scoreBoard);
		} else if (choicenum == GameOption.ROCK && compnum == GameOption.SCISSORS ||
				choicenum == GameOption.SCISSORS && compnum == GameOption.PAPER ||
				choicenum == GameOption.PAPER && compnum == GameOption.ROCK) //user wins paper vs rock
		{
			wins(scoreBoard);
		}
		lose(scoreBoard);

	}

	private static void lose(ScoreBoard scoreBoard) {
		System.out.println("you lose.");
		scoreBoard.incrementLossnum();
	}

	private static void ties(ScoreBoard scoreBoard) {
		System.out.println("It's a tie");
		scoreBoard.incrementTienum();
	}

	private static void wins(ScoreBoard scoreBoard) {
		System.out.println("you win!");
		scoreBoard.incrementWinnum();
	}


	private static void gameRules() {
		System.out.println("Let's play Rock, Paper, Scissors!");
		System.out.println("Say \"Rock\", \"Paper\", or \"Scissors\" to indicate your choice. Otherwise say \"Quit\" to quit.");
	}

	private GameOption getChoiceComputer() {
		GameOption option = GameOption.values()[random.nextInt(3)];
		System.out.println("Computer chose " + option.toString().toLowerCase());
		return option;
	}

	private GameOption getChoiceNumber(String choice) {
		GameOption selectedOption = null;

		if (choice.equals("QUIT")) {
			System.exit(0); //quit program
		}

		try {
			selectedOption = GameOption.valueOf(choice);
		} catch (Exception exception) {
			return null;
		}

		return selectedOption;
	}
}
