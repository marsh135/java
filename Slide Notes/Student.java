import ClassAnatomy.Student;

public class Student {
    String studentName;
    int studentID;
    double gpa;
  
    public Student(String name) {
        studentName= name;
    }
    public Student(String name, int id) {
        studentName= name;
        studentID= id;
    }
    public Student(String name, int id, double gpa) {
        studentName= name;
        studentID= id;
        this.gpa= gpa;
    }

    public void printInfo() {
        System.out.println("Name: " + studentName);
        System.out.println("ID: " + studentID);
        System.out.println("GPA: " + gpa);
    }

    public void forceGPA(double amount) {
        gpa += amount;
    }

    public class Main{
        public static void main(String[] args) {
            Student dvader = new Student("Darth Vader", 12345, 1.2);
            Student luke = new Student("Luke Skywalker", 54321, 3.5);
            dvader.printInfo();
            luke.printInfo();
            dvader.forceGPA(3.0);
            luke.forceGPA(-2.5);
            dvader.printInfo();
            luke.printInfo();
        }
    }


}
