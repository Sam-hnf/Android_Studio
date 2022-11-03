package com.example.myapplication.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.myapplication.R;
import com.example.myapplication.adapters.CastAdapter;
import com.example.myapplication.models.Cast;
import com.example.myapplication.models.Movie;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class MovieDetailActivity extends AppCompatActivity implements View.OnClickListener{

    private ImageView MovieThumbnailImg, MovieCoverImg;
    private TextView tv_title, tv_description;
    private FloatingActionButton play_fab;
    private RecyclerView RvCast;
    private CastAdapter castAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_detail);
        //get data
        iniViews();
        //setup list cast
        setupRvCast();
        play_fab=findViewById(R.id.play_fab);
        play_fab.setOnClickListener(this);

    }
    void iniViews(){
        RvCast=findViewById(R.id.rv_cast);

        String movieTitle=getIntent().getExtras().getString("title");
        int imageResourceId=getIntent().getExtras().getInt("imgURL");
        int imageCover=getIntent().getExtras().getInt("imgCover");
        MovieThumbnailImg=findViewById(R.id.detail_movie_img);
        Glide.with(this).load(imageResourceId).into(MovieThumbnailImg);
        MovieThumbnailImg.setImageResource(imageResourceId);
        MovieCoverImg=findViewById(R.id.detail_movie_cover);
        Glide.with(this).load(imageCover).into(MovieCoverImg);
        tv_title=findViewById(R.id.detail_movie_title);
        tv_title.setText(movieTitle);
        getSupportActionBar().setTitle(movieTitle);
        tv_description=findViewById(R.id.detail_movie_desc);
        //setup animation
        MovieCoverImg.setAnimation(AnimationUtils.loadAnimation(this,R.anim.scale_animation));
       // play_fab.setAnimation(AnimationUtils.loadAnimation(this,R.anim.scale_animation));
    }
    void setupRvCast(){
        List<Cast> mdata=new ArrayList<>();
        mdata.add(new Cast("name",R.drawable.dan));
        mdata.add(new Cast("name",R.drawable.ron));
        mdata.add(new Cast("name",R.drawable.emma));
        mdata.add(new Cast("name",R.drawable.alanr));
        mdata.add(new Cast("name",R.drawable.drago));
        mdata.add(new Cast("name",R.drawable.lupin));
        castAdapter=new CastAdapter(this, mdata);
        RvCast.setAdapter(castAdapter);
        RvCast.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
    }


    @Override
    public void onClick(View view) {
        Intent intent = new Intent(this,YtbPlayerActivity.class);
        startActivity(intent,
                ActivityOptions.makeSceneTransitionAnimation(this).toBundle());
    };


}