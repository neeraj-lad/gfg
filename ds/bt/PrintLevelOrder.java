import java.util.*;

class Node
{
	int data;
	Node left, right;

	Node(int d)
	{
		data = d;
		left = right = null;	
	}
}

class BinaryTree
{
	Node root;

	BinaryTree()
	{
		root = null;	
	}
}

class PrintLevelOrder
{
	public static void main(String args[])
	{
		BinaryTree bt = new BinaryTree();

		bt.root = new Node(1);
		bt.root.left = new Node(2);
		bt.root.right = new Node(3);
		bt.root.left.left = new Node(4);
		bt.root.left.right = new Node(5);

		System.out.println("Method 1:");
		mtd1(bt.root);
		System.out.println("Method 2 (BFS):");
		bFSMtd(bt.root);
	}

	static void mtd1(Node root)
	{
		int height = getHeight(root);
		for (int i = 1; i <= height; i++)
		{
			printNodeAtHeight(root, i);	
			System.out.println();
		}
	}

	static int getHeight(Node root)
	{
		if (root == null)
			return 0;
		else
			return 1 + Math.max(getHeight(root.left), getHeight(root.right));	
	}

	static void printNodeAtHeight(Node root, int height)
	{
		if (root == null)
			return;
		else
		if (height == 1)
			System.out.print(root.data + " ");
		else
		{
			printNodeAtHeight(root.left, height-1);
			printNodeAtHeight(root.right, height-1);
		}	
	}

	static void bFSMtd(Node root)
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

