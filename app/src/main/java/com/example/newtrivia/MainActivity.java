package com.example.newtrivia;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.example.newtrivia.controller.AppController;
import com.example.newtrivia.data.AnswerListAsyncResponse;
import com.example.newtrivia.data.Repository;
import com.example.newtrivia.model.Question;

import org.json.JSONArray;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity
{
    private String TAG = "TRIVIA_APP";

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<Question> questions = new Repository().getQuestions(questionArrayList ->
        {
            for (int i = 0; i < questionArrayList.size(); i++)
            {
                Question question = questionArrayList.get(i);
                Log.d(TAG, (i + 1) + "º " + question);
            }
        });
    }
}