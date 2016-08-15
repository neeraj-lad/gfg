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

	boolean printAncestor(Node root, int x)
	{
		if (root == null)
			return false;
		if (root.data == x)
			return true;
		
		if (printAncestor(root.left, x) || printAncestor(root.right, x))	
		{
			System.out.print(root.data + " ");
			return true;
		}
		return false;
	}

	void printLevelOrder(Node root)
	{
		if (root == null)
			return;
		Queue<Node> q = new LinkedList<Node>();
		q.add(root);
		while (true)
		{
			int nodeCount = q.size();
			if (nodeCount == 0)
				break;
			while (nodeCount > 0)
			{
				root = q.remove();
				System.out.print(root.data + " ");
				if (root.left != null)
					q.add(root.left);
				if (root.right != null)
					q.add(root.right);
				nodeCount--;	
			}	
			System.out.println();
		}	
	}
}


class PrintAncestor
{
	public static void main(String args[])
	{
		BinaryTree bt = new BinaryTree();
		bt.root = new Node(1);
		bt.root.left = new Node(2);
		bt.root.right = new Node(3);
		bt.root.left.left = new Node(4);
		bt.root.left.right = new Node(5);
		bt.root.left.left.left = new Node(7);

		int x = 7;

		bt.printLevelOrder(bt.root);		

		System.out.println("The Ancestors of " + x + " are: ");
		bt.printAncestor(bt.root, x);
		System.out.println();
	}
}

