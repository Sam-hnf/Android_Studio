package com.example.myapplication.models;
import android.widget.ListPopupWindow;

import java.util.List;

public class Slide {
    private int Image;
    private String Title;

    public Slide(int image, String title) {
        Image = image;
        Title = title;
    }

    public int getImage() {
        return Image;
    }

    public String getTitle() {
        return Title;
    }

    public void setImage(int image) {
        Image = image;
    }

    public void setTitle(String title) {
        Title = title;
    }

}
