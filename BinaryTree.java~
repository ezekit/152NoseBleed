public class BinaryTree<V> {

	Node root;

	public BinaryTree()
	{
		root = null;
	}

	public void insert (int key, String[] data)
	{
		if(root == null)
			root = new Node(key, data);
		else
			root.insert(key, data);
	}
	
	public void preOrderTraversal(Node node)
	{
		if (node == null)
			return;
		else 
		{
			String temp = "Key: " + node.key + " Token: " + node.data[0]; 	
			System.out.println(temp);
			preOrderTraversal(node.left);
			preOrderTraversal(node.right);
		}
	}
	
	public void print()
	{
		preOrderTraversal(root);
		
	}
	
	public String toString()
	{
		return "Key: " + root.key + "Token : " + root.data[0] + " Type: " + root.data[1]; 		
	}
	
}
