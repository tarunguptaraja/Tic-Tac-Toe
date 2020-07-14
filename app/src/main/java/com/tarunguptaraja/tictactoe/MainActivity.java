package com.tarunguptaraja.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;



public class MainActivity extends AppCompatActivity {
    int plr = 1;
    int[] gamest = {0,0,0,0,0,0,0,0,0};
    int[][] winning = {{0, 1, 2}, {3, 4, 5}, {6, 7, 8}, {0, 3, 6}, {1, 4, 7}, {2, 5, 8}, {0, 4, 8}, {2, 4, 6}};
    boolean active = true;


    public void playerTap(View v) {

        ImageView img = (ImageView) v;
        int tapimg = Integer.parseInt(img.getTag().toString());
        if (gamest[tapimg] == 0) {
            gamest[tapimg] = plr;
            if (plr == 1) {
                img.setImageResource(R.drawable.x);
                plr = 2;
                TextView status = findViewById(R.id.status);
                status.setText("0's turn - Tap to Play");
            } else {
                img.setImageResource(R.drawable.o);
                plr = 1;
                TextView status = findViewById(R.id.status);
                status.setText("X's turn - Tap to Play");
            }
        }
        if((gamest[0]==1 || gamest[0] ==2) && (gamest[1]==1 || gamest[1] ==2) && (gamest[2]==1 || gamest[2] ==2) && (gamest[3]==1 || gamest[3] ==2) && (gamest[4]==1 || gamest[4] ==2) && (gamest[5]==1 || gamest[5] ==2) && (gamest[6]==1 || gamest[6] ==2) && (gamest[7]==1 || gamest[7] ==2) && (gamest[8]==1 || gamest[8] ==2)){
                     active=false;
                     TextView status = findViewById(R.id.status);
                     status.setText("Draw ");
                 }

        for (int[] win : winning) {
            if (gamest[win[0]] == gamest[win[1]]  && gamest[win[2]] == gamest[win[0]] && gamest[win[0]] != 0) {
                    String speech;
                    if (gamest[win[0]] == 1) {
                        speech = "X won the match";
                    } else {
                        speech = "0 won the match";
                    }
                    TextView status = findViewById(R.id.status);
                    status.setText(speech);
                    active = false;
            }
        }
        if (!active) {
            reset(v);
        }
    }


    public void reset(View v){
        plr=1;

        for(int i=0;i<9;i++){
            gamest[i]=0;
        }
        ((ImageView)findViewById(R.id.imageView1)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView2)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView3)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView4)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView5)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView6)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView7)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView8)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView9)).setImageResource(0);
        active = true;
    }



    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

}
