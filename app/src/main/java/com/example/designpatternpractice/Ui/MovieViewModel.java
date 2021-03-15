package com.example.designpatternpractice.Ui;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.designpatternpractice.Model.MovieModel;

import java.util.ArrayList;
import java.util.List;

public class MovieViewModel extends ViewModel {
     MutableLiveData<List<String>> movieMutableLiveData =new MutableLiveData<>();
   public void getMovie(){

       List<String> movieName=new ArrayList<>();
       movieName.add(getMovieFromDB().getName());
       movieName.add(getMovieFromDB().getDescription());
       movieName.add(getMovieFromDB().getDate());

       movieMutableLiveData.setValue(movieName);


   }

    private MovieModel getMovieFromDB(){
        return new MovieModel("cast away","1/1/2014","bad",3);
    }
}
