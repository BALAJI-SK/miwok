package com.example.miwok;

public class Word {
   private   String Default="",miwok="";
    Word(String Default,String miwok){
        this.Default = Default;
        this.miwok = miwok;
    }
    public  String getMiwokTranslation(){
        return  miwok;
    }
    public  String getDefaultTranslation(){
        return Default;
    }
}
