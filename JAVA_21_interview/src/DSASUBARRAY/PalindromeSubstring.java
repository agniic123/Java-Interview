package DSASUBARRAY;

import java.util.HashMap;

public class PalindromeSubstring {

    public static int maxLength(int [] nums){
        for(int i=0;i<nums.length;i++){
            if(nums[i] ==0) nums[i]=-1;
        }

        int sum=0;
        int maxLength=0;
        HashMap<Integer,Integer>trackSum=new HashMap<>();
        trackSum.put(0,-1);
        for (int j=0;j<nums.length;j++){
            sum+=nums[j];

            if(trackSum.containsKey(sum)){
                maxLength=Math.max(maxLength,j-trackSum.get(sum));
            }else {
                trackSum.put(sum,j);
            }
        }
return maxLength;
    }

    public static void main(String[] args) {
        int [] input={0,0,1,0,0,0,1,1};
        System.out.println(maxLength(input));
    }
}
