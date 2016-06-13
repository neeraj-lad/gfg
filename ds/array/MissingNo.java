import java.io.*;
import java.util.*;

class MissingNo
{
    public static void main(String args[])throws IOException
    {
       int a[] = {1, 2, 3, 4, 5, 6, 8, 9, 10, 11}; 

       sumMtd(a);
       xorMtd(a);
    }

    static void sumMtd(int a[]) 
    {
        int n = a.length + 1;
        int sum = (n * (n + 1)) / 2;
        int tot = 0;
        for (int i = 0; i < n-1; i++)
            tot += a[i];

        System.out.println("Missing number is: " + (sum - tot));
    }

    static void xorMtd(int a[])
    {
        int n = a.length + 1;
        int xor = 1;
        for (int i = 2; i <= n; i++)
            xor ^= i;

        int aXor = a[0];
        for (int i = 1; i < n-1; i++)
            aXor ^= a[i];

        System.out.println("Missing number is: " + (xor ^ aXor));
    }
}

