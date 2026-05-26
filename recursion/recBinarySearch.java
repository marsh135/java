package recursion;

public class recBinarySearch {

    int binarySearch(int arr[], int l, int r, int x)
    {
        if (r >= l) {
            int mid = l + (r - l) / 2;
 
            // If the element is present at the middle
            // itself
            if (arr[mid] == x)
                return mid;
 
            // If element is smaller than mid, then
            // search in the left subarray
            if (arr[mid] > x)
                return binarySearch(arr, l, mid - 1, x);
 
            // Else the element can only be present
            // in the right subarray
            return binarySearch(arr, mid + 1, r, x);
        }
 
        // We reach here when element is not present
        // in array
        return -1;
    }

    public static void main(String args[])
    {
        recBinarySearch ob = new recBinarySearch();
        int arr[] = { 2, 4, 6, 8, 10, 12, 14, 16, 18, 20, 22, 24, 26, 28, 30, 32, 34, 36, 38, 40 };
        int n = arr.length;
        int x = 8;
        int result = ob.binarySearch(arr, 0, n - 1, x);
        if (result == -1)
            System.out.println("Element not found in the array");
        else
            System.out.println("Element found at index " + result);
    }

}
