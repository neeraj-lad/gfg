import java.io.*;
import java.util.*;

class DeleteElem
{
    public static void main(String args[])throws IOException
    {
        int a[] = {3, 1, 2, 5, 90};
        int x = 2;
        printArray(a);
        singleTrav(a, x);
        printArray(a);
    }

    static void printArray(int a[])
    {
        for (int i = 0; i < a.length; i++)
            System.out.print(a[i] + " ");
        System.out.println();
    }

    static int doubleTrav(int a[], int x)
    {
        int i, n = a.length;
        for (i = 0; i < a.length; i++)
            if (a[i] == x)
                break;
        if (i == n)
            return n;

        n--;
        for (; i < a.length-1; i++)
            a[i] = a[i+1];

        return n;
    }

    static int singleTrav(int a[], int x)
    {
        int n = a.length; 

        if (a[n-1] == x)
            return n-1;

        int prev = a[n-1];
        int curr = a[n-2];
        int i;
        for (i = n-1; i >= 0 && a[i] != x; i--)
        {
            curr = a[i];
            a[i] = prev;
            prev = curr;
        }

        if (i < 0)
            return 0;

        a[i] = prev;

        return n-1;
    }
}

