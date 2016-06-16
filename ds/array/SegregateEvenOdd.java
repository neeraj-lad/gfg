import java.io.*;
import java.util.*;

class SegregateEvenOdd
{
    public static void main(String args[])throws IOException
    {
       int a[] = {12, 11, 13, 15, 16, 2, 3, 8, 10};
       printArray(a);
       leftRightMtd(a);

       int b[] = {};
       printArray(b);
       leftRightMtd(b);
    }

    static void printArray(int a[])
    {
        if (a.length == 0)
        {
            System.out.println("Empty array");
            return;
        }
        for (int i = 0; i < a.length; i++)
            System.out.print(a[i] + " ");
        System.out.println();
    }

    static void leftRightMtd(int a[])
    {
        int left = 0, right = a.length-1;
        while (left < right)
        {
            while (a[left] % 2 == 0 && left <= right)
                left++;
            while (a[right] % 2 == 1 && right >= left)
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

