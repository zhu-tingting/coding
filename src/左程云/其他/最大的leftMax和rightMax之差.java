package 左程云.其他;

/**
 * Created by zhutingting on 2017/9/20.
 * 题目：给定长度为N（N>1）的数组，划分为左右两部分，求左部分的最大值减去右部分的绝对值的最大值是多少
 */
public class 最大的leftMax和rightMax之差 {
    //时间复杂度O(N^2)空间复杂度O(1)
    public static int maxABS1(int[] arr){
        int res=Integer.MIN_VALUE;
        int maxLeft=0;
        int maxRight=0;
        for(int i=0;i!=arr.length-1;i++){
            maxLeft=Integer.MIN_VALUE;
            for(int j=0;j!=i+1;j++){
                maxLeft=Math.max(arr[j],maxLeft);
            }
            maxRight=Integer.MIN_VALUE;
            for(int j=i+1;j!=arr.length;j++){
                maxRight=Math.max(arr[j],maxRight);
            }
            res=Math.max(res,Math.abs(maxLeft-maxRight));
        }
        return res;
    }
    //时间复杂度O(N)空间复杂度O(N)
    public static int maxABS2(int[] arr){
        int[] lArr=new int[arr.length];
        int[] rArr=new int[arr.length];
        lArr[0]=arr[0];
        rArr[arr.length-1]=arr[arr.length-1];
        for(int i=1;i<arr.length;i++){
            lArr[i]=Math.max(lArr[i-1],arr[i]);
        }
        for(int i=arr.length-2;i>-1;i--){
            rArr[i]=Math.max(rArr[i+1],arr[i]);
        }
        int max=0;
        for(int i=0;i<arr.length-1;i++){
            max=Math.max(max,Math.abs(lArr[i]-rArr[i]));
        }
        return max;
    }
    //时间复杂度O(N)空间复杂度O(1)
    public static int maxABS3(int[] arr){
        int max=Integer.MIN_VALUE;
        for(int i=0;i<arr.length;i++){
            max=Math.max(max,arr[i]);
        }
        return max-Math.min(arr[0],arr[arr.length-1]);
    }
    public static void main(String[] args) {
        int[] arr={2,7,3,1,1};
        System.out.println(maxABS1(arr));
        System.out.println(maxABS2(arr));
        System.out.println(maxABS3(arr));
    }
}
