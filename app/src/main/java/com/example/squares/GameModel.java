package com.example.squares;

import android.widget.Button;

public class GameModel {

    //holds the values of the array
    public int[][] numberArray = new int[4][4];
    //used to check if the square is in the correct spot or not
    public int[][] key = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14 ,15, 16}};
    //the button array
    public Button[][] buttonArray = new Button[4][4];
    //used to shuffle values of the array with Collections.shuffle
    public Integer[] test = new Integer[16];


}
