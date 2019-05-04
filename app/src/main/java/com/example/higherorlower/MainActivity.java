package com.example.higherorlower;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity
{
    int randomNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        randomNumber = createRandomNumber();

    }

    public void guess(View view) {
        EditText guessEditText = findViewById(R.id.guessEditText);

        int guessInt = Integer.parseInt(guessEditText.getText().toString());

        CheckGuess(guessInt);
    }

    private void CheckGuess(int guessInt)
    {

        int testResult = Integer.compare(guessInt, randomNumber);

        switch (testResult)
        {
            case -1:
                displayLowerAnswerToast();
                break;

            case 0:
                displayCorrectAnswerToast();
                break;

            case 1:
                displayHigherAnswerToast();
                break;


        }

    }

    

    public int createRandomNumber()
    {
        Random random = new Random();
        return random.nextInt(20)+1;
    }

    private void displayCorrectAnswerToast()
    {
        Toast.makeText(MainActivity.this, "That's right!You guessed Correctly", Toast.LENGTH_SHORT).show();
    }

    private void displayLowerAnswerToast()
    {
        Toast.makeText(MainActivity.this, "Lower!", Toast.LENGTH_SHORT).show();
    }

    private void displayHigherAnswerToast()
    {
        Toast.makeText(MainActivity.this, "Higher!",Toast.LENGTH_SHORT).show();
    }

}
