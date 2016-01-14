package com.kpit.csr.akshar.adapter;

import android.app.Activity;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.kpit.csr.akshar.R;


//java class for custom layout
public class CustomList extends ArrayAdapter<String>{

    //variable declaration
    private final Activity context;
    private final String[] web;
    private final String[] alphabets;
    public String[] getAlphabets() {
        return alphabets;
    }
    private final String[] pics;
    public String[] getPics() {
        return pics;
    }
    public CustomList(Activity context,String[] web, String[] alphabets, String[] pics) {

        super(context, R.layout.custom_list, web);
        this.context = context;
        this.web = web;
        this.alphabets = alphabets;
        this.pics=pics;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {

        LayoutInflater inflater = context.getLayoutInflater();
        View rowView= inflater.inflate(R.layout.custom_list, null, true);
        TextView txtTitle = (TextView) rowView.findViewById(R.id.txtlabel);
        ImageView imageView = (ImageView) rowView.findViewById(R.id.imgaplha);
        ImageView imageView1 = (ImageView) rowView.findViewById(R.id.imgasset);
        txtTitle.setText(web[position]);
        //imageView.setImageResource(context.getResources().getIdentifier("drawable/"+CanvasActivity.alphabets[position], null, context.getPackageName()));

        imageView.setImageResource(context.getResources().getIdentifier("drawable/"+alphabets[position], null, context.getPackageName()));
        imageView1.setImageResource(context.getResources().getIdentifier("drawable/"+pics[position], null, context.getPackageName()));
        return rowView;
    }
}