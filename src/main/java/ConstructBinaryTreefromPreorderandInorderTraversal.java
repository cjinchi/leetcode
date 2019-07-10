class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
	}
}

public class ConstructBinaryTreefromPreorderandInorderTraversal {
	public TreeNode buildTree(int[] preorder, int[] inorder) {
		return build(preorder, inorder, 0, preorder.length-1, 0, inorder.length-1);
		
	}
	
	TreeNode build(int[] preorder,int[] inorder,int pl,int pr,int il,int ir) {
		if(pl>pr) {
			return null;
		}
		if(pl==pr) {
			return new TreeNode(preorder[pl]);
		}
		int index = -1;
		for(int i = il;i<=ir;i++) {
			if(preorder[pl]==inorder[i]) {
				index = i;
				break;
			}
		}
		TreeNode root = new TreeNode(inorder[index]);
		root.left = build(preorder, inorder, pl+1,index-il+pl, il, index - 1);
		root.right = build(preorder, inorder, index-il+pl+1, pr, index+1, ir);
		return root;
	}
}
