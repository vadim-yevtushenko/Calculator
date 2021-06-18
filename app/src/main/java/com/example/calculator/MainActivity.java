 package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private Button btn1;
    private Button btn2;
    private Button btn3;
    private Button btn4;
    private Button btn5;
    private Button btn6;
    private Button btn7;
    private Button btn8;
    private Button btn9;
    private Button btn0;
    private Button btnComma;
    private Button btnMinusValue;
    private Button btnPlus;
    private Button btnMinus;
    private Button btnMulti;
    private Button btnDiv;
    private Button btnCancel;
    private Button btnResult;
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

        btn0 = findViewById(R.id.b0);
        btn0.setOnClickListener(v -> {
            if (stringToShow.toString().equals("0")) {
                stringToShow.setLength(0);
            }
            stringToShow.append("0");
            operation.setText(stringToShow.toString());
        });
        btn1 = findViewById(R.id.b1);
        btn1.setOnClickListener(v -> {
            if (stringToShow.toString().equals("0")) {
                stringToShow.setLength(0);
            }
            stringToShow.append("1");
            operation.setText(stringToShow.toString());
        });
        btn2 = findViewById(R.id.b2);
        btn2.setOnClickListener(v -> {
            if (stringToShow.toString().equals("0")) {
                stringToShow.setLength(0);
            }
            stringToShow.append("2");
            operation.setText(stringToShow.toString());
        });
        btn3 = findViewById(R.id.b3);
        btn3.setOnClickListener(v -> {
            if (stringToShow.toString().equals("0")) {
                stringToShow.setLength(0);
            }
            stringToShow.append("3");
            operation.setText(stringToShow.toString());
        });
        btn4 = findViewById(R.id.b4);
        btn4.setOnClickListener(v -> {
            if (stringToShow.toString().equals("0")) {
                stringToShow.setLength(0);
            }
            stringToShow.append("4");
            operation.setText(stringToShow.toString());
        });
        btn5 = findViewById(R.id.b5);
        btn5.setOnClickListener(v -> {
            if (stringToShow.toString().equals("0")) {
                stringToShow.setLength(0);
            }
            stringToShow.append("5");
            operation.setText(stringToShow.toString());
        });
        btn6 = findViewById(R.id.b6);
        btn6.setOnClickListener(v -> {
            if (stringToShow.toString().equals("0")) {
                stringToShow.setLength(0);
            }
            stringToShow.append("6");
            operation.setText(stringToShow.toString());
        });
        btn7 = findViewById(R.id.b7);
        btn7.setOnClickListener(v -> {
            if (stringToShow.toString().equals("0")) {
                stringToShow.setLength(0);
            }
            stringToShow.append("7");
            operation.setText(stringToShow.toString());
        });
        btn8 = findViewById(R.id.b8);
        btn8.setOnClickListener(v -> {
            if (stringToShow.toString().equals("0")) {
                stringToShow.setLength(0);
            }
            stringToShow.append("8");
            operation.setText(stringToShow.toString());
        });
        btn9 = findViewById(R.id.b9);
        btn9.setOnClickListener(v -> {
            if (stringToShow.toString().equals("0")) {
                stringToShow.setLength(0);
            }
            stringToShow.append("9");
            operation.setText(stringToShow.toString());
        });
        btnComma = findViewById(R.id.bComma);
        btnComma.setOnClickListener(v -> {
            if (stringToShow.length() < 1) {
                stringToShow.append("0,");
            } else {
                stringToShow.append(",");
            }
            operation.setText(stringToShow.toString());
        });
        btnMinusValue = findViewById(R.id.bMinusValue);
        btnMinusValue.setOnClickListener(v -> {
            if (stringToShow.toString().startsWith("-")) {
                stringToShow.replace(0, 1, "");
            } else {
                stringToShow.insert(0, "-");

            }
            operation.setText(stringToShow.toString());
        });
        btnPlus = findViewById(R.id.bPlus);
        btnPlus.setOnClickListener(v -> {
            if (stringToCalc.toString().endsWith("+ ")) {
                stringToShow.append("+");
            } else if (stringToShow.length() < 1 && (stringToCalc.toString().endsWith("- ") || stringToCalc.toString().endsWith("* ") || stringToCalc.toString().endsWith("/ "))) {
                stringToCalc.setLength(stringToCalc.length() - 3);
                stringToCalc.append(stringToShow).append(" + ");
                stringToShow.setLength(0);
                stringToShow.append("+");
            } else {
                stringToCalc.append(stringToShow).append(" + ");
                stringToShow.setLength(0);
                stringToShow.append("+");
            }
            operation.setText(stringToShow.toString());
            stringToShow.setLength(0);
        });
        btnMinus = findViewById(R.id.bMinus);
        btnMinus.setOnClickListener(v -> {
            if (stringToCalc.toString().endsWith("- ")) {
                stringToShow.append("-");
            } else if (stringToShow.length() < 1 && (stringToCalc.toString().endsWith("+ ") || stringToCalc.toString().endsWith("* ") || stringToCalc.toString().endsWith("/ "))) {
                stringToCalc.setLength(stringToCalc.length() - 3);
                stringToCalc.append(stringToShow).append(" - ");
                stringToShow.setLength(0);
                stringToShow.append("-");
            } else {
                stringToCalc.append(stringToShow).append(" - ");
                stringToShow.setLength(0);
                stringToShow.append("-");
            }
            operation.setText(stringToShow.toString());
            stringToShow.setLength(0);
        });
        btnMulti = findViewById(R.id.bMulti);
        btnMulti.setOnClickListener(v -> {
            if (stringToCalc.toString().endsWith("* ")) {
                stringToShow.append("*");
            } else if (stringToShow.length() < 1 && (stringToCalc.toString().endsWith("- ") || stringToCalc.toString().endsWith("+ ") || stringToCalc.toString().endsWith("/ "))) {
                stringToCalc.setLength(stringToCalc.length() - 3);
                stringToCalc.append(stringToShow).append(" * ");
                stringToShow.setLength(0);
                stringToShow.append("*");
            } else {
                stringToCalc.append(stringToShow).append(" * ");
                stringToShow.setLength(0);
                stringToShow.append("*");
            }
            operation.setText(stringToShow.toString());
            stringToShow.setLength(0);
        });
        btnDiv = findViewById(R.id.bDiv);
        btnDiv.setOnClickListener(v -> {
            if (stringToCalc.toString().endsWith("/ ")) {
                stringToShow.append("/");
            } else if (stringToShow.length() < 1 && (stringToCalc.toString().endsWith("- ") || stringToCalc.toString().endsWith("* ") || stringToCalc.toString().endsWith("+ "))) {
                stringToCalc.setLength(stringToCalc.length() - 3);
                stringToCalc.append(stringToShow).append(" / ");
                stringToShow.setLength(0);
                stringToShow.append("/");
            } else {
                stringToCalc.append(stringToShow).append(" / ");
                stringToShow.setLength(0);
                stringToShow.append("/");
            }
            operation.setText(stringToShow.toString());
            stringToShow.setLength(0);
        });
        btnCancel = findViewById(R.id.bCancel);
        btnCancel.setOnClickListener(v -> {
            if (stringToShow.length() > 0) {
                stringToShow.setLength(stringToShow.length() - 1);
            } else {
                stringToShow.append("0");
            }
            operation.setText(stringToShow.toString());
        });
        btnResult = findViewById(R.id.bResult);
        btnResult.setOnClickListener(v -> {
            stringToCalc.append(stringToShow);
            String result = "0";
            try {
                result = Calculator.calculate(stringToCalc.toString());
            } catch (Exception e) {

            }
            operation.setText(result);
            allOperation.setText(stringToCalc);
            stringToShow.setLength(0);
            stringToCalc.setLength(0);
        });
    }
}