import java.io.*;
import java.util.*;

class LSCS
{
    public static void main(String args[])throws IOException
    {
       int a[] = {1, 3, -2, 1, -1, 5, 2, -3};
       printArray(a);
       System.out.println("LSCS is: " + kadane(a));

       int b[]  = {-1, -2, -3, -4, -5};
       printArray(b);
       System.out.println("LSCS is: " + allNegative(b));

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

    static int kadane(int a[])
    {
        int max_here = 0;
        int max_all = 0;
        for (int i = 0; i < a.length; i++)
        {
            max_here += a[i];
            if (max_here + a[i] < 0)
                max_here = 0;
            else
            if (max_here > max_all)
                max_all = max_here;
        }

        return max_all;
    }

    static int allNegative(int a[])
    {
        if (a.length == 0)
            return -1;
        int max_here = a[0];
        int max_all = a[0];
        for (int i = 1; i < a.length; i++)
        {
            max_here = Math.max(a[i], max_here+a[i]);
            max_all = Math.max(max_all, max_here);
        }
        return max_all;
    }
}

