import java.io.*;
import java.util.*;

class FloorCeil
{
    public static void main(String args[])throws IOException
    {
       int a[] = {1, 2, 8, 10, 10, 12, 19}; 
       int x = 20;

       linearMtd(a, x);
       binaryMtd(a, x);
    }

    static void linearMtd(int a[], int x)
    {
        if (a.length < 1)
        {
            System.out.println("Insufficient elements (less than 1)");
            return;
        }

        int floor = linearFloor(a, x);
        int ceil = linearCeil(a, x);

        System.out.println("For X = " + x + " Floor = " + floor + " and Ceil = " + ceil);
    }

    static int linearFloor(int a[], int x)
    {
        if (x >= a[a.length-1])
            return a[a.length-1];

        for (int i = a.length-1; i > 0; i--)
        {
            if (a[i] == x)
                return a[i];

            if (a[i] > x && a[i-1] <= x)
                return a[i-1];
        }

        return -1;
    }

    static int linearCeil(int a[], int x)
    {
        if (x <= a[0])
            return a[0];

        for (int i = 0; i < a.length-1; i++)
        {
            if (a[i] == x)
                return a[i];
            if (a[i] < x && a[i+1] >= x)
                return a[i+1];
        }
        return -1;
    }

    static void binaryMtd(int a[], int x)
    {
        if (a.length < 1)
        {
            System.out.println("Insufficient elements (less than 1)");
            return;
        }

        int floor = binaryFloor(a, 0, a.length-1, x);
        int ceil = binaryCeil(a, 0, a.length-1, x);
        
        System.out.println("For X = " + x + " Floor = " + floor + " and Ceil = " + ceil);
    }

    static int binaryFloor(int a[], int low, int high, int x)
    {
        if (x >= a[high])
            return a[high];
        if (x < a[low])
            return -1;

        int mid = (low + high) / 2;

        if (a[mid] == x)
            return a[mid];
        else
        if (a[mid] < x)
        {
            if (mid + 1 < high && a[mid+1] > x)
                return a[mid];
            else
                return binaryFloor(a, mid+1, high, x);
        }
        else
        {
            if (mid - 1 > low && a[mid-1] <= x)
                return a[mid-1];
            else
                return binaryFloor(a, low, mid-1, x);
        }
    }

    static int binaryCeil(int a[], int low, int high, int x)
    {
        if (x <= a[low])
            return a[low];
        if (x > a[high])
            return -1;

        int mid = (low + high) / 2;

        if (a[mid] == x)
            return a[mid];
        else
        if (a[mid] < x)
        {
            if (mid + 1 < high && a[mid+1] >= x)
                return a[mid+1];
            else 
                return binaryCeil(a, mid+1, high, x);
        }
        else
        {
            if (mid - 1 > low && a[mid-1] < x)
                return a[mid];
            else
                return binaryCeil(a, low, mid-1, x);
        }
    }
}

