package solutions.mundovirtual.application.results;

import solutions.mundovirtual.domain.GameOption;
import solutions.mundovirtual.domain.ScoreBoard;

public class GetResults {
	public static void getScoreBoard(GameOption choicenum, GameOption compnum, ScoreBoard scoreBoard) {
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
}
