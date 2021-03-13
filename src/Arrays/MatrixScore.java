package Arrays;
//有一个二维矩阵 A 其中每个元素的值为 0 或 1 。
//
//移动是指选择任一行或列，并转换该行或列中的每一个值：将所有 0 都更改为 1，将所有 1 都更改为 0。
//
//在做出任意次数的移动后，将该矩阵的每一行都按照二进制数来解释，矩阵的得分就是这些数字的总和。
//
//返回尽可能高的分数。
//861
public class MatrixScore {
    //官方的方法直接观察，然后计数，不进行更改，10来行就解决了，淦
    //行列别混淆
    public static void main(String[] args) {
        int[][] a = new int[][]{{0,0,1,1},{1,0,1,0},{1,1,0,0}};
        System.out.println(matrixScore(a));
    }
    public static int matrixScore(int[][] A) {
        //考虑特殊情况
        //当数组为空或者只有一行或者一列时
        if(A==null) return 0;
        int rowLength = A.length;
        int columnLength = A[0].length;
        int sum = 0;
        if(rowLength==1){
            for (int i = 0; i < columnLength; i++) {
                sum+=(int)Math.pow(2,columnLength-i-1);
            }
            return sum;
        }
        if(columnLength==1){
            return rowLength;
        }
        //首先将第一列所有数变为1
        //取反操作用~，啊这，~不行啊，只能自己整了
        for (int i = 0; i < rowLength; i++) {
            if(A[i][0]==0){
                for (int j = 0; j < columnLength; j++) {
                    if(A[i][j]==0) A[i][j] = 1;
                    else A[i][j] = 0;
                }
            }
        }
        //将第一列往后的每一列1尽量多
        //也就是要1的数量大于等于行数的1/2
        for (int i = 1; i < columnLength; i++) {
            int n = 0;
            for (int j = 0; j < rowLength; j++) {
                if(A[j][i]==1) n++;
            }
            if(n<=rowLength/2){
                for (int j = 0; j < rowLength; j++) {
                    if(A[j][i]==0) A[j][i] = 1;
                    else A[j][i] = 0;
                }
            }
        }
        //求和
        //每一列求和n，然后乘上对应的2的倍数，sum+=n，sum就是最后的值
        for (int i = 0; i < columnLength; i++) {
            int n = 0;
            for (int j = 0; j < rowLength; j++) {
                if(A[j][i]==1) n++;
            }
            sum+=n*(int)Math.pow(2,columnLength-i-1);
        }
        return sum;
    }
}
