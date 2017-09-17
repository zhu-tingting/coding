package 左程云.递归和动态规划;

/**
 * Created by yyc on 2017/9/4.
 * 给定整数N，返回斐波那契数列的第N项
 * 1,1,2,3,5,8,13...
 * 时间复杂度O(logN)
 * 将求第N项的问题变成如何用最快的方法求矩阵的N次方
 * 类比求一个整数的N次方
 * e.g.求10的75次方
 * 75的二进制数形式为1001011
 * 10的75次方=10^64*10^8*10^2*10^1
 */
public class 斐波那契数列 {
    public static int[][] multiMatrix(int[][] m1,int[][] m2){
        int[][] res=new int[m1.length][m2[0].length];
        for(int i=0;i<m2[0].length;i++){
            for(int j=0;j<m1.length;j++){
                for(int k=0;k<m2.length;k++){
                    res[i][j]+=m1[i][k]*m2[k][j];
                }
            }
        }
        return res;
    }
    public static int[][] matrixPower(int[][] m,int p){
        int[][] res=new int[m.length][m[0].length];
        //将res设为单位矩阵，相当于整数中的1
        for(int i=0;i<res.length;i++){
            res[i][i]=1;
        }
        int[][] tmp=m;
        for(;p!=0;p>>=1){
            if((p&1)!=0){
                res=multiMatrix(res,tmp);
            }
            tmp=multiMatrix(tmp,tmp);
        }
        return res;
    }
    //O(logN)解法
    public static int f3(int n){
        if(n<1){
            return 0;
        }
        if(n==1||n==2){
            return 1;
        }
        int[][] base={{1,1},{1,0}};
        int[][] res=matrixPower(base,n-2);
        return res[0][0]+res[1][0];
    }
    //O(N)的方法
    public static int f2(int n){
        if(n<1){
            return 0;
        }
        if(n==1||n==2){
            return 1;
        }
        int res=1;
        int pre=1;
        int tmp=0;
        for(int i=3;i<=n;i++){
            tmp=res;
            res=res+pre;
            pre=tmp;
        }
        return res;
    }
    //暴力递归方法O(2^N)
    public static int f1(int n){
        if(n<1){
            return 0;
        }
        if(n==1||n==2){
            return 1;
        }
        return f1(n-1)+f1(n-2);
    }


    public static void main(String[] args) {
        System.out.println(f1(3));
        System.out.println(f2(3));
        System.out.println(f3(3));
    }
}
