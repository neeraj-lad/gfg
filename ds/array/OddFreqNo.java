import java.io.*;
import java.util.*;

class OddFreqNo
{
    public static void main(String args[])throws IOException
    {
       int a[] = {1, 1, 2, 2, 3, 4, 4, 5, 5};

       hashMtd(a);
       xorMtd(a);
    }

    static void hashMtd(int a[])
    {
        Map<Integer, Integer> hm = new HashMap<Integer, Integer>();

        for (int i = 0; i < a.length; i++)
            if (hm.get(a[i]) == null)
                hm.put(a[i], 1);
            else
                hm.put(a[i], hm.get(a[i])-1);

        for (Map.Entry<Integer, Integer> entry : hm.entrySet())
            if (entry.getValue() == 1)
            {
                System.out.println(entry.getKey() + " occurs Odd number of times"); 
            }
    }

    static void xorMtd(int a[])
    {
        if (a.length == 0)
            return;

        int xor = a[0];
        for (int i = 1; i < a.length; i++)
            xor ^= a[i];

        System.out.println(xor + " occurs Odd number of times"); 
    }
}

