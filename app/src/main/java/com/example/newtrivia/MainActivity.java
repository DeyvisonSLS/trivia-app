package com.example.newtrivia;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.example.newtrivia.controller.AppController;
import com.example.newtrivia.data.Repository;

import org.json.JSONArray;

public class MainActivity extends AppCompatActivity
{
    private String TAG = "TRIVIA_APP";

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new Repository().getQuestions();
    }
}