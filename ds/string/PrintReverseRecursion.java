import java.io.*;
import java.util.*;

class PrintReverseRecursion
{
    public static void main(String args[])throws IOException
    {
       String s = "Happy birthday!";
       System.out.println(s);
       printRev(s, s.length()-1);
       System.out.println();

       String s1 = "";
       System.out.println(s1);
       printRev(s1, s1.length()-1);
       System.out.println();
    }

    static void printRev(String s, int index)
    {
        if (index >= 0)
        {
            System.out.print(s.charAt(index));
            printRev(s, index-1);
        }
    }
}

