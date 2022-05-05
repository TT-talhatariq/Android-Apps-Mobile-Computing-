package com.talhatariq.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.fathzer.soft.javaluator.DoubleEvaluator;

public class MainActivity extends AppCompatActivity {

    private TextView expression;
    private TextView result;
    private Button plus, minus, multiply, mod, divide, ac,del, equal;
    private Button one,two,three,four,five,six,seven,eight,nine, zero, dot;
    String dummyTempExp = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initiate();
    }
    public void initiate(){
        expression = findViewById(R.id.expression);
        result = findViewById(R.id.result);
    }


    public void onclicksimple(View view) {
        Button b = findViewById(view.getId());
        dummyTempExp += b.getText();
        expression.setText(dummyTempExp);
    }
    public void equal(View view){
        DoubleEvaluator eval = new DoubleEvaluator();
        try {

            Double res = eval.evaluate(dummyTempExp);
            result.setText(String.valueOf(res));
        }
        catch (Exception e){
            Toast.makeText(this, "Invalid Input", Toast.LENGTH_SHORT).show();
        }
        }
    public void clear(View view)
    {
        expression.setText("");
        dummyTempExp = "";
        result.setText("");
    }
    public void back(View view)
    {
        String w = expression.getText().toString();
        expression.setText(w.substring(0, expression.getText().length() - 1));
        dummyTempExp = dummyTempExp.substring(0,dummyTempExp.length()-1);
        result.setText("");
    }
}