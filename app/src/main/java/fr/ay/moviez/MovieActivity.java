package fr.ay.moviez;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class MovieActivity extends AppCompatActivity {

private RecyclerView recyclerView;
private MovieAdapter adapter;
private ArrayList<Movie> movieList;
private RequestQueue mRequestQueue;
private String baseurl = "http://image.tmdb.org/t/p/w92";

//private static String URL = "https://api.themoviedb.org/3/trending/all/day?api_key=e4a9d54204f8ee1d8121e867e9a8a5a5";
//private MovieAdapter adapter ;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);

        recyclerView = findViewById(R.id.list_recycler_view_movie);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        movieList = new ArrayList<>();
        mRequestQueue = Volley.newRequestQueue(this);

        getTrends();
        adapter.addMovies(movieList);




    }


    private void getTrends() {

        String url = "https://api.themoviedb.org/3/trending/all/day?api_key=e4a9d54204f8ee1d8121e867e9a8a5a5";

        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET,url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        JSONArray jsonArray = null;
                        try {
                            jsonArray = response.getJSONArray("results");
                        for (int i = 0; i < jsonArray.length(); i++) {

                            JSONObject res = jsonArray.getJSONObject(i);

                            String movieTitle = res.getString("title");
                            String moviePoster = baseurl + res.getString("poster_path");
                            String movieDate = res.getString("release_date");
                            String movieSyn = res.getString("overview");


                            movieList.add(new Movie(moviePoster, movieTitle, movieDate, movieSyn));
                        }
                        adapter = new MovieAdapter(MovieActivity.this, movieList);
                        //adapter.addMovies(movieList);
                            recyclerView.setAdapter(adapter);

                               /* movie.setImageUrl("http://image.tmdb.org/t/p/w92" + res.getString("poster_path"));
                                movie.setTitle(res.getString("title"));
                                movie.setDate(res.getString("release_date"));
                                movie.setSyn(res.getString("overview"));/

                                movies.add(movie);*/
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