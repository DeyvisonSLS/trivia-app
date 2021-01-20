package com.example.newtrivia.data;

import com.example.newtrivia.model.Question;

import java.util.ArrayList;

public interface AnswerListAsyncResponse
{
    void processFinished(ArrayList<Question> questionArrayList);
}
