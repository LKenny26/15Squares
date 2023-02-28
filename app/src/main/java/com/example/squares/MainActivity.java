package com.example.squares;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //view, controller, and model
        GameView gv = new GameView();
        GameModel gm = gv.getGameModel();
        GameController gc = new GameController(gv);

        //initialize the button array
        gm.buttonArray[0][0] = findViewById(R.id.b00);
        gm.buttonArray[0][1] = findViewById(R.id.b01);
        gm.buttonArray[0][2] = findViewById(R.id.b02);
        gm.buttonArray[0][3] = findViewById(R.id.b03);

        gm.buttonArray[1][0] = findViewById(R.id.b10);
        gm.buttonArray[1][1] = findViewById(R.id.b11);
        gm.buttonArray[1][2] = findViewById(R.id.b12);
        gm.buttonArray[1][3] = findViewById(R.id.b13);

        gm.buttonArray[2][0] = findViewById(R.id.b20);
        gm.buttonArray[2][1] = findViewById(R.id.b21);
        gm.buttonArray[2][2] = findViewById(R.id.b22);
        gm.buttonArray[2][3] = findViewById(R.id.b23);

        gm.buttonArray[3][0] = findViewById(R.id.b30);
        gm.buttonArray[3][1] = findViewById(R.id.b31);
        gm.buttonArray[3][2] = findViewById(R.id.b32);
        gm.buttonArray[3][3] = findViewById(R.id.b33);

        //set on click listener for all buttons
        for(int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                gm.buttonArray[i][j].setOnClickListener(gc);
            }
        }

        //make the game on start
        gv.createGame();

        //reset button on click listener
        Button reset = findViewById(R.id.reset);
        reset.setOnClickListener(gc);



    }

    //quit the game
    public void quit(View button) {
        finishAffinity();
    }
}