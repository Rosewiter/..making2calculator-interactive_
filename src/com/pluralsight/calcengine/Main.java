package com.pluralsight.calcengine;

import java.awt.*;
import  java.util.Scanner;

public class Main {
    //calculator engine parallel arrays
    public static void main(String[] args) {
        double[] leftVals = {100.0d, 25.0d, 225.0d, 11.0d};
        double[] rightVals = {50.0d, 92.0d, 17.0d, 3.0d};
        char[] opCode = {'d', 'a', 's', 'm'};
        double[] results = new double[opCode.length];

        if (args.length == 0) {
            for (int i = 0; i < opCode.length; i++) {
                results[i] = execute(opCode[i], leftVals[i], rightVals[i]);
            }
            for (double currentResult : results)
                System.out.println(currentResult);
        } else if (args.length == 3)
            handleCommandLine(args);
        else
            System.out.println("Please provide an operation code and 2 numeric values");
    }

    static void executeInteractively(){
        System.out.println("Enter an operation and two numbers");
        Scanner scanner = new Scanner(System.in);
        String userInput = scanner.nextLine();
        String[] parts = userInput.split("");
        performOperation(parts);

    }

    private static void performOperation(String[] parts) {
        char opCode = opCodeFromString(parts[0]);
        double leftVal = valueFromWord(parts[1]);
        double rightVal = valueFromWord(parts[2]);
        double result = execute(opCode,leftVal,rightVal);
        System.out.println(result);
    }

    private static void handleCommandLine(String[] args) {
        char opCode = args[0].charAt(0);
        double leftVal = Double.parseDouble(args[1]);
        double rightVal = Double.parseDouble(args[2]);
        double result = execute(opCode, leftVal,rightVal);
        System.out.println(result);
    }


    static   double execute (char opCode, double leftVal, double rightVal){
        double result;

        switch (opCode) {
            case 'a':
                result = leftVal + rightVal;
                break;
            case 's':
                result = leftVal - rightVal;
                break;
            case 'm':
                result = leftVal * rightVal;
                break;
            case 'd':
                result = rightVal != 0 ? leftVal / rightVal : 0.0d;
                break;
            default:
                System.out.println("Invalid opCode: " + opCode);
                result = 0.0d;
                break;
        }
        return result;
    }

    static char opCodeFromString(String operationName){
        char opCode = operationName.charAt(0);
        return opCode;
    }

    static double valueFromWord(String word){
        String[] numberWords = {
                "zero","one", "two","three","four",
                "five","six", "two","seven","eight", "nine",
        };
        double value = 0d;
        for(int index = 0;index < numberWords.length; index++){
            if(word.equals(numberWords[index])) {
                value = index;
                break;
            }
        }
        return  value;
    }
}
