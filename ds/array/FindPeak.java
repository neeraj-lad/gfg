import java.io.*;
import java.util.*;

class FindPeak
{
    public static void main(String args[])throws IOException
    {
       int a[] = {1, 2, 3, 4};
       printArray(a);
       System.out.println(linearMtd(a));
       System.out.println(divideConquerMtd(a));

       int b[] = {5, 4, 3, 2, 1};
       printArray(b);
       System.out.println(linearMtd(b));
       System.out.println(divideConquerMtd(b));
   
       int c[] = {1, 2, 30, 4};
       printArray(c);
       System.out.println(linearMtd(c));
       System.out.println(divideConquerMtd(c));

       int d[] = {1, 11, 3, 0, 1, 12, 10};
       printArray(d);
        System.out.println(linearMtd(d));
       System.out.println(divideConquerMtd(d));
    }
    
    static void printArray(int a[])
    {
        for (int i = 0; i < a.length; i++)
            System.out.print(a[i] + " ");
        System.out.println();
    }

    static int linearMtd(int a[])
    {
        if (a.length == 1)
            return a[0];
        int peak = -1;
        if (a[0] >= a[1])
        {
            peak = a[0];
            return peak;
        }

        for (int i = 1; i < a.length-1; i++)
            if (a[i] >= a[i-1] && a[i] >= a[i+1])
            {
                peak = a[i];
                return peak;
            }

        if (a[a.length-1] >= a[a.length-2])
            peak = a[a.length-1];

        return peak;
    }

    static int divideConquerMtd(int a[])
    {
        return binarySearch(a, a.length, 0, a.length-1); 
    }

    static int binarySearch(int a[], int n, int start, int end)
    {
        int mid = start + (end - start) / 2;

        if ((mid == 0 || (mid > 0 && a[mid-1] <= a[mid])) && (mid == n-1 || (mid < n-1 && a[mid+1] <= a[mid])))
            return a[mid];
        else
        if (mid > 0 && a[mid-1] > a[mid])
            return binarySearch(a, n, 0, mid-1);
        else
            return binarySearch(a, n, mid+1, end);
    }
}

