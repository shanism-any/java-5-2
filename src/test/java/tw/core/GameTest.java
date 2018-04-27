package tw.core;

import tw.core.generator.AnswerGenerator;
import tw.core.generator.RandomIntGenerator;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;

/**
 * 在GameTest文件中完成Game中对应的单元测试
 */

public class GameTest {
    private Game game;

    @Before
    public void before() throws Exception {
        game = new Game(new AnswerGenerator(new RandomIntGenerator()));
        game.guess(Answer.createAnswer("1 2 3 4"));
        game.guess(Answer.createAnswer("1 2 3 4"));
        game.guess(Answer.createAnswer("1 2 3 4"));
        game.guess(Answer.createAnswer("1 2 3 4"));
        game.guess(Answer.createAnswer("1 2 3 4"));
        game.guess(Answer.createAnswer("1 2 3 4"));
    }

    @After
    public void after() throws Exception {
    }

    @Test
    public void testGuessHistory() throws Exception {
        assertEquals(game.guessHistory().size(), 6);
    }

    @Test
    public void testCheckCoutinue() throws Exception {
        assertFalse(game.checkCoutinue());
    }

    @Test
    public void testCheckStatus() throws Exception {
        assertNotEquals(game.checkCoutinue(), GameStatus.CONTINUE);
    }
}
