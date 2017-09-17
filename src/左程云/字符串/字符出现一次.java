package 左程云.字符串;

/**
 * Created by yyc on 2017/9/17.
 * 判断字符数组中是否所有字符都只出现一次
 */
public class 字符出现一次 {
    //时间复杂度为O(N)
    public static boolean isUnique1(char[] chas){
        if(chas==null){
            return true;
        }
        boolean [] map=new boolean[256];
        for(char c:chas){
            if(map[c]){
                return false;
            }
            map[c]=true;
        }
        return true;
    }
    //空间复杂度为O(1)，使得时间复杂度尽量低：使用非递归的堆排序实现,时间复杂度为O(NlogN)
    public static boolean isUnique2(char[] chas){
        if(chas==null){
            return true;
        }
        heapSort(chas);
        for(int i=1;i<chas.length;i++){
            if(chas[i]==chas[i-1]){
                return false;
            }
        }
        return true;
    }
    public static void heapSort(char[] chas){
        for(int i=0;i<chas.length;i++){
            heapInsert(chas,i);
        }
        for(int i=chas.length-1;i>0;i--){
            swap(chas,0,i);
            heapify(chas,0,i);
        }
    }
    public static void heapInsert(char[] chas,int i){
        int parent=0;
        while(i!=0){
            parent=(i-1)/2;
            if(chas[parent]<chas[i]){
                swap(chas,parent,i);
                i=parent;
            }else {
                break;
            }
        }
    }
    public static void swap(char[]chas,int index1,int index2){
        char tmp=chas[index1];
        chas[index1]=chas[index2];
        chas[index2]=tmp;
    }
    public  static void heapify(char[] chas,int i,int size){
        int left=i*2+1;
        int right=i*2+2;
        int largest=i;
        while(left<size){
            if(chas[left]>chas[i]){
                largest=left;
            }
            if(right<size&&chas[right]>chas[largest]){
                largest=right;
            }
            if(largest!=i){
                swap(chas,largest,i);
            }else {
                break;
            }
            i=largest;
            left=i*2+1;
            right=i*2+2;
        }
    }
    public static void main(String[] args) {

        char[] chas={'a','b','c'};
        //时间复杂度为O(N)
        System.out.println(isUnique1(chas));
        //空间复杂度O(1)
        System.out.println(isUnique2(chas));
    }
}
