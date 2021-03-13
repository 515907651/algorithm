package offer;

import DataStructure.TreeNode;

import java.util.*;

public class LevelOrder_3_medium {
    public List<List<Integer>> levelOrder(TreeNode root) {
        // 我还以为自己的方法很好了，结果双端队列，放入的时候判断奇偶，然后从两头放入就OK了，不需要最后再反转，费时间
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;
        Deque<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int flag = 1;// 如果用boolean怎么搞
        while (!queue.isEmpty()){
            List<Integer> list = new ArrayList<>();
            int sizeOfLevel = queue.size();
            for (int i = 0; i < sizeOfLevel; i++) {
                TreeNode parent = queue.poll();
                list.add(parent.val);
                if (parent.left != null){
                    queue.offer(parent.left);
                }
                if (parent.right != null){
                    queue.offer(parent.right);
                }
            }
            if ((flag&1) == 1){
                // 位运算判断奇偶，我可是太强了，秀起来了，要加()，因为&优先级太低了
                result.add(list);
            } else {
                Collections.reverse(list);
                result.add(list);
            }
            flag++;
        }
        return result;
    }
    public List<List<Integer>> levelOrder1(TreeNode root) {
        // 我还以为自己的方法很好了，结果双端队列，放入的时候判断奇偶，然后从两头放入就OK了，不需要最后再反转，费时间
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;
        Deque<TreeNode> deque = new LinkedList<>();
        deque.offer(root);
        while (!deque.isEmpty()){
            LinkedList<Integer> list = new LinkedList<>();
            // 只能用linkedList，ArrayList不能前插或者后插，插入尽量用linked吧
            int sizeOfLevel = deque.size();
            for (int i = 0; i < sizeOfLevel; i++) {
                TreeNode parent = deque.poll();
                if ((result.size() & 1) == 0){
                    // 开始是0，也就是奇数行是偶数，偶数行是奇数
                    // addLast()是往最后插入，addFirst()是往最前面插入
                    list.addLast(parent.val);
                } else {
                    list.addFirst(parent.val);
                }
                if (parent.left != null){
                    deque.offer(parent.left);
                }
                if (parent.right != null){
                    deque.offer(parent.right);
                }
            }
            result.add(list);
        }
        return result;
    }

}
