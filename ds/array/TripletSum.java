import java.io.*;
import java.util.*;

class TripletSum
{
    public static void main(String args[])throws IOException
    {
       int a[] = {1, 4, 45, 6, 10, 8};
       int sum = 22;
       printArray(a);
       bFMtd(a, sum);
       sortMtd(a, sum);
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

    static void bFMtd(int a[], int sum)
    {
        for (int i = 0; i < a.length-2; i++)
            for (int j = i+1; j < a.length-1; j++)
                for (int k = j+1; k < a.length; k++)
                    if (a[i] + a[j] + a[k] == sum)
                    {
                        System.out.println("Triplet adding to " + sum + " is: " + a[i] + ", " + a[j] + ", and " + a[k]);
                        return;
                    }
        System.out.println("Triplet adding to " + sum + " is not present in the given array");
    }

    static void sortMtd(int a[], int sum)
    {
        Arrays.sort(a);

        for (int i = 0; i < a.length-2; i++)
        {
            int left = i+1, right = a.length-1;
            while (left < right)
            {
                if (a[i] + a[left] + a[right] == sum) 
                {
                    System.out.println("Triplet adding to " + sum + " is: " + a[i] + ", " + a[left] + ", and " + a[right]);
                    return;
                }
                else
                if (a[i] + a[left] + a[right] < sum)
                    left++;
                else
                    right--;
            }
        }
        
        System.out.println("Triplet adding to " + sum + " is not present in the given array");
    }
}

