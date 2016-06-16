import java.io.*;
import java.util.*;

class MaxChar
{
    public static void main(String args[])throws IOException
    {
       String s = "aaaaaabbbbcccbbbbbbccde";
       System.out.println("Max Char in s = " + s + " is: " + maxChar(s));

       String ss = "";
       System.out.println("Max Char in ss = " + ss + " is: " + maxChar(ss));
    }

    static char maxChar(String s)
    {
        int count[] = new int[256];
    
        for (int i = 0; i < s.length(); i++)
            count[s.charAt(i)]++;

        int max = -1;
        char maxChar = 0;
        for (int i = 0; i < count.length; i++)
            if (max < count[i])
            {
                max = count[i];
                maxChar = (char)i;
            }
        return maxChar;
    }
}

