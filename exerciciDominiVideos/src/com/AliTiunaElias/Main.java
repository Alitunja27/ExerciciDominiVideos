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
        String name, lastName, password, strDate, userType, userOption;
        Date registerDate;
        int i, j, addVideo;
        List<List<String>> mainUserData = new ArrayList<List<String>>();
        List <String> user1 = new ArrayList<>();
        System.out.println("Are you a new user (N) or a registered user(R)?");
        Scanner userType1 = new Scanner(System.in);
        userType = userType1.nextLine();
        //userType = "R";


        if (userType.equalsIgnoreCase("N")){                         //New user register cycle

            System.out.println("Name:");
            Scanner name1 = new Scanner(System.in);
            name = name1.nextLine();
            //name = "Ali";
            System.out.println("Last Name:");
            Scanner lastName1 = new Scanner(System.in);
            lastName = lastName1.nextLine();
            //lastName = "Elias";
            System.out.println("Password:");
            Scanner password1 = new Scanner(System.in);
            password = password1.nextLine();
            //password = "123456";
            registerDate = Calendar.getInstance().getTime();
            DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
            strDate = dateFormat.format(registerDate);
            mainUserData = User.NewUserList(name,lastName,password,strDate);
            System.out.println("New user data " + mainUserData);

        }else if (userType.equalsIgnoreCase("R")){                  //Registered user cycle

            User registeredUser = new User ("Ali", "Elias", "123456", "2019-10-28");
            System.out.println("Name:");
            Scanner name1 = new Scanner(System.in);
            name = name1.nextLine();
            //name = "Ali";
            System.out.println("Last Name:");
            Scanner lastName1 = new Scanner(System.in);
            lastName = lastName1.nextLine();
            //lastName = "Elias";
            System.out.println("Password:");
            Scanner password1 = new Scanner(System.in);
            password = password1.nextLine();
            //password = "123456";
            strDate = "2019-10-28";
            mainUserData = User.NewUserList(name,lastName,password,strDate);
            User user = new User (name,lastName,password,strDate);


            //Procedure to compare the user info with the info in the data base, if the info match asks what to do
            if (CharSequence.compare(registeredUser.name, user.name) == 0) {
                if (CharSequence.compare(registeredUser.lastName, user.lastName) == 0) {
                    if (CharSequence.compare(registeredUser.password, user.password) == 0) {
                        System.out.println("Do you want to see your Video List \"VL\" or you want to Add a new video \"NV\"");
                        Scanner userOption1 = new Scanner(System.in);
                        userOption = userOption1.nextLine();
                        //userOption = "NV";

                        //View list of video of the user
                        if (userOption.equalsIgnoreCase("VL")){
                            for (i=0; i<mainUserData.size(); i++){
                                if (i == 0) {
                                    System.out.println("User: " + mainUserData.get(i));
                                } else {
                                    System.out.println("Video " + i + " :" + mainUserData.get(i));
                                }
                            }

                        //Add new list of video into the user
                        }else if (userOption.equalsIgnoreCase("NV")){
                            System.out.println("How many videos you want to upload:");
                            Scanner addVideo1 = new Scanner(System.in);
                            addVideo = addVideo1.nextInt();
                            List<String> videoList = new ArrayList<>();
                            for (j=0; j<addVideo; j++) {
                                mainUserData = UsersVideos.UsersVideos(addVideo, mainUserData);
                            }
                            for (i=0; i < mainUserData.size(); i++) {
                                if (i == 0) {
                                    System.out.println("User: " + mainUserData.get(i));
                                } else {
                                    System.out.println("Video " + i + " :" + mainUserData.get(i));
                                }
                            }
                        }else {
                            System.out.println("This is not a valid option, please choose to see your Videos List \"VL\" or if you want to Add a new video \"NV\"");
                            throw new Exception ();
                        }
                    }
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
