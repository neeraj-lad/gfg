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

class IsIdentical
{
	public static void main(String args[])
	{
		BinaryTree bt1 = new BinaryTree();
		BinaryTree bt2 = new BinaryTree();

		bt1.root = new Node(1);
		bt1.root.left = new Node(2);
		bt1.root.right = new Node(3);
		bt1.root.left.left = new Node(4);
		bt1.root.left.right = new Node(5);

		bt2.root = new Node(1);
		bt2.root.left = new Node(2);
		bt2.root.right = new Node(3);
		bt2.root.right.left = new Node(4);
		bt2.root.right.right = new Node(5);
		
		System.out.println("Binary Tree 1:");
		levelOrderTraversal(bt1.root);

		System.out.println("Binary Tree 2:");
		levelOrderTraversal(bt2.root);

		System.out.println("IsIdentical? " + isIdentical(bt1.root, bt2.root));
	}

	static void levelOrderTraversal(Node root)
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

	static boolean isIdentical(Node root1, Node root2)
	{
		if (root1 == null && root2 == null)
			return true;
		else
		if ((root1 == null && root2 != null) || (root1 != null && root2 == null))	
			return false;
		else
		return ((root1.data == root2.data) && isIdentical(root1.left, root2.left) && isIdentical(root1.right, root2.right));
	}
}

