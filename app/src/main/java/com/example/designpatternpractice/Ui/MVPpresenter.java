package com.example.designpatternpractice.Ui;

import com.example.designpatternpractice.Model.MovieModel;

public class MVPpresenter {
    MovieViewMVP viewMVP;

    public MVPpresenter(MovieViewMVP viewMVP) {
        this.viewMVP = viewMVP;
    }
    public MovieModel getMovieFromDB(){
        return new MovieModel("king kong","14/12/2015","amazing",2);
    }
    //getting data by using interface
    public void getMovie(){
        viewMVP.OnGetMovie(getMovieFromDB().getName(),getMovieFromDB().getDate()
        ,getMovieFromDB().getDescription(),getMovieFromDB().getId());
    }
}



