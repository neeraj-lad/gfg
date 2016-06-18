import java.io.*;
import java.util.*;

class NextGreatest
{
    public static void main(String args[])throws IOException
    {
       int a[] = {3, 2, 5, 6, 1, 3, 7};
       printArray(a);
       bFMtd(a);
       stackMtd(a);
    }

    static void printArray(int a[])
    {
        if (a.length == 0)
        {
            System.out.println("Empty Array");
            return;
        }

        for (int i = 0; i < a.length; i++)
            System.out.print(a[i] + " ");
        System.out.println();
    }

    static void bFMtd(int a[])
    {
        if (a.length == 0)
        {
            System.out.println("Empty Array");
            return;
        }


        for (int i = 0; i < a.length; i++)
        {

                 int ng = -1;
            for (int j = i+1; j < a.length; j++)
                if (a[i] < a[j])
                {
                    ng = a[j];
                    break;
                }
            System.out.println(a[i] + " -> " + ng);
        }
    }

    static void stackMtd(int a[])
    {
        if (a.length == 0)
        {
            System.out.println("Empty Array");
            return;
        }

        Stack<Integer> st = new Stack<Integer>();

        st.push(a[0]);

        for (int i = 1; i < a.length; i++)
        {
            int ng = a[i];

            if (st.size() > 0)
            {
                int t = st.pop();

                while (t < ng)
                {
                    System.out.println(t + " -> " + ng);
                    if (st.size() == 0)
                        break;
                    t = st.pop();
                }

                if (t >= ng)
                    st.push(t);
            }

            st.push(ng);
        }

        while (st.size() > 0)
        {
            System.out.println(st.pop() + " -> " + -1);
        }
    }
}

