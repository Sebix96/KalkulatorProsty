package com.example.sebastian.kalkulatorprosty;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView resultView;
    EditText number1, number2;
    Button dodawanie, dzielenie, mnozenie, odejmowanie;
    float resultNumber;
    int num1, num2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        resultView =(TextView) findViewById(R.id.resultView);

        number1 = (EditText) findViewById(R.id.number0);
        number2 = (EditText) findViewById(R.id.number1);

        dodawanie = (Button) findViewById(R.id.dodawanie);
        odejmowanie = (Button) findViewById(R.id.odjemowanie);
        mnozenie = (Button) findViewById(R.id.mnozenie);
        dzielenie = (Button) findViewById(R.id.dzielenie);

        dodawanie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    num1 = Integer.parseInt(number1.getText().toString());
                    num2 = Integer.parseInt(number2.getText().toString());
                    resultNumber = num1 + num2;
                    resultView.setText(String.valueOf(resultNumber));
                }catch(Exception e){
                    resultView.setText("0");
                }
            }

        });
        odejmowanie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    num1 = Integer.parseInt(number1.getText().toString());
                    num2 = Integer.parseInt(number2.getText().toString());
                    resultNumber = num1 - num2;
                    resultView.setText(String.valueOf(resultNumber));
                }catch(Exception e){
                    resultView.setText("0");
             }

            }

        });
        mnozenie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    num1 = Integer.parseInt(number1.getText().toString());
                    num2 = Integer.parseInt(number2.getText().toString());
                    resultNumber = num1 * num2;
                    resultView.setText(String.valueOf(resultNumber));
                }catch(Exception e){
                    resultView.setText("0");
                }
            }

        });
        dzielenie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    num1 = Integer.parseInt(number1.getText().toString());
                    num2 = Integer.parseInt(number2.getText().toString());
                    resultNumber = num1 / num2;
                    resultView.setText(String.valueOf(resultNumber));
                }catch(Exception e){
                    resultView.setText("nie mozna");
                }


            }

        });
    }
}
