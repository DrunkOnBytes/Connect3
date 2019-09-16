package com.arjun.connect3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int activePlayer=0;//0=yellow, 1=red
    boolean gameIsActive=true;
    int[] gamestate={2,2,2,2,2,2,2,2,2};//2=unplayed
    int[][] winningPositions={{0,1,2},{3,4,5},{6,7,8},{0,3,6},{1,4,7},{2,5,8},{0,4,8},{2,4,6}};

    public void dropin(View view) {

        ImageView counter = (ImageView) view;

        int tappedcounter = Integer.parseInt(counter.getTag().toString());

        if (gamestate[tappedcounter] == 2 && gameIsActive) {

            gamestate[tappedcounter] = activePlayer;


            counter.setTranslationY(-1000f);
            if (activePlayer == 0) {

                counter.setImageResource(R.drawable.yellow);
                activePlayer = 1;

            } else {

                counter.setImageResource(R.drawable.red);
                activePlayer = 0;

            }
            counter.animate().translationYBy(1000f).rotation(360).setDuration(300);

            for(int[] winningPosition: winningPositions){

                if(gamestate[winningPosition[0]]==gamestate[winningPosition[1]] &&
                        gamestate[winningPosition[1]]==gamestate[winningPosition[2]] &&
                            gamestate[winningPosition[0]]!=2) {

                   String winner="Red";
                    if(gamestate[winningPosition[0]]==0){

                        gameIsActive=false;
                        winner="Yellow";

                    }

                    //Someone has won
                    TextView winnerMessage=(TextView)findViewById(R.id.winnerMessage);
                    winnerMessage.setText(winner+" has won!");
                    LinearLayout layout=(LinearLayout)findViewById(R.id.playAgainLayout);
                    layout.setVisibility(View.VISIBLE);


                }
                else{

                    boolean gameIsOver=true;

                    for(int counterState: gamestate){

                        if(counterState==2) gameIsOver=false;

                    }
                    if(gameIsOver){

                        TextView winnerMessage=(TextView)findViewById(R.id.winnerMessage);
                        winnerMessage.setText("It's a draw!");
                        LinearLayout layout=(LinearLayout)findViewById(R.id.playAgainLayout);
                        layout.setVisibility(View.VISIBLE);

                    }

                }

            }

        }
    }

    public void playAgain(View view) {

        gameIsActive=true;
        LinearLayout layout=(LinearLayout)findViewById(R.id.playAgainLayout);
        layout.setVisibility(View.INVISIBLE);
        activePlayer=0;//0=yellow, 1=red
        for(int i=0; i<gamestate.length; i++) {

            gamestate[i]=2;

        }

        ImageView image=(ImageView)findViewById(R.id.red1);
        image.setImageResource(0);
        image=(ImageView)findViewById(R.id.red2);
        image.setImageResource(0);
        image=(ImageView)findViewById(R.id.red3);
        image.setImageResource(0);
        image=(ImageView)findViewById(R.id.red4);
        image.setImageResource(0);
        image=(ImageView)findViewById(R.id.red5);
        image.setImageResource(0);
        image=(ImageView)findViewById(R.id.red6);
        image.setImageResource(0);
        image=(ImageView)findViewById(R.id.red7);
        image.setImageResource(0);
        image=(ImageView)findViewById(R.id.red8);
        image.setImageResource(0);
        image=(ImageView)findViewById(R.id.red9);
        image.setImageResource(0);


        /*
         GridLayout gridLayout = (GridLayout)findViewById(R.id.gridLayout);

        for (int i = 0; i< gridLayout.getChildCount(); i++) {

            ((ImageView) gridLayout.getChildAt(i)).setImageResource(0);

        }
        */





    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
