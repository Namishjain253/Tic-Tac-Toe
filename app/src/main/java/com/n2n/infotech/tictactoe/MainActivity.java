package com.n2n.infotech.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.GridLayout;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // 0 = yellow, 1 = red
    int activePlayer = 0;
    boolean gameIsActive = true;
    // 2 means unplayed
    int[] gameState = {2, 2, 2, 2, 2, 2, 2, 2, 2};
    int[][] winningPositions = {{0,1,2}, {3,4,5}, {6,7,8}, {0,3,6}, {1,4,7}, {2,5,8}, {0,4,8}, {2,4,6}};

    LinearLayout layout;
    GridLayout gridLayout;
    TextView winnerMessage;
    int w,h;
    ImageView counter;

    ImageView imageView1, imageView2, imageView3, imageView4, imageView5, imageView6, imageView7, imageView8, imageView9;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        w = getResources().getDisplayMetrics().widthPixels;
        h = getResources().getDisplayMetrics().heightPixels;
        // All Object define in init()
        init();
        setDesign();
    }

    private void setDesign() {
        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(
                w * 744 / 1080, w * 783 / 1080);
        params.addRule(RelativeLayout.CENTER_IN_PARENT);
        gridLayout.setLayoutParams(params);
        gridLayout.setColumnCount(3);
        gridLayout.setRowCount(3);

        GridLayout.LayoutParams layoutParams1 = new GridLayout.LayoutParams(gridLayout.getLayoutParams());
        layoutParams1.height = w*180/1080; //this is in pixels
        layoutParams1.width = w*180/1080;
        layoutParams1.setMargins(w*50/1080,w*50/1080,w*20/1080,w*20/1080);
        imageView1.setLayoutParams(layoutParams1);

        GridLayout.LayoutParams layoutParams2 = new GridLayout.LayoutParams(gridLayout.getLayoutParams());
        layoutParams2.height = w*180/1080; //this is in pixels
        layoutParams2.width = w*180/1080;
        layoutParams2.setMargins(w*50/1080,w*50/1080,w*20/1080,w*20/1080);
        imageView2.setLayoutParams(layoutParams2);

        GridLayout.LayoutParams layoutParams3 = new GridLayout.LayoutParams(gridLayout.getLayoutParams());
        layoutParams3.height = w*180/1080; //this is in pixels
        layoutParams3.width = w*180/1080;
        layoutParams3.setMargins(w*50/1080,w*50/1080,w*20/1080,w*20/1080);
        imageView3.setLayoutParams(layoutParams3);

        GridLayout.LayoutParams layoutParams4 = new GridLayout.LayoutParams(gridLayout.getLayoutParams());
        layoutParams4.height = w*180/1080; //this is in pixels
        layoutParams4.width = w*180/1080;
        layoutParams4.setMargins(w*50/1080,w*50/1080,w*20/1080,w*20/1080);
        imageView4.setLayoutParams(layoutParams4);

        GridLayout.LayoutParams layoutParams5 = new GridLayout.LayoutParams(gridLayout.getLayoutParams());
        layoutParams5.height = w*180/1080; //this is in pixels
        layoutParams5.width = w*180/1080;
        layoutParams5.setMargins(w*50/1080,w*50/1080,w*20/1080,w*20/1080);
        imageView5.setLayoutParams(layoutParams5);

        GridLayout.LayoutParams layoutParams6 = new GridLayout.LayoutParams(gridLayout.getLayoutParams());
        layoutParams6.height = w*180/1080; //this is in pixels
        layoutParams6.width = w*180/1080;
        layoutParams6.setMargins(w*50/1080,w*50/1080,w*20/1080,w*20/1080);
        imageView6.setLayoutParams(layoutParams6);

        GridLayout.LayoutParams layoutParams7 = new GridLayout.LayoutParams(gridLayout.getLayoutParams());
        layoutParams7.height = w*180/1080; //this is in pixels
        layoutParams7.width = w*180/1080;
        layoutParams7.setMargins(w*50/1080,w*50/1080,w*20/1080,w*20/1080);
        imageView7.setLayoutParams(layoutParams7);

        GridLayout.LayoutParams layoutParams8 = new GridLayout.LayoutParams(gridLayout.getLayoutParams());
        layoutParams8.height = w*180/1080; //this is in pixels
        layoutParams8.width = w*180/1080;
        layoutParams8.setMargins(w*50/1080,w*50/1080,w*20/1080,w*20/1080);
        imageView8.setLayoutParams(layoutParams8);

        GridLayout.LayoutParams layoutParams9 = new GridLayout.LayoutParams(gridLayout.getLayoutParams());
        layoutParams9.height = w*180/1080; //this is in pixels
        layoutParams9.width = w*180/1080;
        layoutParams9.setMargins(w*50/1080,w*50/1080,w*20/1080,w*20/1080);
        imageView9.setLayoutParams(layoutParams9);
    }

    private void init() {
        layout = (LinearLayout)findViewById(R.id.playAgainLayout);
        gridLayout = (GridLayout)findViewById(R.id.gridLayout);
        winnerMessage = (TextView) findViewById(R.id.winnerMessage);
        imageView1 = (ImageView)findViewById(R.id.imageView1);
        imageView2 = (ImageView)findViewById(R.id.imageView2);
        imageView3 = (ImageView)findViewById(R.id.imageView3);
        imageView4 = (ImageView)findViewById(R.id.imageView4);
        imageView5 = (ImageView)findViewById(R.id.imageView5);
        imageView6 = (ImageView)findViewById(R.id.imageView6);
        imageView7 = (ImageView)findViewById(R.id.imageView7);
        imageView8 = (ImageView)findViewById(R.id.imageView8);
        imageView9 = (ImageView)findViewById(R.id.imageView9);

    }

    public void playAgain(View view) {
        gameIsActive = true;

        layout.setVisibility(View.INVISIBLE);
        activePlayer = 0;
        for (int i = 0; i < gameState.length; i++) {
            gameState[i] = 2;
        }

        for (int i = 0; i< gridLayout.getChildCount(); i++) {
            ((ImageView) gridLayout.getChildAt(i)).setImageResource(0);
        }
    }

    public void dropIn(View view) {
        counter = (ImageView) view;
        int tappedCounter = Integer.parseInt(counter.getTag().toString());
        if (gameState[tappedCounter] == 2 && gameIsActive) {
            gameState[tappedCounter] = activePlayer;
            counter.setTranslationY(-1000f);
            if (activePlayer == 0) {
               counter.setImageResource(R.drawable.yellow);
                activePlayer = 1;
            } else {
                counter.setImageResource(R.drawable.red);
                activePlayer = 0;
            }
            counter.animate().translationYBy(1000f).rotation(360).setDuration(300);
            for (int[] winningPosition : winningPositions) {
                if (gameState[winningPosition[0]] == gameState[winningPosition[1]] &&
                        gameState[winningPosition[1]] == gameState[winningPosition[2]] &&
                        gameState[winningPosition[0]] != 2) {
                    // Someone has won!
                    gameIsActive = false;
                    String winner = "Red";
                    layout.setBackgroundColor(Color.RED);
                    if (gameState[winningPosition[0]] == 0) {
                        winner = "Yellow";
                        layout.setBackgroundColor(Color.YELLOW);
                    }

                    winnerMessage.setText(winner + " has won!");

                    layout.setVisibility(View.VISIBLE);
                } else {
                    boolean gameIsOver = true;
                    for (int counterState : gameState) {
                        if (counterState == 2) gameIsOver = false;
                    }
                    if (gameIsOver) {
                        winnerMessage.setText("It's a draw");
                        layout.setVisibility(View.VISIBLE);
                        layout.setBackgroundColor(Color.BLUE);
                    }
                }
            }
        }
    }
}