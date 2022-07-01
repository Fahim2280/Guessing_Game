package com.example.guessinggame;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText editText;
    private Button button;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.EditTextID);
        button = findViewById(R.id.ButtonID);
        textView = findViewById(R.id.TextViewID);

        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        String text = editText.getText().toString();

        try {
            if (text.isEmpty()){
                ErrorMessage();
            }else {
                int guess = Integer.parseInt(text);
                if (guess>5) {
                    ErrorMessage();
                }else {
                    Random random = new Random();
                    int randomNumber = random.nextInt(5)+1;
                    if (randomNumber==guess) {
                        textView.setText(R.string.won_text);
                    }else {
                        textView.setText("Sorry ! You have lost.Random number was "+randomNumber);
                    }
                }
            }

        }catch (Exception e) {
            Toast.makeText(getApplicationContext(),"Exception :"+e,Toast.LENGTH_SHORT).show();
        }
    }

    void ErrorMessage() {
        editText.setError("place enter a valid input");
        editText.requestFocus();
        return;
    }
}