package recursion;

public class baseCaseRecursion {
    public static int addOne(int n){
        if(n>=10)
            return n;
        else
        {
            n= n + 1;
            return addOne(n);
        }
    }
}
