package com.example.designpatternpractice.Ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.designpatternpractice.R;

import butterknife.BindView;

public class MVPActivity extends AppCompatActivity implements View.OnClickListener,MovieViewMVP {
    TextView movieNameTv;
    TextView movieDateTv;
    TextView movieDesTv;
    TextView movieIdTv;
    Button buttonGetMovie;
    MVPpresenter presenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_m_v_p);
        movieNameTv=findViewById(R.id.movie_NameTv);
        movieDateTv=findViewById(R.id.movie_DateTv);
        movieDesTv=findViewById(R.id.movie_DesTv);
        movieIdTv=findViewById(R.id.movie_IdTv);
        buttonGetMovie=findViewById(R.id.button_get_movie);
        buttonGetMovie.setOnClickListener(this);
        presenter=new MVPpresenter(this);
    }

   //view want getting data so he calling presenter
    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.button_get_movie) ;
        presenter.getMovie();
    }
   //presenter return date to activity by using interface responsible getting data from modelDB
    @Override
    public void OnGetMovie(String name, String date, String Description, int id) {
        movieNameTv.setText(name);
        movieDateTv.setText(date);
        movieDesTv.setText(Description);
        movieIdTv.setText(id+"");

    }
}