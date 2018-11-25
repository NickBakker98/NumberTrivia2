package com.example.nick0.numbertrivia;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

public class TriviaObjectAdapter extends RecyclerView.Adapter<TriviaObjectViewHolder> {
    private Context context;
    public List<TriviaObject> listTrivia;

    public TriviaObjectAdapter(Context context, List<TriviaObject> listTrivia) {
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
        final TriviaObject triviaObject = listTrivia.get(position);
        // The holder argument is used to reference the views inside the viewHolder
        // Populate the views with the data from the list
        holder.Number.setText(triviaObject.getmNumber());
        holder.Quote.setText(triviaObject.getmQuote());
    }

    @Override
    public int getItemCount(){
        return listTrivia.size();
    }

}
