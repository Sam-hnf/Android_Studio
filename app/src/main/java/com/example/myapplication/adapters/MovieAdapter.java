package com.example.myapplication.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;
import com.example.myapplication.models.Movie;

import java.util.List;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MyViewHolder> {

    Context context;
    List<Movie>mdata;
    MovieItemClickListener movieItemClickListener;

    public MovieAdapter(Context context, List<Movie> mdata, MovieItemClickListener listener) {
        this.context = context;
        this.mdata = mdata;
        movieItemClickListener = listener;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view = LayoutInflater.from(context).inflate(R.layout.item_movie,viewGroup,false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {

        myViewHolder.TvTitle.setText(mdata.get(i).getTitle());
        myViewHolder.ImgMovie.setImageResource(mdata.get(i).getThumbnail());
    }

    @Override
    public int getItemCount() {
        return mdata.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        private TextView TvTitle;
        private ImageView ImgMovie;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            TvTitle=itemView.findViewById(R.id.item_movie_title);
            ImgMovie=itemView.findViewById(R.id.item_movie_img);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    movieItemClickListener.onMovieClick(mdata.get(getAdapterPosition()), ImgMovie);
                }
            });
        }
    }
}
