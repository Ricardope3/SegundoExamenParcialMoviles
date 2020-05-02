package com.example.segundoexamenparcial;

import android.app.Activity;
import android.content.Context;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.io.Serializable;

public class RequestBook implements Serializable {
    private final long serialVersionUID = 1L;

    static private Activity activity;

    public RequestBook()
    {

    }
    public static void getRequest(final Context t, final Callback callback, String genero) {

        activity = (Activity) t;
        RequestQueue queue = Volley.newRequestQueue(t);

        String URL = "http://androidstorepddm.000webhostapp.com/services/getbooks.php?category=" + genero;
        StringRequest request = new StringRequest(Request.Method.GET,
                URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.d("response:", response);
                        callback.processJSON(response);
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("Problem: ", "Can't connect to server");
                callback.onError();
            }
        });
        queue.add(request);
    }

    public interface Callback {
        void processJSON(String response);
        void onError();
    }
}