package tw.core;

import tw.validator.InputValidator;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import java.util.*;
import java.lang.reflect.Method;
import static org.junit.Assert.*;

/**
 * 在InputValidatorTest文件中完成InputValidator中对应的单元测试
 */
public class InputValidatorTest {
    private  InputValidator inputValidator;

    @Before
    public void before() throws Exception {
        inputValidator = new InputValidator();
    }

    @After
    public void after() throws Exception {
    }

    @Test
    public void testValidate() throws Exception {
        assertTrue(inputValidator.validate("1 2 3 4"));
        assertFalse(inputValidator.validate("1 2 3 4 5"));
        assertFalse(inputValidator.validate("1 2 3 10"));
    }

    @Test
    public void testValidateSingleGigit() throws Exception {
        Class<?> inputValidatorClass = InputValidator.class;
        Method method = inputValidatorClass.getDeclaredMethod("validateSingleGigit", List.class, int.class);
        method.setAccessible(true);
        String[] arr1 = new String[]{"1", "2", "3", "4"};
        String[] arr2 = new String[]{"1", "2", "3", "4" , "10"};

        assertEquals(method.invoke(inputValidatorClass.newInstance(),Arrays.asList(arr1), 4), true);
        assertEquals(method.invoke(inputValidatorClass.newInstance(),Arrays.asList(arr2), 4), true);
        assertEquals(method.invoke(inputValidatorClass.newInstance(),Arrays.asList(arr2), 5), false);
    }

    @Test
    public void testValidateDigitsCount() throws Exception {
        Class<?> inputValidatorClass = InputValidator.class;
        Method method = inputValidatorClass.getDeclaredMethod("validateDigitsCount", List.class, int.class);
        method.setAccessible(true);
        String[] arr = new String[]{"1", "2", "3", "4"};

        Object result = method.invoke(inputValidatorClass.newInstance(),Arrays.asList(arr), 4);
        assertEquals(result, true);

    }

    @Test
    public void testNumStrToList() throws Exception {
        Class<?> inputValidatorClass = InputValidator.class;
        Method method = inputValidatorClass.getDeclaredMethod("numStrToList", String.class);
        method.setAccessible(true);
        Object result = method.invoke(inputValidatorClass.newInstance(), "1 2 3 4");
        String[] expectedResult = new String[]{"1", "2", "3", "4"};
        assertArrayEquals(((List<String>)result).toArray(), expectedResult);
    }
}
