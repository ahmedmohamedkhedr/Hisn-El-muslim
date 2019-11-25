package com.example.hesnel_muslim;

import java.util.ArrayList;

public class Data {
    private String title;
    private String audioUrl;
    private String txtUrl;
    public static ArrayList<Data> container = new ArrayList<>();
    public static ArrayList<String> azkar = new ArrayList<>() ;
    public static String language = null;


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAudioUrl() {
        return audioUrl;
    }

    public void setAudioUrl(String audioUrl) {
        this.audioUrl = audioUrl;
    }

    public String getTxtUrl() {
        return txtUrl;
    }

    public void setTxtUrl(String txt) {
        this.txtUrl = txt;
    }
}
