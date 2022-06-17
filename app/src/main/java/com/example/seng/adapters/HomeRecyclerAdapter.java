package com.example.seng.adapters;

import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.seng.R;
import com.example.seng.listener.OnMovieClickListener;
import com.example.seng.model.SearchArrayObjects;
import com.squareup.picasso.Picasso;

import org.w3c.dom.Text;

import java.util.List;

public class HomeRecyclerAdapter extends RecyclerView.Adapter<HomeViewHolder> {

    Context context;
    List<SearchArrayObjects> list;
    OnMovieClickListener listener;

    public HomeRecyclerAdapter(Context context, List<SearchArrayObjects> list, OnMovieClickListener listener) {
        this.context = context;
        this.list = list;
        this.listener = listener;
    }

    @NonNull
    @Override
    public HomeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new HomeViewHolder(LayoutInflater.from(context).inflate(R.layout.home_movies_list, parent, false));

    }

    @Override
    public void onBindViewHolder(@NonNull HomeViewHolder holder, int position) {

        holder.textView_movie.setText(list.get(position).getTitle());
        Picasso.get().load(list.get(position).getImage()).into(holder.ImageView_poster);

        holder.home_container.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onMovieClicked(list.get(position).getId());
            }
        });
    }

    @Override
    public int getItemCount() {
        return 0;
    }
}

class HomeViewHolder extends RecyclerView.ViewHolder {

    ImageView ImageView_poster;
    TextView textView_movie;
    CardView home_container;
    public HomeViewHolder(@NonNull View itemView) {
        super(itemView);
        ImageView_poster = itemView.findViewById(R.id.ImageView_poster);
        textView_movie =  itemView.findViewById(R.id.textView_movie);
        home_container = itemView.findViewById(R.id.home_container);
    }
}