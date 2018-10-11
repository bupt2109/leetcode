import java.util.ArrayList;
import java.util.List;

/**
 * Created by YX on 2016/10/25.
 */
//TODO
    //a difficult question
public class leetcode437 {

    public void dfs(TreeNode node, List<TreeNode> nodes,int sum){
        if(node.left==null && node.right==null){//leaf
            int size = nodes.size();
            int [] tmp = new int[size];
            for(int i=0;i<size;i++){
                tmp[i] = nodes.get(i).val;
            }
            //core code: 判断tmp数组是否有子集相加合为目标值
            for(int i=0;i<size;i++){
                System.out.print(tmp[i]+" ");
            }
            System.out.println();
            nodes.remove(size - 1);
            return	;
        }
        if(node.left!=null){
            nodes.add(node.left);
            dfs(node.left,nodes,sum);
        }
        if(node.right!=null){
            nodes.add(node.right);
            dfs(node.right,nodes,sum);

        }
        nodes.remove(nodes.size()-1);
        return ;
    }

    public int pathSum(TreeNode root, int sum) {
        List<TreeNode> nodes = new ArrayList<TreeNode>();
        if(root==null)
            return 0;
        nodes.add(root);
        dfs(root,nodes,sum);
        return 0;
    }

    /*public static void main(String[] args) {
        TreeNode node = new TreeNode(7);
        leetcode437 test = new leetcode437();
        test.pathSum(node,8);
    }*/
}
