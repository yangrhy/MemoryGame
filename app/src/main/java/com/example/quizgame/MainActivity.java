package com.example.quizgame;

import android.content.Intent;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.AssetManager;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import static android.widget.Toast.*;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "Memory Game Activity";
    private TextView score, time;
    private Button reset;
    private ButtonClickListener bttnClick;
    private List<Integer> myImages;
    private List<Integer> imgsInPlay; // images that will be in play
    private int numOfFlips = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imgsInPlay = new ArrayList<Integer>();
        score = (TextView)findViewById(R.id.scoreText);
        time = (TextView)findViewById(R.id.timeText);
        bttnClick = new ButtonClickListener();

        // array of images directed towards drawable by R.drawable
        myImages = Arrays.asList
                (R.drawable.alligator, R.drawable.armadillo, R.drawable.bear, R.drawable.bee, R.drawable.cat,
                 R.drawable.chicken, R.drawable.cow, R.drawable.deer, R.drawable.dog, R.drawable.duck,
                 R.drawable.elephant, R.drawable.frog, R.drawable.giraffe, R.drawable.horse, R.drawable.kangaroo,
                 R.drawable.lion, R.drawable.monkey, R.drawable.mouse, R.drawable.octopus, R.drawable.owl,
                 R.drawable.panda, R.drawable.parrot, R.drawable.peacock, R.drawable.penguin, R.drawable.pig,
                 R.drawable.rabbit, R.drawable.raccoon, R.drawable.shark, R.drawable.sheep, R.drawable.skunk,
                 R.drawable.snake, R.drawable.squirrel, R.drawable.tiger, R.drawable.turtle, R.drawable.whale,
                 R.drawable.wolf, R.drawable.zebra
                );


        StartGame();

        int numButtonArray[] = {R.id.card1a, R.id.card1b, R.id.card1c, R.id.card1d, R.id.card1e,
                                R.id.card2a, R.id.card2b, R.id.card2c, R.id.card2d, R.id.card2e,
                                R.id.card3a, R.id.card3b, R.id.card3c, R.id.card3d, R.id.card3e,
                                R.id.card4a, R.id.card4b, R.id.card4c, R.id.card4d, R.id.card4e,
                                R.id.resetBttn};

        for (int bttn : numButtonArray)
        {
            View v = (View) findViewById(bttn);

            v.setOnClickListener(bttnClick);
        }

    }

    // on start up, get images for cards ready
    private void StartGame() {

        Collections.shuffle(myImages);

        for (int i = 0; i < 10; i++) {
            int ref = myImages.get(i);
            imgsInPlay.add(ref);
            imgsInPlay.add(ref);
        }

        Collections.shuffle(imgsInPlay);
    }

    private class ButtonClickListener implements OnClickListener
    {

        public void onClick (View v)
        {
            ImageView flippedCard;

            switch (v.getId())
            {
                case R.id.resetBttn:
                    Reset();
                    break;
                case R.id.card1a:
                    flippedCard = (ImageView)findViewById(R.id.card1a);
                    flippedCard.setImageResource(imgsInPlay.get(0));
                    numOfFlips += 1;
                    break;
                case R.id.card1b:
                    flippedCard = (ImageView)findViewById(R.id.card1b);
                    flippedCard.setImageResource(imgsInPlay.get(1));
                    numOfFlips += 1;
                    break;
                case R.id.card1c:
                    flippedCard = (ImageView)findViewById(R.id.card1c);
                    flippedCard.setImageResource(imgsInPlay.get(2));
                    numOfFlips += 1;
                    break;
                case R.id.card1d:
                    flippedCard = (ImageView)findViewById(R.id.card1d);
                    flippedCard.setImageResource(imgsInPlay.get(3));
                    numOfFlips += 1;
                    break;
                case R.id.card1e:
                    flippedCard = (ImageView)findViewById(R.id.card1e);
                    flippedCard.setImageResource(imgsInPlay.get(4));
                    numOfFlips += 1;
                    break;
                case R.id.card2a:
                    flippedCard = (ImageView)findViewById(R.id.card2a);
                    flippedCard.setImageResource(imgsInPlay.get(5));
                    numOfFlips += 1;
                    break;
                case R.id.card2b:
                    flippedCard = (ImageView)findViewById(R.id.card2b);
                    flippedCard.setImageResource(imgsInPlay.get(6));
                    numOfFlips += 1;
                    break;
                case R.id.card2c:
                    flippedCard = (ImageView)findViewById(R.id.card2c);
                    flippedCard.setImageResource(imgsInPlay.get(7));
                    numOfFlips += 1;
                    break;
                case R.id.card2d:
                    flippedCard = (ImageView)findViewById(R.id.card2d);
                    flippedCard.setImageResource(imgsInPlay.get(8));
                    numOfFlips += 1;
                    break;
                case R.id.card2e:
                    flippedCard = (ImageView)findViewById(R.id.card2e);
                    flippedCard.setImageResource(imgsInPlay.get(9));
                    numOfFlips += 1;
                    break;
                case R.id.card3a:
                    flippedCard = (ImageView)findViewById(R.id.card3a);
                    flippedCard.setImageResource(imgsInPlay.get(10));
                    numOfFlips += 1;
                    break;
                case R.id.card3b:
                    flippedCard = (ImageView)findViewById(R.id.card3b);
                    flippedCard.setImageResource(imgsInPlay.get(11));
                    numOfFlips += 1;
                    break;
                case R.id.card3c:
                    flippedCard = (ImageView)findViewById(R.id.card3c);
                    flippedCard.setImageResource(imgsInPlay.get(12));
                    numOfFlips += 1;
                    break;
                case R.id.card3d:
                    flippedCard = (ImageView)findViewById(R.id.card3d);
                    flippedCard.setImageResource(imgsInPlay.get(13));
                    numOfFlips += 1;
                    break;
                case R.id.card3e:
                    flippedCard = (ImageView)findViewById(R.id.card3e);
                    flippedCard.setImageResource(imgsInPlay.get(14));
                    numOfFlips += 1;
                    break;
                case R.id.card4a:
                    flippedCard = (ImageView)findViewById(R.id.card4a);
                    flippedCard.setImageResource(imgsInPlay.get(15));
                    numOfFlips += 1;
                    break;
                case R.id.card4b:
                    flippedCard = (ImageView)findViewById(R.id.card4b);
                    flippedCard.setImageResource(imgsInPlay.get(16));
                    numOfFlips += 1;
                    break;
                case R.id.card4c:
                    flippedCard = (ImageView)findViewById(R.id.card4c);
                    flippedCard.setImageResource(imgsInPlay.get(17));
                    numOfFlips += 1;
                    break;
                case R.id.card4d:
                    flippedCard = (ImageView)findViewById(R.id.card4d);
                    flippedCard.setImageResource(imgsInPlay.get(18));
                    numOfFlips += 1;
                    break;
                case R.id.card4e:
                    flippedCard = (ImageView)findViewById(R.id.card4e);
                    flippedCard.setImageResource(imgsInPlay.get(19));
                    numOfFlips += 1;
                    break;
            }
        }
    }

    // reset memory game
    private void Reset() {
        Intent intent = new Intent(MainActivity.this, MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK); //this will always start your activity as a new task
        startActivity(intent);
    }

    private void CheckWin() {

    }
}
