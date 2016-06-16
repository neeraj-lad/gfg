import java.io.*;
import java.util.*;

class PrintDuplicate
{
    public static void main(String args[])throws IOException
    {
       String s = "geeks for geeks";
       System.out.println(s);
       mapMtd(s);
    
       String s1 = "";
       System.out.println(s1);
       mapMtd(s1);
 
    }

    static void mapMtd(String s)
    {
        int count[] = new int[256];

        for (int i = 0; i < s.length(); i++)
            count[s.charAt(i)]++;

        for (int i = 0; i < count.length; i++)
            if (count[i] > 1)
                System.out.print((char)i + " = " + count[i] + ", "); 
        System.out.println();
    }
}

