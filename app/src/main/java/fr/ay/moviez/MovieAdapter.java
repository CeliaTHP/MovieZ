package fr.ay.moviez;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import org.w3c.dom.Text;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.ViewHolder> {


    private Context mContext;
    private ArrayList<Movie> mMovieList;
    private List<Movie> movies;

    void addMovies(List movies) {
        this.movies = movies;
        notifyDataSetChanged();
    }

    LayoutInflater inflater;

    public MovieAdapter(Context context, ArrayList<Movie> movieList) {

        mContext = context;
        mMovieList = movieList;

        this.inflater = LayoutInflater.from(context);





        //this.movies = movies;
    }



    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = inflater.inflate(R.layout.movie_adapter,parent,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        Movie currentItem = mMovieList.get(position);

        String imageUrl = currentItem.getImageUrl();
        String movieTitle = currentItem.getTitle();
        String movieDate = currentItem.getDate();
        String movieSyn = currentItem.getSyn();


        holder.movieTitle.setText(movieTitle);
        holder.movieDate.setText(movieDate);
        holder.movieSyn.setText(movieSyn);
        Picasso.get().load(imageUrl).fit().centerInside().into(holder.moviePoster);

    }

    @Override
    public int getItemCount() {
        return mMovieList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        public ImageView moviePoster;
        public TextView movieTitle;
        public TextView movieDate;
        public TextView movieSyn;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            movieTitle = itemView.findViewById(R.id.titleview);
            movieDate = itemView.findViewById(R.id.dateview);
            movieSyn = itemView.findViewById(R.id.synview);
            moviePoster = itemView.findViewById(R.id.poster);
        }

    }
}