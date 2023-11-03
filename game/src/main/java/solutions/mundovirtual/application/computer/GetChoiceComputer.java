package solutions.mundovirtual.application.computer;

import solutions.mundovirtual.domain.GameOption;

import java.util.Random;

public class GetChoiceComputer {
	public static GameOption getChoiceComputer(Random random) {
		GameOption option = GameOption.values()[random.nextInt(3)];
		System.out.println("Computer chose " + option.toString().toLowerCase());
		return option;
	}
}
