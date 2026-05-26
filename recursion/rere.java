package recursion;

public class rere {
    public static int re(int n){
        if(n<9)
            return n*3;
        return re(re(n/5));
    }
}
