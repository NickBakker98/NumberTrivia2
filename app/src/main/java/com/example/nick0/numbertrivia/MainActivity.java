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
    private TextView mQuoteTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addFab = findViewById(R.id.add_fab);


        List<TriviaObject> mTriviaObjects = new ArrayList<>();
        RecyclerView mTriviaRecyclerView = findViewById(R.id.recyclerview);
        RecyclerView.LayoutManager mLayoutManager = new StaggeredGridLayoutManager(2, LinearLayoutManager.VERTICAL);
        mTriviaRecyclerView.setLayoutManager(mLayoutManager);
        TriviaObjectAdapter mAdapter = new TriviaObjectAdapter(this, mTriviaObjects);
        mTriviaRecyclerView.setAdapter(mAdapter);

        addFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Create random number
            }
        });

    }

    public void setQuoteTextView(String quoteMessage) {
        mQuoteTextView.setText(quoteMessage);
    }

    private void requestData()
    {
        com.example.marmm.reminderdemo.NumbersApiService service = com.example.marmm.reminderdemo.NumbersApiService.retrofit.create(com.example.marmm.reminderdemo.NumbersApiService.class);
        Calendar calendar = Calendar.getInstance();
        int month = calendar.get(Calendar.MONTH) + 1; //Calendar.MONTH starts at zero
        int dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);
        /**
         * Make an a-synchronous call by enqueing and definition of callbacks.
         */
        Call<DayQuoteItem> call = service.getTodaysQuote(month, dayOfMonth);
        call.enqueue(new Callback<DayQuoteItem>() {

            @Override
            public void onResponse(Call<DayQuoteItem> call, Response<DayQuoteItem> response) {
                DayQuoteItem dayQuoteItem = response.body();
                setQuoteTextView(dayQuoteItem.getText());
            }

            @Override
            public void onFailure(Call<DayQuoteItem> call, Throwable t) {
                Log.d("error",t.toString());
            }
        });

    }
}
