package top100;

import java.util.HashMap;

public class _146_LRUCache_Medium {
    // 手动实现LRUCache
    // 双向链表+hashmap，hashmap存放key和指向链表的索引
    // 当get时，返回hashmap中的值，没有就返回-1，然后把用到的节点放到头结点
    // 当put时，放入hashmap，并且放到头结点。如果超过容量，删除尾结点。
    // 方便起见，建立虚假的头结点和尾结点
    private static class DLinkedNode{
        // 双向链表的节点
        int key;
        int value;
        DLinkedNode prev;
        DLinkedNode next;
        public DLinkedNode(){};
        public DLinkedNode(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
    // 各种必要的属性
    private int size;
    private int capacity;
    private DLinkedNode head, tail;
    private HashMap<Integer, DLinkedNode> hashMap;

    public _146_LRUCache_Medium(int capacity) {
        // 初始化
        size = 0;
        this.capacity = capacity;
        head = new DLinkedNode();
        tail = new DLinkedNode();
        head.next = tail;
        tail.prev = head;
        hashMap = new HashMap();
    }

    public int get(int key) {
        DLinkedNode temp = this.hashMap.get(key);
        if (temp == null) {
            return -1;
        } else {
            // 将temp取出
/*
            DLinkedNode temp1 = temp.next;
            DLinkedNode temp2 = temp.prev;
            temp1.prev = temp2;
            temp2.next = temp1;
*/
            temp.prev.next = temp.next;
            temp.next.prev = temp.prev;
            // 将temp放到头结点
            head.next.prev = temp;
            temp.next = head.next;
            temp.prev = head;
            head.next = temp;
            return temp.value;
        }
    }

    public void put(int key, int value) {
        // 这里逻辑有点复杂了
        // 主要是涉及到了删除节点，删除的时候应该怎么做
        DLinkedNode temp = hashMap.get(key);
        if (temp == null) {
            // 先判断容量
            temp = new DLinkedNode(key, value);
            size++;
            if (size > capacity) {
                // 容量满了，要先删除最后一个
                hashMap.remove(tail.prev.key);

                tail.prev = tail.prev.prev;
                tail.prev.next = tail;
                size--;
            }
            // 保存到hashmap
            hashMap.put(key, temp);
            // 放到头结点，这一步一起做，算了，写了再说
            temp.next = head.next;
            head.next.prev = temp;
            head.next = temp;
            temp.prev = head;
        } else {
            // 已经存在，更新
            temp.value = value;
            // 取出temp
            temp.prev.next = temp.next;
            temp.next.prev = temp.prev;
            // 将temp放到头结点
            head.next.prev = temp;
            temp.next = head.next;
            temp.prev = head;
            head.next = temp;
        }

    }

}
