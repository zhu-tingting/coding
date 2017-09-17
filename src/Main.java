import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int m=sc.nextInt();
        int n=sc.nextInt();
        int c=sc.nextInt();
        HashMap<Integer,List<Integer>> hash=new HashMap<>();
        for(int i=0;i<n;i++){
            int num_i=sc.nextInt();
            if(num_i==0)
                continue;
            for(int j=0;j<num_i;j++){
                int x=sc.nextInt();
                if(hash.containsKey(j+1)){
                    List<Integer> number=hash.get(j+1);
                    number.add(x);
                    hash.put(j+1,number);
                }else{
                    hash.put(j+1,new ArrayList<>()) ;
                }

            }
        }
        int count=0;
        for(int i=1;i<=c;i++){
            List<Integer> number=hash.get(c);
            if(number.isEmpty()){
                continue;
            }
            Collections.sort(number);
            if(n-number.get(number.size()-1)<m){
                count++;
                continue;
            }

            for(int j=1;j<number.size();j++){
                if(number.get(j)-number.get(j-1)<m){
                    count++;
                    break;
                }
            }
        }
        System.out.print(count);

    }

}
