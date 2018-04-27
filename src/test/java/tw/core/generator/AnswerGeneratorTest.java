package tw.core.generator;

import tw.core.Answer;
import org.junit.*;
import static org.junit.Assert.assertTrue;


/**
 * 在AnswerGeneratorTest文件中完成AnswerGenerator中对应的单元测试
 */
public class AnswerGeneratorTest {
    @Before
    public void before() throws Exception {
    }

    @After
    public void after() throws Exception {
    }

    @Test
    public void testGenerate() throws Exception {
        RandomIntGenerator randomIntGenerator = new RandomIntGenerator();
        String nums = randomIntGenerator.generateNums(9, 4);
        assertTrue(nums.length() == 7);
        assertTrue(nums.contains(" "));

    }

}

