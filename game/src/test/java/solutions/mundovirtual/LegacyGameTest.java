package solutions.mundovirtual;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
final class LegacyGameTest {

    @InjectMocks
    private LegacyGame game;

    @Mock
    Scanner scanner;

    @Test
    public void when_quitInput_then_exitGame(){
        when(scanner.nextLine())
                .thenReturn("Quit");

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        game.play();

        Assertions.assertTrue(out.toString().contains("Let's play Rock, Paper, Scissors!"));
    }

}