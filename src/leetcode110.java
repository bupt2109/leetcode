/**
 * Created by YX on 2016/11/2.
 */

//110. Balanced Binary Tree
public class leetcode110 {
    public int deep(TreeNode node, int count){
        if(node==null)
            return 0;
        int a,b,diff;
        a = deep(node.left,1);
        b = deep(node.right,1);
        if(a==-1 || b==-1)
            return -1;
        diff = Math.abs(a-b);
        if(diff>1)
            return -1;
        else
            return count + Math.max(a,b);
    }

    public boolean isBalanced(TreeNode root) {
        if(root==null)
            return true;
        return deep(root,0)!=-1;
    }
}
