package Blind75;

import java.util.HashSet;
import java.util.Set;

public class LengthOflongestSubstring {

    public static void main(String[] args) {
        String s="pwwkewxpw";
        System.out.println(LogestSubstring(s));
    }

    private static int  LogestSubstring(String s){
        Set<Character> sc=new HashSet<>();
        int maxLength=0;
        int left=0;

        for (int i=0;i<s.length();i++){

            while (sc.contains(s.charAt(i))){
                sc.remove(s.charAt(left));
                left++;
            }
            sc.add(s.charAt(i));
            maxLength=Math.max(maxLength,i-left+1);
        }
       return maxLength;
    }
}
