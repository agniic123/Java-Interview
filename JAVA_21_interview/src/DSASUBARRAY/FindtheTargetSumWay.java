package DSASUBARRAY;

import java.util.HashMap;
import java.util.Map;

public class FindtheTargetSumWay {

    public static int findWayofsums(int[] nums,int target){
        Map<Integer,Integer> Dp=new HashMap<>();
        Dp.put(0,1);
        for(int num: nums){
            Map<Integer,Integer> nextDp=new HashMap<>();
            for(int sum:Dp.keySet()){
                int count=Dp.get(sum);
                nextDp.put(sum+num,nextDp.getOrDefault(sum+num,0)+count);
                nextDp.put(sum-num,nextDp.getOrDefault(sum-num,0)+count);

            }
            Dp=nextDp;
        }
        return Dp.getOrDefault(target,0);
    }

    public static void main(String[] args) {
        int [] arr={1,1,1,1,1};
        System.out.println(findWayofsums(arr,1));
    }
}
