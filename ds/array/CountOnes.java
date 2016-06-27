import java.io.*;
import java.util.*;

class CountOnes
{
    public static void main(String args[])throws IOException
    {
        int a[] = {1, 1, 1, 1, 1, 0, 0, 0};
        printArray(a);
        bFMtd(a);
        binarySearchMtd(a);
        int b[] = {0, 0, 0, 0};
        printArray(b);
        bFMtd(b);
        binarySearchMtd(b);
    }

    static void printArray(int a[])
    {
        for (int i = 0; i < a.length; i++)
            System.out.print(a[i] + " ");
        System.out.println();
    }

    static void bFMtd(int a[])
    {
        int count = 0;
        for (int i = 0; i < a.length; i++)
            if (a[i] == 1)
                count++;
        System.out.println(count);
    }

    static void binarySearchMtd(int a[])
    {
        int first, last;
        if (a[0] == 0)
        {
            System.out.println(0); 
            return; 
        }
        else
            first = 0;

        last = getLast(a, 0, a.length-1, 1);

        System.out.println(last - first + 1);
    }

    static int getLast(int a[], int start, int end, int x)
    {
        if (a[end] == x)
            return end;

        while (start <= end)
        {
            int mid = start + (end - start) / 2;

            if (a[mid] == 1)
            {
                if (mid == end || a[mid+1] == 0)
                    return mid;
                else
                    start = mid+1;
            }
            else
                end = mid-1;
        }
        return -1;
    }
}

