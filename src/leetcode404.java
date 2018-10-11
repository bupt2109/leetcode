import java.util.ArrayList;

/**
 * Created by YX on 2016/10/14.
 */
public class leetcode404 {
    public int sumOfLeftLeaves(TreeNode root) {
        if(root==null)
            return 0;
        int res=0;
        ArrayList<TreeNode> list = new ArrayList<TreeNode>();
        list.add(root);
        while(!list.isEmpty()){
            TreeNode node = list.get(0);
            if(node.left!=null){
                list.add(node.left);
                if(node.left.left==null&&node.left.right==null)
                    res+=node.left.val;
            }
            if(node.right!=null)
                list.add(node.right);
            list.remove(0);
        }
        return res;
    }
}
