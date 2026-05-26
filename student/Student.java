public class Student {

    private String name;
    private int[] scores = new int[10];

    public Student(){
        name= "default";
    }
    public Student(String name){
        this.name = name;
       
    }
    public Student(String name, int score1, int score2, int score3, int score4, int score5, int score6, int score7, int score8, int score9, int score10){
        this.name = name;
        scores[0] = score1;
        scores[1] = score2;
        scores[2] = score3;
        scores[3] = score4;
        scores[4] = score5;
        scores[5] = score6;
        scores[6] = score7;
        scores[7] = score8;
        scores[8] = score9;
        scores[9] = score10;

    }



    public void setName(String name){
        this.name =  name;
    }
    
    public String getName(){
        return name;
    }

    public void setScore(int whichtest, int score){
        int which = whichtest;
        for(int i = 0; i < scores.length; i++){
            if(i == which - 1){
                scores[i] = score;
            }
        }
    }

    public int getScore(int whichTest){
        int which =  whichTest;
        for(int i = 0; i < scores.length; i++){
            if(i == which - 1){
                return scores[i];
            }
        }
        return 0;
    }
    

    public int getAverage(){
        int sum = 0;
        for(int i = 0; i < scores.length; i++){
            sum += scores[i];
        }
        return sum / scores.length;
    }

    public int getHighScore(){
        int highScore = scores[0];
        for(int i = 1; i < scores.length; i++){
            if(scores[i] > highScore){
                highScore = scores[i];
            }
        }
        return highScore;

    }

    public String toString(){
        String result = "Name: " + name;
        for(int i = 0; i < scores.length; i++){
            result += "\nScore " + (i + 1) + ": " + scores[i];
        }
        return result;
    }

    public void print(){
        System.out.println("Name: " + name);
        for(int i = 0; i < scores.length; i++){
            System.out.println("Score " + (i + 1) + ": " + scores[i]);
        }
    }
    public int[] getScores() {
        return scores;
    }
    public void setScores(int[] scores) {
        this.scores = scores;
    }
}
