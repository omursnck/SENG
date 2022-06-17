package com.example.seng.listener;

import com.example.seng.model.SearchAPIResponse;

public interface OnSearchAPIListener {

    void onResponse(SearchAPIResponse response);
    void onError(String message);

}
