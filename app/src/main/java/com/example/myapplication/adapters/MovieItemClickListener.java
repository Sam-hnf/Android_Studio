package com.example.myapplication.adapters;

import android.widget.ImageView;

import com.example.myapplication.models.Movie;

public interface MovieItemClickListener {

    void onMovieClick(Movie movie, ImageView movieImageView); //We'll need the image view to make the shared animation between activities


}
