public class Node {
	int key;
	String[] data;
	Node left;
	Node right;

	public Node(int key, String[] data) {
		this.key = key;
		this.data = data;
		this.left = null;
		this.right = null;
	}

	public void insert(int key, String[] data) {
		if (key < this.key) {
			if (left == null)
				left = new Node(key, data);
			else
				left.insert(key, data);
			
		} else if (key > this.key) {
			if (right == null)
				right = new Node(key, data);
			else
				right.insert(key, data);
		}
	}
	
	public String toString()
	{
		return "Key: " + key + "Token : " + data[0] + " Type: " + data[1]; 		
	}
	
}
