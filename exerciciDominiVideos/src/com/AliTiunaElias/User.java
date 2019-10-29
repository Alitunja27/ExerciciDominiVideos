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

    public static List<List<String>> NewUserList(String name, String lastName, String password, String strDate) throws Exception{

        if (name==null || lastName==null || password==null){
            throw new Exception("Please don't leave any space empty");
        }
        User user =  new User (name,lastName,password,strDate);
        List<String> user1 = new ArrayList<>();
        List<List<String>> mainUserData = new ArrayList<List<String>>();
        user1.add(user.name);
        user1.add(user.lastName);
        user1.add(user.password);
        user1.add(user.strDate);
        mainUserData.add(user1);
        //System.out.println(mainUserData);
        return mainUserData;
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
