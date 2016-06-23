import java.io.*;
import java.util.*;

class PrevNextMult
{
    public static void main(String args[])throws IOException
    {
       int a[] = {2, 3, 4, 5, 6};
       printArray(a);
       prevNextMult(a);
       printArray(a);

    }

    static void printArray(int a[])
    {
        for (int i = 0; i < a.length; i++)
            System.out.print(a[i] + " ");
        System.out.println();

    }

    static void prevNextMult(int a[])
    {
        if (a.length < 2)
            return;

        int prev = a[0], curr;
        a[0] = prev * a[1];
        for (int i = 1; i < a.length-1; i++)
        {
            curr = a[i];
            a[i] = prev * a[i+1];
            prev = curr;
        }
        a[a.length-1] = prev * a[a.length-1];
    }
}

