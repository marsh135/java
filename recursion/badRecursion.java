package recursion;

public class badRecursion {
    
    public static int addOne(int n){
        n= n + 1;
        return addOne(n);
    }

}
