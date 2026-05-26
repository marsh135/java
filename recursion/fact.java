package recursion;

public class fact {
    
    public static int reFact(int n){
        System.out.println(n);
        if (n==1)
            return 1;
        return n*reFact(n-1);
    }
    //Iterative Factorial
    public static int itFact(int n){
        int result = 1;
        for (int i = 1; i <= n; i++) {
            result *= i;
        }
        return result;
    }
}
