import java.io.*;
import java.util.*;

class MoveZeroEnd
{
    public static void main(String args[])throws IOException
    {
        int a[] = {1, 0, 9, 0, 0, 8, 2, 3, 0, 0}; 
        printArray(a);
        shiftMtd(a);
       
        int b[] = {0, 1, 0, 0, 9, 7, 0, 8, 2, 3, 0, 0}; 
        printArray(b);
        swapMtd(b);
    }

    static void printArray(int a[])
    {
        for (int i = 0; i < a.length; i++)
            System.out.print(a[i] + " ");
        System.out.println();
    }

    static void shiftMtd(int a[])
    {
        int j = 0;
        for (int i = 0; i < a.length; i++)
            if (a[i] != 0)
                a[j++] = a[i];
        for (; j < a.length; j++)
            a[j] = 0;
        
        printArray(a);
    }

    static void swapMtd(int a[])
    {
        int i = 0, j = a.length-1;
        while (i < j)
        {
            while (a[i] != 0)
                i++;
            while (a[j] == 0)
                j--;
            if (i < j)
            {
                int t = a[i];
                a[i] = a[j];
                a[j] = t;
            }
        }
        printArray(a);
    }
}

