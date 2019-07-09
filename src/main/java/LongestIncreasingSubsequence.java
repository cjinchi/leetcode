import java.util.Arrays;
import java.util.Collections;

public class LongestIncreasingSubsequence {
	public int lengthOfLIS(int[] nums) {
		if(nums.length==0) {
			return 0;
		}
		int[] dp = new int[nums.length];
		dp[0] = 1;
		for(int i = 1;i<dp.length;i++) {
			dp[i] = 1;
			for(int j = 0;j<i;j++) {
				if(nums[j]<nums[i]) {
					dp[i] = Math.max(dp[j]+1, dp[i]);
				}
			}
		}
		
		int max = 0;
		for(int x:dp) {
			max = Math.max(max, x);
		}
		return max;
		
		
		
//		Version 2
//		if(nums.length == 0) {
//			return 0;
//		}
//		int[] tail = new int[nums.length];
//		int current = 0;
//		for(int num:nums) {
//			int i = 0;
//			while(i<current && tail[i]<num) {
//				i++;
//			}
//			if(i==current) {
//				tail[current] = num;
//				current ++;
//			}else {
//				tail[i] = num;	
//			}
//		}
//		return current;
	}
	
	public static void main(String[] args) {
		int a[] = {1,3,6,7,9,4,10,5,6};
		System.out.println(new LongestIncreasingSubsequence().lengthOfLIS(a));
	}
}
