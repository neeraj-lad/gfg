import java.io.*;
import java.util.*;

class RemoveDuplicate
{
    public static void main(String args[])throws IOException
    {
       String s = "Time is Money";
       System.out.println(s);

       String s1 = sortMtd(s);
       System.out.println(s1);

       String s2 = mapMtd(s);
       System.out.println(s2);
    }

    static String sortMtd(String s)
    {
        char cs[] = s.toCharArray();
        Arrays.sort(cs);
        StringBuilder sortedS = new StringBuilder(new String(cs));
        int i = 1; 
        while (i < sortedS.length())
        {
            if (sortedS.charAt(i) == sortedS.charAt(i-1))
                sortedS = sortedS.deleteCharAt(i);
            else
                i++;
        }
                 // " ieMmnosTy"
        return sortedS.toString();
    }

    static String mapMtd(String s)
    {
        int count[] = new int[256];

        char cs[] = s.toCharArray();

        int i = 0, j = 0;
        while (i < cs.length)
        {
            if (count[cs[i]] == 0)
            {
                count[cs[i]] = 1;
                cs[j] = cs[i];
                j++;
            }
            i++;
        }
        while (j < cs.length)
            cs[j++] = ' ';

        String res = new String(cs);
                  // "Time sMony"
        return res.trim();
    }
}

