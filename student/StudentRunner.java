public class StudentRunner {

    public static void main(String[] args){
       StudentTestScores app = new StudentTestScores();
       app.setVisible(true);
    }

    public static void s1(){
         Student s1 = new Student();
        s1.print();

        String s1name=  s1.getName();

        System.out.println("Name: " + s1name);

        s1.setName("Henry");
        
        s1.setScore(2, 95);
        int s1s2 = s1.getScore(2);
        System.out.println("Score 2: " + s1s2);

        int s1avg = s1.getAverage();

        s1.print();
        Student s2 = s1;

        int hscore1 = s1.getHighScore();
        System.out.println("High Score: " + hscore1);
        s2.setName("Sally");
        s2.setScore(1, 88);
        s2.setScore(3, 92);

        s1.print();
        s2.setName("George");
        System.out.println("Average: " + s1avg);
        System.out.println("Student 2:");
        System.out.println(s1.toString());

    }

    public static void a1(){
        Athlete a1 = new Athlete();
        System.out.println(a1.toString());
        System.out.println("Is eligible: " + a1.isEligible());
        a1.setSport("Basketball");

        a1.setName("Michael");
        a1.setScore(1, 80);
        a1.setScore(2, 75);
        a1.setScore(3, 90);
        System.out.println(a1.toString());
        System.out.println("Is eligible: " + a1.isEligible());

    }
}
