import java.io.*;
import java.util.*;

class UnionIntersection
{
    public static void main(String args[])throws IOException
    {
       int a[] = {1, 2, 5, 8, 9, 10};
       int b[] = {3, 5, 6, 8, 9};
       printArray(a);
       printArray(b);
       union(a, b);
       intersection(a, b);
    }

    static void printArray(int a[])
    {
        for (int i = 0; i < a.length; i++)
            System.out.print(a[i] + " ");
        System.out.println();
    }

    static void union(int a[], int b[])
    {
        System.out.println("Union is:");

        int i = 0, j = 0;
        int m = a.length, n = b.length;

        while (i < m && j < n)
        {
            if (a[i] < b[j])
                System.out.print(a[i++] + " ");
            else
            if (b[j] < a[i])
                System.out.print(b[j++] + " ");
            else
            {
                System.out.print(a[i++] + " ");
                j++;
            }
        }
        while (i < m)
            System.out.print(a[i++] + " ");
        while (j < n)
            System.out.print(b[j++] + " ");

        System.out.println();
    }
    
    static void intersection(int a[], int b[])
    {
        System.out.println("Intersection is:");

        int i = 0, j = 0;
        int m = a.length, n = b.length;

        while (i < m && j < n)
        {
            if (a[i] < b[j])
                i++;
            else
            if (b[j] < a[i])
                j++;
            else
            {
                System.out.print(a[i++] + " ");
                j++;
            }
        }

        System.out.println();
    }
}

