package solutions.mundovirtual.infraestructure.software;

import solutions.mundovirtual.domain.GameOption;
import solutions.mundovirtual.domain.ScoreBoard;

import java.util.Random;
import java.util.Scanner;

import static solutions.mundovirtual.application.computer.GetChoiceComputer.getChoiceComputer;
import static solutions.mundovirtual.application.player.GetChoicePlayer.getChoicePlayer;
import static solutions.mundovirtual.application.results.GetResults.getScoreBoard;
import static solutions.mundovirtual.infraestructure.printers.printers.gameRules;
import static solutions.mundovirtual.infraestructure.printers.printers.gameScoreBoard;


public class LegacyGame {

	private Scanner input;
	private Random random;

	public LegacyGame(){
		input = new Scanner(System.in);
		random = new Random();
	}

	public void play() {
		gameRules();
		String choice = input.nextLine().toUpperCase();

		ScoreBoard scoreBoard = new ScoreBoard();

		while (!choice.equals("QUIT")) {
			GameOption choicenum = getChoicePlayer(choice);
			while (choicenum == null) {
				System.out.println("Sorry, it looks like you didn't enter a correct input. Try again.");
				choice = input.nextLine().toUpperCase();
				choicenum = getChoicePlayer(choice);
			}

			GameOption compnum = getChoiceComputer(random);

			getScoreBoard(choicenum, compnum, scoreBoard);
			gameScoreBoard(scoreBoard);
			choice = input.nextLine().toUpperCase();
		}
	}
}
