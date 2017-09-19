package 左程云.数组和矩阵;

/**
 * Created by yyc on 2017/9/19.
 */
public class 转圈打印矩阵 {
    public static void spiralOrderPrint(int[][] matrix){
        int tR=0;
        int tC=0;
        int dR=matrix.length-1;
        int dC=matrix[0].length-1;
        while(tR<=dR&&tC<=dC){
            printEdge(matrix,tR++,tC++,dR--,dC--);
        }
    }
    public static void printEdge(int[][]m,int tR,int tC,int dR,int dC){
        if(tR==dR){//子矩阵只有一行时
            for(int i=tC;i<=dC;i++){
                System.out.print(m[tR][i]+" ");
            }
        }else if(tC==dC){//子矩阵只有一列时
            for(int i=tR;i<=dR;i++){
                System.out.print(m[i][tC]);
            }
        }else{//一般情况
            int curC=tC;
            int curR=tR;
            while(curC!=dC){
                System.out.print(m[tR][curC]+" ");
                curC++;
            }
            while(curR!=dR){
                System.out.print(m[curR][dC]+" ");
                curR++;
            }
            while(curC!=tC){
                System.out.print(m[dR][curC]+" ");
                curC--;
            }
            while(curR!=tR){
                System.out.print(m[curR][tC]+" ");
                curR--;
            }
        }
    }

    public static void main(String[] args) {
        int[][] m={{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        spiralOrderPrint(m);
    }
}
