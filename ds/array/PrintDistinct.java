import java.io.*;
import java.util.*;

class PrintDistinct
{
    public static void main(String args[])throws IOException
    {
       int a[] = {2, 3, 7, 8, 9, 7, 3, 2};
       printArray(a);
       bFMtd(a);
       sortMtd(a);
       setMtd(a);
    }

    static void printArray(int a[])
    {
        for (int i = 0; i < a.length; i++)
            System.out.print(a[i] + " ");
        System.out.println();
    }

    static void bFMtd(int a[])
    {
        for (int i = 0; i < a.length; i++)
        {
            int j;
            for (j = 0; j < i; j++)
                if (a[j] == a[i])
                    break;
            if (j == i)
                System.out.print(a[j] + " ");
        }
        System.out.println();
    }

    static void sortMtd(int a[])
    {
        Arrays.sort(a);

        int j = 0;
        for (int i = 0; i < a.length; i++)
            if (a[i] != a[j])
            {
                System.out.print(a[j] + " ");
                j = i;
            }
        System.out.println(a[j]);
    }

    static void setMtd(int a[])
    {
        Set<Integer> lhs = new LinkedHashSet<Integer>();

        for (int i = 0; i < a.length; i++)
            lhs.add(a[i]);

        for (int i : lhs)
            System.out.print(i + " ");
        System.out.println();
    }
}

