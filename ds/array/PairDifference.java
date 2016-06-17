import java.io.*;
import java.util.*;

class PairDifference
{
    public static void main(String args[])throws IOException
    {
       int a[] = {1, 11, 30, 40, 100};
       int diff = 29;
       printArray(a);
       bFMtd(a, diff);
       sortMtd(a, diff);
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

    static void bFMtd(int a[], int diff)
    {
        for (int i = 0; i < a.length-1; i++)
            for (int j = i+1; j < a.length; j++)
                if (Math.abs(a[i] - a[j]) == diff)
                {
                    System.out.println("Pair subtracting to " + diff + " is: " + a[i] + ", and " + a[j]);
                    return;
                }
        System.out.println("Pair subtracting to " + diff + " does not exist in the array");
    }

    static void sortMtd(int a[], int diff)
    {
        Arrays.sort(a);

        int i = 0, j = 1;
        while (i < a.length && j < a.length)
        {
            if (a[j] - a[i] == diff)
            {
                System.out.println("Pair subtracting to " + diff + " is: " + a[i] + ", and " + a[j]);
                return;
            }
            else
            if (a[j] - a[i] < diff)
                j++;
            else
                i++;
        }
        System.out.println("Pair subtracting to " + diff + " does not exist in the array");
    }
}

