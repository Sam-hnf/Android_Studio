package utils;

import com.example.myapplication.R;
import com.example.myapplication.models.Movie;

import java.util.ArrayList;
import java.util.List;

public class DataSource {

    public static List<Movie> getPopularMovies(){

        List<Movie>lstMovies=new ArrayList<>();
        lstMovies.add(new Movie("Toy Story", R.drawable.toy_story,R.drawable.toystory_cover));
        lstMovies.add(new Movie("Cars",R.drawable.cars,R.drawable.cars_cover));
        lstMovies.add(new Movie("The Irish Man",R.drawable.irish,R.drawable.irish_cover));
        lstMovies.add(new Movie("Harry Potter",R.drawable.harry,R.drawable.harry_cover));
        lstMovies.add(new Movie("Cars",R.drawable.cars,R.drawable.cars_cover));
        lstMovies.add(new Movie("Cars",R.drawable.cars,R.drawable.cars_cover));
        return lstMovies;
    }

    public static List<Movie> getWeekMovies(){
        List<Movie>lstMovies=new ArrayList<>();
        lstMovies.add(new Movie("Harry Potter",R.drawable.harry,R.drawable.harry_cover));
        lstMovies.add(new Movie("The Irish Man",R.drawable.irish,R.drawable.irish_cover));
        lstMovies.add(new Movie("Toy Story", R.drawable.toy_story,R.drawable.toystory_cover));
        lstMovies.add(new Movie("Cars",R.drawable.cars,R.drawable.cars_cover));
        return lstMovies;
    }

}
