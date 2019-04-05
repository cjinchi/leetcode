public class UniquePathsII {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {

        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

//        int[][] num = new int[m][n];
        boolean srcIsZero = true;
        if (obstacleGrid[0][0] == 0) {
            obstacleGrid[0][0] = 1;
        } else {
            obstacleGrid[0][0] = 0;
            srcIsZero = false;
        }

        boolean pivot = srcIsZero;
        for (int i = 1; i < m; i++) {
            if (obstacleGrid[i][0] == 1) {
                pivot = false;
            }
            if (pivot) {
                obstacleGrid[i][0] = 1;
            } else {
                obstacleGrid[i][0] = 0;
            }
        }

        pivot = srcIsZero;
        for (int j = 1; j < n; j++) {
            if (obstacleGrid[0][j] == 1) {
                pivot = false;
            }
            if (pivot) {
                obstacleGrid[0][j] = 1;
            } else {
                obstacleGrid[0][j] = 0;
            }
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (obstacleGrid[i][j] == 1) {
                    obstacleGrid[i][j] = 0;
                } else {
                    obstacleGrid[i][j] = obstacleGrid[i - 1][j] + obstacleGrid[i][j - 1];
                }

            }
        }
        return obstacleGrid[m - 1][n - 1];
    }
}
