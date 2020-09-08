package fr.ay.moviez;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MovieItemsViewHolder> {

    private Context mContext;
    private ArrayList<Movie> movieArrayList;

    public MovieAdapter(Context context, ArrayList<Movie> movieList) {

        mContext = context;
        movieArrayList = movieList;

    }

    @NonNull
    @Override
    public MovieItemsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(mContext).inflate(R.layout.movie_adapter, parent, false);
        return new MovieItemsViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieItemsViewHolder holder, int position) {
        Movie currentItem = movieArrayList.get(position);

        String imageUrl = currentItem.getPosterUrl();
        String movieTitle = currentItem.getMovieTitle();
        String movieDate = currentItem.getMovieDate();
        String movieSyn = currentItem.getMovieSyn();

        Picasso.get().load(imageUrl).fit().centerInside().into(holder.mImageView);
        holder.mTextViewTitle.setText(movieTitle);
        holder.mTextViewDate.setText(movieDate);
        holder.mTextViewSyn.setText(movieSyn);

    }

    @Override
    public int getItemCount() {
        return movieArrayList.size();
    }


    public class MovieItemsViewHolder extends RecyclerView.ViewHolder {

        public ImageView mImageView;
        public TextView mTextViewTitle;
        public TextView mTextViewDate;
        public TextView mTextViewSyn;




        public MovieItemsViewHolder(@NonNull View itemView) {
            super(itemView);

            mImageView = itemView.findViewById(R.id.poster);

            mTextViewTitle = itemView.findViewById(R.id.titleview);

            mTextViewDate = itemView.findViewById(R.id.dateview);

            mTextViewSyn = itemView.findViewById(R.id.synview);


        }
    }




}

