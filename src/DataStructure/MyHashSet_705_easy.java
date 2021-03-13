package DataStructure;

import java.util.Iterator;
import java.util.LinkedList;

public class MyHashSet_705_easy {
    // 参考hashmap，使用拉链法
    // 首先是一个数组，然后数组的后面跟着链表
    // 当hash值一样时，判断是否相等，不相等就插入，相等就什么都不做
    /** Initialize your data structure here. */
    private LinkedList<Integer>[] array;
    private static final int NUM = 779;
    public MyHashSet_705_easy() {
        array = new LinkedList[NUM];
        for (int i = 0; i < NUM; i++) {
            array[i] = new LinkedList<>();
        }
    }

    public void add(int key) {
        int h = hash(key);
        Iterator<Integer> iterator = array[h].iterator();
        while (iterator.hasNext()){
            Integer element = iterator.next();
            if (element == key){
                return;
            }
        }
        array[h].offerLast(key);
    }

    public void remove(int key) {
        int h = hash(key);
        Iterator<Integer> iterator = array[h].iterator();
        while (iterator.hasNext()) {
            Integer element = iterator.next();
            if (key == element){
                array[h].remove(element);
                return;
            }
        }

    }

    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        int h = hash(key);
        Iterator<Integer> iterator = array[h].iterator();
        while (iterator.hasNext()){
            Integer element = iterator.next();
            if (element == key) {
                return true;
            }
        }
        return false;
    }

    public int hash(int key){
        return key % NUM;
    }

}
