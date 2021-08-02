package com.example.miwok;

public class Word {
    private  int imageId=hasImage;
    private   String Default="",miwok="";
    //Act's like a flag
    private static final int  hasImage=-1;
    Word(String Default,String miwok,int imageId){
        this.Default = Default;
        this.miwok = miwok;
        this.imageId= imageId;
    }
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
   public  int getImageResourceId(){return imageId;}

   public  boolean hasImageResourceId(){

        return imageId != hasImage;
   }
}
