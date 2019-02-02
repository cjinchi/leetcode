import java.util.HashSet;
import java.util.Set;

public class ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        for(int i=0;i<9;i++){
            Set<Character> set1 = new HashSet<>();
            Set<Character> set2 = new HashSet<>();
            for(int j=0;j<9;j++){
                if (board[i][j]!='.'&&set1.contains(board[i][j])){
                    return false;
                }else{
                    set1.add(board[i][j]);
                }

                if(board[j][i]!='.'&&set2.contains(board[j][i])){
                    return false;
                }else{
                    set2.add(board[j][i]);
                }
            }

        }

        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                Set<Character> set = new HashSet<>();
                for(int k=i*3;k<i*3+3;k++){
                    for(int l=j*3;l<j*3+3;l++){
                        if (board[k][l]!='.'&&set.contains(board[k][l])){
                            return false;
                        }else{
                            set.add(board[k][l]);
                        }
                    }
                }
            }
        }
        return true;
    }
}
