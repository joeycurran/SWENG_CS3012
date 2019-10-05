

	

// Java Program for Lowest Common Ancestor in a Binary Tree 
// A O(n) solution to find LCA of two given values n1 and n2 
import java.util.ArrayList; 
import java.util.List; 

// A Binary Tree node 





public class lowestCommonAncestor<Key extends Comparable<Key>, Value> {

	class TreeNode {
		private int val;
		private TreeNode left;
		private TreeNode right;
		private int N;
	}
	

	public TreeNode LCA(TreeNode root, TreeNode p, TreeNode q) {
		if(root == null){
			return null;
		}if((p == root) || (q == root)){
			return root;
		} 
		if(root.left == null && root.right == null){
			return null;
		}
		List<TreeNode> path1 = new ArrayList<>();
		List<TreeNode> path2 = new ArrayList<>();

		path1 = getPath(root,p,path1);
		path2 = getPath(root,q,path2);
		if(path1.size() > 1 &&  path2.size() > 1){
			for(int i = 0; i < path1.size(); i++){
				if((i == path1.size()-1 || i == path2.size()-1) && path1.get(i) == path2.get(i)){
					return path1.get(i);
				}
				if(path1.get(i) != path2.get(i)){
					return path1.get(i-1);
				}
			}
		}
		return null;
	}
	/**
	 * Return the path from root to node
	 */
	private  List<TreeNode> getPath(TreeNode root, TreeNode node, List<TreeNode> path){
		if(root == null){
			return path;
		}
		if(root == node){
			path.add(root);
			return path;
		}
		if(root.left == node){
			path.add(root);
			path.add(root.left);
			return path;
		}
		if(root.right == node){
			path.add(root);
			path.add(root.right);
			return path;
		}
		if(isLeftChild(root,node)){
			path.add(root);
			return getPath(root.left,node,path);
		}else{
			path.add(root);
			return getPath(root.right,node,path);
		}
	}
	/**
	 * Return true if the a given node is in the left subtree
	 */
	private boolean isLeftChild(TreeNode root, TreeNode node){
		return isChild(root.left,node);
	}

	/**
	 * Return true if the a given node is in the right subtree
	 */
	private boolean isRightChild(TreeNode root, TreeNode node){
		return isChild(root.right,node);   
	}

	/**
	 * Return true if the a given node is a child of the tree rooted at parent.
	 */
	private boolean isChild(TreeNode parent, TreeNode child){
		if(parent == null){
			return false;}
		if(parent == child){
			return true;
		}return (isChild(parent.left,child) || isChild(parent.right,child));
	}

}



