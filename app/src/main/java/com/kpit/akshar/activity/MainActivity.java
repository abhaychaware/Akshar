package com.kpit.akshar.activity;

import android.content.Intent;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.kpit.akshar.R;
import com.kpit.akshar.adapter.CustomList;

//java class for activity_main layout file used for generating the list view
public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    //variable declaration
    ListView listView;
    Button btn;


    private static final int TIME_INTERVAL = 2000;
    private long mBackPressed;

    //Hemalkasa alphabet arrays
    static final String[] alphabets = {"m1", "m2", "m3", "m4", "m5", "m6", "m7", "m9", "m11", "l1", "l3", "s1", "l5", "l7", "l9", "l11", "l14", "l16", "l18", "l19", "l21", "l23", "l24", "l25", "l26", "l27", "l30", "l31", "s2", "l32"};
    static final String[] pics = {"pm1", "pm2", "pm3", "pm4", "pm5", "pm6", "pm7", "pm9", "pm11", "pl1", "pl3", "ps1", "pl5", "pl7", "pl9", "pl11", "pl14", "pl16", "pl18", "pl19", "pl21", "pl23", "pl24", "pl25", "pl26", "pl27", "pl30", "pl31", "ps2", "pl32"};
    static final String[] words = {"अनम", "आपा", "इल्‌वि", "ईचळ मीन", "उलि", "ऊज", "एर्‌रे", "ओडा", "अंज", "कय", "गब्‌ले", "मोलाङ", "चहा", "जगा", "टडो", "डाक्‌टर", "तला", "दळिया", "नय", "पल्‌क", "बरे", "मरा", "यायाल", "रय्‌के", "लसुस्‌क", "वग़्‌किङ", "सगम", "हामुर", "नेग़ल", "ताळ"};

    //custom list adapter
    CustomList adapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //setting custom layout
        listView = (ListView) findViewById(R.id.listView1);

        //populate list
        loadList();

        //setting on click listener to list view activity
        listView.setOnItemClickListener(this);

    }

    //list population
    private void loadList(){

        //set custom adapter
        adapter = new CustomList(MainActivity.this, words, alphabets, pics);
        //set adapter to listview
        listView.setAdapter(adapter);

    }

    @Override
    public void onItemClick(AdapterView<?> adapter, View view,
                            int position, long id) {

        //passing parameter via intent to another activity

        String str = String.valueOf(position);

        Intent i = new Intent(MainActivity.this,
                CanvasActivity.class);
        Bundle bundle = ActivityOptionsCompat.makeCustomAnimation(
                MainActivity.this, R.anim.in_right_animation,
                R.anim.out_left_animation).toBundle();
        i.putExtra("clickId", str);
        ActivityCompat.startActivity(MainActivity.this, i, bundle);

    }




  // function to detect back button pressed event
    @Override
    public void onBackPressed() {
        if (mBackPressed + TIME_INTERVAL > System.currentTimeMillis()) {
            super.onBackPressed();
            Toast.makeText(getBaseContext(), "धन्यवाद !!!",
                    Toast.LENGTH_SHORT).show();
            return;
        } else {

        }

        mBackPressed = System.currentTimeMillis();
    }
}