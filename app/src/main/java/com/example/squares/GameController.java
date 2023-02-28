package com.example.squares;

import android.view.View;

public class GameController implements View.OnClickListener{
    //instance variables
    private GameView gv;
    private GameModel gm;

    public GameController(GameView gvo) {
        //controller constructor
        gv = gvo;
        gm = gv.getGameModel();
    }

    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.reset){
            //will recreate the game board
            gv.createGame();
        }
        else {
            //gets the row and col values of the button clicked
            int row = gv.getRow(view);
            int col = gv.getCol(view);

            //if it is not the end col check to the right
            if (col != 3) {
                if(gm.numberArray[row][col + 1] == 16) {
                    gv.swap(view, row, col + 1);
                }
            }
            //if it is not the end row check down
            if (row != 3) {
                if(gm.numberArray[row+1][col] == 16) {
                    gv.swap(view, row + 1, col);
                }
            }
            //if it is not the first col check to the left
            if (col != 0) {
                if (gm.numberArray[row][col-1] == 16) {
                    gv.swap(view, row, col - 1);
                }
            }
            //if it is not the first row check up
            if (row != 0) {
                if (gm.numberArray[row-1][col] == 16) {
                    gv.swap(view, row - 1, col);
                }
            }

        }

    }
}
