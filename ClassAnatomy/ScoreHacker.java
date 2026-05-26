package ClassAnatomy;

public class ScoreHacker {
   
    int hackScore(Student student, int extraPoints) {
        student.score += extraPoints;
        return student.score;
    }



}
