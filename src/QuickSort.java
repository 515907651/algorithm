public class QuickSort {
    //挖坑和分治
    public static void main(String[] args) {
        int[] a = new int[]{1,8,6,4,9,5};
        Solution1 solution1 = new Solution1();
        solution1.QSort(a,0,5);
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
    }
}
class Solution1{
    public int ArrayAdjust(int[] a, int l, int r){

        if(a==null||l>=r) return 0;
        int temp = a[l];
        while(a!=null&&l<r){
            while (r>l&&a[r]>=temp){
                r--;
            }
            if(r>l){
                a[l] = a[r];
                l++;
            }
            while (r>l&&a[l]<=temp){
                l++;
            }
            if(r>l){
                a[r] = a[l];
                r--;
            }
        }
        a[r] = temp;
        return r;
    }
    public void QSort(int[] a, int l, int r){

        if(l<r){
            int initial = ArrayAdjust(a,l,r);
            QSort(a,initial+1,r);
            QSort(a,l,initial-1);
        }
    }
}
