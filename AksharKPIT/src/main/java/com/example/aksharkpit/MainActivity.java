package com.example.aksharkpit;


import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;

import com.kpit.aksharkpit.R;

//java class for activity_main layout file used for generating the list view
public class MainActivity extends Activity implements OnItemClickListener {

    //variable declaration
    ListView listView;
    Button btn;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //setting custom layout 
        CustomList adapter = new CustomList(MainActivity.this, CanvasActivity.words, CanvasActivity.alphabets,CanvasActivity.pics);
        listView = (ListView) findViewById(R.id.listView1);
        listView.setAdapter(adapter);
/*
        btn = (Button) findViewById(R.id.button1);
        btn.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub
                startActivity(new Intent(getApplicationContext(), GestureBuilderActivity.class));
            }
        });
        */
        //setting on click listener to list view activity
        listView.setOnItemClickListener(this);

    }

    @Override
    public void onItemClick(AdapterView<?> adapter, View view,
                            int position, long id) {

        //passing parameter via intent to another activity
        int temp = position;
        String str = String.valueOf(position);
        Intent i = new Intent(MainActivity.this, CanvasActivity.class);
        i.putExtra("clickId", str);
        startActivity(i);


    }


}
