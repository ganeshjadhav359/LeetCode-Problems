import java.util.ArrayList;
import java.util.List;

public class UniqueBinarySearchTreesII {
    public static List<TreeNode> generateTrees(int s,int e){
      List<TreeNode> res = new ArrayList<>();
      if(s>e){
          res.add(null);
          return res;
      }


      for(int i=s;i<=e;i++){
          List<TreeNode> left = generateTrees(s,i-1);
          List<TreeNode> right = generateTrees(i+1,e);
          for(TreeNode leftNode : left)
              for(TreeNode rightNode : right){
                  TreeNode root = new TreeNode(i);
                  root.left = leftNode;
                  root.right = rightNode;
                  res.add(root);
              }


      }

      return res;

    }
    public static List<TreeNode> generateTrees(int n) {
        return generateTrees(1,n);
    }
    public static void main(String[] args) {

    }
}
