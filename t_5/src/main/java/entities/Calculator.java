package entities;

import exception.CalculatorException;

public class Calculator {
    public int addTwoNumbers(int firstNumber, int secondNumber) throws CalculatorException {
        if ((firstNumber == Integer.MAX_VALUE && secondNumber > 0)
                || (firstNumber == Integer.MIN_VALUE && secondNumber < 0)
                || (firstNumber > 0 && secondNumber == Integer.MAX_VALUE)
                || (firstNumber < 0 && secondNumber == Integer.MIN_VALUE)) {
            throw new CalculatorException("Impossible to add numbers!");
        } else {
            return firstNumber + secondNumber;
        }
    }

    public int subTwoNumbers(int firstNumber, int secondNumber) throws CalculatorException {
        if ((firstNumber == Integer.MIN_VALUE && secondNumber > 0)
                || (firstNumber == Integer.MAX_VALUE && secondNumber < 0)
                || (firstNumber > 0 && secondNumber == Integer.MIN_VALUE)
                || (firstNumber < 0 && secondNumber == Integer.MAX_VALUE)) {
            throw new CalculatorException("Impossible to subtract numbers!");
        } else {
            return firstNumber - secondNumber;
        }
    }

    public int multiplyTwoNumbers(int firstNumber, int secondNumber) throws CalculatorException {
        if ((firstNumber == Integer.MIN_VALUE || firstNumber == Integer.MAX_VALUE
                || secondNumber == Integer.MIN_VALUE || secondNumber == Integer.MAX_VALUE)) {
            throw new CalculatorException("Impossible to multiply numbers!");
        } else {
            return firstNumber * secondNumber;
        }
    }

    public int divideTwoNumbers(int firstNumber, int secondNumber) throws CalculatorException {
        if (secondNumber == 0) {
            throw new CalculatorException("Division by 0 is not possible!");
        } else {
            return firstNumber / secondNumber;
        }
    }

    public int divideWithRemainderTwoNumbers(int firstNumber, int secondNumber) throws CalculatorException {
        if (secondNumber == 0) {
            throw new CalculatorException("Division with remainder by 0 is not possible!");
        } else {
            return firstNumber % secondNumber;
        }
    }
}
