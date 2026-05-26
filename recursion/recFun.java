package recursion;

public class recFun {
    public static int re(int n){
        if (n > 10000)
            return n;
        else
            System.out.println(n);
            return re(n*2);
    }
}
