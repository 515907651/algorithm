package List;

public class InsertionSortList {
    public static void main(String[] args) {
        MyList node1 = new MyList(1);
        MyList node2 = new MyList(2,node1);
        MyList node3 = new MyList(3,node2);
        MyList node4 = new MyList(1,node3);
        MyList node5 = new MyList(2,node4);
        MyList node6 = new MyList(3,node5);

        MyList head = insertionSortList2(node6);
        while (head!=null){
            System.out.println(head.value);
            head = head.next;
        }
        System.out.println();
    }
    public static MyList insertionSortList(MyList head) {
        //先找到第N个节点，然后把第N个节点和之前的所有节点比较大小，在大于前一个，小于后一个的位置插入该节点
        MyList temp = head;
        MyList temp1 = head;
        while(head!=null){
            boolean flag = true;
            MyList now = head;
            MyList after = head.next;
            System.out.println("1");
            while(temp.next!=head&&temp!=head){
                if(temp.value<= head.value&&temp.next.value>= head.value) {
                    MyList temp2 = temp.next;
                    temp.next = head;
                    head.next = temp2;
                    temp2.next = after;
                    flag = false;
                    break;
                }
                temp = temp.next;
            }
            if(flag){
                head = head.next;
            }
            else {
                head = after;
            }
            temp = temp1;

            head = head.next;

        }
        return temp1;
    }
    public static MyList insertionSortList1(MyList head){
        if(head==null) return null;
        MyList now = head.next;
        MyList after = now.next;
        MyList front = head;
        MyList pre = head;
        while(now!=null){
            int frontI = 0;
            while (front!=now){
                if(frontI==0&&now.value<=front.value){
                    //小于第一个，直接插入
                    now.next = front;
                    pre.next = after;
                    after = after.next;
                    front = now;
                    frontI++;
                    break;
                }
                if(front.value<=now.value&&front.next.value>now.value){
                    //小于前面的，大于后面的，插入
                    MyList temp = front.next;
                    front.next = now;
                    now.next = temp;
                    pre.next = after;
                    after = after.next;
                    frontI++;
                    break;
                }
            }
            if(frontI!=0){

            }else {
                pre = now;
                now = after;
                after = after.next;
            }
        }
        return front;

    }
    public static MyList insertionSortList2(MyList head){
        if(head==null) return null;
        MyList dummyHead = new MyList();
        dummyHead.next = head;
        MyList last = head;
        MyList current = head.next;
        MyList pre = new MyList();
        while(current!=null){
            if(last.value <= current.value){
                last = current;
            }else {
                pre = dummyHead;
                while (pre.next.value< current.value){
                    pre = pre.next;
                }
                last.next = current.next;
                current.next = pre.next;
                pre.next = current;
            }
            current = last.next;
        }
        return dummyHead.next;
    }
}
