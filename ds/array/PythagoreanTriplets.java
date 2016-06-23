import java.io.*;
import java.util.*;

class PythagoreanTriplets
{
    public static void main(String args[])throws IOException
    {
       int a[] = {3, 1, 4, 6, 5};
       System.out.println("Has Pythagorean Triplets?: " + hasPythaTriplets(a));
    }

    static boolean hasPythaTriplets(int a[])
    {
        for (int i = 0; i < a.length; i++)
            a[i] = a[i] * a[i];

        Arrays.sort(a);

        for (int i = a.length-1; i >= 2; i--)
        {
            int l = 0, r = i-1;
            while (l < r)
            {
                if (a[l] + a[r] == a[i])
                    return true;
                else
                if (a[l] + a[r] > a[i])
                    r--;
                else
                    l++;
            }
        }
        return false;
    }
}

