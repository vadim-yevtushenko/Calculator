package com.example.calculator;

import java.util.ArrayList;
import java.util.Arrays;

public class Calculator {

    public static String calculate(String str) {
        String resultStr = checkStr(str);
        double result = 0;
        String[] elements = resultStr.split(" ");
        ArrayList<String> list = new ArrayList<>(Arrays.asList(elements));

        switch (list.get(1)){
            case "+": {
                result = Double.parseDouble(list.get(0)) + Double.parseDouble(list.get(2));
                break;
            }
            case "-":{
                result = Double.parseDouble(list.get(0)) - Double.parseDouble(list.get(2));
                break;
            }
            case "*":{
                result = Double.parseDouble(list.get(0)) * Double.parseDouble(list.get(2));
                break;
            }
            case "/":{
                result = Double.parseDouble(list.get(0)) / Double.parseDouble(list.get(2));
                break;
            }
        }
        String res = String.valueOf(result);
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
}
