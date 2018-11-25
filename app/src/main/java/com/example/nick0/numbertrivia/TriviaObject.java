package com.example.nick0.numbertrivia;

public class TriviaObject {

    private String mQuote;
    private int mNumber;

    public TriviaObject(String mQuote, int mNumber){

        this.mQuote = mQuote;
        this.mNumber = mNumber;
    }
    public String getmQuote(){
        return mQuote;
    }
    public int getmNumber(){
        return mNumber;
    }
    public void setmQuote(String mQuote){
        this.mQuote = mQuote;
    }
    public void setmNumber(int mNumber){
        this.mNumber = mNumber;
    }
}
