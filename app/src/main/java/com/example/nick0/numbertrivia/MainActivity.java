package com.example.nick0.numbertrivia;

import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Random;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private FloatingActionButton addFab;
    TriviaObjectAdapter adapter;
    ArrayList<NumberQuoteItem> mTriviaObjects;
    RecyclerView mTriviaRecyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addFab = findViewById(R.id.add_fab);

        mTriviaObjects = new ArrayList<>();

        mTriviaRecyclerView = findViewById(R.id.recyclerview);

        RecyclerView.LayoutManager mLayoutManager = new StaggeredGridLayoutManager(1, LinearLayoutManager.VERTICAL);
        mTriviaRecyclerView.setLayoutManager(mLayoutManager);
        TriviaObjectAdapter mAdapter = new TriviaObjectAdapter(this, mTriviaObjects);
        mTriviaRecyclerView.setAdapter(mAdapter);

        addFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                requestData();
            }
        });
    }

    private void updateUI(){
        if(adapter == null){
            adapter = new TriviaObjectAdapter(this, mTriviaObjects);
            mTriviaRecyclerView.setAdapter(adapter);
        }else{
            adapter.swapList(mTriviaObjects);
        }
    }


    private void requestData()
    {
        com.example.nick0.numbertrivia.NumbersAPIService service = com.example.nick0.numbertrivia.NumbersAPIService.retrofit.create(com.example.nick0.numbertrivia.NumbersAPIService.class);
        Random r;
        r = new Random();
        int number = r.nextInt(300);
        String trivia = "trivia";
        /**
         * Make an a-synchronous call by enqueing and definition of callbacks.
         */
        Call<NumberQuoteItem> call = service.getNumberQuote(number, trivia);
        call.enqueue(new Callback<NumberQuoteItem>() {

            @Override
            public void onResponse(Call<NumberQuoteItem> call, Response<NumberQuoteItem> response) {
                NumberQuoteItem numberQuoteItem = response.body();
                mTriviaObjects.add(numberQuoteItem);
                updateUI();
            }

            @Override
            public void onFailure(Call<NumberQuoteItem> call, Throwable t) {
                Log.d("error", t.toString());
            }
        });
    }
}
