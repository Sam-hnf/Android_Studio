package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.example.myapplication.models.Slide;

import java.util.List;

public class SliderPagerAdapter extends PagerAdapter {

    private Context nContext;
    private List<Slide> nList;

    public SliderPagerAdapter(Context nContext, List<Slide> nList) {
        this.nContext = nContext;
        this.nList = nList;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        LayoutInflater inflater =(LayoutInflater) nContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View slideLayout =inflater.inflate(R.layout.slide_item,null);
        ImageView slideImg= slideLayout.findViewById(R.id.slider_img);
        TextView slideText= slideLayout.findViewById(R.id.slider_title);
        slideImg.setImageResource(nList.get(position).getImage());
        slideText.setText(nList.get(position).getTitle());
        container.addView(slideLayout);
        return slideLayout;
    }

    @Override
    public int getCount() {
        return nList.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
        return view==o;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View)object);
    }
}
