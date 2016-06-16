import java.io.*;
import java.util.*;

class SmallestMissingNo
{
    public static void main(String args[])throws IOException
    {
       int a[] = {0, 1, 2, 4, 6, 7, 8, 9};
       System.out.println("Smallest Missing Number is: " + binarySearchMtd(a, 0, a.length-1));

       int b[] = {};
       System.out.println("Smallest Missing Number is: " + binarySearchMtd(b, 0, b.length-1));
    }

    static int binarySearchMtd(int a[], int start, int end)
    {
        if (a.length == 0)
            return -1;

        if (start > end)
            return end+1;

        if (a[start] != start)
            return start;

        int mid = (start + end) / 2;

        if (a[mid] > mid)
            return binarySearchMtd(a, start, mid);
        else
            return binarySearchMtd(a, mid+1, end);
    }
}

