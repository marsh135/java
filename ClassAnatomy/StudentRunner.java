package ClassAnatomy;


public class StudentRunner {
    public static void main(String[] args) {
        Student student1 = new Student("Sam");
        Student student2 = new Student("Ashley", 95);

        System.out.println(student1.getName() + "'s score: " + student1.getScore()); // Outputs: Sam's score: 0
        System.out.println(student2.getName() + "'s score: " + student2.getScore());    // Outputs: Ashley's score: 95

        student1.setScore(88);  // Using mutator to set score for student1 to 88
        System.out.println(student1.getName() + "'s new score: " + student1.getScore());    // Outputs: Sam's new score: 88
        
        //SCOREHACKER
        ScoreHacker hacker = new ScoreHacker();
    
    }
}
