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

	void getMax(Node root, Node max)
	{
		if (root != null)
		{
			getMax(root.left, max);
			if (root.data > max.data)
				max.data = root.data;
			getMax(root.right, max);	
		}	
	}

	void inorderTraversal(Node root)
	{
		if (root != null)
		{
			inorderTraversal(root.left);
			System.out.print(root.data + " ");
			inorderTraversal(root.right);	
		}	
	}
}

class GetMax
{
	public static void main(String args[])
	{
		BinaryTree bt = new BinaryTree();
		bt.root = new Node(14);
		bt.root.left = new Node(2);
		bt.root.right = new Node(32);
		bt.root.left.left = new Node(53);
		bt.root.left.right = new Node(23);
		bt.root.right.left = new Node(54);

		bt.inorderTraversal(bt.root);
		System.out.println();

		Node max = new Node(Integer.MIN_VALUE);
		bt.getMax(bt.root, max);
		System.out.println("Max value is: " + max.data);
	}
}

