package tw.controllers;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import tw.commands.GuessInputCommand;
import tw.core.Game;
import tw.core.generator.AnswerGenerator;
import tw.core.generator.RandomIntGenerator;
import tw.views.GameView;
import java.io.*;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * 在GameControllerTest文件中完成GameController中对应的单元测试
 */
public class GameControllerTest {

    private ByteArrayOutputStream outContent;
    private GameController gameController;
    private String systemOut() {
        return outContent.toString();
    }

    private void systemIn(String input){
        System.setIn(new ByteArrayInputStream(input.getBytes()));
    }

    @Before
    public void before() throws Exception {
        outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        gameController = new GameController(new Game(new AnswerGenerator(new RandomIntGenerator())), new GameView());
    }

    public void after() throws Exception {
    }

    @Test
    public void testBeginGame() throws Exception {
        gameController.beginGame();
        assertTrue( systemOut().endsWith("------Guess Number Game, You have 6 chances to guess!  ------" +System.getProperty("line.separator") ));
    }

    @Test
    public void testPlay() throws Exception {
        String newLine = System.getProperty("line.separator");
        String input ="1 2 3" + newLine +
                "1 2 3 4" + newLine +
                "1 2 3 4" + newLine +
                "1 2 3 4" + newLine +
                "1 2 3 4" + newLine +
                "1 2 3 4" + newLine +
                "1 2 3 4" + newLine ;
        systemIn(input);
        gameController.play(new GuessInputCommand());
        String output = systemOut();
        assertTrue(output.startsWith("------Please input your answer as x x x x , x <10 ------" + newLine + "------Please input your answer as x x x x , x <10 ------"));
        assertTrue(output.contains("Guess History"));
        assertTrue(output.contains("Guess Result"));
        assertTrue(output.contains("Game Status"));
    }

}