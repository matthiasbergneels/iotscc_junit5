package de.mbn.iotscc;

public class Calculator {


    public double add(double numberA, double numberB){
        return numberA + numberB;
    }

    public double substract(double numberA, double numberB){
        return numberA - numberB;
    }

    public double multiply(double numberA, double numberB){
        return numberA * numberB;
    }

    public double divide(double numberA, double numberB) throws ArithmeticException{
        if(numberB == 0){
            throw new ArithmeticException("Division by 0 not allowed");
        }
        return numberA / numberB;
    }

    public double veryLongCalculation(int complexity){
        try {
            Thread.sleep(complexity);
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return complexity;
    }
}

