package com.example.nick0.numbertrivia;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

public class TriviaObjectViewHolder extends RecyclerView.ViewHolder {
    public TextView mQuoteTextView;
    public TextView mNumberTextView;
    public View view;

    public TriviaObjectViewHolder(View itemView) {
        super(itemView);
        mQuoteTextView = itemView.findViewById(R.id.QuoteTextView);
        mNumberTextView = itemView.findViewById(R.id.QuoteNumber);
        view = itemView;
    }

    
}
