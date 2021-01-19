package com.example.newtrivia.data;

import android.util.Log;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.example.newtrivia.controller.AppController;
import com.example.newtrivia.model.Question;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;
import java.util.List;

public class Repository
{
    ArrayList<Question> questionArrayList = new ArrayList<>();
    private String url = "https://raw.githubusercontent.com/curiousily/simple-quiz/master/script/statements-data.json";
    private final String TAG = "TRIVIA_REPOSITORY";

    public List<Question> getQuestions()
    {
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONArray>()
                {
                    @Override
                    public void onResponse(JSONArray response)
                    {
                        for (int i = 0; i < response.length(); i++)
                        {
                            try
                            {
                                Log.d(TAG, "Question: " + response.getJSONArray(i).get(0));
                                Log.d(TAG, "Answer: " + response.getJSONArray(i).get(1));
                            } catch (JSONException e)
                            {
                                e.printStackTrace();
                            }
                        }
                    }
                },
                new Response.ErrorListener()
                {
                    @Override
                    public void onErrorResponse(VolleyError error)
                    {
                        Log.e(TAG, "onErrorResponse: " + error);
                    }
                }
        );

        AppController.getInstance().addToRequestQueue(jsonArrayRequest);

        return null;
    }
}
