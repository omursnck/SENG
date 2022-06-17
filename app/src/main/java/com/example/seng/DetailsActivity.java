package com.example.seng;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailsActivity extends AppCompatActivity {

        TextView textView_movie_plot, textView_movie_name, textView_movie_released;
        ImageView imageView_movie_poster;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        textView_movie_plot = findViewById(R.id.textView_movie_plot);
        textView_movie_name = findViewById(R.id.textView_movie_name);
        textView_movie_released = findViewById(R.id.textView_movie_released);
    }
}