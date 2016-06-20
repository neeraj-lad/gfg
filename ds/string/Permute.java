import java.io.*;
import java.util.*;

class Permute
{
    public static void main(String args[])throws IOException
    {
       StringBuilder sb = new StringBuilder("ABC");
       permute(sb, 0, sb.length()-1);
    }
    
    static void permute(StringBuilder sb, int start, int end)
    {
        if (start == end)
            System.out.println(sb);
        else
            for (int i = start; i <= end; i++)
            {
                swap(sb, start, i);
                permute(sb, start+1, end);
                swap(sb, i, start);
            }
    }

    static void swap(StringBuilder sb, int a, int b)
    {
       char t = sb.charAt(a);
       sb.setCharAt(a, sb.charAt(b));
       sb.setCharAt(b, t);
    }
}

