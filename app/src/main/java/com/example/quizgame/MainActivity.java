package com.example.quizgame;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.os.Handler;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "Memory Game Activity";
    private TextView score, time;
    private Button reset;
    private ButtonClickListener bttnClick;
    private List<Integer> myImages;
    private List<Integer> imgsInPlay; // images that will be in play
    private List<ImageView> imageViewList;
    private List<Integer> imageViewsToCheck;
    private int numOfFlips = 0;
    private Handler handler;
    private int numScore = 0;
    private int numOfPairs = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imgsInPlay = new ArrayList<Integer>();
        score = (TextView)findViewById(R.id.scoreText);
        time = (TextView)findViewById(R.id.timeText);
        bttnClick = new ButtonClickListener();
        handler = new Handler(); // used to perform delayed operations

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

        imageViewList = Arrays.asList
                (
                        (ImageView)findViewById(R.id.card1a),(ImageView)findViewById(R.id.card1b), (ImageView)findViewById(R.id.card1c),
                        (ImageView)findViewById(R.id.card1d),(ImageView)findViewById(R.id.card1e),(ImageView)findViewById(R.id.card2a),
                        (ImageView)findViewById(R.id.card2b),(ImageView)findViewById(R.id.card2c),(ImageView)findViewById(R.id.card2d),
                        (ImageView)findViewById(R.id.card2e), (ImageView)findViewById(R.id.card3a), (ImageView)findViewById(R.id.card3b),
                        (ImageView)findViewById(R.id.card3c),(ImageView)findViewById(R.id.card3d),(ImageView)findViewById(R.id.card3e),
                        (ImageView)findViewById(R.id.card4a),(ImageView)findViewById(R.id.card4b),(ImageView)findViewById(R.id.card4c),
                        (ImageView)findViewById(R.id.card4d),(ImageView)findViewById(R.id.card4e)
                );

        imageViewsToCheck = new ArrayList<Integer>();

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

        for (ImageView iv: imageViewList) {
            iv.setImageResource(R.drawable.back);
        }
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
            switch (v.getId())
            {
                case R.id.resetBttn:
                    Reset();
                    break;
                case R.id.card1a:
                    imageViewList.get(0).setImageResource(imgsInPlay.get(0));
                    imageViewsToCheck.add(0);
                    numOfFlips += 1;
                    if (numOfFlips == 2)
                    {
                        handler.postDelayed(
                                new Runnable()
                                {
                                    @Override
                                    public void run()
                                    {
                                        CheckMatch();
                                    }
                                }, 1000); // 1000 milliseconds for 1-second delay
                    }
                    break;
                case R.id.card1b:
                    imageViewList.get(1).setImageResource(imgsInPlay.get(1));
                    imageViewsToCheck.add(1);
                    numOfFlips += 1;
                    if (numOfFlips == 2)
                    {
                        handler.postDelayed(
                                new Runnable()
                                {
                                    @Override
                                    public void run()
                                    {
                                        CheckMatch();
                                    }
                                }, 1000); // 1000 milliseconds for 1-second delay
                    }
                    break;
                case R.id.card1c:
                    imageViewList.get(2).setImageResource(imgsInPlay.get(2));
                    imageViewsToCheck.add(2);
                    numOfFlips += 1;
                    if (numOfFlips == 2)
                    {
                        handler.postDelayed(
                                new Runnable()
                                {
                                    @Override
                                    public void run()
                                    {
                                        CheckMatch();
                                    }
                                }, 1000); // 1000 milliseconds for 1-second delay
                    }
                    break;
                case R.id.card1d:
                    imageViewList.get(3).setImageResource(imgsInPlay.get(3));
                    imageViewsToCheck.add(3);
                    numOfFlips += 1;
                    if (numOfFlips == 2)
                    {
                        handler.postDelayed(
                                new Runnable()
                                {
                                    @Override
                                    public void run()
                                    {
                                        CheckMatch();
                                    }
                                }, 1000); // 1000 milliseconds for 1-second delay
                    }
                    break;
                case R.id.card1e:
                    imageViewList.get(4).setImageResource(imgsInPlay.get(4));
                    imageViewsToCheck.add(4);
                    numOfFlips += 1;
                    if (numOfFlips == 2)
                    {
                        handler.postDelayed(
                                new Runnable()
                                {
                                    @Override
                                    public void run()
                                    {
                                        CheckMatch();
                                    }
                                }, 1000); // 1000 milliseconds for 1-second delay
                    }
                    break;
                case R.id.card2a:
                    imageViewList.get(5).setImageResource(imgsInPlay.get(5));
                    imageViewsToCheck.add(5);
                    numOfFlips += 1;
                    if (numOfFlips == 2)
                    {
                        handler.postDelayed(
                                new Runnable()
                                {
                                    @Override
                                    public void run()
                                    {
                                        CheckMatch();
                                    }
                                }, 1000); // 1000 milliseconds for 1-second delay
                    }
                    break;
                case R.id.card2b:
                    imageViewList.get(6).setImageResource(imgsInPlay.get(6));
                    imageViewsToCheck.add(6);
                    numOfFlips += 1;
                    if (numOfFlips == 2)
                    {
                        handler.postDelayed(
                                new Runnable()
                                {
                                    @Override
                                    public void run()
                                    {
                                        CheckMatch();
                                    }
                                }, 1000); // 1000 milliseconds for 1-second delay
                    }
                    break;
                case R.id.card2c:
                    imageViewList.get(7).setImageResource(imgsInPlay.get(7));
                    imageViewsToCheck.add(7);
                    numOfFlips += 1;
                    if (numOfFlips == 2)
                    {
                        handler.postDelayed(
                                new Runnable()
                                {
                                    @Override
                                    public void run()
                                    {
                                        CheckMatch();
                                    }
                                }, 1000); // 1000 milliseconds for 1-second delay
                    }
                    break;
                case R.id.card2d:
                    imageViewList.get(8).setImageResource(imgsInPlay.get(8));
                    imageViewsToCheck.add(8);
                    numOfFlips += 1;
                    if (numOfFlips == 2)
                    {
                        handler.postDelayed(
                                new Runnable()
                                {
                                    @Override
                                    public void run()
                                    {
                                        CheckMatch();
                                    }
                                }, 1000); // 1000 milliseconds for 1-second delay
                    }
                    break;
                case R.id.card2e:
                    imageViewList.get(9).setImageResource(imgsInPlay.get(9));
                    imageViewsToCheck.add(9);
                    numOfFlips += 1;
                    if (numOfFlips == 2)
                    {
                        handler.postDelayed(
                                new Runnable()
                                {
                                    @Override
                                    public void run()
                                    {
                                        CheckMatch();
                                    }
                                }, 1000); // 1000 milliseconds for 1-second delay
                    }
                    break;
                case R.id.card3a:
                    imageViewList.get(10).setImageResource(imgsInPlay.get(10));
                    imageViewsToCheck.add(10);
                    numOfFlips += 1;
                    if (numOfFlips == 2)
                    {
                        handler.postDelayed(
                                new Runnable()
                                {
                                    @Override
                                    public void run()
                                    {
                                        CheckMatch();
                                    }
                                }, 1000); // 1000 milliseconds for 1-second delay
                    }
                    break;
                case R.id.card3b:
                    imageViewList.get(11).setImageResource(imgsInPlay.get(11));
                    imageViewsToCheck.add(11);
                    numOfFlips += 1;
                    if (numOfFlips == 2)
                    {
                        handler.postDelayed(
                                new Runnable()
                                {
                                    @Override
                                    public void run()
                                    {
                                        CheckMatch();
                                    }
                                }, 1000); // 1000 milliseconds for 1-second delay
                    }
                    break;
                case R.id.card3c:
                    imageViewList.get(12).setImageResource(imgsInPlay.get(12));
                    imageViewsToCheck.add(12);
                    numOfFlips += 1;
                    if (numOfFlips == 2)
                    {
                        handler.postDelayed(
                                new Runnable()
                                {
                                    @Override
                                    public void run()
                                    {
                                        CheckMatch();
                                    }
                                }, 1000); // 1000 milliseconds for 1-second delay
                    }
                    break;
                case R.id.card3d:
                    imageViewList.get(13).setImageResource(imgsInPlay.get(13));
                    imageViewsToCheck.add(13);
                    numOfFlips += 1;
                    if (numOfFlips == 2)
                    {
                        handler.postDelayed(
                                new Runnable()
                                {
                                    @Override
                                    public void run()
                                    {
                                        CheckMatch();
                                    }
                                }, 1000); // 1000 milliseconds for 1-second delay
                    }
                    break;
                case R.id.card3e:
                    imageViewList.get(14).setImageResource(imgsInPlay.get(14));
                    imageViewsToCheck.add(14);
                    numOfFlips += 1;
                    if (numOfFlips == 2)
                    {
                        handler.postDelayed(
                                new Runnable()
                                {
                                    @Override
                                    public void run()
                                    {
                                        CheckMatch();
                                    }
                                }, 1000); // 1000 milliseconds for 1-second delay
                    }
                    break;
                case R.id.card4a:
                    imageViewList.get(15).setImageResource(imgsInPlay.get(15));
                    imageViewsToCheck.add(15);
                    numOfFlips += 1;
                    if (numOfFlips == 2)
                    {
                        handler.postDelayed(
                                new Runnable()
                                {
                                    @Override
                                    public void run()
                                    {
                                        CheckMatch();
                                    }
                                }, 1000); // 1000 milliseconds for 1-second delay
                    }
                    break;
                case R.id.card4b:
                    imageViewList.get(16).setImageResource(imgsInPlay.get(16));
                    imageViewsToCheck.add(16);
                    numOfFlips += 1;
                    if (numOfFlips == 2)
                    {
                        handler.postDelayed(
                                new Runnable()
                                {
                                    @Override
                                    public void run()
                                    {
                                        CheckMatch();
                                    }
                                }, 1000); // 1000 milliseconds for 1-second delay
                    }
                    break;
                case R.id.card4c:
                    imageViewList.get(17).setImageResource(imgsInPlay.get(17));
                    imageViewsToCheck.add(17);
                    numOfFlips += 1;
                    if (numOfFlips == 2)
                    {
                        handler.postDelayed(
                                new Runnable()
                                {
                                    @Override
                                    public void run()
                                    {
                                        CheckMatch();
                                    }
                                }, 1000); // 1000 milliseconds for 1-second delay
                    }
                    break;
                case R.id.card4d:
                    imageViewList.get(18).setImageResource(imgsInPlay.get(18));
                    imageViewsToCheck.add(18);
                    numOfFlips += 1;
                    if (numOfFlips == 2)
                    {
                        handler.postDelayed(
                                new Runnable()
                                {
                                    @Override
                                    public void run()
                                    {
                                        CheckMatch();
                                    }
                                }, 1000); // 1000 milliseconds for 1-second delay
                    }
                    break;
                case R.id.card4e:
                    imageViewList.get(19).setImageResource(imgsInPlay.get(19));
                    imageViewsToCheck.add(19);
                    numOfFlips += 1;
                    if (numOfFlips == 2)
                    {
                        handler.postDelayed(
                                new Runnable()
                                {
                                    @Override
                                    public void run()
                                    {
                                        CheckMatch();
                                    }
                                }, 1000); // 1000 milliseconds for 1-second delay
                    }
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

    private void CheckMatch() {

        if (imgsInPlay.get(imageViewsToCheck.get(0)).equals(imgsInPlay.get(imageViewsToCheck.get(1)))) {
            imageViewList.get(imageViewsToCheck.get(0)).setVisibility(View.INVISIBLE);
            imageViewList.get(imageViewsToCheck.get(1)).setVisibility(View.INVISIBLE);
            numScore += 10;
            score.setText("Score: " + numScore);
            numOfPairs += 1;
            CheckWin();
        }
        else {
            imageViewList.get(imageViewsToCheck.get(0)).setImageResource(R.drawable.back);
            imageViewList.get(imageViewsToCheck.get(1)).setImageResource(R.drawable.back);
        }

        imageViewsToCheck.clear();
        numOfFlips = 0;
    }

    private void CheckWin() {
        boolean gameOver = false;

        if (numOfPairs == 10) {
            gameOver = true;
        }
        else {
            gameOver = false;
        }

        if (gameOver == true) {
            AlertDialog();
        }
    }

    public void AlertDialog() {
        // Create the object of
        // AlertDialog Builder class
        AlertDialog.Builder builder
                = new AlertDialog
                .Builder(MainActivity.this);

        // Set the message show for the Alert time
        builder.setMessage("Do you want to exit ?");

        // Set Alert Title
        builder.setTitle("Alert !");

        // Set Cancelable false
        // for when the user clicks on the outside
        // the Dialog Box then it will remain show
        builder.setCancelable(false);

        // Set the positive button with yes name
        // OnClickListener method is use of
        // DialogInterface interface.

        builder
                .setPositiveButton(
                        "Yes",
                        new DialogInterface
                                .OnClickListener() {

                            @Override
                            public void onClick(DialogInterface dialog,
                                                int which)
                            {

                                // When the user click yes button
                                // then app will close
                                finish();
                            }
                        });

        // Set the Negative button with No name
        // OnClickListener method is use
        // of DialogInterface interface.
        builder
                .setNegativeButton(
                        "No",
                        new DialogInterface
                                .OnClickListener() {

                            @Override
                            public void onClick(DialogInterface dialog,
                                                int which)
                            {

                                // If user click no
                                // then dialog box is canceled.
                                dialog.cancel();
                            }
                        });

        // Create the Alert dialog
        AlertDialog alertDialog = builder.create();

        // Show the Alert Dialog box
        alertDialog.show();
    }
}
