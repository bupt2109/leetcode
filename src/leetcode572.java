import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by LYX on 2019/4/25.
 */

public class leetcode572 {
    /**
     * 方法一：
     * t转换成字符串，
     * 遍历s各个点，找到所有节点值和t根节点值相同的。
     * 求这些节点为根节点的树字符串，如果有字符串和t字符串相等就是true，全不等就是false
     * T(O): t + s^2
     * 存在问题：前序遍历不能唯一代表这棵树。
     * 解决方法：前序+中序（得遍历两遍树。。。）
     * 方法一方案不可行。
     *
     * 方法二：
     * 直接遍历s。找到根节点一样的，判断是否是.
     * 方法二时间22ms，95%之后，得提高。只能从算法去减小时间复杂度
     *
     * @param s
     * @param t
     * @return
     */
    public boolean isSubtree(TreeNode s, TreeNode t) {
        Queue<TreeNode> queue = new LinkedList<>();
        Queue<TreeNode> queue1 = new LinkedList<>();
        Queue<TreeNode> queue2 = new LinkedList<>();
        queue.offer(s);
        while(!queue.isEmpty()){
            TreeNode node = queue.poll();
            if(node.val == t.val){
                queue1.clear();
                queue2.clear();
                queue1.offer(t);
                queue2.offer(node);
                boolean flag = true;
                while(!queue1.isEmpty()){
                    TreeNode node1 = queue1.poll();
                    TreeNode node2 = queue2.poll();
                    if(node1.left == null){
                        if(node2.left != null){
                            flag = false;
                            break;
                        }
                    }else{
                        if(node2.left != null && node2.left.val==node1.left.val){
                            queue1.offer(node1.left);
                            queue2.offer(node2.left);
                        }else{
                            flag = false;
                            break;
                        }
                    }
                    if(node1.right == null){
                        if(node2.right != null){
                            flag = false;
                            break;
                        }
                    }else{
                        if(node2.right != null && node2.right.val==node1.right.val){
                            queue1.offer(node1.right);
                            queue2.offer(node2.right);
                        }else{
                            flag = false;
                            break;
                        }
                    }
                }
                if(flag && queue2.isEmpty()){
                    return true;
                }
            }
            if(node.left != null){
                queue.offer(node.left);
            }
            if(node.right != null){
                queue.offer(node.right);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        leetcode572 test = new leetcode572();
        TreeNode s = new TreeNode(4);//[4,4,5,1,2,null,null,null,1]
        s.left = new TreeNode(4);
        s.right = new TreeNode(5);
        s.left.left = new TreeNode(1);
        s.left.right = new TreeNode(2);
        s.left.left.right = new TreeNode(1);

        TreeNode t = new TreeNode(4);//[4,1,2,null,1]
        t.left = new TreeNode(1);
        t.right = new TreeNode(2);
        t.left.right = new TreeNode(1);
        System.out.println(test.isSubtree(s, t));

    }
}
