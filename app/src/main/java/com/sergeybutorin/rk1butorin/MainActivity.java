package com.sergeybutorin.rk1butorin;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.zip.Inflater;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button rectangleBtn = (Button) findViewById(R.id.btn_rectangle_area);
        final Button circleBtn = (Button) findViewById(R.id.btn_circle_perimeter);
        final Button sumBtn = (Button) findViewById(R.id.btn_sum_of_3);

        rectangleBtn.setOnClickListener(this);
        circleBtn.setOnClickListener(this);
        sumBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        final Intent intent = new Intent(MainActivity.this, CalcActivity.class);
        switch (v.getId()) {
            case R.id.btn_circle_perimeter:
                intent.putExtra(CalcActivity.ACTION, Formula.CIRCLE_PERIMETER);
                startActivity(intent);
                break;
            case R.id.btn_rectangle_area:
                intent.putExtra(CalcActivity.ACTION, Formula.RECTANGLE_AREA);
                startActivity(intent);
                break;
            case R.id.btn_sum_of_3:
                intent.putExtra(CalcActivity.ACTION, Formula.SUM_OF_3);
                startActivity(intent);
                break;
        }
    }



}
