import java.io.*;
import java.util.*;

class ZeroFlipMaxOne
{
    public static void main(String args[])throws IOException
    {
       int a[] = {1, 0, 0, 1, 1, 0, 1, 0, 1, 1, 1};
       int m = 2;
       printArray(a);
       bFMtd(a, m);
       slidingWindowMtd(a, m);
    }

    static void printArray(int a[])
    {
        for (int i = 0; i < a.length; i++)
            System.out.print(a[i] + " ");
        System.out.println();
    }

    static void bFMtd(int a[], int m)
    {
        int maxLen = Integer.MIN_VALUE, start = 0;
        for (int i = 0; i < a.length; i++)
        {
            int zeroes = 0;
            for (int j = i; j < a.length; j++)
            {
                if (a[j] == 0)
                    zeroes++;
                
                if (zeroes <= m)
                {
                    if (j - i + 1 > maxLen)
                    {
                        maxLen = j - i + 1;
                        start = i;
                    }
                }
                else
                    break;
            }
        }

        for (int i = 0; i < maxLen; i++)
            if (a[start + i] == 0)
                System.out.print((start + i) + " ");
            System.out.println();
    }

    static void slidingWindowMtd(int a[], int m)
    {
        int left = 0, right = 0;
        int maxLen = Integer.MIN_VALUE, start = 0;
        int zeroes = 0;

        while (right < a.length)
        {
            if (zeroes <= m)
            {
                if (a[right] == 0)
                    zeroes++;
                right++;
            }

            if (zeroes > m)
            {
                if (a[left] == 0)
                    zeroes--;
                left++;
            }

            if (right - left > maxLen)
            {
                maxLen = right - left;
                start = left;
            }
        }

        for (int i = 0; i < maxLen; i++)
            if (a[start + i] == 0)
                System.out.print((start + i) + " ");
        System.out.println();
    }
}
