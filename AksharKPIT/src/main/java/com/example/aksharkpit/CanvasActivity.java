package com.example.aksharkpit;

import android.app.Activity;
import android.gesture.GestureLibrary;
import android.gesture.GestureOverlayView;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.kpit.aksharkpit.R;

//java class related to canvas layout 
public class CanvasActivity extends Activity {

    //variable declarations
    private GestureLibrary gLib;
    String value;
    FrameLayout activity;
    TextView tv;
    Button btn, btn2, btn3;
    GestureOverlayView gestures;
    int temp;
    MediaPlayer mp = new MediaPlayer();
    int id;
    String alphabet="";
/*
    static final Integer[] resIds = {R.raw.a, R.raw.aa, R.raw.e, R.raw.ee, R.raw.u, R.raw.uu};
    static final String[] words = {"अननस", "आई", "इमारत", "ईद","उखळ","ऊर्ध्व "};
    static final Integer[] imageIds = {R.drawable.a, R.drawable.aa, R.drawable.e, R.drawable.ee, R.drawable.u, R.drawable.uu};
*/

//    Marathi alphabet
/*
    static final String[] alphabets = {"l1","l2","l3","l4","l5","l6","l7","l8","l9","l10","l11","l12","l13","l14","l15","l16","l17","l18","l19","l20","l21","l22","l23","l24","l25","l26","l27","l28","l29","l30","l31","l32","l33","l34"};
    static final String[] words = {"कमळ", "खडू", "गणपती", "घर","चमचा","छत्री","जहाज","झगा","टरबूज","ठसा","डबा","ढग","बाण","तलवार","थडगे","दऊत","धनुष्य","नळ","पतंग","फणस","बदक","भटजी","मका","यज्ञ","रथ","लसूण","वजन","शहामृग","षट्कोन","ससा","हरीण","कमळ","क्षत्रिय","ज्ञानदेव"};
*/

//  Hemalkasa alphabet

    static final String[] alphabets = {"m1","m2","m3","m4","m5","m6","m7","m9","m11","l1","l3","s1","l5","l7","l9","l11","l14","l16","l18","l19","l21","l23","l24","l25","l26","l27","l30","l31","s2","l32"};
    static final String[] pics = {"pm1","pm2","pm3","pm4","pm5","pm6","pm7","pm9","pm11","pl1","pl3","ps1","pl5","pl7","pl9","pl11","pl14","pl16","pl18","pl19","pl21","pl23","pl24","pl25","pl26","pl27","pl30","pl31","ps2","pl32"};
    static final String[] words = {"अनम","आपा","इल्‌वि","ईचळ मीन","उलि","ऊज","एर्‌रे","ओडा","अंज","कय","गब्‌ले","मोलाङ","चहा","जगा","टडो","डाक्‌टर","तला","दळिया","नय","पल्‌क","बरे","मरा","यायाल","रय्‌के","लसुस्‌क","वग़्‌किङ","सगम","हामुर","नेग़ल","ताळ"};

//  static final Integer[] resIds = {R.raw.a, R.raw.aa, R.raw.e, R.raw.ee, R.raw.u, R.raw.uu}
//  static final Integer[] imageIds = {R.drawable.a, R.drawable.aa, R.drawable.e, R.drawable.ee, R.drawable.u, R.drawable.uu};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.canvas);


        //get parameter via intent
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            value = extras.getString("clickId");
        }

        temp = Integer.parseInt(value);

        temp = temp + 1;

        //referencing variables to xml layout file
        activity = (FrameLayout) findViewById(R.id.Frame2);
        tv = (TextView) findViewById(R.id.textView1);
        btn = (Button) findViewById(R.id.button1);
        btn2 = (Button) findViewById(R.id.button2);
        btn3 = (Button) findViewById(R.id.button3);

        gestures = (GestureOverlayView) findViewById(R.id.gestureOverlayView1);
        activity.setAlpha((float) 0.2);

        //applying opacity to layout
        activity.setAlpha((float) 0.2);


        btn.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub
                gestureClear();
            }
        });

        btn2.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                gestureClear();

                if (temp < alphabets.length) {
                    ++temp;
                } else {
                    //Toast.makeText(CanvasActivity.this, "You are already at the last position.", Toast.LENGTH_SHORT).show();
                    temp=1;
                }
                changeAlphabet(temp);
            }
        });

        btn3.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                gestureClear();

                if (temp > 1) {
                    --temp;
                } else {
                    //Toast.makeText(CanvasActivity.this, "You are already at the first position.", Toast.LENGTH_SHORT).show();
                    temp=alphabets.length;
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
    public void playAudio(View view) {

        try {
            MediaPlayer mPlayer2 = null;
            mPlayer2 = MediaPlayer.create(this, getResources().getIdentifier("raw/" + getAlphabet(), null, this.getPackageName()));
            mPlayer2.start();
        }catch (Exception re){
            Toast.makeText(CanvasActivity.this, "Can not play this sound.", Toast.LENGTH_SHORT).show();
        }


    }


    public void changeAlphabet(int k) {
        int res = getResources().getIdentifier("drawable/"+alphabets[k - 1], null, this.getPackageName());
        activity.setBackground(getResources().getDrawable(res));
        tv.setText(words[k - 1]);
        ImageView imageView = (ImageView) findViewById(R.id.imageView3);
        imageView.setImageResource(getResources().getIdentifier("drawable/" + pics[k-1], null, this.getPackageName()));
        setAlphabet(alphabets[k-1]);
    }

    public String getAlphabet() {
        return alphabet;
    }

    public void setAlphabet(String alphabet) {
        this.alphabet = alphabet;
    }
}
