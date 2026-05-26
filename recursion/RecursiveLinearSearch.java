package recursion;

public class RecursiveLinearSearch {

    public static void main(String args[])
    {
        int arr[] = {10, 2, 21, 6, 18};
        int target = 2;

        int index =  recSearch(arr, 0, arr.length-1, target);

        if(index!=-1)
            System.out.println("Element found at index: " + index);
        else
            System.out.println("Element not found in the array");
    }

    static int recSearch(int arr[], int left, int right, int target)
    {
        if(left > right)
            return -1;

        if(arr[left] == target)
            return left;

        return recSearch(arr, left+1, right, target);
    }

}
