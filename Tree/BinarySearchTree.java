// Declaration of the Binary node with the left and right references and a data value
class BinaryNode {
	int data; 		 // the data to be stored in the node
	BinaryNode left; // Reference to the left sub-tree
	BinaryNode right; //Reference to the right sub-tree
	
	// The constructor constructs the node with the data and the null left and right references
	BinaryNode (int data) {
		this.data = data; 
		left=right=null; 
	}
	// returns the data of the node being referred to
	public int getData() {
		return data; 
	}
}

public class BinarySearchTree {
	
	// The ROOT node. Any operation on the tree starts from the root node.
	// Ensure that the root node reference remains unaltered unless the operation is on the root node itself
	BinaryNode root; 			 
	
	/*
	 * INSERTION into a Binary Tree
	 * Case 1: Empty Tree - The new node created becomes the ROOT node
	 * Case 2: Non-empty Tree - Insertion of new node can happen either to the left subtree or right subtree depending on the data
	 */
	public void insert (BinaryNode temp, int data) {
		
		// Case 1: Empty Tree - The new node created becomes the ROOT node
		if (temp == null) {
			temp = new BinaryNode(data);
			root = temp;  
			System.out.println ("Data of the New Node inserted as the root: " + data);
			return; 
		}
		
		// Case 2: Non-empty Tree - Insertion of new node can happen either to the left subtree or right subtree depending on the data
		// Compare the data with the current node's data, if the data to be inserted is 
		// smaller then branch to the left subtree,
		// otherwise branch to the right subtree
		if (data < temp.getData()) {
			// if 'left' is null, it implies there is no left subtree, then insert the new node as left child of current node
			if (temp.left == null) {
				temp.left = new BinaryNode(data); 
				System.out.println("The new node inserted as the left child is:"+ data);
				return;
			} else
				insert(temp.left, data); // if a left subtree is present, then recursive call to move further down the tree
		} else {
			// if 'right' is null, it implies there is no right subtree, then insert the new node as right child of current node
			if (temp.right == null) {
				temp.right = new BinaryNode(data);
				System.out.println("The new node inserted as the right child is:"+ data);
				return;
			} else
				insert(temp.right, data); // if a right subtree is present, then recursive call to move further down the tree
		}
	}
	
	// PREORDER TRAVERSAL of Binary Tree
	// root => left => right
	public void preorder(BinaryNode p) {
		if (p!= null) {
			System.out.print(p.getData()+"  ");
			preorder(p.left);
			preorder(p.right);
		}
	}	
	
	// POSTORDER TRAVERSAL of Binary Tree
	// left => right => root
	public void postorder(BinaryNode p) {
		if (p!= null) {
			postorder(p.left);
			postorder(p.right);
			System.out.print(p.getData()+"  ");
		}
	}	
	
	// INORDER TRAVERSAL of Binary Tree
	// left => root => right
	public void inorder(BinaryNode p) {			
		if (p!= null) {
			inorder(p.left);
			System.out.print(p.getData()+"  ");
			inorder(p.right);
		}	
	}
	
	// Locate an element "theelement" in the tree
	public BinaryNode locateItem(BinaryNode p, int theelement) {
		boolean found = false;
		if (p!=null) {
			if (theelement == p.getData()) {  // TRUE, if found
				found = true;
				return p;
			} else if (theelement < p.getData())  // if not found, branch to the left subtree, if data is smaller than current node's data
				p = locateItem(p.left, theelement);
			else // if not found, branch to the right subtree, if data is larger than current node's data
				p = locateItem(p.right, theelement);
		}
		if(!found)
			p = null;
		return p;
	}
	
	
	// Find the parent node of the node-to-be-deleted
	public BinaryNode findParentNode(BinaryNode temproot, BinaryNode delnode) {
		
		BinaryNode parent = null;
		
		// start search for the ROOT, and branch to the left subtree or right subtree 
		// continuously till the 'delnode' is found or else you end-up at a leaf node
		// not equal to 'delnode' meaning the 'delnode' is not present in the tree
		while (temproot != delnode) { 
			parent = temproot; 
			if (delnode.getData() < temproot.getData())
				temproot = temproot.left; 
			else 
				temproot = temproot.right; 
		}
		return parent;
	}
	
