import java.util.HashSet;
import java.util.Set;

public class ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        Set<String> set = new HashSet<>();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    continue;
                }
                String str = "[" + board[i][j] + "]";
                if (!set.add(i + str) || !set.add(str + j) || !set.add((i / 3) + str + (j / 3))) {
                    return false;
                }
            }
        }
        return true;
    }
}
