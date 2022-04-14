package com.mle.homework2;


import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {

    private static final String KEY_CALCULATIONS = "KEY_CALCULATIONS";
    private static final String DISPLAY = "display";

    private TextView display;
    private Calculator calculator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        calculator = new Calculator();
        initView();

        View.OnClickListener onClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                switch (view.getId()) {
                    case R.id.zero:
                        calculator.setFirstArg("0");
                        setText();
                        break;
                    case R.id.one:
                        calculator.setFirstArg("1");
                        setText();
                        break;
                    case R.id.two:
                        calculator.setFirstArg("2");
                        setText();
                        break;
                    case R.id.three:
                        calculator.setFirstArg("3");
                        setText();
                        break;
                    case R.id.four:
                        calculator.setFirstArg("4");
                        setText();
                        break;
                    case R.id.five:
                        calculator.setFirstArg("5");
                        setText();
                        break;
                    case R.id.six:
                        calculator.setFirstArg("6");
                        setText();
                        break;
                    case R.id.seven:
                        calculator.setFirstArg("7");
                        setText();
                        break;
                    case R.id.eight:
                        calculator.setFirstArg("8");
                        setText();
                        break;
                    case R.id.nine:
                        calculator.setFirstArg("9");
                        setText();
                        break;
                    case R.id.dot:
                        calculator.setFirstArg("0.");
                        setText();
                        break;
                    case R.id.plus:
                        calculator.setAddFlag(true);
                        display.setText("+");
                        break;
                    case R.id.minus:
                        calculator.setSubFlag(true);
                        display.setText("-");
                        break;
                    case R.id.multiply:
                        calculator.setMulFlag(true);
                        display.setText("*");
                        break;
                    case R.id.division:
                        calculator.setDivFlag(true);
                        display.setText("/");
                        break;
                    case R.id.equal:
                        calculator.calculations();
                        display.setText(calculator.getCalculations());
                        break;
                    case R.id.clear:
                        calculator.reset();
                        display.setText("0");
                }
            }
        };
        findViewById(R.id.zero).setOnClickListener(onClickListener);
        findViewById(R.id.one).setOnClickListener(onClickListener);
        findViewById(R.id.two).setOnClickListener(onClickListener);
        findViewById(R.id.three).setOnClickListener(onClickListener);
        findViewById(R.id.four).setOnClickListener(onClickListener);
        findViewById(R.id.five).setOnClickListener(onClickListener);
        findViewById(R.id.six).setOnClickListener(onClickListener);
        findViewById(R.id.seven).setOnClickListener(onClickListener);
        findViewById(R.id.eight).setOnClickListener(onClickListener);
        findViewById(R.id.nine).setOnClickListener(onClickListener);
        findViewById(R.id.dot).setOnClickListener(onClickListener);
        findViewById(R.id.plus).setOnClickListener(onClickListener);
        findViewById(R.id.minus).setOnClickListener(onClickListener);
        findViewById(R.id.division).setOnClickListener(onClickListener);
        findViewById(R.id.multiply).setOnClickListener(onClickListener);
        findViewById(R.id.equal).setOnClickListener(onClickListener);
        findViewById(R.id.clear).setOnClickListener(onClickListener);


        // Сохранение состояния
        if (savedInstanceState != null) {
            display.setText(savedInstanceState.getString(DISPLAY));
            calculator = savedInstanceState.getParcelable(KEY_CALCULATIONS);
        }

    }

    public void initView() {
        display = findViewById(R.id.resultField);
    }

    public void setText() {
        display.setText(calculator.getResult());
    }


    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(DISPLAY, (String) display.getText());
        outState.putParcelable(KEY_CALCULATIONS, calculator);
    }
}