package Arrays;

import java.util.Iterator;
import java.util.LinkedList;

public class NestedIterator_341_medium{
    // 看了半天题，脑子就没转悠，没有思路
    // 题解用的是深度优先搜索，列表中嵌套着列表，遍历的时候，把整个结构看做树，列表就是非叶子节点，列表中的整数是叶子节点
/*
    // 利用一个数组来存储遍历结果，最后遍历数组
    private LinkedList<Integer> list;
    private Iterator<Integer> iterator;
    public NestedIterator_341_medium(List<NestedInteger> nestedList) {
        list = new LinkedList<>();
        dfs(nestedList);
        iterator = list.iterator();
    }

    private void dfs(List<NestedInteger> nestedList) {
        for (NestedInteger temp:nestedList) {
            if (temp.isInteger) {
                list.add(temp);
            } else {
                dfs(temp.getList());
            }
        }
    }

    @Override
    public Integer next() {
        return iterator.next();
    }

    @Override
    public boolean hasNext() {
*/
/*
        if (iterator.hasNext()){
            return true;
        } else {
            return false;
        }
*//*

        return iterator.hasNext();
    }
*/
}