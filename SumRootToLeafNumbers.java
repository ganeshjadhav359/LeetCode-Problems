

 //Definition for a binary tree node.
 class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {
          left=null;
          right=null;
      }
      TreeNode(int val) { this.val = val; left=null;right=null; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }

public class SumRootToLeafNumbers {

    public static int solution(TreeNode root,int sum){
        if(root==null)
            return 0;
        if(root.left==null && root.right==null)
            return sum*10 + root.val;
        return solution(root.left,sum*10+root.val) +solution(root.right,sum*10 + root.val);
    }
    public static int sumNumbers(TreeNode root) {
        return solution(root,0);
    }
}
