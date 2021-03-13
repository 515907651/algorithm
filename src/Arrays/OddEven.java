package Arrays;

public class OddEven {
    public static void main(String[] args) {

    }
}
class OddEvenSolution{
    public int[] sortArrayByParityII(int[] A) {
        int[] result = new int[A.length];
        int oddIndex = 1;
        int evenIndex = 0;
        for (int i = 0; i < A.length; i++) {
            if(A[i]%2==0){
                result[evenIndex] = A[i];
                evenIndex+=2;
            }
            else {
                result[oddIndex] = A[i];
                oddIndex+=2;
            }
        }
        return result;
    }

}
