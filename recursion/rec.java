package recursion;

public class rec {

    public static int re(int n){

        if (n<=1)
            return 1;

        return n +  re(n/2);
    }
}
