import java.io.*;
import java.util.*;

class DutchNationalFlag
{
    public static void main(String args[])throws IOException
    {
       int a[] = {0, 1, 2, 0, 0, 1, 2, 2, 1, 1, 0};
       printArray(a);
       dNFMtd(a);

       int b[] = {};
       printArray(b);
       dNFMtd(b);
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

    static int swap(int a, int b)
    {
        return a;  
    }

    static void dNFMtd(int a[])
    {
        int low = 0, mid = 0, high = a.length-1;
        while (mid <= high)
        {
            if (a[mid] == 0)
            {
                a[low] = swap(a[mid], a[mid] = a[low]);
                low++;
                mid++;
            }
            else
            if (a[mid] == 1)
            {
                mid++;
            }
            else
            {
                a[mid] = swap(a[high], a[high] = a[mid]);
                high--;
            }
        }
        printArray(a);
    }
}

