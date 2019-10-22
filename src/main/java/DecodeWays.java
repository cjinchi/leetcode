public class DecodeWays {
    public int numDecodings(String s) {
        if (s.length() == 0) {
            return 0;
        }
        if (s.length() == 1) {
            return (s.equals("0") ? 0 : 1);
        }
        int[] num = new int[s.length()];
        num[0] = (s.charAt(0) == '0' ? 0 : 1);
        int firstTwoNum = Integer.valueOf(s.substring(0, 2));
        num[1] = (s.charAt(1) == '0' ? 0 : num[0]) + (firstTwoNum >= 10 && firstTwoNum <= 26 ? 1 : 0);
        for (int i = 2; i < s.length(); i++) {
            num[i] = 0;
            num[i] += (s.charAt(i) != '0' ? num[i - 1] : 0);
            int partNum = Integer.valueOf(s.substring(i - 1, i + 1));
            num[i] += (partNum >= 10 && partNum <= 26 ? num[i - 2] : 0);
        }
        return num[s.length() - 1];
    }
}
