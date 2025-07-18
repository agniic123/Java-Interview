import java.util.HashMap;
import java.util.Map;

public class LogestSubarrayZRO {


    public static void main(String[] args) {
        int [] input={1, 2, -2, 4, -4, 3, 1, -1, 2, -2};
       // System.out.println(logestSubarrayLargestzero(input));
    }

    private static void logestSubarrayLargestzero(int [] input) {

        int sum=0,len=0,maxLen=0,start=0;
        Map<Integer,Integer> trackerSum= new HashMap<>();
        trackerSum.put(0,-1);
        for(int i=0;i<input.length;i++){
         sum=+input[i];

         if(trackerSum.containsKey(sum)){
             len=i- trackerSum.get(sum);

             if(len>maxLen){
                 maxLen=len;
                 start=trackerSum.get(sum)+1;
             }
         }else {
             trackerSum.put(sum,i);
         }
        }

    }
}
