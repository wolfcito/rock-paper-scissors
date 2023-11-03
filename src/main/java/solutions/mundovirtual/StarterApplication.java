package solutions.mundovirtual;

import org.springframework.context.annotation.ComponentScan;
import solutions.mundovirtual.application.LegacyGame;

@ComponentScan({"solutions.mundovirtual"})
public class StarterApplication {

    public static void main(String[] args) {
        LegacyGame game = new LegacyGame();
        game.play();
    }

}
