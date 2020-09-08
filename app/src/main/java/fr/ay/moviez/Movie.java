package fr.ay.moviez;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;

import com.android.volley.Cache;
import com.android.volley.Network;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.BasicNetwork;
import com.android.volley.toolbox.DiskBasedCache;
import com.android.volley.toolbox.HurlStack;

import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Movie extends AppCompatActivity {

    private String mImageUrl = " ";
    private String mTitle = " ";
    private String mDate = " ";
    private String mSyn = " ";


    public Movie(JSONObject Object) {







        try {
            this.mImageUrl = "http://image.tmdb.org/t/p/w92" + Object.getString("poster_path");
            this.mTitle = Object.getString("title");
            this.mDate = Object.getString("release_date");
            this.mSyn = Object.getString("overview");

        } catch (JSONException e) {
            e.printStackTrace();
        }


    }





    public String getPosterUrl() { return mImageUrl ; }

    public String getMovieTitle() { return mTitle ; }

    public String getMovieDate() { return mDate; }

    public String getMovieSyn() { return mSyn ; }





}