public class ReverseInteger {
    public int reverse(int x) {
        final boolean active = (x >= 0);

        int temp = Math.abs(x);
        while (temp!=0 && temp%10==0){
            temp /= 10;
        }
        String retStr = new StringBuilder(String.valueOf(temp)).reverse().toString();
        try {
            int ret = Integer.valueOf(retStr);
            return active?ret:-ret;
        }catch (Exception e){
            //overflow
            return 0;
        }
    }

    public static void main(String[] args) {
        for (String c:"abc".split("")){
            System.out.println(c);
        }
//        int a = Integer.valueOf("534619978");
//        System.out.println(new ReverseInteger().reverse(123));
//        System.out.println(new ReverseInteger().reverse(-123));
//        System.out.println(new ReverseInteger().reverse(120));
    }

}
