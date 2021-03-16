package offer;

import DataStructure.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

public class Codec_37 {
    // 序列化和反序列化
    // 有两种方式，BFS和DFS
    // 先把序列化写完吧
    // 注意序列化的形式[a,b,c]
    // Encodes a tree to a single string.
    String result = "";
    public String serialize1(TreeNode root) {
        // DFS先序遍历
        if (root == null) {
            return result + "null";
        }
        result += root.val;
        serialize1(root.left);
        serialize1(root.right);
        return result;
    }
    public String serialize2(TreeNode root) {
        // BFS遍历
        if (root == null){
            return "null";
        }
        result += "[";
        Deque<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode temp = queue.poll();
            if (temp != null){
                result += temp.val;
                queue.offer(temp.left);
                queue.offer(temp.right);
            } else {
                result += "null";
            }
            if (!queue.isEmpty()) {
                result += ",";
            }
            // 最后一个会多一个','吧
        }
        result += "]";
        return result;
    }

    // Decodes your encoded data to tree.

    public TreeNode deserialize1(String data) {
        // BFS遍历后的反序列化
        // 注意遇到null时的处理
        // 这个使用队列是怎么想到的
        // 先新建一个新节点，再找到他的两个子节点，这时候如果不用队列，这俩后面就没法处理了
        // 每次取出一个字符，如果是空，作为父节点的左右节点，但是不加入队列
        if ("null".equals(data)) {
            return null;
        }
        // String[] dataSplit = data.split(",");
        // 这里处理的太巧妙了，先去'['，再按','分割
        String[] dataSplit = data.substring(1, data.length()-1).split(",");
        Deque<TreeNode> queue = new LinkedList<>();
        int n = dataSplit.length;
        String temp;
        TreeNode head;
        int i = 0;
        TreeNode root = new TreeNode(Integer.parseInt(dataSplit[i]));
        i++;
        head = root;
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (i < n && dataSplit[i].equals("null")){
                node.left = null;
                i++;
            } else {
                TreeNode nodeLeft = new TreeNode(Integer.parseInt(dataSplit[i]));
                i++;
                node.left = nodeLeft;
                queue.offer(nodeLeft);
            }
            if (i < n && dataSplit[i].equals("null")){
                node.right = null;
                i++;
            } else {
                TreeNode nodeRight = new TreeNode(Integer.parseInt(dataSplit[i]));
                i++;
                node.right = nodeRight;
                queue.offer(nodeRight);
            }
        }
        return head;
    }

}
