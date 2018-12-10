package com.example.nick0.numbertrivia;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TriviaObjectAdapter extends RecyclerView.Adapter<TriviaObjectViewHolder> {
    private Context context;
    public List<NumberQuoteItem> listTrivia;

    public TriviaObjectAdapter(Context context, List<NumberQuoteItem> listTrivia) {
        this.context = context;
        this.listTrivia = listTrivia;
    }
    @Override
    public TriviaObjectViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.grid_cell, parent, false);
        return new TriviaObjectViewHolder(view);
    }
    @Override
    public void onBindViewHolder(final TriviaObjectViewHolder holder, final int position) {
        // Gets a single item in the list from its position
        final NumberQuoteItem triviaObject = listTrivia.get(position);
        // The holder argument is used to reference the views inside the viewHolder
        // Populate the views with the data from the list
        holder.mNumberTextView.setText(triviaObject.getText());
        holder.mQuoteTextView.setText(triviaObject.getNumber());

        requestData();
    }

    @Override
    public int getItemCount(){
        return listTrivia.size();
    }

    public void setQuoteTextView(final TriviaObjectViewHolder holder, String quoteMessage) {
        holder.mQuoteTextView.setText(quoteMessage);
    }

    private void requestData()
    {
        com.example.nick0.numbertrivia.NumbersAPIService service = com.example.nick0.numbertrivia.NumbersAPIService.retrofit.create(com.example.nick0.numbertrivia.NumbersAPIService.class);

        int number = 42;
        String trivia = "trivia";
        /**
         * Make an a-synchronous call by enqueing and definition of callbacks.
         */
        Call<NumberQuoteItem> call = service.getNumberQuote(number, trivia);
        call.enqueue(new Callback<NumberQuoteItem>() {

            @Override
            public void onResponse(Call<NumberQuoteItem> call, Response<NumberQuoteItem> response) {
                NumberQuoteItem numberQuoteItem = response.body();
                setQuoteTextView(numberQuoteItem.getText());
            }

            @Override
            public void onFailure(Call<NumberQuoteItem> call, Throwable t) {
                Log.d("error",t.toString());
            }
        });
    }
}


