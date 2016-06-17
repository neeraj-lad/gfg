import java.io.*;
import java.util.*;

class CountSortedArray
{
    public static void main(String args[])throws IOException
    {
       int a[] = {1, 2, 3, 3, 3, 3, 4, 4, 5, 6, 6, 6};
       int x = 6;
       printArray(a);
       System.out.println("Count of x = " + x + " in Array a[] is: " + countSortedArray(a, x));
    }

    static void printArray(int a[])
    {
        if (a.length == 0)
        {
            System.out.println("Emtpy Array");
            return;
        }

        for (int i = 0; i < a.length; i++)
            System.out.print(a[i] + " ");
        System.out.println();
    }

    static int countSortedArray(int a[], int x)
    {
        int i, j;

        i = getMinPos(a, x);

        if (i == -1)
            return -1;

        j = getMaxPos(a, x);

        return j - i + 1;
    }

    static int getMinPos(int a[], int x)
    {
        int start = 0, end = a.length-1;
        while (start <= end)
        {
            int mid = start + (end - start) / 2;

            if ((mid ==  0 || a[mid-1] < x) && a[mid] == x)
                return mid;
            else
            if (a[mid] >= x)
                end = mid-1;
            else
                start = mid+1;
        }
        return -1;
    }

    static int getMaxPos(int a[], int x)
    {
        int start = 0, end = a.length-1;
        while (start <= end)
        {
            int mid = start + (end - start) / 2;

            if ((mid == a.length-1 || a[mid+1] > x) && a[mid] == x)
                return mid;
            else
            if (a[mid] <= x)
                start = mid+1;
            else
                end = mid-1;
        }
        return -1;
    }
}

