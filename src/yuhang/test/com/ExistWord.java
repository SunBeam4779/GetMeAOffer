package yuhang.test.com;

public class ExistWord {
    public static void main(String[] args) {
        char[][] data = {
                {'C', 'A', 'A'},
                {'A', 'A', 'A'},
                {'B', 'C', 'D'}
        };
        System.out.println(new ExistWord().exist(data, "AAB"));
    }
    char[] letters;
    int row;
    int col;
    public boolean exist(char[][] board, String word) {
        letters = word.toCharArray();
        row = board.length;
        col = board[0].length;
        boolean[][] mark = new boolean[row][col];
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                if(dfs(board, mark, i, j, 0)) return true;
            }
        }
        return false;
    }
    public boolean dfs(char[][] board, boolean[][] mark, int indexi, int indexj, int index){

        if(board[indexi][indexj] != letters[index]) return false;
        else{
            if(index == letters.length - 1) return true;
        }
        mark[indexi][indexj] = true;

        if(indexi > 0 && !mark[indexi - 1][indexj]){
            if(dfs(board, mark, indexi - 1, indexj, index + 1)){
                mark[indexi][indexj] = false;
                return true;
            }
        }
        if(indexi < row - 1 && !mark[indexi + 1][indexj]){
            if(dfs(board, mark, indexi + 1, indexj, index + 1)){
                mark[indexi][indexj] = false;
                return true;
            }
        }
        if(indexj > 0 && !mark[indexi][indexj - 1]){
            if(dfs(board, mark, indexi, indexj - 1, index + 1)){
                mark[indexi][indexj] = false;
                return true;
            }
        }
        if(indexj < col - 1 && !mark[indexi][indexj + 1]){
            if(dfs(board, mark, indexi, indexj + 1, index + 1)){
                mark[indexi][indexj] = false;
                return true;
            }
        }
        mark[indexi][indexj] = false;
        return false;
    }
}
