import java.util.ArrayList;
import java.util.List;

public class KMin {
    public static void main(String[] args) {

    }
}
class Solution {
    public int[][] kClosest(int[][] points, int K) {
        int[] distance = new int[points.length];
        List<int[]> temp = new ArrayList();
        int[][] result = new int[K][2];
        for (int i = 0; i < points.length; i++) {
            distance[i] = (int)(Math.pow(points[i][0],2)+Math.pow(points[i][1],2));
        }
        for(int i = 0; i < K; i++){
            //temp.add(points[findMin(distance)]);
            result[i] = points[findMin(distance)];
            //result[i][1] = points[findMin(distance)][1];
        }
        return result;

    }
    public int findMin(int[] distance){
        int min = Integer.MAX_VALUE;
        int index = 0;
        for(int i=0;i<distance.length;i++){
            if(distance[i]<min){
                index=i;
                min = distance[i];
            }
        }
        distance[index]=Integer.MAX_VALUE;
        return index;
    }
}
