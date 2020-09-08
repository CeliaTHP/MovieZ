package fr.ay.moviez;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MovieService extends AppCompatActivity {

        private MovieAdapter movieAdapter;

        RequestQueue mRequestQueue;



    //REQUEST
    public void GetTrends(ArrayList<Movie> movieList){



        String urlTrends = "https://api.themoviedb.org/3/trending/all/day?api_key=e4a9d54204f8ee1d8121e867e9a8a5a5";


         JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, urlTrends, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {

                        ArrayList<Movie> movieList = null;
                        try {

                            JSONArray jsonArray = response.getJSONArray("results");

                            for(int i = 0; i < jsonArray.length(); i++) {

                                JSONObject res = jsonArray.getJSONObject(i);

                                movieList.add(new Movie(res));

                            }

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