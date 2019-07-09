
public class PalindromePartitioningII {
    public int minCut(String s) {
        int[] dp = new int[s.length()];
        dp[0] = 1;
        for(int i = 1;i<dp.length;i++) {
        	dp[i] = dp[i-1]+1;
        	for(int j = 0;j<i;j++) {
        		if(isPalindrome(s.substring(j,i+1))) {
        			dp[i] = Math.min(dp[i], j==0?1:dp[j-1]+1);
        		}
        	}
        }
        return dp[s.length()-1]-1;
    }
    
    boolean isPalindrome(String s) {
    	if(s.length()==0) {
    		return true;
    	}
    	int i = 0,j=s.length()-1;
    	while(i<j) {
    		if(s.charAt(i)!=s.charAt(j)) {
    			return false;
    		}
    		i++;
    		j--;
    	}
    	return true;
    }
    
    public static void main(String[] args) {
		System.out.println(new PalindromePartitioningII().minCut("aab"));
	}
}
