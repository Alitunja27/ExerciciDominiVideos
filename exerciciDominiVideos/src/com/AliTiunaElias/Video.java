package com.AliTiunaElias;

import java.util.ArrayList;
import java.util.List;

public class Video {
    protected String url, title;
    protected List<String> tags = new ArrayList<>();

    public Video(String url, String title, List<String> tags){
        this.url = url;
        this.title = title;
        this.tags = tags;
    }
}
