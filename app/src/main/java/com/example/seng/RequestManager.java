package com.example.seng;

import android.content.Context;
import android.widget.Toast;


import com.example.seng.listener.OnSearchAPIListener;
import com.example.seng.model.SearchAPIResponse;

import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Path;

public class RequestManager {

    Context context;
    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("https://api.themoviedb.org/3/movie/550?api_key=460fc3671db2c39b339c9ce92581c4c5")
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    public RequestManager(Context context) {
        this.context = context;
    }
    public void searchMovies(OnSearchAPIListener listener,String movie_name){
        getMovies getMovies = retrofit.create(RequestManager.getMovies.class);
                Call<SearchAPIResponse> call = getMovies.callMovies(movie_name);

                call.enqueue(new Callback<SearchAPIResponse>() {
                    @Override
                    public void onResponse(Call<SearchAPIResponse> call, Response<SearchAPIResponse> response) {
                         if (!response.isSuccessful()){
                             Toast.makeText(context, "Couldnt fetch Data", Toast.LENGTH_SHORT).show();
                             return;

                         }
                         listener.onResponse(response.body());
                    }

                    @Override
                    public void onFailure(Call<SearchAPIResponse> call, Throwable t) {

                        listener.onError(t.getMessage());
                    }
                });
    }

    public interface getMovies  {
        @Headers({
                "Accept: application/json",
                "X-RapidAPI-Host: movie-database-alternative.p.rapidapi.com",
                "X-RapidAPI-Key: d063ae3413msh94688abf209cee4p119789jsn87c9a740b037"
        })
        @GET("s={movie_name}")
        Call<SearchAPIResponse> callMovies(
            @Path("movie_name") String movie_name
        );
    }
}
