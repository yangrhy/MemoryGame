package com.example.quizgame;

import android.content.Intent;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
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

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "Memory Game Activity";
    private TextView score, time;
    private Button reset;
    private ButtonClickListener bttnClick;
    private List<String> animalPathList; // list of all animal image paths
    private List<Drawable> animalPics; // list of animal images
    private int[] randArray = new int[10]; // array of int
    private int numOfFlips = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        animalPathList = new ArrayList<String>();
        animalPics = new ArrayList<Drawable>(); // list of animal images
        score = (TextView)findViewById(R.id.scoreText);
        time = (TextView)findViewById(R.id.timeText);
        bttnClick = new ButtonClickListener();

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
        AssetManager assets = getAssets();
        List<String> imgsInPlay = new ArrayList<String>();
        try {
            String[] images = assets.list("");
            for (String path: images) {
                animalPathList.add(path);
            }
        }
        catch (IOException e) {
            Log.e(TAG, "Error loading image file names", e);
        }

        // shuffle animalPathList to get different images each game
        Collections.shuffle(animalPathList);

        int i = 0;
        // There are 20 cards, so add the same image twice into list so there is a pair
        while (i < 10) {
            for (String path: animalPathList) {
                imgsInPlay.add(path);
                imgsInPlay.add(path);
                i++;
            }
        }

        // shuffle images in play
        Collections.shuffle(imgsInPlay);

        for (String path:imgsInPlay)
        {
            animalPics.add(Drawable.createFromPath(path));
        }
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
                    flippedCard.setImageDrawable(animalPics.get(0));
                case R.id.card1b:
                case R.id.card1c:
                case R.id.card1d:
                case R.id.card1e:
                case R.id.card2a:
                case R.id.card2b:
                case R.id.card2c:
                case R.id.card2d:
                case R.id.card2e:
                case R.id.card3a:
                case R.id.card3b:
                case R.id.card3c:
                case R.id.card3d:
                case R.id.card3e:
                case R.id.card4a:
                case R.id.card4b:
                case R.id.card4c:
                case R.id.card4d:
                case R.id.card4e:
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

    // when clicked show card in array according to position

}
