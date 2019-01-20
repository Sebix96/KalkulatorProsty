package com.example.sebastian.kalkulatorprosty;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;


import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;


public class MainActivity extends AppCompatActivity {

    StringBuilder textEquation = new StringBuilder();




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }
    public void refreshText()
    {
        TextView textView = findViewById(R.id.ViewM);
        textView.setText(textEquation.toString());
    }

    public void addToEquation(View view)
    {
        int lengthOfEguqtion = textEquation.length()-1;
        TextView button = (TextView)view;
        String character = button.getText().toString();
        if(lengthOfEguqtion>14)
        {
            return;
        }
        textEquation.append(character);
        refreshText();
    }
    public void calculateEquation(View view)
    {
        int lengthEquation = textEquation.length();
        if(lengthEquation<1){
            return;
        }
        Expression expression = new ExpressionBuilder(textEquation.toString()).build();
        double result;
        try {
            result = expression.evaluate();
        } catch (Throwable cause) {
            result = Double.NaN;
        }

        TextView textView = findViewById(R.id.ViewM);
        textView.setText(String.valueOf(result));
        if(Double.isNaN(result)){
        }
        else{
            DatabaseHelper database = new DatabaseHelper(this);
            database.addData(textEquation.toString()+" = "+result);
        }
        textEquation.delete(0, textEquation.length());


    }
    public void clearOne(View view)
    {
        int lengthEquation = textEquation.length();
        if(lengthEquation<1) {
            refreshText();
            return;
        }
        else
        {
            textEquation.delete(textEquation.length() - 1, textEquation.length());
            refreshText();
        }
    }
    public void clearAll(View view)
    {
        int lengthEquation = textEquation.length();
        if(lengthEquation<1) {
            refreshText();
            return;
        }
        else {
            textEquation.delete(0, textEquation.length());
            refreshText();
        }
    }
    public void goHistory(View view)
    {
        Intent intent = new Intent(MainActivity.this, StoryActivity.class);
        startActivity(intent);
    }

}
