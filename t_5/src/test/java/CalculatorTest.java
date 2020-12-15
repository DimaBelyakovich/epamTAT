import entities.Calculator;
import exception.CalculatorException;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CalculatorTest {
    private Calculator calculator = new Calculator();

    @Test
    public void addTwoPositiveNumbersTest() throws CalculatorException {
        int expected = 10;
        int actual = calculator.addTwoNumbers(5,5);
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void addTwoNegativeNumbersTest() throws CalculatorException {
        int expected = -30;
        int actual = calculator.addTwoNumbers(-15,-15);
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void addOnePositiveAndOneNegativeNumbersTest() throws CalculatorException {
        int expected = -20;
        int actual = calculator.addTwoNumbers(30,-50);
        Assert.assertEquals(actual, expected);
    }

    @Test (expectedExceptions = CalculatorException.class)
    public void checkExceptionAddTwoMaxValuesNumbersTest() throws CalculatorException {
        calculator.addTwoNumbers(Integer.MAX_VALUE, Integer.MAX_VALUE);
    }

    @Test (expectedExceptions = CalculatorException.class)
    public void checkExceptionAddTwoMinValuesNumbersTest() throws CalculatorException {
        calculator.addTwoNumbers(Integer.MIN_VALUE, Integer.MIN_VALUE);
    }

    @Test (expectedExceptions = CalculatorException.class)
    public void checkExceptionAddMaxValueAndPositiveNumbersTest() throws CalculatorException {
        calculator.addTwoNumbers(Integer.MAX_VALUE, 100);
    }

    @Test (expectedExceptions = CalculatorException.class)
    public void checkExceptionAddMinValueAndNegativeNumbersTest() throws CalculatorException {
        calculator.addTwoNumbers(Integer.MIN_VALUE, -100);
    }

    @Test
    public void subTwoPositiveNumbersTest() throws CalculatorException {
        int expected = 100;
        int actual = calculator.subTwoNumbers(150, 50);
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void subTwoNegativeNumbersTest() throws CalculatorException {
        int expected = -100;
        int actual = calculator.subTwoNumbers(-150, -50);
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void subOnePositiveAndOneNegativeNumbersTest() throws CalculatorException {
        int expected = 200;
        int actual = calculator.subTwoNumbers(150, -50);
        Assert.assertEquals(actual, expected);
    }

    @Test (expectedExceptions = CalculatorException.class)
    public void checkExceptionSubMinValueAndOnePositiveNumbersTest() throws CalculatorException {
        calculator.subTwoNumbers(Integer.MIN_VALUE, 1000);
    }

    @Test (expectedExceptions = CalculatorException.class)
    public void checkExceptionSubMaxValueAndOneNegativeNumbersTest() throws CalculatorException {
        calculator.subTwoNumbers(Integer.MAX_VALUE, -1000);
    }

    @Test (expectedExceptions = CalculatorException.class)
    public void checkExceptionSubOnePositiveAndMinValueNumbersTest() throws CalculatorException {
        calculator.subTwoNumbers(2000, Integer.MIN_VALUE);
    }

    @Test (expectedExceptions = CalculatorException.class)
    public void checkExceptionSubOneNegativeAndMaxValueNumbersTest() throws CalculatorException {
        calculator.subTwoNumbers(-2000, Integer.MAX_VALUE);
    }

    @Test
    public void multiTwoPositiveNumbersTest() throws CalculatorException {
        int expected = 10000;
        int actual = calculator.multiplyTwoNumbers(100, 100);
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void multiTwoNegativeNumbersTest() throws CalculatorException {
        int expected = 10000;
        int actual = calculator.multiplyTwoNumbers(-100, -100);
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void multiOnePositiveAndOneNegativeNumbersTest() throws CalculatorException {
        int expected = -10000;
        int actual = calculator.multiplyTwoNumbers(100, -100);
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void multiZeroAndPositiveNumbersTest() throws CalculatorException {
        int expected = 0;
        int actual = calculator.multiplyTwoNumbers(0, 100);
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void multiZeroAndNegativeNumbersTest() throws CalculatorException {
        int expected = 0;
        int actual = calculator.multiplyTwoNumbers(0, -100);
        Assert.assertEquals(actual, expected);
    }

    @Test (expectedExceptions = CalculatorException.class)
    public void checkExceptionMultiTwoMaxValuesNumbersTest() throws CalculatorException {
        calculator.multiplyTwoNumbers(Integer.MAX_VALUE, Integer.MAX_VALUE);
    }

    @Test (expectedExceptions = CalculatorException.class)
    public void checkExceptionMultiTwoMinValuesNumbersTest() throws CalculatorException {
        calculator.multiplyTwoNumbers(Integer.MAX_VALUE, Integer.MAX_VALUE);
    }

    @Test (expectedExceptions = CalculatorException.class)
    public void checkExceptionMultiOneMinValueAndOneNegativeNumbersTest() throws CalculatorException {
        calculator.multiplyTwoNumbers(Integer.MIN_VALUE, -100);
    }

    @Test (expectedExceptions = CalculatorException.class)
    public void checkExceptionMultiOneMinValueAndOnePositiveNumbersTest() throws CalculatorException {
        calculator.multiplyTwoNumbers(Integer.MIN_VALUE, 100);
    }

    @Test (expectedExceptions = CalculatorException.class)
    public void checkExceptionMultiOneMaxValueAndOnePositiveNumbersTest() throws CalculatorException {
        calculator.multiplyTwoNumbers(Integer.MAX_VALUE, 100);
    }

    @Test (expectedExceptions = CalculatorException.class)
    public void checkExceptionMultiOneMaxValueAndOneNegativeNumbersTest() throws CalculatorException {
        calculator.multiplyTwoNumbers(Integer.MAX_VALUE, -100);
    }

    @Test
    public void divideTwoPositiveNumbersTest() throws CalculatorException {
        int expected = 5;
        int actual = calculator.divideTwoNumbers(25, 5);
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void divideTwoNegativeNumbersTest() throws CalculatorException {
        int expected = 5;
        int actual = calculator.divideTwoNumbers(-25, -5);
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void divideOnePositiveAndOneNegativeNumbersTest() throws CalculatorException {
        int expected = -5;
        int actual = calculator.divideTwoNumbers(25, -5);
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void divideZeroAndOnePositiveNumbersTest() throws CalculatorException {
        int expected = 0;
        int actual = calculator.divideTwoNumbers(0, 5);
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void divideZeroAndOneNegativeNumbersTest() throws CalculatorException {
        int expected = 0;
        int actual = calculator.divideTwoNumbers(0, -5);
        Assert.assertEquals(actual, expected);
    }

    @Test (expectedExceptions = CalculatorException.class)
    public void checkExceptionDivideOnePositiveAndZeroNumbersTest() throws CalculatorException {
        calculator.divideTwoNumbers(10, 0);
    }

    @Test (expectedExceptions = CalculatorException.class)
    public void checkExceptionDivideOneNegativeAndZeroNumbersTest() throws CalculatorException {
        calculator.divideTwoNumbers(-10, 0);
    }

    @Test (expectedExceptions = CalculatorException.class)
    public void checkExceptionDivideMaxValueAndZeroNumbersTest() throws CalculatorException {
        calculator.divideTwoNumbers(Integer.MAX_VALUE, 0);
    }

    @Test (expectedExceptions = CalculatorException.class)
    public void checkExceptionDivideMinValueAndZeroNumbersTest() throws CalculatorException {
        calculator.divideTwoNumbers(Integer.MIN_VALUE, 0);
    }

    @Test (expectedExceptions = CalculatorException.class)
    public void checkExceptionDivideZeroAndZeroNumbersTest() throws CalculatorException {
        calculator.divideTwoNumbers(0, 0);
    }

    @Test
    public void divideWithRemainderTwoPositiveNumbersTest() throws CalculatorException {
        int expected = 1;
        int actual = calculator.divideWithRemainderTwoNumbers(23, 2);
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void divideWithRemainderTwoNegativeNumbersTest() throws CalculatorException {
        int expected = -1;
        int actual = calculator.divideWithRemainderTwoNumbers(-29, -2);
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void divideWithRemainderOnePositiveAndOneNegativeNumbersTest() throws CalculatorException {
        int expected = 4;
        int actual = calculator.divideWithRemainderTwoNumbers(24, -5);
        Assert.assertEquals(actual, expected);
    }

    @Test (expectedExceptions = CalculatorException.class)
    public void checkExceptionDivideWithRemainderOnePositiveAndZeroNumbersTest() throws CalculatorException {
        calculator.divideTwoNumbers(220, 0);
    }

    @Test (expectedExceptions = CalculatorException.class)
    public void checkExceptionDivideWithRemainderOneNegativeAndZeroNumbersTest() throws CalculatorException {
        calculator.divideTwoNumbers(-195, 0);
    }

    @Test (expectedExceptions = CalculatorException.class)
    public void checkExceptionDivideWithRemainderZeroAndZeroNumbersTest() throws CalculatorException {
        calculator.divideTwoNumbers(0, 0);
    }

    @Test (expectedExceptions = CalculatorException.class)
    public void checkExceptionDivideWithRemainderMaxValueAndZeroNumbersTest() throws CalculatorException {
        calculator.divideTwoNumbers(Integer.MAX_VALUE, 0);
    }

    @Test (expectedExceptions = CalculatorException.class)
    public void checkExceptionDivideWithRemainderMinValueAndZeroNumbersTest() throws CalculatorException {
        calculator.divideTwoNumbers(Integer.MIN_VALUE, 0);
    }
}
