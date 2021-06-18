 package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private Button b1;
    private Button b2;
    private Button b3;
    private Button b4;
    private Button b5;
    private Button b6;
    private Button b7;
    private Button b8;
    private Button b9;
    private Button b0;
    private Button bComma;
    private Button bMinusValue;
    private Button bPlus;
    private Button bMinus;
    private Button bMulti;
    private Button bDiv;
    private Button bCancel;
    private Button bResult;
    private TextView operation;
    private TextView allOperation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        StringBuilder stringToShow = new StringBuilder();
        StringBuilder stringToCalc = new StringBuilder();

        allOperation = findViewById(R.id.allOperation);
        operation = findViewById(R.id.operation);

        b0 = findViewById(R.id.b0);
        b0.setOnClickListener(v -> {
            if (stringToShow.toString().equals("0")) {
                stringToShow.setLength(0);
            }
            stringToShow.append("0");
            stringToCalc.append("0");
            operation.setText(stringToShow.toString());
        });
        b1 = findViewById(R.id.b1);
        b1.setOnClickListener(v -> {
            if (stringToShow.toString().equals("0")) {
                stringToShow.setLength(0);
            }
            stringToShow.append("1");
            stringToCalc.append("1");
            operation.setText(stringToShow.toString());
        });
        b2 = findViewById(R.id.b2);
        b2.setOnClickListener(v -> {
            if (stringToShow.toString().equals("0")) {
                stringToShow.setLength(0);
            }
            stringToShow.append("2");
            stringToCalc.append("2");
            operation.setText(stringToShow.toString());
        });
        b3 = findViewById(R.id.b3);
        b3.setOnClickListener(v -> {
            if (stringToShow.toString().equals("0")) {
                stringToShow.setLength(0);
            }
            stringToShow.append("3");
            stringToCalc.append("3");
            operation.setText(stringToShow.toString());
        });
        b4 = findViewById(R.id.b4);
        b4.setOnClickListener(v -> {
            if (stringToShow.toString().equals("0")) {
                stringToShow.setLength(0);
            }
            stringToShow.append("4");
            stringToCalc.append("4");
            operation.setText(stringToShow.toString());
        });
        b5 = findViewById(R.id.b5);
        b5.setOnClickListener(v -> {
            if (stringToShow.toString().equals("0")) {
                stringToShow.setLength(0);
            }
            stringToShow.append("5");
            stringToCalc.append("5");
            operation.setText(stringToShow.toString());
        });
        b6 = findViewById(R.id.b6);
        b6.setOnClickListener(v -> {
            if (stringToShow.toString().equals("0")) {
                stringToShow.setLength(0);
            }
            stringToShow.append("6");
            stringToCalc.append("6");
            operation.setText(stringToShow.toString());
        });
        b7 = findViewById(R.id.b7);
        b7.setOnClickListener(v -> {
            if (stringToShow.toString().equals("0")) {
                stringToShow.setLength(0);
            }
            stringToShow.append("7");
            stringToCalc.append("7");
            operation.setText(stringToShow.toString());
        });
        b8 = findViewById(R.id.b8);
        b8.setOnClickListener(v -> {
            if (stringToShow.toString().equals("0")) {
                stringToShow.setLength(0);
            }
            stringToShow.append("8");
            stringToCalc.append("8");
            operation.setText(stringToShow.toString());
        });
        b9 = findViewById(R.id.b9);
        b9.setOnClickListener(v -> {
            if (stringToShow.toString().equals("0")) {
                stringToShow.setLength(0);
            }
            stringToShow.append("9");
            stringToCalc.append("9");
            operation.setText(stringToShow.toString());
        });

        bComma = findViewById(R.id.bComma);
        bComma.setOnClickListener(v -> {
            if (stringToShow.length() < 1) {
                stringToShow.append("0,");
                stringToCalc.append("0,");
            } else {
                stringToShow.append(",");
                stringToCalc.append(",");
            }
            operation.setText(stringToShow.toString());
        });

        bMinusValue = findViewById(R.id.bMinusValue);
        bMinusValue.setOnClickListener(v -> {
            int length = stringToCalc.toString().split(" ").length;
            if (length > 2){
                stringToShow.insert(0, "-");
                String str = insMinus(stringToCalc.toString());
                stringToCalc.setLength(0);
                stringToCalc.append(str);
            }else if (length > 1){
                stringToCalc.append("-");
                stringToShow.insert(0, "-");
            }else if (stringToShow.toString().startsWith("-")) {
                stringToShow.replace(0, 1, "");
                stringToCalc.replace(0, 1, "");
            } else {
                stringToShow.insert(0, "-");
                stringToCalc.insert(0, "-");

            }
            operation.setText(stringToShow.toString());
        });

        bPlus = findViewById(R.id.bPlus);
        bPlus.setOnClickListener(v -> {
            int length = stringToCalc.toString().split(" ").length;
            if (length > 2){
                try {
                    String result = Calculator.calculate(stringToCalc.toString());
                    stringToCalc.setLength(0);
                    stringToCalc.append(result);
                    allOperation.setText(stringToCalc.toString());
                } catch (Exception e) {

                }
            }
            if (stringToCalc.toString().endsWith("+ ")) {
                stringToShow.append("+");
            } else if (stringToShow.length() < 1 && (stringToCalc.toString().endsWith("- ") || stringToCalc.toString().endsWith("* ") || stringToCalc.toString().endsWith("/ "))) {
                stringToCalc.setLength(stringToCalc.length() - 3);
                stringToCalc.append(" + ");
                stringToShow.setLength(0);
                stringToShow.append("+");
            } else {
                stringToCalc.append(" + ");
                stringToShow.setLength(0);
                stringToShow.append("+");
            }
            operation.setText(stringToShow.toString());
            stringToShow.setLength(0);
        });

        bMinus = findViewById(R.id.bMinus);
        bMinus.setOnClickListener(v -> {
            int length = stringToCalc.toString().split(" ").length;
            if (length > 2){
                try {
                    String result = Calculator.calculate(stringToCalc.toString());
                    stringToCalc.setLength(0);
                    stringToCalc.append(result);
                    allOperation.setText(stringToCalc.toString());
                } catch (Exception e) {

                }
            }
            if (stringToCalc.toString().endsWith("- ")) {
                stringToShow.append("-");
            } else if (stringToShow.length() < 1 && (stringToCalc.toString().endsWith("+ ") || stringToCalc.toString().endsWith("* ") || stringToCalc.toString().endsWith("/ "))) {
                stringToCalc.setLength(stringToCalc.length() - 3);
                stringToCalc.append(" - ");
                stringToShow.setLength(0);
                stringToShow.append("-");
            } else {
                stringToCalc.append(" - ");
                stringToShow.setLength(0);
                stringToShow.append("-");
            }
            operation.setText(stringToShow.toString());
            stringToShow.setLength(0);
        });

        bMulti = findViewById(R.id.bMulti);
        bMulti.setOnClickListener(v -> {
            int length = stringToCalc.toString().split(" ").length;
            if (length > 2){
                try {
                    String result = Calculator.calculate(stringToCalc.toString());
                    stringToCalc.setLength(0);
                    stringToCalc.append(result);
                    allOperation.setText(stringToCalc.toString());
                } catch (Exception e) {

                }
            }
            if (stringToCalc.toString().endsWith("* ")) {
                stringToShow.append("*");
            } else if (stringToShow.length() < 1 && (stringToCalc.toString().endsWith("- ") || stringToCalc.toString().endsWith("+ ") || stringToCalc.toString().endsWith("/ "))) {
                stringToCalc.setLength(stringToCalc.length() - 3);
                stringToCalc.append(" * ");
                stringToShow.setLength(0);
                stringToShow.append("*");
            } else {
                stringToCalc.append(" * ");
                stringToShow.setLength(0);
                stringToShow.append("*");
            }
            operation.setText(stringToShow.toString());
            stringToShow.setLength(0);
        });

        bDiv = findViewById(R.id.bDiv);
        bDiv.setOnClickListener(v -> {
            int length = stringToCalc.toString().split(" ").length;
            if (length > 2){
                try {
                    String result = Calculator.calculate(stringToCalc.toString());
                    stringToCalc.setLength(0);
                    stringToCalc.append(result);
                    allOperation.setText(stringToCalc.toString());
                } catch (Exception e) {

                }
            }
            if (stringToCalc.toString().endsWith("/ ")) {
                stringToShow.append("/");
            } else if (stringToShow.length() < 1 && (stringToCalc.toString().endsWith("- ") || stringToCalc.toString().endsWith("* ") || stringToCalc.toString().endsWith("+ "))) {
                stringToCalc.setLength(stringToCalc.length() - 3);
                stringToCalc.append(" / ");
                stringToShow.setLength(0);
                stringToShow.append("/");
            } else {
                stringToCalc.append(" / ");
                stringToShow.setLength(0);
                stringToShow.append("/");
            }
            operation.setText(stringToShow.toString());
            stringToShow.setLength(0);
        });

        bCancel = findViewById(R.id.bCancel);
        bCancel.setOnClickListener(v -> {
            if (stringToShow.length() == 1){
                stringToShow.setLength(stringToShow.length() - 1);
                stringToShow.append("0");
            } else  if (stringToShow.length() > 0) {
                stringToShow.setLength(stringToShow.length() - 1);
            }else {
                stringToShow.append("0");
            }
            operation.setText(stringToShow.toString());
        });

        bResult = findViewById(R.id.bResult);
        bResult.setOnClickListener(v -> {

            String result = "0";
            try {
                result = Calculator.calculate(stringToCalc.toString());
            } catch (Exception e) {

            }
            operation.setText(result);
            allOperation.setText("");
            stringToShow.setLength(0);
            stringToCalc.setLength(0);
        });
    }

    private String insMinus(String string) {
        String[] strings = string.split(" ");
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(strings[0] + " ");
        stringBuilder.append(strings[1] + " ");
        stringBuilder.append("-" + strings[2]);

        return stringBuilder.toString();
    }
}