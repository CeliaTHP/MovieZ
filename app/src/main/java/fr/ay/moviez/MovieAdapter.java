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

    LayoutInflater inflater;
    List <Movie> movieList;



    public MovieAdapter(Context context, List<Movie> movieList) {

       this.inflater = LayoutInflater.from(context);
       this.movieList = movieList;

    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = inflater.inflate(R.layout.movie_adapter,parent,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {


        holder.movieTitle.setText(movieList.get(position).getTitle());
        holder.movieDate.setText(movieList.get(position).getDate());
        holder.movieSyn.setText(movieList.get(position).getSyn());
        Picasso.get().load(movieList.get(position).getImageUrl()).into(holder.moviePoster);

    }

    @Override
    public int getItemCount() {
        return movieList.size();
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