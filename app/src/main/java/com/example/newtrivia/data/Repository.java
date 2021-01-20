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

    public List<Question> getQuestions(final AnswerListAsyncResponse callback)
    {
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, url, null,
                response ->
                {
                    for (int i = 0; i < response.length(); i++)
                    {
                        try
                        {
//                                 Log.d(TAG, "Question: " + response.getJSONArray(i).get(0));
//                                 Log.d(TAG, "Answer: " + response.getJSONArray(i).get(1));

                            Question question;
                            String answer = response.getJSONArray(i).getString(0);
                            boolean answerTrue = response.getJSONArray(i).getBoolean(1);

                            question = new Question(answer, answerTrue);

                            questionArrayList.add(question);
                        } catch (JSONException e)
                        {
                            e.printStackTrace();
                        }
                    }
                    if(callback != null) callback.processFinished(questionArrayList);
                },
                error -> Log.e(TAG, "onErrorResponse: " + error)
        );

        AppController.getInstance().addToRequestQueue(jsonArrayRequest);

        Log.d(TAG, "onResponse: " + questionArrayList);

        return questionArrayList;
    }
}
