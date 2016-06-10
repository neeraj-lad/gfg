import java.io.*;
import java.util.Stack;

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
    Node r;

    void insert(Node root, int data)
    {
        Node n = new Node(data);

        if (root == null)
        {
            root = n;
         //   System.out.println(root + " " + this.root);
        }
        else
        if (root.data > data)
        {
            if (root.left == null)
                root.left = n;
            else
                insert(root.left, data);
        }
        else
        {
            if (root.right == null)
                root.right = n;
            else
                insert(root.right, data);
        }
    }

    Node search(Node root, int data)
    {
        if (root == null || root.data == data)
            return root;
        if (root.data > data)
            return search(root.left, data);
        else
            return search(root.right, data);
    }

    void inorderTraversal(Node root)
    {
        System.out.println("Inorder traversal of BST: ");
        System.out.print("[");
        if (root == null)
        {
            System.out.println("]");
            return;
        }
       
        Stack<Node> st = new Stack<Node>();

        while (true)
        {
            while (root.left != null)
            {
                st.push(root);
                root = root.left;
            }
            if (st.size() == 0)
                break;
            root = st.pop();
            System.out.print(root.data + " ");
            root = root.right;
        }
        System.out.println("]");
    }
}

class InsertSearch
{
    public static void main(String args[])throws IOException
    {
       BST bst = new BST(); 

       bst.insert(bst.r, 20);
       System.out.println(bst.r);
       bst.insert(bst.r, 13);
       bst.insert(bst.r, 23);
       bst.insert(bst.r, 29);
       bst.insert(bst.r, 30);
       bst.insert(bst.r, 10);
       bst.insert(bst.r, 07);

       System.out.println(bst.r);
       bst.inorderTraversal(bst.r);

//       System.out.println("Node with data 7 has value: " + bst.search(bst.root, 7).data);
    }
}

