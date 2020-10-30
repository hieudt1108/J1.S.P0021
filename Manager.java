/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

/**
 *
 * @author hieudt
 */
public class Manager {

    Scanner sc = new Scanner(System.in);

    public static void menu() {

        System.out.println("\t1. Create");
        System.out.println("\t2. Find and Sort");
        System.out.println("\t3. Update/Delete");
        System.out.println("\t4. Report");
        System.out.println("\t5. Display all student");
        System.out.println("\t6. Exit");
    }

    public static void create(ArrayList<Student> list) {
        String name = null, id, semester, course;
        Student newStudent = new Student();
        while (true) {
            System.out.print("Enter studentID : ");
            id = Validate.checkInput();
            System.out.print("Enter studentName :");
            if (Validate.checkDuplicateID(list, id) == true) {
                for (Student student : list) {
                    if (student.getStudentID().equalsIgnoreCase(id)) {
                        name = student.getStudentName();
                        System.out.println(student.getStudentName());
                        break;
                    }
                }
            } else {
                name = Validate.checkInput();
            }

            System.out.print("Enter semester : ");
            semester = Validate.checkInput();
            System.out.print("Enter courseName : ");
            course = Validate.checkInputCourse();
            newStudent = new Student(id, name, semester, course);
            if (Validate.checkDuplicate(list, newStudent) == true) {
                break;
            }
        }

        list.add(newStudent);
        displayListStudent(list);
    }

    public static void findAndSort(ArrayList<Student> list) {
        ArrayList<Student> list2 = new ArrayList<>();

        if (list.isEmpty()) {
            System.err.println("List empty");
        } else {
            System.out.print("Enter name to find :");
            String name = Validate.checkInput();

            boolean checkExist = true;
            for (Student student : list) {
                if (student.getStudentName().toUpperCase().contains(name.toUpperCase())) {
                    list2.add(student);
                    checkExist = false;
                }
            }
            if (checkExist == true) {
                System.err.println("Name does not exist!");
            } else {
                Collections.sort(list2, new Comparator<Student>() {
                    @Override
                    public int compare(Student o1, Student o2) {
                        return o1.getStudentName().compareToIgnoreCase(o2.getStudentName());
                    }
                });

                System.out.printf("%s%30s%30s%30s\n", "Id", "Name", "Semester", "Course");
                for (Student student : list2) {
                    student.display();
                }
            }
        }

    }

