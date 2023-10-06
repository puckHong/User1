package Common;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import model.User;

public class Library {

    public int[] createArray(int size_Array) {
        int[] array = new int[size_Array];
        Random rd = new Random();
        for (int i = 0; i < size_Array; i++) {
            array[i] = rd.nextInt(100);
        }
        return array;
    }

    public void display(int[] array) {
        for (int i = 0; i < array.length; i++) {
            if (i < array.length - 1) {
                System.out.print(array[i] + ", ");
            } else {
                System.out.print(array[i]);
            }
        }
        System.out.println("");
    }

//    public int checkID(String msg, ArrayList<Student> list) {
//        while (true) {
//            String id = getValue(msg);
//
//            if (checkDuplicateID(list, Integer.parseInt(id)) < 0) {
//                continue;
//            }
//
//            String sub = id.substring(0);
//            try {
//                int out = Integer.parseInt(sub);
//                if (out < 0) {
//                    System.out.println("Invalid value. Please enter again.");
//                    continue;
//                }
//                return Integer.parseInt(id);
//            } catch (Exception e) {
//                System.out.println("Wrong format");
//            }
//        }
//    }
    public String checkEmail(String msg) {
        while (true) {
            int vt = 0;
            String sub = "";
            String email = getValue(msg);
            email.trim();
            if (email.startsWith(" ")) {
                continue;
            } else {
                vt = email.indexOf("@");    //nhan@fpt.edu.vn
                if (email.charAt(0) == '@') {
                    continue;
                }
                sub = email.substring(vt + 1);
            }
            if (!sub.equals("gmail.com")) {
                continue;
            }
            return email;
        }
    }

//    public int checkDuplicateID(ArrayList<Student> list, int id) {
//        for (Student d : list) {
//            if (d.getId()== id) {
//                System.out.println("ID is existed.Enter again.");
//                continue;
//            }
//        }
//        return id;
//    }
//    public int autoIncreasingID(ArrayList<Student> st) {
//        int id = st.size() + 1;
//        return id;
//    }

    public String checkUpdatePhone(String msg) {
        while (true) {
            String input = getValue(msg);
            if (input == null || input.length() != 10) {
                continue;
            }

            for (int i = 2; i < 10; i++) {
                if ((input.charAt(i)) > '9' || input.charAt(i) < '0') {
                    continue;
                }
            }
            return input;
        }
    }
    Scanner sc = new Scanner(System.in);

    public String getValue(String msg) {
        while (true) {
            System.out.println(msg);
            String input = sc.nextLine();
            input.trim();
            if (input == null || input.length() == 0) {
                System.out.println("Do not enter null data. Please enter again.");
                continue;
            }
            return input;
        }
    }

    public int checkBithday(String msg) {
        while (true) {
            String birthDate = getValue(msg);
            if (birthDate.length() != 4) {
                continue;
            }
            if ((Integer.parseInt(birthDate) > 2023) || Integer.parseInt(birthDate) < 1900) {
                continue;
            }
            return Integer.parseInt(birthDate);
        }

    }

    public int checkYearEx(String msg) {
        while (true) {
            String yearEx = getValue(msg);
            if (Integer.parseInt(yearEx) < 0 || Integer.parseInt(yearEx) > 100) {
                continue;
            }
            return Integer.parseInt(yearEx);

        }
    }

   public String checkUserName(String msg){
       while(true){
       String input = getValue(msg);
       if(input.length()<5 || input.contains(" ")){
           continue;
       }else return input;
       }
   }
   public String checkDuplicateID(ArrayList<User> list, String userName) {
       for (User d : list) {
            if (d.getUserName()== userName) {
                System.out.println("ID is existed.Enter again.");
                continue;
            }
        }
        return userName;
    }

 

    public String checkUserPassword(String msg) {
        while (true) {
            String input = getValue(msg);
            if (input.length()<6 || input.contains(" ")) {
                 continue;
            }
            else return input;
        }
    }
//        public static boolean checkReportExist(ArrayList<Report> listReports, String name, String course, int total) {
//        for (Report report : listReports) {
//            if (name.equalsIgnoreCase(report.getStuName())
//                    && course.equalsIgnoreCase(report.getCourseName())
//                    && total == report.getTotalCourse()) {
//                return true;
//            }
//        }
//        return false;
//    }

}
