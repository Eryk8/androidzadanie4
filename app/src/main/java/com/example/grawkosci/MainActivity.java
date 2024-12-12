package com.example.grawkosci;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import java.util.Random;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private Button rollDiceButton;
    private Button resetButton;

    private TextView dice1;
    private TextView dice2;
    private TextView dice3;
    private TextView dice4;
    private TextView dice5;

    private TextView rollResultText;
    private TextView gameResultText;
    private TextView rollCountText;
    private int rollCount = 0, gameSum = 0;
    private Random random = new Random();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rollDiceButton = findViewById(R.id.rollDiceButton);
        resetButton = findViewById(R.id.resetButton);

        dice1 = findViewById(R.id.dice1);
        dice2 = findViewById(R.id.dice2);
        dice3 = findViewById(R.id.dice3);
        dice4 = findViewById(R.id.dice4);
        dice5 = findViewById(R.id.dice5);

        rollResultText = findViewById(R.id.rollResultText);
        gameResultText = findViewById(R.id.gameResultText);
        rollCountText = findViewById(R.id.rollCountText);

        rollDiceButton.setOnClickListener(v -> {
            rollCount++;
            rollCountText.setText("Liczba rzutów: " + rollCount);

            int[] dice = new int[5];
            int[] counts = new int[7];
            int rollSum = 0;

            for (int i = 0; i < 5; i++) {
                dice[i] = random.nextInt(6) + 1;
                counts[dice[i]]++;
            }

            for (int i = 1; i <= 6; i++) {
                if (counts[i] >= 2) rollSum += i * counts[i];
            }

            dice1.setText(String.valueOf(dice[0]));
            dice2.setText(String.valueOf(dice[1]));
            dice3.setText(String.valueOf(dice[2]));
            dice4.setText(String.valueOf(dice[3]));
            dice5.setText(String.valueOf(dice[4]));

            rollResultText.setText("Wynik tego losowania: " + rollSum);
            gameSum += rollSum;
            gameResultText.setText("Wynik gry: " + gameSum);
        });

        resetButton.setOnClickListener(v -> {
            dice1.setText("?");
            dice2.setText("?");
            dice3.setText("?");
            dice4.setText("?");
            dice5.setText("?");

            rollCount = 0;
            gameSum = 0;

            rollCountText.setText("Liczba rzutów: 0");
            rollResultText.setText("Wynik tego losowania: 0");
            gameResultText.setText("Wynik gry: 0");
        });
    }
}