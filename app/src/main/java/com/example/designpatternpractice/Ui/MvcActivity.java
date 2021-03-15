package com.example.designpatternpractice.Ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.designpatternpractice.Model.MovieModel;
import com.example.designpatternpractice.R;

public class MvcActivity extends AppCompatActivity implements View.OnClickListener {
    TextView movieNameTv;
    TextView movieDateTv;
    TextView movieDesTv;
    TextView movieIdTv;
    Button buttonGetMovie;
    Button buttonGoToMVP;
    Button buttonGoToMVVM;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mvc);
        movieNameTv=findViewById(R.id.movie_NameTv);
        movieDateTv=findViewById(R.id.movie_DateTv);
        movieDesTv=findViewById(R.id.movie_DesTv);
        movieIdTv=findViewById(R.id.movie_IdTv);
        buttonGetMovie=findViewById(R.id.button_get_movie);
        buttonGetMovie.setOnClickListener(this);
        buttonGoToMVP=findViewById(R.id.go_to_MVP);
        buttonGoToMVP.setOnClickListener(this);
        buttonGoToMVVM=findViewById(R.id.go_to_MVVM);
        buttonGoToMVVM.setOnClickListener(this);
    }
    public MovieModel getMovieFromDB(){
        return new MovieModel("avatar","22/1/2012","good",1);
    }
    public void getMovie(){
        movieNameTv.setText(getMovieFromDB().getName());
        movieDateTv.setText(getMovieFromDB().getDate());
        movieDesTv.setText(getMovieFromDB().getDescription());
        movieIdTv.setText(getMovieFromDB().getId()+"");
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.button_get_movie){
            getMovie();
        }else if(v.getId()==R.id.go_to_MVP){
            Intent intent=new Intent(MvcActivity.this,MVPActivity.class);
            startActivity(intent);
        }else if(v.getId()==R.id.go_to_MVVM){
            Intent intent=new Intent(MvcActivity.this,MVVMActivity.class);
            startActivity(intent);
        }

    }
}