package com.example.designpatternpractice.Ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.designpatternpractice.R;
import com.example.designpatternpractice.databinding.ActivityMVVMBinding;

import java.util.List;

public class MVVMActivity extends AppCompatActivity  {
    MovieViewModel movieViewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMVVMBinding binding= DataBindingUtil.setContentView(this,R.layout.activity_m_v_v_m);
        binding.buttonGetMovie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                movieViewModel.getMovie();
            }
        });

        movieViewModel= ViewModelProviders.of(this).get(MovieViewModel.class);
//        movieViewModel.movieMutableLiveData.observe(this, new Observer<String>() {
//            @Override
//            public void onChanged(String s) {
//                binding.movieNameTv.setText(s);
//            }
//        });
        movieViewModel.movieMutableLiveData.observe(this, new Observer<List<String>>() {
            @Override
            public void onChanged(List<String> strings) {
                binding.movieNameTv.setText(strings.toString());

            }
        });
    }

}