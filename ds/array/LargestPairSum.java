import java.io.*;
import java.util.*;

class LargestPairSum
{
    public static void main(String args[])throws IOException
    {
       int a[] = {13, 5, 8, 9, 2, 10};
       printArray(a);
       System.out.println("Largest Pair Sum: " + largestPairSum(a));
    }

    static void printArray(int a[])
    {
        for (int i = 0; i < a.length; i++)
            System.out.print(a[i] + " ");
        System.out.println();
    }

    static int largestPairSum(int a[])
    {
        if (a.length < 2)
            return -1;

        int first = Math.max(a[0], a[1]);
        int second = Math.min(a[0], a[1]);

        for (int i = 2; i < a.length; i++)
            if (a[i] > first)
            {
                second = first;
                first = a[i];
            }
            else
            if (a[i] > second)
                second = a[i];

        return first + second;
    }
}

