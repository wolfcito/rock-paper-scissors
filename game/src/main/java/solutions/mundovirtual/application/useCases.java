package solutions.mundovirtual.application;

import solutions.mundovirtual.domain.GameOption;
import solutions.mundovirtual.domain.ScoreBoard;

import java.util.Random;

public class useCases {
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

	public static void getResult(GameOption choicenum, GameOption compnum, ScoreBoard scoreBoard) {
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

	public static GameOption getChoiceComputer(Random random) {
		GameOption option = GameOption.values()[random.nextInt(3)];
		System.out.println("Computer chose " + option.toString().toLowerCase());
		return option;
	}

	public static GameOption getChoicePlayer(String choice) {
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
