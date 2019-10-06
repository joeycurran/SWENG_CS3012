

// Java Program for Lowest Common Ancestor in a Binary Tree 
// A O(n) solution to find LCA of two given values n1 and n2 
import java.util.ArrayList; 
import java.util.List; 

// A Binary Tree node 





public class lowestCommonAncestor<Key extends Comparable<Key>, Value> {
	
	private TreeNode root;
	
	
	lowestCommonAncestor(){
		root = null;
	}

	class TreeNode {
		private Key key;
		private Value val;
		private TreeNode left;
		private TreeNode right;
		private int nodesBelow;



		public TreeNode(Key key, Value val, int nodesBelow ) {
			this.key = key;
			this.val = val;
			this.nodesBelow= nodesBelow;
		}
	}
	
	
	//check if key exists
	public boolean existsCheck(Key key) {
		if(getNode(key) != null) {
			return true;
		}
		else {
			return false;
		}
	}

	public Value getNode(Key key) {
		Value x = null;
		if( key != null) x = getNode(root, key);
		return x;

	}


	private Value getNode(TreeNode x, Key key) {
		if( x==null) return null;
		int compare = key.compareTo(x.key);
		if (compare < 0) return getNode(x.left, key);
		else if (compare > 0) return getNode(x.right, key);
		else return x.val;
	}
	
	public void putNode(Key key, Value val) {
    	if (val!= null && !existsCheck(key) ){
				root = putNode(root, key, val);
			}
		}
	
	private TreeNode putNode(TreeNode x, Key key, Value val) {
		if(x == null) return new TreeNode(key, val, 1);
		int compare = key.compareTo(x.key);
		if (compare < 0) x.left  = putNode(x.left,  key, val);
        else if (compare > 0) x.right = putNode(x.right, key, val);
        else x.val   = val;
        x.nodesBelow = 1 + size(x.left) + size(x.right); //increment the number of nodes under this node
        return x;
    }
	
	private int size(TreeNode x) {
        if (x == null) return 0;
        else return x.nodesBelow;
    }
	
	 //returns the lowest common ancestor of two keys if both exist in the tree.
		public Key getLowestCommonAncestor(Key keyA, Key keyB){
			Key answer = null;
			//there exists a LCA if both the keys are in the binary tree
			if (existsCheck(keyA) && existsCheck(keyB)){
				answer = getLowestCommonAncestor(root, keyA, keyB);
			}
			return answer;
		}

		private Key getLowestCommonAncestor(TreeNode node, Key keyA, Key keyB){
			//if both inputs are greater than the current node, LCA is in right subtree
			if ((node.key.compareTo(keyA)<0 && node.key.compareTo(keyB)<0)){
				return  getLowestCommonAncestor(node.right, keyA, keyB);
			}
			//else if both are less, then LCA is in the right subtree
			else if((node.key.compareTo(keyA)>0 && node.key.compareTo(keyB)>0)){
				return  getLowestCommonAncestor(node.left, keyA, keyB);
			}
			//otherwise the current node is the LCA
			else{
				return node.key;
			}
		}

}


