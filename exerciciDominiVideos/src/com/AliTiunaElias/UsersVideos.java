package com.AliTiunaElias;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UsersVideos {

    public static List<List<String>> UsersVideos(Integer addVideo, List<List<String>> mainUserData) throws Exception {
        List<String> videoList = new ArrayList<>();

        //for (Integer j=0; j<addVideo; j++) {
            System.out.println("Please insert the URL");
            Scanner url1 = new Scanner(System.in);
            String url = url1.nextLine();
            if (url == null || url.isEmpty()) {
                throw new Exception("Please don't leave any space empty");
            }
            System.out.println("Please insert the Title");
            Scanner title1 = new Scanner(System.in);
            String title = title1.nextLine();
            if (title == null || title.isEmpty()) {
                throw new Exception("Please don't leave any space empty");
            }
            System.out.println("How many tags you want to add");
            Scanner tagsN1 = new Scanner(System.in);
            Integer tagsN = tagsN1.nextInt();
            List<String> tagsList = new ArrayList<>();

            for (Integer i = 0; i < tagsN; i++) {
                System.out.println("Pleas insert the " + (i + 1) + " tag:");
                Scanner tags1 = new Scanner(System.in);
                String tags = tags1.nextLine();
                if (tags == null || tags.isEmpty()) {
                    throw new Exception("Please don't leave any space empty");
                }
                tagsList.add(tags);
            }
            Video videoInfo = new Video(url, title, tagsList);
            videoList.add(videoInfo.url);
            videoList.add(videoInfo.title);
            videoList.addAll(tagsList);
            mainUserData.add(videoList);
        //}
        return mainUserData;
    }
}
