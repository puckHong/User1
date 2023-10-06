package controller;

import Common.Library;
import View.Menu;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import model.User;

public class UserManagement extends Menu<String> {

    Library lib = new Library();
    static String[] choices = {"Create a new account", "Login system"};
    ArrayList<User> userList = new ArrayList<>();

    public UserManagement() {
        super("======================= USER MANAGEMENT SYSTEM =======================", choices, "Exit");

    }

    @Override
    public void execute(int n) {
        switch (n) {
            case 1:
                addUser();
                break;
            case 2 :
                login();
                break;
        }
    }

    public void addUser() {
        String username = lib.checkUserName("Enter Username: ");
        String password = lib.checkUserPassword("Enter Password: ");
        userList.add(new User(username, password));
        testSaveBinaryFile(userList, "user.dat");
        System.out.println("=================== create success ===================");
    }

    public  ArrayList<User> readFile(String path) {
        ArrayList<User> UserList = new ArrayList<>();
        try {
            FileInputStream fis = new FileInputStream(path);
            DataInputStream dis = new DataInputStream(fis);
            while (dis.available() > 0) {
                UserList.add(new User(dis.readUTF(), dis.readUTF()));
            }
            dis.close();
            fis.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return UserList;
    }

    public  void testReadBinaryFile(String path) {
        ArrayList<User> stdList = readFile(path);
        stdList.forEach(s -> System.out.println(s));
    }
     
    public boolean saveBinaryFile(ArrayList<User> userList, String path) {
        try {
            FileOutputStream fos = new FileOutputStream(path);
            DataOutputStream dos = new DataOutputStream(fos);            
            for (User t : userList) {
                dos.writeUTF("\n");
                dos.writeUTF(t.getUserName());
                dos.writeUTF(t.getUserPassword());
            }
            dos.close();
            fos.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public void testSaveBinaryFile(ArrayList<User> userList, String path) {
        boolean kq = saveBinaryFile(userList, path);
        if (kq == true) {
            System.out.println("Luu File thanh cong");

        } else {
            System.out.println("Luu File that bai");
        }
    }

    public void login() {
        readFile("user.dat");
        String username = lib.checkUserName("Enter Username: ");
        String password = lib.checkUserPassword("Enter Password: ");
       
        
    }
}
