package com.example.sebastian.kalkulatorprosty;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import org.mariuszgromada.math.mxparser.Expression;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    StringBuilder textE = new StringBuilder();
    ArrayList<String> history = new ArrayList<>();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }
    public void refreshText()
    {
        TextView textView = findViewById(R.id.ViewM);
        textView.setText(textE.toString());
    }

    public void addToEquation(View view)
    {
        int lengthOfEguqtion = textE.length()-1;
        TextView button = (TextView)view;
        String character = button.getText().toString();
        if(lengthOfEguqtion>14)
        {
            return;
        }
        textE.append(character);
        refreshText();
    }
    public void calculateEquation(View view)
    {
        Expression expression = new Expression(textE.toString());
        double result = expression.calculate();

        TextView textView = findViewById(R.id.ViewM);
        textView.setText(String.valueOf(result));

        DatabaseHelper database = new DatabaseHelper(this);
        database.addData(textE.toString()+" = "+result);
        history.add(textE.toString()+"="+result);
        textE.delete(0,textE.length());
    }
    public void clearOne(View view)
    {
        int lengthEquation = textE.length();
        if(lengthEquation<1) {
            refreshText();
            return;
        }
        else
        {
            textE.delete(textE.length() - 1, textE.length());
            refreshText();
        }
    }
    public void clearAll(View view)
    {
        int lengthEquation = textE.length();
        if(lengthEquation<1) {
            refreshText();
            return;
        }
        else {
            textE.delete(0, textE.length());
            refreshText();
        }
    }
    public void goHistory(View view)
    {
        Intent intent = new Intent(MainActivity.this, StoryActivity.class);
        startActivity(intent);
    }

}
