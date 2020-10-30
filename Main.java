
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        ArrayList<Student> list = new ArrayList<>();
        list.add(new Student("2", "Nguyen Van Hieu", "2", ".Net"));
        list.add(new Student("1", "Doan Trung Hieu", "3", "Java"));
        list.add(new Student("1", "Doan Trung Hieu", "2", "Java"));
        list.add(new Student("1", "Doan Trung Hieu", "1", "Java"));
        list.add(new Student("3", "Dang Dinh Sang", "2", "C/C++"));

        Scanner sc = new Scanner(System.in);
        System.out.println("WELCOME TO STUDENT MANAGEMENT");
        Manager.menu();
        while (true) {
            int choice = Validate.inputChoice();
            switch (choice) {
                case 1:
                    Manager.create(list);
                    break;
                case 2:
                    Manager.findAndSort(list);
                    break;
                case 3:
                    Manager.updateAndDelete(list);
                    break;
                case 4:
                    Manager.reportStudent(list);
                    break;
                case 5:
                    Manager.displayListStudent(list);
                    break;
                case 6:
                    System.exit(0);
                    break;
            }
        }

    }
}
