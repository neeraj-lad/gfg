import java.io.*;
import java.util.*;

class MaxIncDecArr
{
    public static void main(String args[])throws IOException
    {
        int a[] = {10, 20, 30, 40, 100, 80, 70, 60};
        printArray(a);
        System.out.println(linearMtd(a));
        System.out.println(binarySearchMtd(a));
    }

    static void printArray(int a[])
    {
       for (int i = 0; i < a.length; i++)
           System.out.print(a[i] + " ");
       System.out.println();
    }

    static int linearMtd(int a[])
    {
        int diff = -1;
        for (int i = 0; i < a.length-1; i++)
            if (a[i] - a[i+1] >= 0)
               return a[i];
        return a[a.length-1];
    }

    static int binarySearchMtd(int a[])
    {
        int start = 0, end = a.length-1;
        while (start <= end)
        {
            int mid = start + (end - start) / 2;

            if (mid == 0 && a[mid] >= a[mid+1])
                return a[mid];
            if (mid == a.length-1 && a[mid] > a[mid-1])
                return a[mid];
            if (a[mid] > a[mid+1] && a[mid] > a[mid-1])
                return a[mid];
           
            if (a[mid] > a[mid+1] && a[mid] < a[mid-1])
                end = mid-1;
            else
                start = mid+1;
        }
        return -1;
       // int a[] = {10, 20, 30, 100, 100, 80, 70, 60};
    }
}

