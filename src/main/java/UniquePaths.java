public class UniquePaths {
    public int uniquePaths(int m, int n) {
        int[][] num = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            num[i][1] = 1;
        }
        for (int j = 1; j <= n; j++) {
            num[1][j] = 1;
        }
        for (int i = 2; i <= m; i++) {
            for (int j = 2; j <= n; j++) {
                num[i][j] = num[i - 1][j] + num[i][j - 1];
            }
        }
        return num[m][n];
    }

    public static void main(String[] args) {
        System.out.println(new UniquePaths().uniquePaths(7, 3));
    }
}
