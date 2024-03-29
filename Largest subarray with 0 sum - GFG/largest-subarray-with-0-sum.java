//{ Driver Code Starts
import java.util.*;

class MaxLenZeroSumSub
{

    // Returns length of the maximum length subarray with 0 sum

    // Drive method
    public static void main(String arg[])
    {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T > 0)
        {
            int n = sc.nextInt();
            int arr[] = new int[n];
            for (int i = 0; i < n; i++)
                arr[i] = sc.nextInt();

            GfG g = new GfG();
            System.out.println(g.maxLen(arr, n));
            T--;
        }
    }
}
// } Driver Code Ends


class GfG
{
    int maxLen(int arr[], int n)
    {
        // Your code here
        Map<Integer, Integer> hm  = new HashMap<>();
        int maxLength = 0;
        int pSum = 0;
        
        for(int i = 0; i < n; i++) {
            pSum += arr[i];
            if(pSum == 0) {
                maxLength = Math.max(maxLength, (i+1));
                hm.put(pSum, i);
            }
            else {
                if(hm.containsKey(pSum)) {
                maxLength = Math.max(maxLength, (i-hm.get(pSum)));
                }
                else {
                    hm.put(pSum, i);
                }   
            }
        }
        
        return maxLength;
    }
}