/*
36. Valid Sudoku
Determine if a Sudoku is valid, according to: Sudoku Puzzles - The Rules.

The Sudoku board could be partially filled, where empty cells are filled with the character '.'.


A partially filled sudoku which is valid.

Note:
A valid Sudoku board (partially filled) is not necessarily solvable. Only the filled cells need to be validated.
*/
public class Solution {
    public boolean isValidSudoku(char[][] board) {
        Set<Character> row = new HashSet<Character>();
        Set<Character> column = new HashSet<Character>();
        Set<Character> block = new HashSet<Character>();
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                if(board[i][j]!='.' && !row.contains(board[i][j]))
                    row.add(board[i][j]);
                else if(row.contains(board[i][j]))
                    return false;
                if(board[j][i]!='.' && !column.contains(board[j][i]))
                    column.add(board[j][i]);
                else if(column.contains(board[j][i]))
                    return false;
                int blockRow = 3*(i/3)+j/3;
                int blockColumn = 3*(i%3)+j%3;
                if(board[blockRow][blockColumn]!='.' && !block.contains(board[blockRow][blockColumn])){
                    block.add(board[blockRow][blockColumn]);
                }
                else if(block.contains(board[blockRow][blockColumn]))
                    return false;
            }
            row.clear();
            column.clear();
            block.clear();
        }
        return true;
    }
    
}
