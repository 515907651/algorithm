package Arrays;

import java.util.HashSet;
import java.util.Set;

public class Intersection {
    public static void main(String args[]){
        int[] a = {2,2,3};
        int[] b = {1,2,3};
        //System.out.println(b.length);
        System.out.println(intersect(a,b)[0]);


    }
    static int[] intersect(int[] a, int[] b){
        Set<Integer> hashset = new HashSet<Integer>();
        for(int i=0;i<a.length;i++){
            for(int j=0;j<b.length;j++){
                if(a[i]==b[j]) hashset.add(a[i]);
            }
        }
        int[] result = new int[hashset.size()];
        int temp = 0;
        for (int num:hashset
             ) {
            result[temp] = num;
            temp++;
        }
        return result;
    }
}
