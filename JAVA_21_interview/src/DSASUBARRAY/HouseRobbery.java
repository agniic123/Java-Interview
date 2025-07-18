package DSASUBARRAY;

import java.util.Arrays;

public class HouseRobbery {

    public static int HouseRobery(int[] nums) {
        if (nums.length < 2) {
            return 0;
        }
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(dp[0], nums[1]);

        for(int i=2;i<nums.length;i++){

            dp[i]=Math.max(dp[i-2]+nums[i],dp[i-1]);
        }

  return dp[nums.length-1];
    }

    public static void main(String[] args) {
        int [] input={2,7,3,1,4,2,1,8};
        System.out.println(HouseRobery(input));
    }
}
