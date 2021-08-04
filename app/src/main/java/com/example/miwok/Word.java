package com.example.miwok;

public class Word {
    //Act's like a flag
    private static final int hasImage = -1;
    private final String Default, miwok;
    private final int mediaId;
    private int imageId = hasImage;

    Word(String Default, String miwok, int imageId, int mediaId) {
        this.Default = Default;
        this.miwok = miwok;
        this.imageId = imageId;
        this.mediaId = mediaId;
    }

    Word(String Default, String miwok, int mediaId) {
        this.Default = Default;
        this.miwok = miwok;
        this.mediaId = mediaId;
    }


    public String getMiwokTranslation() {
        return miwok;
    }

    public String getDefaultTranslation() {
        return Default;
    }

    public int getImageResourceId() {
        return imageId;
    }

    public int getMediaResourceId() {
        return mediaId;
    }

    public boolean hasImageResourceId() {

        return imageId != hasImage;
    }
}
