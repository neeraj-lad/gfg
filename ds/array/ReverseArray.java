import java.io.*;
import java.util.*;

class ReverseArray
{
    public static void main(String args[])throws IOException
    {
       int a[] = {1, 2, 3, 4, 5, 6};
       printArray(a);

       reverse(a);
       printArray(a);
       
       reverseRecursive(a, 0, a.length-1);
       printArray(a);
    }

    static void reverse(int a[])
    {
        int start = 0, end = a.length-1;
        while (start < end)
        {
            int t = a[start];
            a[start++] = a[end];
            a[end--] = t;
        }
    }

    static void reverseRecursive(int a[], int start, int end)
    {
        if (start < end)
        {
            int t = a[start];
            a[start] = a[end];
            a[end] = t;

            reverseRecursive(a, start+1, end-1);
        }
    }

    static void printArray(int a[])
    {
        for (int i = 0; i < a.length; i++)
            System.out.print(a[i] + " ");
        System.out.println();
    }
}

