package com.example.squares;

import android.widget.Button;

public class GameModel {
    public int[][] numberArray = new int[4][4]; //holds the values of the array
    public int[][] key = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14 ,15, 16}}; //used for green
    public Button[][] buttonArray = new Button[4][4]; //the buttons
    public Integer[] test = new Integer[16]; //used to shuffle vals


}
