package DSASUBARRAY;

public class LongestIncreaseSubArray {

    public  static int  LongestSubsequence(int[] nums){
int [] t=new int[nums.length];
for(int i=1;i<nums.length;i++){
    for(int j =0;j<i;j++){
        if(nums[i]>nums[j]){
            if(t[j]+1>t[i]){
                t[i]=t[j]+1;
            }
        }
    }
}

        int maxIndex = 0;
        for (int i = 0; i < t.length; i++)
            if (t[i] > t[maxIndex])
                maxIndex = i;

        return t[maxIndex] + 1;
    }

    public static void main(String[] args) {
        int [] s={10,9,2,5,3,7,101,18};
        int i = LongestSubsequence(s);
        System.out.println(i);
    }
}
