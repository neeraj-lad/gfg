import java.util.*;

class Node
{
	int data;
	Node left, right;

	Node (int d)
	{
		data = d;
		left = right = null;	
	}
}

class BinaryTree
{
	Node root;

	BinaryTree ()
	{
		root = null;	
	}
}

class IterativeInorder
{
	public static void main(String args[])
	{
		BinaryTree bt = new BinaryTree();
		bt.root = new Node(1);
		bt.root.left = new Node(2);
		bt.root.right = new Node(3);
		bt.root.left.left = new Node(4);
		bt.root.left.right = new Node(5);

		printIterativeInorder(bt.root);	
	}

	static void printIterativeInorder(Node root)
	{
		Stack<Node> st = new Stack<Node>();
		Node current = root;
		while (true)
		{
			while (current != null)
			{
				st.push(current);
				current = current.left;
			}
			if (st.size() == 0)
				break;
			current = st.pop();
			System.out.print(current.data + " ");
			current = current.right;	
		}	
		System.out.println();
	}
}

