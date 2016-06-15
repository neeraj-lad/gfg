import java.io.*;
import java.util.*;

class Node
{
    int data;
    Node left, right;

    Node(int d)
    {
        data = d; 
    }
}

class BST
{
    Node root;

    Node insert(Node root, int data)
    {
        if (root == null)
            return new Node(data);
        else
        {
            if (root.data >= data)
                root.left = insert(root.left, data);
            else
                root.right = insert(root.right, data);
        }
        return root;
    }

    void addArray(int a[])
    {
        for (int i = 0; i < a.length; i++)
            root = insert(root, a[i]);
    }

   void leaders(Node root)
   {
        if (root != null)
        {
            leaders(root.left);
            if (root.right == null)
                System.out.print(root.data + " ");
            leaders(root.right);
        }
   }
}

class Leaders
{
    public static void main(String args[])throws IOException
    {
        int a[] = {17, 1, 2, 3, 11, 5, 6, 8, 7, 5};
        leadersBF(a);
        leadersMax(a);
        
        BST bst = new BST();
        bst.addArray(a);
        bst.leaders(bst.root);
        System.out.println();
    }

    static void leadersBF(int a[])
    {
        if (a.length == 0)
        {
            System.out.println("There are no Leaders in an Empty array");
            return;
        }

        for (int i = 0; i < a.length; i++)
        {
            int j = i+1;
            for (; j < a.length; j++)
                if (a[i] <= a[j])
                    break;
            if (j == a.length)
                System.out.print(a[i] + " ");
        }
        System.out.println();
    }

    static void leadersMax(int a[])
    {
        if (a.length == 0)
        {
            System.out.println("There are no Leaders in an Empty array");
            return;
        }

        int max = a[a.length-1];
        System.out.print(max + " ");
        for (int i = a.length-2; i >= 0; i--)
            if (a[i] > max)
            {
                max = a[i];
                System.out.print(max + " ");
            }
        System.out.println();
    }
}

