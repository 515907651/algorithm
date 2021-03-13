package Order;

import java.util.Arrays;

public class BucketSort {
    //这是计数排序，不是桶排序嗷
    public static void main(String[] args) {
        int[] array = new int[]{9,5,4,7,6,8,4,2,3,1,9,1};
        bucketSort(array);
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }
    public static void bucketSort(int[] a){
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < a.length; i++){
            if(a[i]>max) max = a[i];
            if(a[i]<min) min = a[i];
        }
        int[] temp = new int[max+1];
        for(int i = 0; i < a.length; i++){
            //System.out.println(temp[i]);
            temp[a[i]]++;
            //System.out.println(temp[a[i]]);
        }
        for (int i = 0; i < temp.length; i++) {
            //System.out.println(temp[i]);
        }
        int n = 0;
        for(int i = 0; i < max+1; i++){
            while(temp[i]!=0) {
                a[n] = i;
                n++;
                temp[i]--;

            }
        }
    }
}
