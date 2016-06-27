import java.io.*;
import java.util.*;

class FindZeroToFlip
{
    public static void main(String args[])throws IOException
    {
       int a[] = {1, 1, 0, 0, 1, 0, 1, 1, 1, 0, 1, 1, 1};
       printArray(a);
       bFMtd(a);
       slidingWindowMtd(a);
    }

    static void printArray(int a[])
    {
        for (int i = 0; i < a.length; i++)
            System.out.print(a[i] + " ");
        System.out.println();
    }

    static void bFMtd(int a[])
    {
        int maxLen = Integer.MIN_VALUE, zeroPos = -1;
        for (int i = 0; i < a.length; i++)
            if (a[i] == 0)
            {
                int l, r, onesLeft, onesRight;
                l = i-1;
                r = i+1;
                onesLeft = onesRight = 0;

                while (l >= 0)
                {
                    if (a[l] == 1)
                        onesLeft++;
                    else
                        break;
                    l--;
                }

                while (r < a.length)
                {
                    if (a[r] == 1)
                        onesRight++;
                    else
                        break;
                    r++;
                }

                if (maxLen < onesLeft + 1 + onesRight)
                {
                    zeroPos = i;
                    maxLen = onesLeft + 1 + onesRight;
                }
            }
        System.out.println("Flip zero at " + zeroPos + " to get max length of " + maxLen);
    }

    static void slidingWindowMtd(int a[])
    {
        int l, r, startPos, zeroCount, maxLen;
        l = r = zeroCount = 0;
        startPos = -1;
        maxLen = Integer.MIN_VALUE;

        while (r < a.length)
        {
            if (zeroCount <= 1)
            {
                if (a[r] == 0)
                    zeroCount++;
                r++;
            }

            if (zeroCount > 1)
            {
                if (a[l] == 0)
                    zeroCount--;
                l++;
            }

            if (maxLen < r - l)
            {
                startPos = l;
                maxLen = r - l;
            }
        }

        for (int i = 0; i < maxLen; i++)
            if (a[startPos + i] == 0)
                System.out.println("Flip zero at " + (startPos + i) + " to get max length of " + maxLen);
    }
}

