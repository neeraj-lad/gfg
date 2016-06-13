import java.io.*;
import java.util.*;

class Node
{
    int data;
    int count;
    Node left;
    Node right;

    Node(int d)
    {
        data = d;
        count = 1;
    }
}

class BST
{
    Node root;
    int total;
    int majority;

    BST(int n)
    {
        total = n; 
        majority = -1;
    }

    Node insert(Node root, int data)
    {
        if (root == null)
        {
            Node n =  new Node(data);
            if (n.count > total / 2)
            {
                majority = n.data;
            }
            return n;
        }
        else
        {
            if (root.data > data)
            {
                root.left = insert(root.left, data); 
            }
            else
            if (root.data < data)
            {
                root.right = insert(root.right, data); 
            }
            else
            {
                root.count = root.count + 1;
                if (root.count > total / 2)
                {
                    majority = root.data;
                }
            }
            return root;
        }
    }

    void inorderTraversal(Node root)
    {
        if (root != null)
        {
            inorderTraversal(root.left);
            System.out.println(root.data + " " + root.count);
            inorderTraversal(root.right);
        }
    }

    void printMajority()
    {
        if (majority > -1)
            System.out.println("Majority element is: " + majority);
        else
            System.out.println("There is No Majority element");
    }
}

class MajorityElement
{
    public static void main(String args[])throws IOException
    {
       int a[] = {1, 2, 3, 1, 1, 1, 4};
       
       BST bst = new BST(a.length);
       for (int i = 0; i < a.length; i++)
           bst.root = bst.insert(bst.root, a[i]);
       bst.printMajority();

       mooresMtd(a);
    }

    static void mooresMtd(int a[])
    {
        if (a.length == 0)
            return;

        int max = a[0], count = 1;
        for (int i = 1; i < a.length; i++)
        {
            if (a[i] == max)
                count++;
            else
                count--;
            if (count == 0)
            {
                max = a[i];
                count = 1; 
            }
        }

        int maxCount = 0;
        for (int i = 0; i < a.length; i++)
            if (a[i] == max)
                maxCount++;

        if (maxCount > a.length/2)
            System.out.println("Majority element is: " + max);
        else
            System.out.println("There is No Majority element");
    }
}

