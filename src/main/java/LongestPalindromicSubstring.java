public class LongestPalindromicSubstring {
    public String longestPalindrome(String s) {
        if (s.length()<=1){
            return s;
        }
        final int length = s.length();
        int maxLeft = 0,maxRight = 0;
        for (int i = 1;i<s.length();i++){
            int left = i,right =i;
            while (left - 1>=0 && right+1<length && s.charAt(left-1)==s.charAt(right+1)){
                left --;
                right++;
            }
            if (right - left > maxRight - maxLeft){
                maxLeft = left;
                maxRight = right;
            }
            if (s.charAt(i)==s.charAt(i-1)){
                left = i-1;
                right = i;
                while (left - 1>=0 && right+1<length && s.charAt(left-1)==s.charAt(right+1)){
                    left --;
                    right++;
                }
                if (right - left > maxRight - maxLeft){
                    maxLeft = left;
                    maxRight = right;
                }
            }
        }
        return s.substring(maxLeft,maxRight+1);
    }

}
