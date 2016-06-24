import java.io.*;
import java.util.*;

class Intersection3Arr
{
    public static void main(String args[])throws IOException
    {
       int a[] = {1, 5, 10, 20, 40, 80};
       int b[] = {6, 7, 20, 80, 100};
       int c[] = {3, 4, 15, 20, 30, 70, 80, 120};
       printArray(a);
       printArray(b);
       printArray(c);
       bFMtd(a, b, c);
       linearMtd(a, b, c);
    }

    static void printArray(int a[])
    {
        for (int i = 0; i < a.length; i++)
            System.out.print(a[i] + " ");
        System.out.println();
    }

    static void bFMtd(int a[], int b[], int c[])
    {
        for (int i = 0; i < a.length; i++)
            for (int j = 0; j < b.length; j++)
                for (int k = 0; k < c.length; k++)
                    if (a[i] == b[j] && b[j] == c[k])
                        System.out.print(a[i] + " ");

        System.out.println();
    }

    static void linearMtd(int a[], int b[], int c[])
    {
        int i = 0, j = 0, k = 0;
        int m = a.length, n = b.length, o = c.length;

        while (i < m && j < n && k < o)
        {
            if (a[i] == b[j] && b[j] == c[k])
            {
                System.out.print(a[i++] + " ");
                j++;
                k++;
            }
            else
            if (a[i] < b[j])
                i++;
            else
            if (b[j] < c[k])
                j++;
            else
                k++;
        }

        System.out.println();
    }
}

