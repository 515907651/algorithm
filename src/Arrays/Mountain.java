package Arrays;

public class Mountain {
    public static void main(String args[]){
        int[] a = {1,2,3,1,4};
        System.out.println(validMountainArray(a));
    }
    static boolean validMountainArray(int[] a){
        //在山峰之前单增，山峰之后单减
        //先找到最大值，即山峰，山峰之前单增，后面单减
        if(a.length<3||a==null) return false;
        int max = 0;
        int index = 0;
        for(int i = 0;i<a.length;i++){
            if(a[i]>max){
                max = a[i];
                index = i;
            }
        }
        for(int i = 0;i<index;i++){
            if(a[i]-a[i+1]>0) return false;
        }
        for(int i=a.length-1;i>index;i--){
            if(a[i]>a[i-1]) return false;
        }
        return true;
    }
}
