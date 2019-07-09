
public class OnesandZeroes {
	public int findMaxForm(String[] strs, int m, int n) {
		int[] ones = new int[strs.length];
		int[] zeros = new int[strs.length];
		for(int i = 0;i<strs.length;i++) {
			ones[i] = strs[i].length() - strs[i].replace("1","").length();
			zeros[i] = strs[i].length() - ones[i];
		}
		int[][] dp = new int[m+1][n+1];
		for(int i = 0;i<strs.length;i++) {
			for(int j = m;j>=0;j--) {
				for(int k = n;k>=0;k--) {
					if(i==0) {
						if(j>=zeros[i]&&k>=ones[i]) {
							dp[j][k] = 1;
						}else {
							dp[j][k] = 0;
						}
						continue;
					}
					dp[j][k] = Math.max(dp[j][k], (j>=zeros[i]&&k>=ones[i]?dp[j-zeros[i]][k-ones[i]]+1:Integer.MIN_VALUE));
				}
			}
		}
		return dp[m][n];
	}
	
	public static void main(String[] args) {
		String[] strs = {"10", "0", "1"};
		System.out.println(new OnesandZeroes().findMaxForm(strs, 1, 1));
	}
}
