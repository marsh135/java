package ClassAnatomy;
public class Student {

    private String name;
    private int score;


    // Constructors
    public Student() {
        this.name = "Unknown";
        this.score = 0;
    }
    public Student(String studentName) {
        name = studentName;
        this.score = 0;
    }
    public Student(String name, int score) {
        this.name = name;
        this.score = score;
    }

    // Mutators
    public void setName(String name) {
        this.name = name; 
    }
    public void setScore(int score) {
        this.score = score; 
    }
    
    // Accessors
    public String getName() {
        return name;
    }
    public int getScore() {
        return score;
    }


}