    public static void updateAndDelete(ArrayList<Student> list) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Student> list3 = new ArrayList<>();
        Student stuRep;
        String newId;
        String newName;
        String newSemester;
        String newCourseName;
        if (list.isEmpty()) {
            System.err.println("List empty ");
        } else {
            System.out.print("Enter id to update or delete :");
            String id = Validate.checkInput();
            boolean checkExist = true;
            for (Student student : list) {
                if (student.getStudentID().equalsIgnoreCase(id)) {
                    list3.add(student);
                    checkExist = false;
                }
            }
            if (checkExist == true) {
                System.err.println("ID does not exist!");

            }
            int count = 0;
            for (Student student : list3) {
                count++;
            }

            if (count == 1) {
                stuRep = new Student(list3.get(0).getStudentID(), list3.get(0).getStudentName(), list3.get(0).getSemester(), list3.get(0).getCourseName());
                System.out.println("");
                stuRep.display();
                for (Student student : list) {
                    if ((student.getStudentID().equalsIgnoreCase(stuRep.getStudentID()))
                            && (student.getStudentName().equalsIgnoreCase(stuRep.getStudentName()))
                            && (student.getSemester().equalsIgnoreCase(stuRep.getSemester()))
                            && (student.getCourseName().equalsIgnoreCase(stuRep.getCourseName()))) {
                        System.out.println("Do you want to update (U) or delete (D) student.");
                        if (Validate.inputUD() == true) {
                            while (true) {
                                System.out.print("Enter newStudentID : ");
                                newId = Validate.checkInput();
                                System.out.print("Enter newStudentName :");
                                newName = Validate.checkInput();
                                System.out.print("Enter semester : ");
                                newSemester = Validate.checkInput();
                                System.out.print("Enter courseName : ");
                                newCourseName = Validate.checkInputCourse();
                                stuRep = new Student(newId, newName, newSemester, newCourseName);
                                if (Validate.checkDuplicate(list, stuRep) == true) {
                                    student.setStudentID(newId);
                                    student.setStudentName(newName);
                                    student.setSemester(newSemester);
                                    student.setCourseName(newCourseName);
                                    System.out.println("Update Done!");
                                    return;
                                }
                            }
                        } else {
                            list.remove(student);
                            System.out.println("Delete Done !");
                            return;
                        }
                    }
                }
            } else {
                int rollNumber = 1;
                System.out.printf("%s%30s%30s%30s%30s\n", "Roll", "Id", "Name", "Semester", "Course");
                for (Student student : list3) {
                    System.out.print(rollNumber + "\t\t\t\t");
                    student.display();
                    rollNumber++;
                }
                System.out.print("Enter roll number you want delete or update ");
                int rollChoice = Validate.checkRollChoice(rollNumber);

                stuRep = new Student(list3.get(rollChoice - 1).getStudentID(), list3.get(rollChoice - 1).getStudentName(), list3.get(rollChoice - 1).getSemester(), list3.get(rollChoice - 1).getCourseName());
                System.out.println("");
                stuRep.display();
                for (Student student : list) {
                    if ((student.getStudentID().equalsIgnoreCase(stuRep.getStudentID()))
                            && (student.getStudentName().equalsIgnoreCase(stuRep.getStudentName()))
                            && (student.getSemester().equalsIgnoreCase(stuRep.getSemester()))
                            && (student.getCourseName().equalsIgnoreCase(stuRep.getCourseName()))) {
                        System.out.println("Do you want to update (U) or delete (D) student.");
                        if (Validate.inputUD() == true) {
                            while (true) {
                                System.out.print("Enter newStudentID : ");
                                newId = Validate.checkInput();
                                System.out.print("Enter newStudentName :");
                                newName = Validate.checkInput();
                                System.out.print("Enter semester : ");
                                newSemester = Validate.checkInput();
                                System.out.print("Enter courseName : ");
                                newCourseName = Validate.checkInputCourse();
                                stuRep = new Student(newId, newName, newSemester, newCourseName);
                                if (Validate.checkDuplicate(list, stuRep) == true) {
                                    student.setStudentID(newId);
                                    student.setStudentName(newName);
                                    student.setSemester(newSemester);
                                    student.setCourseName(newCourseName);
                                    System.out.println("Update Done !");
                                    return;
                                }
                            }
                        } else {
                            list.remove(student);
                            System.out.println("Delete Done !");
                            return;
                        }
                    }
                }
            }
        }

    }

    public static void reportStudent(ArrayList<Student> list) {
        ArrayList<Report> listReport = new ArrayList<>();
        for (Student student : list) {
            int total = 0;
            for (Student studentCheck : list) {
                if (studentCheck.getStudentID().equalsIgnoreCase(student.getStudentID())
                        && studentCheck.getStudentName().equalsIgnoreCase(student.getStudentName())
                        && studentCheck.getCourseName().equalsIgnoreCase(student.getCourseName())) {
                    total ++ ;

                }
            }
            if(Validate.checkDuplicateReport(listReport, student.getStudentName(), student.getCourseName(), total)== true){
                Report report = new Report(student.getStudentName(), student.getCourseName(), total);
                listReport.add(report);
            }
            
        }
        if(listReport.isEmpty()){
            System.err.println("Empty");
        }else{
            for (Report report : listReport) {
                report.display();
            }
        }

    }

    public static void displayListStudent(ArrayList<Student> list) {
        System.out.printf("%s%30s%30s%30s\n", "Id", "Name", "Semester", "Course");
        for (Student student : list) {
            student.display();
        }
    }

}
