package com.example.quessthenumber;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    TextView questionText;
    int min, max;
    boolean status;
    int avg;
    Button y, n;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        questionText = (TextView) findViewById(R.id.question);
        y = (Button) findViewById(R.id.yes);
        n = (Button) findViewById(R.id.no);
        Intent i = getIntent();
        String minStr = i.getStringExtra("min");
        String maxStr = i.getStringExtra("max");
        min = Integer.parseInt(minStr);
        max = Integer.parseInt(maxStr);
        avg = (max + min) / 2;
        questionText.setText("Угадываем число от " + minStr + " до "+maxStr +
                "\nВаше число больше " + avg +"?");
        status = true;

    }

    public void onYes(View v)
    {
        if (status == true)
            min = avg;
        else
            max = avg;

        avg = (max + min) / 2;
        questionText.setText("Ваше число больше " + Integer.toString(avg) + "?");
        status = true;
        if (avg == min && avg == max) {
            questionText.setText("Ваше число: " + Integer.toString(avg));

            y.setVisibility(View.GONE);
            n.setVisibility(View.GONE);
        }
    }

    public void onNo(View v)
    {
        if (status == false)
            min = avg;
        else
            max = avg;

        avg = (max + min) / 2;
        questionText.setText("Ваше число меньше " + Integer.toString(avg) + "?");
        status = false;
        if (avg == min || avg == max) {
            questionText.setText("Ваше число: " + Integer.toString(avg+1));

            y.setVisibility(View.GONE);
            n.setVisibility(View.GONE);
        }
    }
}
