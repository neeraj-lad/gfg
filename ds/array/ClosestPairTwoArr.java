import java.io.*;
import java.util.*;

class ClosestPairTwoArr
{
    public static void main(String args[])throws IOException
    {
       int a[] = {1, 5, 4, 7};
       int b[] = {20, 40, 30, 10};
       int x = 32;
       printArray(a);
       printArray(b);
       bFMtd(a, b, x);
       sortMtd(a, b, x);
    }

    static void printArray(int a[])
    {
        for (int i = 0; i < a.length; i++)
            System.out.print(a[i] + " ");
        System.out.println();
    }

    static void bFMtd(int a[], int b[], int x)
    {
        int minDiff = Integer.MAX_VALUE;
        int first = -1, second = -1;
        for (int i = 0; i < a.length; i++)
            for (int j = 0; j < b.length; j++)
                if (Math.abs(a[i] + b[j] - x) < minDiff)
                {
                    minDiff = Math.abs(a[i] + b[j] - x);
                    first = i;
                    second = j;
                }
        System.out.println("Closest pair to " + x + " is " + a[first] + " and " + b[second]);
    }

    static void sortMtd(int a[], int b[], int x)
    {
        int minDiff = Integer.MAX_VALUE;
        int first = -1, second = -1;

        Arrays.sort(a);
        Arrays.sort(b);

        int i = 0, j = b.length-1;
        while (i < a.length && j >= 0)
        {
            if (Math.abs(a[i] + b[j] - x) < minDiff)
            {
                minDiff = Math.abs(a[i] + b[j] - x);
                first = i;
                second = j;
            }
            else
            if (a[i] + b[j] < x)
                i++;
            else
                j--;
        }
        
        System.out.println("Closest pair to " + x + " is " + a[first] + " and " + b[second]);
    }
}

