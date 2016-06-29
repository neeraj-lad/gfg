import java.io.*;
import java.util.*;

class FindPivot
{
    public static void main(String args[])throws IOException
    {
       int a[] = {5, 6, 7, 1, 2, 3, 4};
       printArray(a);
       System.out.println("Pivot is: " + binarySearch(a, 0, a.length-1));

       int b[] = {1, 2, 3, 4, 5};
       printArray(b);
       System.out.println("Pivot is: " + binarySearch(b, 0, b.length-1));

       int c[] = {3, 2};
       printArray(c);
       System.out.println("Pivot is: " + binarySearch(c, 0, c.length-1));
    }

    static void printArray(int a[])
    {
        for (int i = 0; i < a.length; i++)
            System.out.print(a[i] + " ");
        System.out.println();
    }

    static int binarySearch(int a[], int start, int end)
    {
        if (start == end)
            return a[start];

        while (start < end)
        {
            int mid = start + (end - start) / 2;

            if (mid > start && a[mid-1] > a[mid])
                return a[mid];
            if (mid < end && a[mid+1] < a[mid])
                return a[mid+1];

            if (a[end] > a[mid])
                end = mid-1;
            else
                start = mid+1;
        }
        return a[0];
    }
}

