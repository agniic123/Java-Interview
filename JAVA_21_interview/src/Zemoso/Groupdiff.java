package Zemoso;

import java.util.Arrays;

public class Groupdiff {
    public int solution(int[] A) {
        int N = A.length;
        Arrays.sort(A);

        int minMaxDiff = Integer.MAX_VALUE;

        // i is the end index of the first group (exclusive)
        for (int i = 1; i < N - 1; i++) {//[1,3,4,5,6,7,8,11,12]
            // j is the end index of the second group (exclusive)
            for (int j = i + 1; j < N; j++) {
                // Group 1: A[0 .. i-1]
                int diff1 = A[i - 1] - A[0];

                // Group 2: A[i .. j-1]
                int diff2 = A[j - 1] - A[i];

                // Group 3: A[j .. N-1]
                int diff3 = A[N - 1] - A[j];

                int currentMax = Math.max(diff1, Math.max(diff2, diff3));
                minMaxDiff = Math.min(minMaxDiff, currentMax);
            }
        }

        return minMaxDiff;
    }
    public static void main(String[] args) {
        Groupdiff sol = new Groupdiff();
        int[] A = {11, 5, 3, 12, 6, 8, 1, 7, 4};
        int result = sol.solution(A);
        System.out.println(result); // Output: 3
    }
}
