package Projects;

public class breakOutMethods {
    //check number vs. secret number

    public static boolean sn(int ug){
        if(ug ==  135)
        {
            return true;
        }
        else{
            return false;
        }
    }

    public static boolean pw(String guess){
        if(guess.equals("wrong"))
        {
            return true;
        }
        else{
            return false;
        }
    }

    public static boolean ri(String riddle){
        if(riddle.equals("fire"))
        {
            return true;
        }
        else{
            return false;
        }
    }

}
