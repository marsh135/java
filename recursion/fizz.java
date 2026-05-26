package recursion;

public class fizz {
    public static String re (String t)
    {
        if(t.length() >6)
            return t;
        return re(t+t.substring(t.indexOf("ZZ")));
    }
}
