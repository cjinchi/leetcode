
public class MinimumPathSum {
	
    public int minPathSum(int[][] grid) {
    	int row = grid.length;
    	int col = grid[0].length;
    	int[][] dp = new int[row][col];
    	dp[row-1][col-1]=grid[row-1][col-1];
    	
    	for(int i = row-1;i>=0;i--) {
    		for(int j = col-1;j>=0;j--) {
    			if(i==row-1&&j==col-1) {
    				continue;
    			}
    			int right = (j==col-1?Integer.MAX_VALUE:dp[i][j+1]);
    			int down = (i==row-1?Integer.MAX_VALUE:dp[i+1][j]);
    			dp[i][j] = Math.min(right, down) + grid[i][j];
    		}
    	}
    	return dp[0][0];
    }
    
    
    
    
	public static void main(String[] args) {
		int[][] a = {{1,3,1},{1,5,1},{4,2,1}};
		System.out.println(new MinimumPathSum().minPathSum(a));
	}
}
