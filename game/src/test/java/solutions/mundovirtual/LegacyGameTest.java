package solutions.mundovirtual;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import solutions.mundovirtual.application.LegacyGame;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Random;
import java.util.Scanner;

import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
final class LegacyGameTest {

    public static final int OPTION_ROCK = 0;
    public static final int OPTION_PAPER = 1;
    public static final int OPTION_SCISSORS = 2;
    @InjectMocks
    private LegacyGame game;

    @Mock
    Scanner scanner;

    @Mock
    Random random;

    @Test
    public void when_quitInput_then_exitGame(){
        when(scanner.nextLine())
                .thenReturn("Quit");

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        game.play();

        Assertions.assertTrue(out.toString().contains("Let's play Rock, Paper, Scissors!"));
    }

    @Test
    public void when_chooseRock_then_beatsScissors(){
        when(scanner.nextLine())
                .thenReturn("Rock")
                .thenReturn("Quit");
        when(random.nextInt(3)).thenReturn(OPTION_SCISSORS);

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        game.play();

        Assertions.assertTrue(out.toString().contains("Computer chose scissors"));
        Assertions.assertTrue(out.toString().contains("wins:1"));

    }

    @Test
    public void when_chooseScissors_then_beatsPaper(){
        when(scanner.nextLine())
                .thenReturn("Scissors")
                .thenReturn("Quit");
        when(random.nextInt(3)).thenReturn(OPTION_PAPER);

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        game.play();

        Assertions.assertTrue(out.toString().contains("Computer chose paper"));
        Assertions.assertTrue(out.toString().contains("wins:1"));

    }

    @Test
    public void when_choosePaper_then_beatsRock(){
        when(scanner.nextLine())
                .thenReturn("Paper")
                .thenReturn("Quit");
        when(random.nextInt(3)).thenReturn(OPTION_ROCK);

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        game.play();

        Assertions.assertTrue(out.toString().contains("Computer chose rock"));
        Assertions.assertTrue(out.toString().contains("wins:1"));

    }

    @Test
    public void when_bothChooseRock_then_tie(){
        when(scanner.nextLine())
                .thenReturn("Rock")
                .thenReturn("Quit");
        when(random.nextInt(3)).thenReturn(OPTION_ROCK);

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        game.play();

        Assertions.assertTrue(out.toString().contains("Computer chose rock"));
        Assertions.assertTrue(out.toString().contains("ties:1"));

    }

    @Test
    public void when_chooseRockAndComputerChoosePaper_then_loose(){
        when(scanner.nextLine())
                .thenReturn("Rock")
                .thenReturn("Quit");
        when(random.nextInt(3)).thenReturn(OPTION_PAPER);

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        game.play();

        Assertions.assertTrue(out.toString().contains("Computer chose paper"));
        Assertions.assertTrue(out.toString().contains("loses:1"));

    }
}