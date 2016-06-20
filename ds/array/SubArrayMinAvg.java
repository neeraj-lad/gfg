import java.io.*;
import java.util.*;

class SubArrayMinAvg
{
    public static void main(String args[])throws IOException
    {
       int a[] = {3, 90, 7, 20, 33, 54, 23, 2};
       int k = 3;
       printArray(a);
       bFMtd(a, k);
       slidingWindowMtd(a, k);
    }

    static void printArray(int a[])
    {
        for (int i = 0; i < a.length; i++)
            System.out.print(a[i] + " ");
        System.out.println();
    }

    static void bFMtd(int a[], int k)
    {
        if (k > a.length)
            k = a.length;

        int min = Integer.MAX_VALUE;
        int st = -1;
        for (int i = 0; i < a.length-2; i++)
        {
            int sum = a[i] + a[i+1] + a[i+2];
            if (sum < min)
            {
                min = sum;
                st = i;
            }
        }
        System.out.println("Subarray from index " + st + " to " + (st + k - 1) + " has the least average value of " + (min / 3));
    }

    static void slidingWindowMtd(int a[], int k)
    {
        if (k > a.length)
            k = a.length;

        int sum = 0;
        for (int i = 0; i < k; i++)
            sum += a[i];
        int min = sum;
        int st = 0;
        for (int i = k; i < a.length; i++)
        {
            sum = sum + a[i] - a[i-k];
            if (sum < min)
            {
                min = sum;
                st = i-k+1;
            }
        }
        System.out.println("Subarray from index " + st + " to " + (st + k - 1) + " has the least average value of " + (min / 3));
    }
}

