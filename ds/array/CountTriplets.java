import java.io.*;
import java.util.*;

class CountTriplets
{
    public static void main(String args[])throws IOException
    {
//        int a[] = {5, 4, 7, 3, 8};
        int a[] = {5, 1, 3, 4, 7};
        int sum = 12;
        printArray(a);
        System.out.println(countTriplets(a, sum));
    }

    static void printArray(int a[])
    {
        for (int i = 0; i < a.length; i++)
            System.out.print(a[i] + " ");
        System.out.println();
    }

    static int countTriplets(int a[], int sum)
    {
        Arrays.sort(a);

        int res = 0;
        for (int i = 0; i < a.length-2; i++)
        {
            int j = i+1, k = a.length-1;
            while (j < k)
            {
                if (a[i] + a[j] + a[k] < sum)
                {
                    res++;
                    j++;
                }
                else
                    k--;
            }
        }
        return res;
    }
}

