package bst;


public class BinarySearchTree {
	public static  Node root;
	public BinarySearchTree(){
		this.root = null;
	}
	
	public boolean find(int id){
		Node current = root;
		while(current!=null){
			if(current.data==id){
				return true;
			}else if(current.data>id){
				current = current.left;
			}else{
				current = current.right;
			}
		}
		return false;
	}
	public boolean delete(int id){
		/*
		 * Deletes a node of the tree with value id
		 * returns false if the node does not exit
		 * */	
		Node parent = root;
		Node curr = root;
		while(curr != null)
		{
				if(curr.data == id)
				{
					
					if(curr.left ==null && curr.right==null)
					{
						if(parent.right == curr)
							parent.right = null;
						else
							parent.left = null;
						return true;
					}
						
					else if(curr.left == null)
					{
						if(parent.right == curr)
							parent.right = curr.right;
						else
							parent.left = curr.right;
						return true;
						
					}
					else if(curr.right == null)
					{
						if(parent.right == curr)
							parent.right = curr.left;
						else
							parent.left = curr.left;
						return true;
					}
					else
					{
						
						/*
						 * 
						 * 
						 * 
						 * 
						 * 
						 * 
						 * the main part of function;
						 *
						 *
						 *
						 *
						 *
						 *
						 *
						 */
						
						Node curr2 = curr.right;
						Node parent2 = curr;
						while(curr2.left != null)
						{
							parent2 = curr2;
							curr2 = curr2.left;
						}
						
						if(parent.right == curr)
						{
							parent2.left = curr2.right;
							parent.right = curr2;
							curr2.left = curr.left;
							curr2.right = curr.right;
						}else if(parent.left == curr)
						{
							parent2.left = curr2.right;
							parent.left = curr2;
							curr2.left = curr.left;
							curr2.right = curr.right;
						}
						else
						{
							curr = curr2;
							parent2.left = curr2.right;
							curr2.right = curr.right;
							curr2.left = curr.left;
						}
						return true;
						
						
						
					}
					
					
					
					
			}else if(curr.data>id){
				
				parent = curr;
				curr = curr.left;
			}else{
				
				parent = curr;
				curr = curr.right;
			}
		}
		
		
		
		return true;		
	}

	
	public Node getSuccessor(Node deleleNode){
		Node successsor =null;
		Node successsorParent =null;
		Node current = deleleNode.right;
		while(current!=null){
			successsorParent = successsor;
			successsor = current;
			current = current.left;
		}
		//check if successor has the right child, it cannot have left child for sure
		// if it does have the right child, add it to the left of successorParent.
//		successsorParent
		if(successsor!=deleleNode.right){
			successsorParent.left = successsor.right;
			successsor.right = deleleNode.right;
		}
		return successsor;
	}
	
	
	
	public void insert(int id){
		Node newNode = new Node(id);
		if(root==null){
			root = newNode;
			return;
		}
		Node current = root;
		Node parent = null;
		while(true){
			parent = current;
			if(id<current.data){				
				current = current.left;
				if(current==null){
					parent.left = newNode;
					return;
				}
			}else{
				current = current.right;
				if(current==null){
					parent.right = newNode;
					return;
				}
			}
		}
	}
	public void display(Node root){
		if(root!=null){
			display(root.left);
			System.out.print(" " + root.data);
			display(root.right);
		}
	}
	public static void main(String arg[]){
		BinarySearchTree b = new BinarySearchTree();
		b.insert(3);b.insert(8);
		b.insert(1);b.insert(4);b.insert(6);b.insert(2);b.insert(10);b.insert(9);
		b.insert(20);b.insert(25);b.insert(15);b.insert(16);
		System.out.println("Original Tree : ");
		b.display(root);		
		System.out.println("");
		System.out.println("Check whether Node with value 4 exists : " + b.find(4));
		/*
		 * test delete for the 3 possible situations 
		 * */
		//b.display(root);
		//System.out.println();
		b.delete(25);
		System.out.println("after delete 25 : ");
		b.display(root);
		b.delete(15);
		System.out.println("\nafter delete 8 : ");
		b.display(root);
		b.delete(10);
		System.out.println("\nafter delete 10 : ");
		b.display(root);

		
		
		System.out.println("\nfuck!!!");
	}
}

class Node{
	int data;
	Node left;
	Node right;	
	public Node(int data){
		this.data = data;
		left = null;
		right = null;
	}
}