import java.io.*;
import java.util.*;

class NearlySortedArr
{
    public static void main(String args[])throws IOException
    {
       int a[] = {2, 6, 3, 12, 56, 8};
       int k = 3;
       printArray(a);
       insertionSort(a);
       int b[] = {2, 6, 3, 12, 56, 8};
       printArray(b);
       heapMtd(b, k);
    }

    static void printArray(int a[])
    {
        for (int i = 0; i < a.length; i++)
            System.out.print(a[i] + " ");
        System.out.println();
    }

    static void insertionSort(int a[])
    {
        for (int i = 1; i < a.length; i++)
        {
            int x = a[i];
            int j = i-1;

            while (j >= 0 && a[j] > x)
            {
                a[j+1] = a[j];
                j--;
            }
            a[j+1] = x;
        }
       printArray(a);
    }

    static void heapMtd(int a[], int k)
    {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        int n = a.length;
        for (int i = 0; i <= k; i++)
            pq.add(a[i]);

        for (int i = 0; i < n; i++)
        {
            a[i] = pq.poll();
            if (i+k < n)
                pq.add(a[i+k]);
        }
        printArray(a);
    }
}

