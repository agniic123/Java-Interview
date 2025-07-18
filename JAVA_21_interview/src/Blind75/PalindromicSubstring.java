package Blind75;

public class PalindromicSubstring {

   public static int countSubStringPalindrome(String s){
        int count =0;
        for(int i=0;i<s.length();i++){
            //odd count
            count+=PalindromeHelper(s,i,i);
            //even count
            count+=PalindromeHelper(s,i,i+1);

        }
  return count;
    }
    private static int PalindromeHelper(String s,int left,int right){
        int count=0;
         while (left>=0 && right < s.length() && s.charAt(left) == s.charAt(right)){
             count ++;
             left--;
             right++;
         }
         return count;
    }

    public static void main(String[] args) {
        String s="aabbc";

        System.out.println(countSubStringPalindrome(s));

    }
}
