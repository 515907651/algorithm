package List;

public class OddEvenList {
    //odd是奇数，even是偶数
    public static void main(String[] args) {
        MyList head = new MyList();
        int n = 0;
        MyList temp = new MyList();
        MyList even = new MyList();
        even = temp;
        MyList temp1 = new MyList();
        temp1 = head;
        while(head.next!=null){
            if(n%2==0){
                temp.next = head.next;
                head.next = head.next.next;
                temp = temp.next;
                n+=2;
            }
        }
        head.next = even;

    }
}
class MyList{
    public int value;
    public MyList next;
    public MyList(){};
    public MyList(int value){
        this.value = value;
    }
    public MyList(int value, MyList next){
        this.value = value;
        this.next = next;
    }

    public void setNext(MyList next) {
        this.next = next;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public MyList getNext() {
        return next;
    }
}
