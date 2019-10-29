package com.AliTiunaElias;
import java.util.Scanner;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {
        String userType, userOption;
        int i, j, addVideo;
        List<List<String>> mainUserData = new ArrayList<>();
        System.out.println("Are you a new user (N) or a registered user(R)?");
        userType = new Scanner(System.in).nextLine();

        if (userType.equalsIgnoreCase("N")){                         //New user register cycle
            User user = User.User(userType);
            mainUserData = User.NewUserList(user);
            System.out.println("New user data " + mainUserData);
            System.out.println("Do you want to add a video? Yes (Y) or No (N)");
            userOption = new Scanner(System.in).nextLine();
            if (userOption.equalsIgnoreCase("Y")) {
                System.out.println("How many videos you want to upload:");
                addVideo = new Scanner(System.in).nextInt();
                for (j = 0; j < addVideo; j++) {
                    mainUserData = User.UsersVideos(addVideo, mainUserData);
                }
                for (i = 1; i < mainUserData.size(); i++) {
                    System.out.println("Video " + i + " :" + mainUserData.get(i));
                }
            } else if (userOption.equalsIgnoreCase("N")){
                System.out.println("Thank you!, see you next time.");
            } else {
                throw new Exception("This is not a valid option");
            }

        }else if (userType.equalsIgnoreCase("R")){                  //Registered user cycle
            User registeredUser = new User ("Ali", "Elias", "123456", "2019-10-28");
            User user = User.User(userType);
            mainUserData = User.NewUserList(user);

            //Procedure to compare the user info with the info in the data base, if the info match asks what to do
            if (User.validatingUser(registeredUser,user)==true){
                System.out.println("Do you want to see your Video List \"VL\" or you want to Add a new video \"NV\"");
                userOption = new Scanner(System.in).nextLine();
                //userOption = "NV";

                //View list of video of the user
                if (userOption.equalsIgnoreCase("VL")){
                    for (i=1; i<mainUserData.size(); i++){
                        System.out.println("Video " + i + " :" + mainUserData.get(i));
                    }

                //Add new list of video into the user
                }else if (userOption.equalsIgnoreCase("NV")){
                    System.out.println("How many videos you want to upload:");
                    addVideo = new Scanner(System.in).nextInt();
                    for (j=0; j<addVideo; j++) {
                        mainUserData = User.UsersVideos(addVideo, mainUserData);
                    }
                    for (i=1; i < mainUserData.size(); i++) {
                        System.out.println("Video " + i + " :" + mainUserData.get(i));
                        }
                }else {
                    System.out.println("This is not a valid option, please choose to see your Videos List \"VL\" or if you want to Add a new video \"NV\"");
                    throw new Exception ();
                }
            } else {
                throw new Exception("Oops something went wrong, please try again"); //info entered and info stored does not match
            }
        }else {
            System.out.println("This is not a valid type of user, please choose if you are a new user (N) or a registered user(R)");
            throw new Exception ();
        }
    }
}
