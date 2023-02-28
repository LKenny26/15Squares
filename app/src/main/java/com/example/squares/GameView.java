package com.example.squares;

import android.graphics.Color;
import android.view.View;
import android.widget.Button;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class GameView {
    //game model variable
    private GameModel gm;

    public GameView() {
        //gameview constructor
        gm = new GameModel();
    }

    //getter method
    public GameModel getGameModel() {return gm;}

    //makes the game and resets the game
    public void createGame() {

        //sets the values in the array
        for (int i = 0; i < 16; i++) {
            gm.test[i] = i + 1;
        }
        //makes the array a list shuffles and makes it an array again
        List<Integer> testList = Arrays.asList(gm.test);
        Collections.shuffle(testList);
        testList.toArray(gm.test);

        //finds 16 and places it as the last value
        for (int i = 0; i < 16; i++) {
            if (gm.test[i] == 16) {
                int swap = gm.test[15];
                gm.test[15] = 16;
                gm.test[i] = swap;
            }
        }

        //makes the shuffled array into a two D array
        int indexTest = 0;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                gm.numberArray[i][j] = gm.test[indexTest];
                indexTest++;
            }
        }

        //sets the buttons text and what color they are
        for(int i = 0; i < 4; i++) {
            for(int j = 0; j < 4; j++) {
                //defaults
                gm.buttonArray[i][j].setText(gm.numberArray[i][j] + "");
                gm.buttonArray[i][j].setBackgroundColor(Color.GRAY);
                gm.buttonArray[i][j].setClickable(true);
                gm.buttonArray[i][j].setVisibility(View.VISIBLE);

                //16 is special and is invisible and can't be clicked
                if(gm.numberArray[i][j] == 16) {
                    gm.buttonArray[i][j].setClickable(false);
                    gm.buttonArray[i][j].setVisibility(View.INVISIBLE);
                }
                //if the button is in the right spot then it should be green
                if (gm.buttonArray[i][j].getText().equals(String.valueOf(gm.key[i][j]))) {
                    gm.buttonArray[i][j].setBackgroundColor(Color.GREEN);
                }
            }
        }
        //used to make sure the game is playable
        //odd is not playable so recreate the game til it is even
        if (this.inversionSum() % 2 == 1) {
            this.createGame();
        }

    }

    //method used to get the row of the view
    public int getRow (View view) {
        int row = -1;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (view == gm.buttonArray[i][j]){
                    row = i;
                }
            }
        }
        return row;
    }

    //method used to get the col of the view
    public int getCol(View view) {
        int col = -1;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (view == gm.buttonArray[i][j]){
                    col = j;
                }
            }
        }
        return col;
    }

    //swaps the values in the current view and the button next to it that is "empty"
    public void swap(View view, int r, int c) {
        //variables
        int row = this.getRow(view);
        int col = this.getCol(view);
        int storage;

        //swaps the number array
        storage = gm.numberArray[row][col];
        gm.numberArray[row][col] = gm.numberArray[r][c];
        gm.numberArray[r][c] = storage;

        //swaps text
        gm.buttonArray[row][col].setText(String.valueOf(gm.numberArray[row][col]));
        gm.buttonArray[r][c].setText(String.valueOf(gm.numberArray[r][c]));

        //swaps visibility
        gm.buttonArray[row][col].setVisibility(View.INVISIBLE);
        gm.buttonArray[r][c].setVisibility(View.VISIBLE);

        //swaps clickability
        gm.buttonArray[row][col].setClickable(false);
        gm.buttonArray[r][c].setClickable(true);

        //check the colors
        this.colorCheck();
    }

    //method checks the colors to make sure the correct ones are green or not after a swap
    public void colorCheck() {
        for(int i = 0; i < 4; i++) {
            for(int j = 0; j < 4; j++) {
                //sets all buttons to gray by default
                gm.buttonArray[i][j].setBackgroundColor(Color.GRAY);
                if (gm.buttonArray[i][j].getText().equals(String.valueOf(gm.key[i][j]))) {
                    //if the button is in the right place make it green
                    gm.buttonArray[i][j].setBackgroundColor(Color.GREEN);
                }
            }
        }
    }

    //inversion sum is the equation that checks whether or not a board is playable
    //this is from the wolfram website
    public int inversionSum(){
        //how many numbers have been checked so far
        int amountChecked = 0;
        //variable to hold the inversion sum
        int invSum = 0;
        for (int i = 0; i < 16; i++) {
            //variable for any numbers that are less than the current one that got checked
            int amountBefore = 1;
            for (int j = 0; j < amountChecked; j++){
                if (gm.test[i] > gm.test[j]) {
                    //increment amount before it there are values that are less before it
                    amountBefore++;
                }
            }
            //increment total amount checked so far
            amountChecked++;
            //add to the invSum with amount before
            invSum += (gm.test[i] - amountBefore);
        }
        //after the loops return the sum
        return invSum;
    }
}
