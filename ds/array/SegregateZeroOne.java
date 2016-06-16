import java.io.*;
import java.util.*;

class SegregateZeroOne
{
    public static void main(String args[])throws IOException
    {
       int a[] = {0, 1, 0, 1, 1, 0, 0, 1};
       printArray(a);

       countMtd(a);
       leftRightMtd(a);
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

    static void countMtd(int a[])
    {
        int zero = 0;
        for (int i = 0; i < a.length; i++)
            if (a[i] == 0)
                zero++;
        
        int one = a.length - zero;

        int i;
        for (i = 0; i < zero; i++)
            a[i] = 0;
        for (; i < a.length; i++)
            a[i] = 1;
        
        printArray(a);
    }

    static void leftRightMtd(int a[])
    {
        int left = 0, right = a.length-1;

        while (left < right)
        {
            while (left <= right && a[left] == 0)
                left++;
            while (right >= left && a[right] == 1)
                right--;

            if (left < right)
            {
                int t = a[left];
                a[left++] = a[right];
                a[right--] = t;
            }
        }

        printArray(a);
    }
}

