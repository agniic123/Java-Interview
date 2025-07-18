package Blind75;

import java.util.Arrays;

public class AddIntervals {

   static int [][] inserts(int [][] intervals,int[] newIntervals){
        int [][] result =new int [intervals.length+1][2];
      int i=0,j=0;
        while (i<intervals.length && intervals[i][1]<newIntervals[0]){
            result[j++]=intervals[i++];
        }

        while(i<intervals.length && intervals[i][0]<=newIntervals[1]){
            newIntervals[0]=Math.min(newIntervals[0],intervals[i][0]);
            newIntervals[1]=Math.max(newIntervals[1],intervals[i++][1]);
}
        result[j++]=newIntervals;
        while (i<intervals.length){
            result[j++]=intervals[i++];
        }
        return Arrays.copyOf(result,j);
    }

    public static void main(String[] args) {
        int [][] input={
                {1,2},
                {3,5},
                {6,7},
                {8,10},
                {12,14}
        };
       int [] newIntervals={4,8};
      Arrays.stream(inserts(input,newIntervals)).forEach(e->Arrays.stream(e).forEach(System.out::println));
    }
}
