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
    Random r;
    private int randomnumber;
    private TextView mQuoteTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addFab = findViewById(R.id.add_fab);

        List<NumberQuoteItem> mTriviaObjects = new ArrayList<>();

        RecyclerView mTriviaRecyclerView = findViewById(R.id.recyclerview);

        RecyclerView.LayoutManager mLayoutManager = new StaggeredGridLayoutManager(1, LinearLayoutManager.VERTICAL);
        mTriviaRecyclerView.setLayoutManager(mLayoutManager);
        TriviaObjectAdapter mAdapter = new TriviaObjectAdapter(this, mTriviaObjects);
        mTriviaRecyclerView.setAdapter(mAdapter);
//        addFab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                //Create random number
//                r = new Random();
//                r.nextInt(randomnumber);
//                //mNumberTextView.setText(randomnumber); (Misschien moet dit in de Adapter.)
        //        objects.add dingen
//                //Show random number + quote.
//            }
//        });

    }





}
