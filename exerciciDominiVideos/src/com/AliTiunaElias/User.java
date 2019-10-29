package com.AliTiunaElias;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;


public class User {
    protected String name, lastName, password, strDate;

    public User (String name, String lastName, String password, String strDate){
        this.name = name;
        this.lastName = lastName;
        this.password = password;
        this.strDate = strDate;
    }
    public static User User (String userType) throws Exception {
        String name,lastName,password,strDate;
        Date registerDate;
        System.out.println("Name:");
        name = new Scanner(System.in).nextLine();
        //name = "Ali";
        System.out.println("Last Name:");
        lastName = new Scanner(System.in).nextLine();
        //lastName = "Elias";
        System.out.println("Password:");
        //password = "123456";
        password = new Scanner(System.in).nextLine();
        if (name==null || lastName==null || password==null){
            throw new Exception("Please don't leave any space empty");
        }
        if (userType.equalsIgnoreCase("N")) {
            registerDate = Calendar.getInstance().getTime();
            DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
            strDate = dateFormat.format(registerDate);
        } else {
            strDate = ("2019-10-28");
        }
        User user = new User (name,lastName,password,strDate);
        return user;
    }

    public static List<List<String>> NewUserList(User user) {
        List<String> user1 = new ArrayList<>();
        List<List<String>> mainUserData = new ArrayList<List<String>>();
        user1.add(user.name);
        user1.add(user.lastName);
        user1.add(user.password);
        user1.add(user.strDate);
        mainUserData.add(user1);
        return mainUserData;
    }

    public static List<List<String>> UsersVideos(Integer addVideo, List<List<String>> mainUserData) throws Exception {

        List<String> videoList = new ArrayList<>();
        System.out.println("Please insert the URL");
        String url = new Scanner(System.in).nextLine();
        if (url == null || url.isEmpty()) {
            throw new Exception("Please don't leave any space empty");
        }
        System.out.println("Please insert the Title");
        String title = new Scanner(System.in).nextLine();
        if (title == null || title.isEmpty()) {
            throw new Exception("Please don't leave any space empty");
        }
        System.out.println("How many tags you want to add");
        Integer tagsN = new Scanner(System.in).nextInt();
        List<String> tagsList = new ArrayList<>();

        for (Integer i = 0; i < tagsN; i++) {
            System.out.println("Pleas insert the " + (i + 1) + " tag:");
            String tags = new Scanner(System.in).nextLine();
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

    public static boolean validatingUser (User registeredUser, User userInput){
        boolean compare = false;
        if ((CharSequence.compare(registeredUser.name, userInput.name)) == 0) {
            if (CharSequence.compare(registeredUser.lastName, userInput.lastName) == 0) {
                if (CharSequence.compare(registeredUser.password, userInput.password) == 0) {
                    compare = true;
                }
            }
        }   return compare;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", lastname='" + lastName + '\'' +
                ", password='" + password + '\'' +
                ", registerDate='" + strDate + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(name, user.name) &&
                Objects.equals(lastName, user.lastName) &&
                Objects.equals(password, user.password) &&
                Objects.equals(strDate, user.strDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, lastName, password, strDate);
    }
}
