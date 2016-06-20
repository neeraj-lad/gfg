import java.io.*;
import java.util.*;

class MergeTwoArrays
{
    public static void main(String args[])throws IOException
    {
       int a[] = {1, -1, 4, -1, 7, -1, -1, 13, 15};
       int b[] = {3, 6, 10, 17};
       printArray(a);
       shift(a);
       printArray(a);
       merge(a, b);
       printArray(a);
    }

    static void printArray(int a[])
    {
        for (int i = 0; i < a.length; i++)
            System.out.print(a[i] + " ");
        System.out.println();
    }

    static void shift(int a[])
    {
        int j = a.length-1;
        for (int i = a.length-1; i >= 0; i--)
            if (a[i] != -1)
                a[j--] = a[i];
    }

    static void merge(int a[], int b[])
    {
        int i = b.length, j = 0, k = 0;
        while (k < a.length)
            if ((i < a.length && a[i] <= b[j]) || j == b.length)
                a[k++] = a[i++];
            else
                a[k++] = b[j++];
    }
}

