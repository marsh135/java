public class Athlete extends Student {
    
    private String sport;

    public Athlete(){
        super();
        sport = "none";
    }

    public Athlete(String name, String sport){
        super(name);
        this.sport = sport;
    }

    public Athlete(String name, int score1, int score2, int score3, String sport){
        super(name);
        this.sport = sport;
    }
    @Override
    public int getAverage(){
        return (int) ((getScore(1) + getScore(2) + getScore(3)) / 3.0);
    }

    public Boolean isEligible(){
        if(getAverage() >=70){
            return true;
        }
        else{
            return false;
        }
    }

    public void setSport(String sport){
        this.sport = sport;
    }

    public String toString(){
        return super.toString() + "\nSport: " + sport;
    }
}
