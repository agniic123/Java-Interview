package DSASUBARRAY;

import java.util.*;

public class subarraySum {
    public static int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> subNum = new HashMap<>();
        subNum.put(0, 1);
        int total = 0, count = 0;

        for (int n : nums) {
            total += n;

            if (subNum.containsKey(total - k)) {
                count += subNum.get(total - k);
            }

            subNum.put(total, subNum.getOrDefault(total, 0) + 1);
        }

        return count;
    }

    public static void main(String[] args) {

        int[] input={1,1,1,1,1};
        int k=2;
        System.out.println(subarraySum(input,k));

    }
}
