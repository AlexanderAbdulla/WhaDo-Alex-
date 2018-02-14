package com.example.steve.wahdo2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Random;

/** main does main stuff*/
public class MainActivity extends AppCompatActivity {
    // the viwer that makes all the stuff pretty
    private RecyclerView mRecyclerView;
    // the adapter that handles putting the data in the viwer
    private ExampleAdapter mExampleAdapter;
    // the array list that holds data "items"
    private ArrayList<Items> mExampleList;
    // i have no idea
    private RequestQueue mRequestQueue;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // grabbing the recycler viewer
        mRecyclerView = findViewById(R.id.recycler_view);
       // fixing its size
        mRecyclerView.setHasFixedSize(true);
        // setting the size to linear, one on top of the other
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        // making an array list to hold the dat aitems
        mExampleList = new ArrayList<>();
        // requests the jason data?
        mRequestQueue = Volley.newRequestQueue(this);
        parseJSON();


    }

    /** Randomly sends us to one of the data items in a new intent */
    public void randomClick(View v) {

        Random rnd = new Random();
        int randomInt = rnd.nextInt(20);

        Intent i = new Intent(this, SecondActivity.class);
        Bundle b = new Bundle();
        String creatorText = mExampleList.get(randomInt).getCreator();
        String viewLikes = " There are: "  + mExampleList.get(randomInt).getLikeCount() + " likes.";
        String URL = mExampleList.get(randomInt).getImageUrl();
        b.putString("creatorText", creatorText);
        b.putString("viewLikes", viewLikes);
        b.putString("URL",  URL);
        i.putExtras(b);
        this.startActivity(i);

    }


    private void parseJSON() {
        String url = "https://pixabay.com/api/?key=5303976-fd6581ad4ac165d1b75cc15b3&q=national_parks&image_type=photo&pretty=true";

        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            JSONArray jsonArray = response.getJSONArray("hits");

                            for (int i = 0; i < jsonArray.length(); i++) {
                                JSONObject hit = jsonArray.getJSONObject(i);

                                String creatorName = hit.getString("user");
                                String imageUrl = hit.getString("webformatURL");
                               int likeCount = hit.getInt("likes");

                                mExampleList.add(new Items(imageUrl, creatorName, likeCount));
                            }

                            mExampleAdapter = new ExampleAdapter(MainActivity.this, mExampleList);
                            mRecyclerView.setAdapter(mExampleAdapter);

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });

        mRequestQueue.add(request);
    }
}