	/*
	 * DELETION from a Binary Tree
	 * (a) locate the node to be deleted in the Binary Tree; (b) determine the parent node of the node-to-be-deleted
	 * Case 1: Deletion of a leaf node - straight-away set the respective reference of its parent node to null
	 * Case 2: Deleting a node which has either a left subtree or a right subtree
	 * Case 3: Deleting a node having both left subtree and right subtree
	 */
	public void delete(BinaryNode rootnode, int data) {

		// locate the node to be deleted in the Binary Tree
		BinaryNode delnode = locateItem(rootnode, data);
		if(delnode == null) {
			System.out.println("Empty BST or the data not present in the BST");
			return;
		}
		
		// determine the parent node of the node-to-be-deleted
		BinaryNode parent = findParentNode(rootnode, delnode);
		
		//Case 1: Deleting a leaf node - set the reference of its parent node to null; 
		if ((delnode.left == null) && (delnode.right == null)) {
			// the node-to-be-deleted can be either the left child or the right child
			if (parent != null) { // If parent is null, it implies only the ROOT exists and not children
				if (parent.getData() > delnode.getData())
					parent.left = null;   // the node-to-be-deleted is the left child, hence left reference is made null
				else
					parent.right = null;  // the node-to-be-deleted is the right child, hence right reference is made null
			} else
				root = null; // Meaning only the ROOT exists and not children, because parent is null, hence root node is deleted
		}	
		
		//Case 2: Deleting a node which has either a left subtree or a right subtree 
		else if ((delnode.left == null) || (delnode.right == null)) {
			if (parent != null) {
				// If there is no left subtree to the node-to-be-deleted, 
				// then make its right subtree as 
				// the parent node's left subtree or right subtree depending on 
				// whether the data of the node-to-be-deleted
				// is smaller or larger than the parent node's data correspondingly
				if (delnode.left == null) { // Only right subtree present, no left subtree 
					if (parent.getData() > delnode.getData())
						parent.left = delnode.right;
					else
						parent.right = delnode.right; 
				} else { // Only left subtree present, no right subtree 
					if (parent.getData() > delnode.getData())
						parent.left = delnode.left; 
					else
						parent.right = delnode.left; 
					
				}
			} else { // Meaning only the ROOT exists and only one of the left or right subtree is present, 
				     // because parent is null, hence root node is deleted, such that it gets shifted to either the right or left child
				if (delnode.left == null)
					root = rootnode.right; 
				else
					root = rootnode.left; 
			}
		}
	
		//Case 3: Deleting a node having both left subtree and right subtree
		else if ((delnode.left!= null) && (delnode.right!=null)) {
			BinaryNode x = delnode.left; 
			// Determine the right-most descendant of the left subtree of the node-to-be-deleted 
			while (x.right != null) {
				x = x.right; // hop to the right child repeatedly till the right-most descendant is found
			}
			
			x.right = delnode.right; 
			
			//Reset the parent of node-to-be-deleted to the left child of node-to-be-deleted; 
			//But for that you need to figure out if node-to-be-deleted was the right or left child of its parent 
			//And before that check if node-to-be-deleted is having a parent 
			
			if (parent != null) {
				if (parent.right == delnode)
					parent.right = delnode.left; 
				else
					parent.left = delnode.left; 
			} else
				root = rootnode.left; 
		}
	}
	
	public static void main (String[] args) {
		
		BinarySearchTree b = new BinarySearchTree();
		
		System.out.println("Insertion Operations");
		b.insert(b.root, 18);
		b.insert(b.root, 10);
		b.insert(b.root, 25);
		b.insert(b.root, 5);
		b.insert(b.root, 15);
		b.insert(b.root, 21);
		b.insert(b.root, 28);
		b.insert(b.root, 3);
		b.insert(b.root, 6);
		b.insert(b.root, 11);
		b.insert(b.root, 16);
		b.insert(b.root, 20);
		b.insert(b.root, 23);
		b.insert(b.root, 26);
		b.insert(b.root, 29);
		
		System.out.println("Preorder Traversal of the BST");
		b.preorder(b.root);
		
		System.out.println();
		System.out.println("Postorder Traversal of the BST");
		b.postorder(b.root);
		
		System.out.println();
		System.out.println("Inorder Traversal of the BST");
		b.inorder(b.root);

		System.out.println("Deletion Operations");
		b.delete(b.root, 13);
		b.delete(b.root, 15);
		b.delete(b.root, 6);
		System.out.println("Inorder Traversal of the Tree");
		b.inorder(b.root);
		
	}
}
