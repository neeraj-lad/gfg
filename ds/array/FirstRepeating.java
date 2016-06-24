import java.io.*;
import java.util.*;

class FirstRepeating
{
    public static void main(String args[])throws IOException
    {
       int a[] = {5, 2, 3, 5, 1, 2, 4};
       printArray(a);
       bFMtd(a);
       hashMtd(a);
    }

    static void printArray(int a[])
    {
        for (int i = 0; i < a.length; i++)
            System.out.print(a[i] + " ");
        System.out.println();
    }

    static void bFMtd(int a[])
    {
        int firstRep = -1;
        boolean flag = true;
        for (int i = 0; i < a.length && flag; i++)
            for (int j = i+1; j < a.length; j++)
                if (a[i] == a[j])
                {
                    firstRep = i;
                    flag = false;
                    break;
                }

        if (firstRep == -1)
            System.out.println("There are no repeating elements");
        else
            System.out.println("The first repeating element is " + a[firstRep]);
    }

    static void hashMtd(int a[])
    {
        int firstRep = -1;
        Set<Integer> hs = new HashSet<Integer>();
        for (int i = 0; i < a.length; i++)
            if (hs.contains(a[i]))
            {
                firstRep = i;
                break;
            }
            else
                hs.add(a[i]);
    
        if (firstRep == -1)
            System.out.println("There are no repeating elements");
        else
            System.out.println("The first repeating element is " + a[firstRep]);
    }
}

