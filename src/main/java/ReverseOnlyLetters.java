public class ReverseOnlyLetters {
    private static boolean isLetter(char c) {
        return (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z');
    }

    public String reverseOnlyLetters(String S) {
        StringBuilder builder = new StringBuilder();
        int left = 0,right = S.length()-1;
        while (left<S.length()){
            if (isLetter(S.charAt(left))){
                while (!isLetter(S.charAt(right))){
                    right--;
                }
                builder.append(S.charAt(right));
                right--;
            }else{
                builder.append(S.charAt(left));
            }
            left++;
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        System.out.println("ab-cd".equals(new ReverseOnlyLetters().reverseOnlyLetters("dc-ba")));
        System.out.println("a-bC-dEf-ghIj".equals(new ReverseOnlyLetters().reverseOnlyLetters("j-Ih-gfE-dCba")));
        System.out.println("Test1ng-Leet=code-Q!".equals(new ReverseOnlyLetters().reverseOnlyLetters("Qedo1ct-eeLg=ntse-T!")));
    }
}
