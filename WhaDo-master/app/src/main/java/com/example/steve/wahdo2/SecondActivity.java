package com.example.steve.wahdo2;

import android.graphics.Bitmap;
import android.media.Image;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

public class SecondActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        //Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);

        Bundle theBundle = getIntent().getExtras();
        String testString = theBundle.getString("creatorText");
        String testString2 = theBundle.getString("viewLikes");
        String imgURL = theBundle.getString("URL");

        ImageView x = (ImageView) findViewById(R.id.img);
        //Picasso.with(mContext).load(imageUrl).fit().centerInside().into(holder.mImageView);

        Picasso.with(this).load(imgURL).fit().centerInside().into(x);

        TextView y = (TextView) findViewById(R.id.txt);

        y.setText(testString + " \n" + testString2);

        // Bitmap bmp = theBundle.getParcelable("bitmap");



//        Toast.makeText(this, "USER : " + testString + " LIKES:  " + testString2,Toast.LENGTH_LONG).show();
  //      Toast.makeText(this, testString2,Toast.LENGTH_LONG).show();


        /*FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/
    }

}
