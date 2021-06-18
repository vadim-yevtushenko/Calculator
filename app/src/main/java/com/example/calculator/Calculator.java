package com.example.calculator;

import java.util.ArrayList;
import java.util.Arrays;

public class Calculator {

    public static String calculate(String str) {
        double result;
        String resultStr = checkStr(str);

        String[] elements = resultStr.split(" ");
        ArrayList<String> list = new ArrayList<>(Arrays.asList(elements));

        while (true) {

            int indexMult = list.indexOf("*");
            int indexDiv = list.indexOf("/");
            if (indexMult == -1 && indexDiv == -1) {
                break;
            }
            firstOperation(list, indexMult, indexDiv);
        }


        while (true) {

            int indexPlus = list.indexOf("+");
            int indexMinus = list.indexOf("-");
            if (indexPlus == -1 && indexMinus == -1) {
                break;
            }
            secondOperation(list, indexPlus, indexMinus);

        }

        String res = list.get(0);
        if (res.endsWith(".0")){
            StringBuilder sb = new StringBuilder(res);
            sb.setLength(res.length() - 2);
            return sb.toString();
        }

        return res;
    }

    private static String checkStr(String str) {
        return str.replaceAll(",", ".");
    }

    private static String plusMinus(String str) {
        String result;
        double num = 0;
        String[] elements = str.trim().split(" ");
        switch (elements[1]) {
            case "+": {
                num = Double.parseDouble(elements[0]) + Double.parseDouble(elements[2]);
                break;
            }
            case "-": {
                num = Double.parseDouble(elements[0]) - Double.parseDouble(elements[2]);
                break;
            }
        }
        result = String.valueOf(num);
        return result;
    }

    private static String multiplyDivide(String str) {
        String result;
        double num = 0;
        String[] elements = str.split(" ");
        switch (elements[1]) {

            case "*": {
                num = Double.parseDouble(elements[0]) * Double.parseDouble(elements[2]);
                break;
            }
            case "/": {
                if (Double.parseDouble(elements[2]) == 0) {
                    throw new ArithmeticException();
                }
                num = Double.parseDouble(elements[0]) / Double.parseDouble(elements[2]);
                break;
            }
        }
        result = String.valueOf(num);
        return result;
    }

    public static void firstOperation(ArrayList<String> arrayList, int indexMult, int indexDiv) {
        String newStr;
        if (indexMult != -1 && (indexMult < indexDiv || indexDiv == -1)) {
            newStr = arrayList.get(indexMult - 1) + " " + arrayList.get(indexMult) + " " + arrayList.get(indexMult + 1);
            arrayList.set(indexMult, multiplyDivide(newStr));
            arrayList.remove(indexMult + 1);
            arrayList.remove(indexMult - 1);

        } else {
            newStr = arrayList.get(indexDiv - 1) + " " + arrayList.get(indexDiv) + " " + arrayList.get(indexDiv + 1);
            arrayList.set(indexDiv, multiplyDivide(newStr));
            arrayList.remove(indexDiv + 1);
            arrayList.remove(indexDiv - 1);
        }
    }

    public static void secondOperation(ArrayList<String> arrayList, int indexPlus, int indexMinus) {
        String newStr;
        if (indexPlus != -1 && (indexPlus < indexMinus || indexMinus == -1)) {
            newStr = arrayList.get(indexPlus - 1) + " " + arrayList.get(indexPlus) + " " + arrayList.get(indexPlus + 1);
            arrayList.set(indexPlus, plusMinus(newStr));
            arrayList.remove(indexPlus + 1);
            arrayList.remove(indexPlus - 1);

        } else {
            newStr = arrayList.get(indexMinus - 1) + " " + arrayList.get(indexMinus) + " " + arrayList.get(indexMinus + 1);
            arrayList.set(indexMinus, plusMinus(newStr));
            arrayList.remove(indexMinus + 1);
            arrayList.remove(indexMinus - 1);
        }
    }
}
