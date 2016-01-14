package com.kpit.csr.akshar.activity;


import android.gesture.GestureLibrary;
import android.gesture.GestureOverlayView;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.kpit.csr.akshar.R;


//java class related to canvas layout
@SuppressWarnings("ALL")
public class CanvasActivity extends AppCompatActivity {

    //variable declarations
    private GestureLibrary gLib;
    String value;
    FrameLayout activity;
    TextView tv;
    ImageButton btn, btn2, btn3;
    GestureOverlayView gestures;
    int temp;
    MediaPlayer mp = new MediaPlayer();
    //int id;
    String alphabet = "";

    static final String[] alphabets = {"m1", "m2", "m3", "m4", "m5", "m6", "m7", "m9", "m11", "l1", "l3", "s1", "l5", "l7", "l9", "l11", "l14", "l16", "l18", "l19", "l21", "l23", "l24", "l25", "l26", "l27", "l30", "l31", "s2", "l32"};
    static final String[] pics = {"pm1", "pm2", "pm3", "pm4", "pm5", "pm6", "pm7", "pm9", "pm11", "pl1", "pl3", "ps1", "pl5", "pl7", "pl9", "pl11", "pl14", "pl16", "pl18", "pl19", "pl21", "pl23", "pl24", "pl25", "pl26", "pl27", "pl30", "pl31", "ps2", "pl32"};
    static final String[] words = {"अनम", "आपा", "इल्‌वि", "ईचळ मीन", "उलि", "ऊज", "एर्‌रे", "ओडा", "अंज", "कय", "गब्‌ले", "मोलाङ", "चहा", "जगा", "टडो", "डाक्‌टर", "तला", "दळिया", "नय", "पल्‌क", "बरे", "मरा", "यायाल", "रय्‌के", "लसुस्‌क", "वग़्‌किङ", "सगम", "हामुर", "नेग़ल", "ताळ"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.canvas);

        //enable back button on action bar
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        //get parameter via intent
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            value = extras.getString("clickId");
        }

        //referencing variables to xml layout file
        activity = (FrameLayout) findViewById(R.id.Frame2);
        tv = (TextView) findViewById(R.id.textView1);
        btn = (ImageButton) findViewById(R.id.button3);
        btn2 = (ImageButton) findViewById(R.id.button2);
        btn3 = (ImageButton) findViewById(R.id.button1);
        gestures = (GestureOverlayView) findViewById(R.id.gestureOverlayView1);

        //Toast.makeText(CanvasActivity.this, value, Toast.LENGTH_SHORT).show();

        temp = Integer.parseInt(value);

        temp = temp + 1;


        //applying opacity to layout
        activity.setAlpha((float) 0.2);


        btn.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View arg0) {

                gestureClear();
            }
        });

        btn2.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {

                gestureClear();

                if (temp < alphabets.length) {
                    ++temp;
                } else {
                    //Toast.makeText(CanvasActivity.this, "You are already at the last position.", Toast.LENGTH_SHORT).show();
                    temp = 1;
                }
                changeAlphabet(temp);
            }
        });

        btn3.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {

                gestureClear();

                if (temp > 1) {
                    --temp;
                } else {
                    temp = alphabets.length;
                }
                changeAlphabet(temp);
            }
        });
        changeAlphabet(temp);
    }

    //function for clearing the drawn gesture
    public void gestureClear() {
        gestures.cancelClearAnimation();
        gestures.clear(true);
    }

    //function to play audio file
    public void playAudio() {

        try {
            MediaPlayer mPlayer2 = null;
            mPlayer2 = MediaPlayer.create(this, getResources().getIdentifier("raw/" + getAlphabet(), null, this.getPackageName()));
            mPlayer2.start();
        } catch (Exception re) {
            Toast.makeText(CanvasActivity.this, "Can not play this sound.", Toast.LENGTH_SHORT).show();
        }
    }

    public void changeAlphabet(int k) {
        int res = getResources().getIdentifier("drawable/" + alphabets[k - 1], null, this.getPackageName());
        activity.setBackground(getResources().getDrawable(res));
        tv.setText(words[k - 1]);
        ImageView imageView = (ImageView) findViewById(R.id.imageView3);
        imageView.setImageResource(getResources().getIdentifier("drawable/" + pics[k - 1], null, this.getPackageName()));
        setAlphabet(alphabets[k - 1]);
    }

    public String getAlphabet() {
        return alphabet;
    }

    public void setAlphabet(String alphabet) {
        this.alphabet = alphabet;
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item
                .getMenuInfo();

        switch (item.getItemId()) {

            case android.R.id.home:
                onBackPressed();
                break;
            case R.id.playaudio:
                playAudio();
                break;

            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.in_left_animation,
                R.anim.out_right_animation);

    }
}
