
import java.util.ArrayList;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author hieudt
 */
public class Validate {

    public static boolean checkDuplicateReport(ArrayList<Report> listReport, String name, String CourseName, int total) {
        for (Report report : listReport) {
            if (report.getStudentName().equalsIgnoreCase(name)
                    && report.getCourseName().equalsIgnoreCase(CourseName)
                    && report.getTotalCourse() == total) {
              
                return false;
            }
        }
        return true;
    }

    public static int checkRollChoice(int rollNumber) {
        Scanner sc = new Scanner(System.in);
        boolean checkNull;
        boolean checkFormat;
        boolean checkLimit;
        String input;
        int inputValue;
        System.out.print("Enter rollNumber :");
        do {
            checkLimit = true;
            do {
                checkFormat = true;
                checkNull = true;
                input = sc.nextLine();
                if (input.trim().isEmpty()) {
                    checkNull = false;
                    System.err.println("Empty");
                    System.out.print("Enter again : ");
                }
                for (int i = 0; i < input.length(); i++) {
                    if (Character.isDigit(input.charAt(i))) {

                    } else {
                        checkFormat = false;
                        System.err.println("Character !");
                        System.out.print("Enter again :");
                        break;
                    }
                }
            } while (checkFormat == false || checkNull == false);
            inputValue = Integer.parseInt(input);
            if (inputValue >= 1 && inputValue <= rollNumber) {

            } else {
                System.err.println("deo co t nay trong danh sach  ");
                System.out.print("Enter again :");
                checkLimit = false;
            }

        } while (checkLimit == false);
        return inputValue;
    }

    public static boolean inputYN() {
        while (true) {
            System.out.print("Enter U or Y");
            String input = checkInput();
            if (input.equalsIgnoreCase("y")) {
                return true;
            }
            if (input.equalsIgnoreCase("n")) {
                return false;
            }
        }
    }

    public static boolean inputUD() {
        while (true) {
            String input = checkInput();
            if (input.equalsIgnoreCase("u")) {
                return true;
            }
            if (input.equalsIgnoreCase("d")) {
                return false;
            }
        }
    }

    public static boolean checkDuplicateID(ArrayList<Student> list, String id) {
        for (Student student : list) {
            if (student.getStudentID().toUpperCase().equalsIgnoreCase(id.toUpperCase())) {
                return true;
            }
        }
        return false;
    }

    public static boolean checkDuplicate(ArrayList<Student> list, Student newStudent) {
        for (Student student : list) {
            if ((student.getStudentID().equalsIgnoreCase(newStudent.getStudentID())) && (student.getStudentName().equalsIgnoreCase(newStudent.getStudentName()))
                    && (student.getSemester().equalsIgnoreCase(newStudent.getSemester()))
                    && (student.getCourseName().equalsIgnoreCase(newStudent.getCourseName()))) {
                System.err.println("Duplicate");
                return false;
            }
        }
        return true;
    }

    public static int inputChoice() {
        Scanner sc = new Scanner(System.in);
        boolean checkNull;
        boolean checkFormat;
        boolean checkLimit;
        String input;
        int inputValue;
        System.out.print("Enter choice :");
        do {
            checkLimit = true;

            do {
                checkFormat = true;
                checkNull = true;
                input = sc.nextLine();
                if (input.trim().isEmpty()) {
                    checkNull = false;
                    System.err.println("Empty");
                    System.out.print("Enter again : ");
                }
                for (int i = 0; i < input.length(); i++) {
                    if (Character.isDigit(input.charAt(i))) {

                    } else {
                        checkFormat = false;
                        System.err.println("Character !");
                        System.out.print("Enter again :");
                        break;
                    }
                }
            } while (checkFormat == false || checkNull == false);
            inputValue = Integer.parseInt(input);
            if (inputValue >= 1 && inputValue <= 6) {

            } else {
                System.err.println("Enter 1 - 6 ");
                System.out.print("Enter again :");
                checkLimit = false;
            }

        } while (checkLimit == false);
        return inputValue;
    }

    public static String checkInput() {
        Scanner sc = new Scanner(System.in);
        boolean checkNull;
        String input;
        do {
            checkNull = true;
            input = sc.nextLine();
            if (input.isEmpty()) {
                System.err.println("Empty");
                System.out.print("Enter again : ");
                checkNull = false;
            }
        } while (checkNull == false);
        return input;
    }

    public static String checkInputCourse() {
        Scanner sc = new Scanner(System.in);
        boolean checkNull;
        boolean checkFormat;
        String input;

        do {
            checkFormat = true;
            do {
                checkNull = true;
                input = sc.nextLine();
                if (input.isEmpty()) {
                    System.err.println("Empty");
                    System.out.print("Enter again : ");
                    checkNull = false;
                }
            } while (checkNull == false);
            if ((input.trim().equalsIgnoreCase("Java"))
                    || (input.trim().equalsIgnoreCase(".Net"))
                    || (input.trim().equalsIgnoreCase("C/C++"))) {
            } else {
                System.err.println("There are only three courses: Java, .Net, C/C++");
                System.out.print("Enter again :");
                checkFormat = false;
            }

        } while (checkFormat == false);
        return input;
    }

    public static int inputUI() {
        while (true) {
            String choice = checkInput();
            if (choice.equalsIgnoreCase("U")) {
                return 0;
            }
            if (choice.equalsIgnoreCase("D")) {
                return 1;
            }
            System.err.println(" Enter U or D");
            System.out.print("Enter again : ");

        }
    }

}
//    public static int checkInputValue() {
//        Scanner sc = new Scanner(System.in);
//        boolean checkNull;
//        boolean checkFormat;
//        String input;
//        do {
//            checkFormat = true;
//            checkNull = true;
//
//            input = sc.nextLine();
//            if (input.isEmpty()) {
//                checkNull = false;
//                System.err.println("Empty");
//                System.out.print("Enter again :");
//            }
//            for (int i = 0; i < input.length(); i++) {
//                if (Character.isDigit(input.charAt(i))) {
//
//                } else {
//                    checkFormat = false;
//                    System.err.println("Character !");
//                    System.out.print("Enter again :");
//                    break;
//                }
//            }
//        } while (checkFormat == false || checkNull == false);
//        int inputValue = Integer.parseInt(input);
//        return inputValue;
//
//    }
