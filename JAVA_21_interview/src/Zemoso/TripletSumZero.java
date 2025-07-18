package Zemoso;

import java.util.List;
import java.util.*;

public class TripletSumZero {
public static Set<List<Integer>> findTriplets(int [] nums){

Set<List<Integer>> result=new HashSet<>();
Arrays.sort(nums);
for(int i=0;i<nums.length-2;i++){

    int left=i+1;
    int right=nums.length-1;
    while(right>left){
        int sum=nums[i]+nums[left]+nums[right];
        if(sum ==0){
            result.add(Arrays.asList(nums[i],nums[left],nums[right]));
            left++;
            right--;
        }else if(sum<0){
            left++;
        }else {
            right--;
        }


    }

}
return result;
}
    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};

        findTriplets(nums);
    }
}
