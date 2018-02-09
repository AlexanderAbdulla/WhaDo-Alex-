package com.example.steve.wahdo2;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by steve on 2/4/2018.
 */

public class ExampleAdapter extends RecyclerView.Adapter<ExampleAdapter.ExampleViewHolder> {
    private Context mContext;
    private ArrayList<Items> mExampleList;

    public ExampleAdapter(Context context, ArrayList<Items> exampleList) {
        mContext = context;
        mExampleList = exampleList;
    }



    @Override
    public ExampleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(mContext).inflate(R.layout.layout_item, parent, false);
        return new ExampleViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ExampleViewHolder holder, int position) {
        Items currentItem = mExampleList.get(position);

        String imageUrl = currentItem.getImageUrl();
        String creatorName = currentItem.getCreator();
        int likeCount = currentItem.getLikeCount();

        holder.mTextViewCreator.setText(creatorName);
        holder.mTextViewLikes.setText("Like: " + likeCount);
        Picasso.with(mContext).load(imageUrl).fit().centerInside().into(holder.mImageView);
    }

    @Override
    public int getItemCount() {
        return mExampleList.size();
    }

    public class ExampleViewHolder extends RecyclerView.ViewHolder {
        public ImageView mImageView;
        public TextView mTextViewCreator;
        public TextView mTextViewLikes;



        //mImageView.OnTouchListener

        @SuppressLint("ClickableViewAccessibility")
        public ExampleViewHolder(View itemView) {
            super(itemView);
            mImageView = itemView.findViewById(R.id.image_view);

            mTextViewCreator = itemView.findViewById(R.id.text_view_creator);
            mTextViewLikes = itemView.findViewById(R.id.text_view_likes);

            mImageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(mContext, "clicked on " + mTextViewCreator + " ", Toast.LENGTH_LONG).show();
                    Intent i = new Intent(mContext, SecondActivity.class);
                    mContext.startActivity(i);

                }
            });


            /*
            mImageView.setonClickListener(new View.OnClickListener() {
                @Override
                public boolean onClick(View view, MotionEvent motionEvent) {
                    Toast.makeText(mContext, "clicked on " + mTextViewCreator + " ", Toast.LENGTH_LONG).show();
                    Intent i = new Intent(mContext, SecondActivity.class);
                    mContext.startActivity(i);
                    return true;

                }
            });
            */

        }
    }
}
