import java.io.*;
import java.util.*;

class ArrayToZigZag
{
    public static void main(String args[])throws IOException
    {
       int a[] = {4, 5, 8, 3, 2, 7};
       printArray(a);
       sortMtd(a);
       printArray(a);
       linearMtd(a);
       printArray(a);
    }

    static void printArray(int a[])
    {
        for (int i = 0; i < a.length; i++)
            System.out.print(a[i] + " ");
        System.out.println();
    }

    static void swap(int a[], int i, int j)
    {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    static void sortMtd(int a[])
    {
        Arrays.sort(a);
        for (int i = 1; i < a.length-2; i += 2)
            swap(a, i, i+1);
    }
    
    static void linearMtd(int a[])
    {
        boolean less = true;
        for (int i = 0; i < a.length-1; i++)
            if (less)
            {
                if (a[i] > a[i+1])
                    swap(a, i, i+1);
            }
            else
            {
                if (a[i] < a[i+1])
                    swap(a, i, i+1);
            }
    }
}

