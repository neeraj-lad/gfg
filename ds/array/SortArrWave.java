import java.io.*;
import java.util.*;

class SortArrWave
{
    public static void main(String args[])throws IOException
    {
       int a[] = {2, 3, 1, 5, 4, 3};
       printArray(a);
       sortMtd(a);
       System.out.println("***");
       int b[] = {8, 3, 9, 10, 7, 5, 1};
       printArray(b);
       linearMtd(b);
    }

    static void printArray(int a[])
    {
        for (int i = 0; i < a.length; i++)
            System.out.print(a[i] + " ");
        System.out.println();
    }

    static void swap(int a[], int x, int y)
    {
        int t = a[x];
        a[x] = a[y];
        a[y] = t;
    }

    static void sortMtd(int a[])
    {
        Arrays.sort(a);

        for (int i = 0; i < a.length-1; i += 2)
            swap(a, i, i+1);

        printArray(a);
    }

    static void linearMtd(int a[])
    {
        for (int i = 0; i < a.length; i += 2)
        {
            if (i > 0 && a[i] < a[i-1])
                swap(a, i, i-1);
            if (i < a.length-1 && a[i] < a[i+1])
                swap(a, i, i+1);
        }
        printArray(a);
    }
}

