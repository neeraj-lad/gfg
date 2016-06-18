import java.io.*;
import java.util.*;

class FixedPoint
{
    public static void main(String args[])throws IOException
    {
       int a[] = {-1, 1, 3, 5, 6, 15, 16}; 
       printArray(a);
       System.out.println(linearMtd(a));
       System.out.println(binarySearchMtd(a));
    }

    static void printArray(int a[])
    {
        if (a.length == 0)
        {
            System.out.println("Empty Array");
            return;
        }
        for (int i = 0; i < a.length; i++)
            System.out.print(a[i] + " ");
        System.out.println();
    }

    static int linearMtd(int a[])
    {
        for (int i = 0; i < a.length; i++)
            if (a[i] == i)
                return i;
        return -1;
    }

    static int binarySearchMtd(int a[])
    {
        int start = 0, end = a.length-1;

        while (start <= end)
        {
            int mid = start + (end - start) / 2;

            if (a[mid] == mid)
                return mid;
            else
            if (a[mid] > mid)
                end = mid-1;
            else
                start = mid+1;
        }
        return -1;
    }
}

