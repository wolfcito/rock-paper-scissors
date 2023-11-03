package solutions.mundovirtual.application.player;

import solutions.mundovirtual.domain.GameOption;

public class GetChoicePlayer {
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
