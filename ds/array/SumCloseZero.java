import java.io.*;
import java.util.*;

class SumCloseZero
{
    public static void main(String args[])throws IOException
    {
       int a[] = {1, 60, -10, 70, -80, 85};
       bFMtd(a);
       sortMtd(a);
    }

    static void bFMtd(int a[])
    {
        if (a.length < 2)
        {
            System.out.println("Too few elements (less than 2)");
            return;
        }
        int minA = -1, minB = -1, minSum = Integer.MAX_VALUE;
        for (int i = 0; i < a.length-1; i++)
            for (int j = i+1; j < a.length; j++)
                if (minSum >= Math.abs(a[i] + a[j]))
                {
                    minSum = Math.abs(a[i] + a[j]);
                    minA = i; minB = j;
                }
    
        if (minA == -1 && minB == -1)
            System.out.println(a[0] + " " + a[1]);
        else
            System.out.println(a[minA] + " " + a[minB]);
    }

    static void sortMtd(int a[])
    {
        if (a.length < 2)
        {
            System.out.println("Too few elements (less than 2)");
            return;
        }

        Arrays.sort(a);

        int left = 0, right = a.length-1;
        int minA = 0, minB = a.length-1;
        int minSum = Integer.MAX_VALUE;

        while (left < right)
        {
            if (Math.abs(a[left] + a[right]) < Math.abs(minSum))
            {
                minSum = a[left] + a[right]; 
                minA = left; minB = right;
            } 

            if (minSum < 0)
                left++;
            else
                right--;
        }
            
        System.out.println(a[minA] + " " + a[minB]);
    }
}

