package com.rohit.sample.Model;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.rohit.sample.Controller.MainController;
import com.rohit.sample.Adapters.DataModel;

import org.json.JSONException;
import org.json.JSONObject;

public class MainModel {
    private RequestQueue mQueue;
    private Context context;
    private MainController controller;

    public MainModel(Context context, MainController controller) {
        this.context = context;
        this.controller = controller;
    }

    public void getData() {
        mQueue = Volley.newRequestQueue(context);

        String url = "https://picsum.photos/v2/list?page=1&limit=100";

        JsonArrayRequest request = new JsonArrayRequest(Request.Method.GET, url, null, response -> {
            for (int i = 0; i <= response.length(); i++) {
                try {
                    JSONObject object = response.getJSONObject(i);
                    String author = object.getString("author");
                    String imgUrl = object.getString("download_url");

                    DataModel dm = new DataModel(author, imgUrl);
                    controller.getImageUrl(dm);

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, error -> {
            error.printStackTrace();
        });

        mQueue.add(request);
    }
}
