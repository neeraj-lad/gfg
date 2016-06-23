import java.io.*;
import java.util.*;

class ClosestPair
{
    public static void main(String args[])throws IOException
    {
        int a[] = {1, 2, 3, 5, 9, 11};        
        int sum = 10;
        printArray(a);
        closestPair(a, sum);
    }

    static void printArray(int a[])
    {}

    static void closestPair(int a[], int sum)
    {
        int l = 0, r = a.length-1;
        int minDiff = Integer.MAX_VALUE, minLeft = -1, minRight = -1;

        while (l < r)
        {
            if (Math.abs(a[l] + a[r] - sum) < minDiff)
            {
                minDiff = Math.abs(a[l] + a[r] - sum);
                minLeft = l;
                minRight = r;
            }
            else
            if (a[l] + a[r] < sum)
                l++;
            else
                r--;
        }

        System.out.format("The pair closest to %d is %d and %d\n", sum, a[minLeft], a[minRight]); 
    }
}

