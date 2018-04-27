package tw.core;

import tw.core.generator.RandomIntGenerator;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertNotNull;

/**
 * 在RandomIntGeneratorTest文件中完成RandomIntGenerator中对应的单元测试
 */
public class RandomIntGeneratorTest {
    @Before
    public void before() throws Exception {
    }

    @After
    public void after() throws Exception {
    }

    @Test
    public void testGenerateNums() throws Exception {
        RandomIntGenerator randomIntGenerator = new RandomIntGenerator();
        String nums = randomIntGenerator.generateNums(9, 4);
        assertEquals(nums.length(), 7);
        assertTrue(nums.contains(" "));

        Throwable t = null;
        try{
            randomIntGenerator.generateNums(9, 10);
        }
        catch (Exception ex){
            t = ex;
        }
        assertNotNull(t);
        assertTrue(t instanceof IllegalArgumentException);
        assertTrue(t.getMessage().contains("Can't ask for more numbers than are available"));
    }
}