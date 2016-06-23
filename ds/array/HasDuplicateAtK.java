import java.io.*;
import java.util.*;

class HasDuplicateAtK
{
    public static void main(String args[])throws IOException
    {
       int a[] = {1, 2, 3, 1, 4, 5, 4, 6};
       int k = 2;
       printArray(a);
       System.out.println("Array has duplicate within " + k + " places?: " + hasDuplicateAtK(a, k));
    }

    static void printArray(int a[])
    {
        for (int i = 0; i < a.length; i++)
            System.out.print(a[i] + " ");
        System.out.println();
    }

    static boolean hasDuplicateAtK(int a[], int k)
    {
        Set<Integer> hs = new HashSet<Integer>();
        for (int i = 0; i < a.length; i++)
        {
            if (hs.contains(a[i]))
                return true;

            hs.add(a[i]);

            if (i >= k)
                hs.remove(a[i-k]);
        }
        return false;
    }
}

