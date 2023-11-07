import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import solutions.mundovirtual.infraestructure.software.LegacyGame;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Random;
import java.util.Scanner;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class GameSteps {
	public static final int OPTION_ROCK = 0;
	public static final int OPTION_PAPER = 1;
	public static final int OPTION_SCISSORS = 2;
	@InjectMocks
	private LegacyGame game;

	@Mock
	Scanner scanner;

	@Mock
	Random random;

	private ByteArrayOutputStream out;
	@Before
	public void setup(){
		MockitoAnnotations.openMocks(this);
		out = new ByteArrayOutputStream();
		System.setOut(new PrintStream(out));
	}
	@Given("the user will choose {string}")
	public void theUserWillChoose(String userOption) {
		when(scanner.nextLine())
				.thenReturn(userOption)
				.thenReturn("Quit");
	}

	@And("the computer will choose {string}")
	public void theComputerWillChoose(String computerSelection) {
		int selection = 0;
		if("scissors".equals(computerSelection.toLowerCase())){
			selection = OPTION_SCISSORS;
		}
		if("rock".equals(computerSelection.toLowerCase())){
			selection = OPTION_ROCK;
		}
		if("paper".equals(computerSelection.toLowerCase())){
			selection = OPTION_PAPER;
		}
		when(random.nextInt(3)).thenReturn(selection);
	}

	@When("they play")
	public void theyPlay() {
		game.play();
	}

	@Then("verify that the computer chose {string}")
	public void verifyThatTheComputerChose(String computerSelection) {
		Assertions.assertTrue(out.toString().contains("Computer chose "+computerSelection));
	}

	@Then("the user wins")
	public void theUserWins() {
		Assertions.assertTrue(out.toString().contains("wins:1"));
	}


	@And("the user lose")
	public void theUserLose() {
		Assertions.assertTrue(out.toString().contains("loses:1"));
	}

	@And("the user tie")
	public void theUserTie() {
		Assertions.assertTrue(out.toString().contains("ties:1"));
	}
}
