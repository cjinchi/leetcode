public class LongestValidParentheses {
    public int longestValidParentheses(String s) {
        //TODO
        int max = 0;
        int num = 0;
//        char nextC = '(';
        boolean shouldLeft = true;
        for (int i = 0;i<s.length();i++){
            if (s.charAt(i)=='('){
                if (!shouldLeft){
                    num = 0;
                }
                shouldLeft = false;
            }else{
                if (!shouldLeft){
                    num += 2;
                    max = Math.max(max,num);
                    shouldLeft = true;
                }else {
                    num = 0;
                }

            }
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(new LongestValidParentheses().longestValidParentheses(")()())"));
    }
}
