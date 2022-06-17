package com.example.seng;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.example.seng.adapters.HomeRecyclerAdapter;
import com.example.seng.listener.OnMovieClickListener;
import com.example.seng.listener.OnSearchAPIListener;
import com.example.seng.model.SearchAPIResponse;

public class MainActivity extends AppCompatActivity implements OnMovieClickListener {

    SearchView search_view;
    RecyclerView recycler_view_home;
    HomeRecyclerAdapter adapter;
    RequestManager manager;
    ProgressDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        search_view = findViewById(R.id.search_view);
        recycler_view_home = findViewById(R.id.recycler_view_home);

        dialog = new ProgressDialog(this);
        manager = new RequestManager(this);

        search_view.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                dialog.setTitle("Please Wait.. ");
                dialog.show();
                manager.searchMovies(listener, query);
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });
    }

    private final OnSearchAPIListener listener = new OnSearchAPIListener() {
        @Override
        public void onResponse(SearchAPIResponse response) {
            dialog.dismiss();
            if(response == null){
                Toast.makeText(MainActivity.this, "No data available", Toast.LENGTH_SHORT).show();
                return;
            }
            showResult(response);
        }

        @Override
        public void onError(String message) {
            dialog.dismiss();
            Toast.makeText(MainActivity.this, "An Error Occured", Toast.LENGTH_SHORT).show();
        }
    };

    private void showResult(SearchAPIResponse response) {

            recycler_view_home.setHasFixedSize(true);
            recycler_view_home.setLayoutManager(new GridLayoutManager(MainActivity.this, 2));
            adapter = new HomeRecyclerAdapter(this, response.getTitle(), this );
            recycler_view_home.setAdapter(adapter);
    }

    @Override
    public void onMovieClicked(String id) {

            startActivity(new Intent(MainActivity.this, DetailsActivity.class)
                    .putExtra("Data", id));
    }
}