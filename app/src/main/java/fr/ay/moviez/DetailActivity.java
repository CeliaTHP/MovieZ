package fr.ay.moviez;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Text;

public class DetailActivity extends AppCompatActivity {

    ImageView movieImage;
    TextView movieTitle;
    TextView movieDate;
    TextView movieSyn;
    TextView movieID;


    ;
    private static String baseurl = "http://image.tmdb.org/t/p/w92";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);


        movieID = findViewById(R.id.id_detail);
        Intent details = getIntent();
        String id = details.getStringExtra("id");
        movieID.setText(id);

        getDetails();
    }

    //getDetails();

    private void getDetails() {
        RequestQueue queue = Volley.newRequestQueue(this);

        movieID = findViewById(R.id.id_detail);
        Intent details = getIntent();
        String id = details.getStringExtra("id");
        movieID.setText(id);

        String findUrl = "https://api.themoviedb.org/3/movie/ " + id + "?api_key=e4a9d54204f8ee1d8121e867e9a8a5a5";

        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, findUrl, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                for (int i = 0; i < response.length(); i++) {
                    try {

                        String title  = response.getString("title");
                        TextView dtitle = findViewById(R.id.title_detail);
                        dtitle.setText(title);


                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();

            }
        });

        queue.add(request);
    }
}


