package com.example.myapplication.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.myapplication.models.Movie;
import com.example.myapplication.MovieAdapter;
import com.example.myapplication.MovieItemClickListener;
import com.example.myapplication.R;
import com.example.myapplication.models.Slide;
import com.example.myapplication.SliderPagerAdapter;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import utils.DataSource;

public class MainActivity extends AppCompatActivity implements MovieItemClickListener {

    private List<Slide> lstSlides;
    private ViewPager sliderpager;
    private TabLayout indicator;
    private RecyclerView MoviesRV, moviesRvWeek;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        iniViews();

        // Prepare a list of slides
        iniSlider();

        iniPopularMovies();

        iniWeekMovies();
    }

    private void iniWeekMovies(){
        MovieAdapter weekMovieAdapter=new MovieAdapter(this, DataSource.getWeekMovies(), this);
        moviesRvWeek.setAdapter(weekMovieAdapter);
        moviesRvWeek.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
    }

    private void iniPopularMovies() {
        //Recyclerview setup
        //ini Data
        MovieAdapter movieAdapter=new MovieAdapter(this, DataSource.getPopularMovies(), this);
        MoviesRV.setAdapter(movieAdapter);
        MoviesRV.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
    }

    private void iniSlider() {
        lstSlides= new ArrayList<>();
        lstSlides.add(new Slide(R.drawable.steve_jobs,"Slide Title \nmore text here"));
        lstSlides.add(new Slide(R.drawable.alan_turing,"Slide Title \nmore text here"));
        lstSlides.add(new Slide(R.drawable.harry,"Slide Title \nmore text here"));
        lstSlides.add(new Slide(R.drawable.cars,"Slide Title \nmore text here"));


        SliderPagerAdapter adapter = new SliderPagerAdapter(this,lstSlides);
        sliderpager.setAdapter(adapter);
        //set Timer
        Timer timer=new Timer();
        timer.scheduleAtFixedRate(new SliderTimer(), 2000, 3000);

        indicator.setupWithViewPager(sliderpager, true);

    }

    private void iniViews() {
        sliderpager=findViewById(R.id.slider_pager);
        indicator= findViewById(R.id.indicator);
        MoviesRV=findViewById(R.id.Rv_movies);
        moviesRvWeek=findViewById(R.id.rv_movies_week);
    }

    @Override
    public void onMovieClick(Movie movie, ImageView movieImageView) {
        // Here we send movie information to detail activity and create transition animation
        Intent intent = new Intent(this, MovieDetailActivity.class);
        // Send movie information to detail activity
        intent.putExtra("title", movie.getTitle());
        intent.putExtra("imgURL",movie.getThumbnail());
        intent.putExtra("imgCover",movie.getCoverPhoto());

        // Create animation
        ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(MainActivity.this,
                movieImageView,"sharedName");
        startActivity(intent, options.toBundle());
        //Test
        Toast.makeText(this, "item clicked : " + movie.getTitle(), Toast.LENGTH_LONG).show();
    }




    class SliderTimer extends TimerTask{
        @Override
        public void run() {
            MainActivity.this.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    if (sliderpager.getCurrentItem()<lstSlides.size()-1){
                        sliderpager.setCurrentItem(sliderpager.getCurrentItem()+1);
                    }
                    else
                        sliderpager.setCurrentItem(0);
                }
            });
        }
    }
}