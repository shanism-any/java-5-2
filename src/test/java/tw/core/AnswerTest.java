package tw.core;

import tw.core.exception.OutOfRangeAnswerException;
import tw.core.model.Record;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import java.util.List;
import java.util.ArrayList;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * 在AnswerTest文件中完成Answer中对应的单元测试
 */
public class AnswerTest {
    @Before
    public void before() throws Exception {
    }

    @After
    public void after() throws Exception {
    }

    @Test
    public void testSetNumList() throws Exception {
        List<String> strings = new ArrayList<>();
        strings.add("1");
        strings.add("2");
        strings.add("3");
        strings.add("4");

        Answer answer = new Answer();
        answer.setNumList(strings);
        assertTrue(answer.toString().equals("1 2 3 4"));
    }


    @Test
    public void testCreateAnswer() throws Exception {
        Answer answer = Answer.createAnswer("1 2 3 4");
        assertTrue(answer.toString().equals("1 2 3 4"));
    }


    @Test
    public void testValidate() throws Exception {
        Answer answer = Answer.createAnswer("1 2 3 10");

        Throwable t = null;
        try{
            answer.validate();
        }
        catch (Exception ex){
            t = ex;
        }
        assertNotNull(t);
        assertTrue(t instanceof OutOfRangeAnswerException);
        assertTrue(t.getMessage().contains("Answer format is incorrect"));

    }


    @Test
    public void testCheck() throws Exception {
        Answer answer1 = Answer.createAnswer("1 2 3 4");
        Answer answer2 = Answer.createAnswer("1 2 3 5");
        int[] record1 = answer1.check(answer1).getValue();
        int[] record2 = answer1.check(answer2).getValue();
        assertEquals(record1[0], 4);
        assertEquals(record1[1], 0);
        assertEquals(record2[0], 3);
        assertEquals(record2[1], 0);

    }


    @Test
    public void testGetIndexOfNum() throws Exception {
        Answer answer = Answer.createAnswer("1 2 3 4");
        assertEquals(answer.getIndexOfNum("1"), 0);
        assertEquals(answer.getIndexOfNum("3"), 2);
        assertEquals(answer.getIndexOfNum("5"), -1);
    }
}