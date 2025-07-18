import java.util.*;
public class LongestConsecutiveTength {



    public static void main(String[] args) {
        int [] nums = {100, 4, 200, 1, 3, 2};
        String s="pwwkewxpw";

        System.out.println(longestConsecutive( nums));

    }

    public static int longestConsecutive(int[] nums){
        if(nums == null || nums.length == 0){
            return 0;
        }
      //  Arrays.sort(nums);
      //  int[] num = Arrays.stream(nums).distinct().toArray();
       Set<Integer> set =new HashSet<>();

        for(int s : nums){
            set.add(s);
        }


      int logestStreak=0;
       for(int num : set){

            if(!set.contains(num-1)){
                int currentNum = num;
               int currentStreak = 1;
            while(set.contains(currentNum + 1)){
                currentNum++;
                currentStreak++;

            }
             logestStreak=Math.max(logestStreak , currentStreak);
            }


        }

        return logestStreak;
    }
}
