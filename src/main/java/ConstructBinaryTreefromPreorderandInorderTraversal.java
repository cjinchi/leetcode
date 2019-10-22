class TreeNode2 {
	int val;
	TreeNode2 left;
	TreeNode2 right;

	TreeNode2(int x) {
		val = x;
	}
}

public class ConstructBinaryTreefromPreorderandInorderTraversal {
	public TreeNode2 buildTree(int[] preorder, int[] inorder) {
		return build(preorder, inorder, 0, preorder.length-1, 0, inorder.length-1);
		
	}
	
	TreeNode2 build(int[] preorder, int[] inorder, int pl, int pr, int il, int ir) {
		if(pl>pr) {
			return null;
		}
		if(pl==pr) {
			return new TreeNode2(preorder[pl]);
		}
		int index = -1;
		for(int i = il;i<=ir;i++) {
			if(preorder[pl]==inorder[i]) {
				index = i;
				break;
			}
		}
		TreeNode2 root = new TreeNode2(inorder[index]);
		root.left = build(preorder, inorder, pl+1,index-il+pl, il, index - 1);
		root.right = build(preorder, inorder, index-il+pl+1, pr, index+1, ir);
		return root;
	}
}
