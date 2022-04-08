package com.mle.homework2;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.view.View;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    private TextView display;
    private boolean isNewOp = true;
    private String op = "+";
    private String oldNumber = "";


    private static final String DISPLAY = "display";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        setNumOnClickListener();
        setOpOnClickListener();


        findViewById(R.id.equal).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String newNumber = display.getText().toString();
                double result = 0.0;
                switch (op) {
                    case "+":
                        result = Double.parseDouble(oldNumber) + Double.parseDouble(newNumber);
                        break;
                    case "-":
                        result = Double.parseDouble(oldNumber) - Double.parseDouble(newNumber);
                        break;
                    case "*":
                        result = Double.parseDouble(oldNumber) * Double.parseDouble(newNumber);
                        break;
                    case "/":
                        result = Double.parseDouble(oldNumber) / Double.parseDouble(newNumber);
                        break;
                }
                display.setText(result + "");
            }
        });

        if (savedInstanceState != null) {
            display.setText(savedInstanceState.getString(DISPLAY));
        }

    }

    public void initView() {
        display = findViewById(R.id.resultField);
    }

    public void setNumOnClickListener() {

        View.OnClickListener onNumberClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isNewOp) {
                    display.setText("");
                }
                isNewOp = false;
                String number = display.getText().toString();
                switch (view.getId()){
                    case R.id.zero:
                        number += "0";
                        break;
                    case R.id.one:
                        number += "1";
                        break;
                    case R.id.two:
                        number += "2";
                        break;
                    case R.id.three:
                        number += "3";
                        break;
                    case R.id.four:
                        number += "4";
                        break;
                    case R.id.five:
                        number += "5";
                        break;
                    case R.id.six:
                        number += "6";
                        break;
                    case R.id.seven:
                        number += "7";
                        break;
                    case R.id.eight:
                        number += "8";
                        break;
                    case R.id.nine:
                        number += "9";
                        break;
                    case R.id.dot:
                        number += ".";
                        break;
                }
                display.setText(number);
            }
        };
        findViewById(R.id.zero).setOnClickListener(onNumberClickListener);
        findViewById(R.id.one).setOnClickListener(onNumberClickListener);
        findViewById(R.id.two).setOnClickListener(onNumberClickListener);
        findViewById(R.id.three).setOnClickListener(onNumberClickListener);
        findViewById(R.id.four).setOnClickListener(onNumberClickListener);
        findViewById(R.id.five).setOnClickListener(onNumberClickListener);
        findViewById(R.id.six).setOnClickListener(onNumberClickListener);
        findViewById(R.id.seven).setOnClickListener(onNumberClickListener);
        findViewById(R.id.eight).setOnClickListener(onNumberClickListener);
        findViewById(R.id.nine).setOnClickListener(onNumberClickListener);
        findViewById(R.id.dot).setOnClickListener(onNumberClickListener);
    }

    public void setOpOnClickListener() {

        View.OnClickListener onOperatorClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                isNewOp = true;
                oldNumber = display.getText().toString();
                switch (view.getId()) {
                    case R.id.minus:
                        op = "-";
                        break;
                    case R.id.plus:
                        op = "+";
                        break;
                    case R.id.division:
                        op = "/";
                        break;
                    case R.id.multiply:
                        op = "*";
                        break;
                }
            }
        };
        findViewById(R.id.minus).setOnClickListener(onOperatorClickListener);
        findViewById(R.id.plus).setOnClickListener(onOperatorClickListener);
        findViewById(R.id.multiply).setOnClickListener(onOperatorClickListener);
        findViewById(R.id.division).setOnClickListener(onOperatorClickListener);

        findViewById(R.id.clear).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                display.setText("0");
                isNewOp = true;
            }
        });

    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(DISPLAY, (String) display.getText());
    }
}