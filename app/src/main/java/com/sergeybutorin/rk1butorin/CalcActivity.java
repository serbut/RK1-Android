package com.sergeybutorin.rk1butorin;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

enum Formula {
    CIRCLE_PERIMETER, RECTANGLE_AREA, SUM_OF_3
}

public class CalcActivity extends AppCompatActivity {

    static final String ACTION = "Action";
    private ViewGroup container;
    private Button calculateButton;
    private TextView textViewResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calc);

        container = (ViewGroup) findViewById(R.id.container);
        calculateButton = (Button) findViewById(R.id.btn_calculate);
        textViewResult = (TextView) findViewById(R.id.text_result);

        Formula action = (Formula) getIntent().getSerializableExtra(ACTION);
        switch (action) {
            case CIRCLE_PERIMETER:
                configureViewCircle();
                break;
            case RECTANGLE_AREA:
                configureViewRectangle();
                break;
            case SUM_OF_3:
                configureViewSum();
                break;

        }
    }


    private void configureViewRectangle() {
        container.removeAllViews();

        final EditText editSideA = new EditText(this);
        editSideA.setHint(R.string.hint_lengthA);
        container.addView(editSideA);

        final EditText editSideB = new EditText(this);
        editSideB.setHint(R.string.hint_lengthB);
        container.addView(editSideB);

        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    final double sideA = Double.valueOf(editSideA.getText().toString());
                    final double sideB = Double.valueOf(editSideB.getText().toString());
                    if (sideA <= 0 || sideB <= 0) {
                        Toast.makeText(CalcActivity.this, R.string.error_less_0, Toast.LENGTH_SHORT).show();
                    } else {
                        textViewResult.setText(String.valueOf(sideA * sideB));
                    }
                } catch (NumberFormatException e) {
                    Toast.makeText(CalcActivity.this, R.string.error_incorrect_input, Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void configureViewCircle() {
        container.removeAllViews();

        final EditText editCircleRadius = new EditText(this);
        editCircleRadius.setHint(R.string.hint_circle_radius);
        container.addView(editCircleRadius);

        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    double radius = Double.valueOf(editCircleRadius.getText().toString());
                    if (radius <= 0) {
                        Toast.makeText(CalcActivity.this, R.string.error_less_0, Toast.LENGTH_SHORT).show();
                    } else {
                        textViewResult.setText(String.valueOf(2 * Math.PI * radius));
                    }
                } catch (NumberFormatException e) {
                    Toast.makeText(CalcActivity.this, R.string.error_incorrect_input, Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void configureViewSum() {
        container.removeAllViews();

        final EditText editFirstNumber = new EditText(this);
        editFirstNumber.setHint(R.string.hint_first_number);
        container.addView(editFirstNumber);

        final EditText editSecondNumber = new EditText(this);
        editSecondNumber.setHint(R.string.hint_second_number);
        container.addView(editSecondNumber);

        final EditText editThirdNumber = new EditText(this);
        editThirdNumber.setHint(R.string.hint_third_number);
        container.addView(editThirdNumber);

        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    final double firstNumber = Double.valueOf(editFirstNumber.getText().toString());
                    final double secondNumber = Double.valueOf(editSecondNumber.getText().toString());
                    final double thirdNumber = Double.valueOf(editThirdNumber.getText().toString());

                    textViewResult.setText(String.valueOf(firstNumber + secondNumber + thirdNumber));
                } catch (NumberFormatException e) {
                    Toast.makeText(CalcActivity.this, R.string.error_incorrect_input, Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}
