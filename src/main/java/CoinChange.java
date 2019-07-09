
public class CoinChange {
	
    public int coinChange(int[] coins, int amount) {
        int coinTypeNum = coins.length;
        //The 0 index of 2d will not be used
        int dp[] = new int[amount+1];
        for(int i = 0;i<coinTypeNum;i++) {
        	for(int j = 0;j<=amount;j++) {
        		if(j==0) {
        			dp[j] = 0;
        		}else if(i==0) {
        			if(j%coins[i]==0) {
        				dp[j] = j/coins[i];
        			}else {
        				dp[j]=Integer.MAX_VALUE;
        			}
        		}else {
        			int one = dp[j];
        			int two = (j>=coins[i]?dp[j-coins[i]]:Integer.MAX_VALUE);
        			if(two != Integer.MAX_VALUE) {
        				two += 1;
        			}
        			dp[j] = Math.min(one, two);
        		}
        	}
        }
        return (dp[amount]==Integer.MAX_VALUE?-1:dp[amount]);
    }
    
    public static void main(String[] args) {
		int[] a = {1,2};
		System.out.println(new CoinChange().coinChange(a, 2));
	}
}
