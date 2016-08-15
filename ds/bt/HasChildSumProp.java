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
}

class HasChildSumProp
{
	public static void main(String args[])
	{
		BinaryTree bt = new BinaryTree();
		bt.root = new Node(10);
		bt.root.left = new Node(8);
		bt.root.left.left = new Node(3);
		bt.root.left.right = new Node(5);
		bt.root.right = new Node(2);
		bt.root.right.left = new Node(2);	

		printLevelOrder(bt.root);

		System.out.println("HasChildSumProp?: " + hasChildSumProp(bt.root));
	}

	static void printLevelOrder(Node root)
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

	static boolean hasChildSumProp(Node root)
	{
		if (root == null)
			return true;
		if (root.left == null && root.right == null)
			return true;

		int leftVal = 0, rightVal = 0;
		if (root.left != null)
			leftVal = root.left.data;
		if (root.right != null)
			rightVal = root.right.data;
		return ((root.data == leftVal + rightVal) && hasChildSumProp(root.left) && hasChildSumProp(root.right));
	}
}

