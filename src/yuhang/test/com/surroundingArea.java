package yuhang.test.com;
import java.util.Stack;

public class surroundingArea {
    public static void main(String[] args) {
        surroundingArea surroundingArea = new surroundingArea();

        String[] nums = new String[]{
                "XOXOXOOOXO",
                "XOOXXXOOOX",
                "OOOOOOOOXX",
                "OOOOOOXOOX",
                "OOXXOXXOOO",
                "XOOXXXOXXO",
                "XOXOOXXOXO",
                "XXOXXOXOOX",
                "OOOOXOXOXO",
                "XXOXXXXOOO"};
        char[][] data = new char[nums.length][nums[0].length()];
        int i = 0;
        for(String item:nums){
            data[i++] = item.toCharArray();
        }
        surroundingArea.solve(data);
        for (char[] item:data
             ) {
            for (char cha:item
                 ) {
                System.out.print(cha + " ");
            }
            System.out.println();
        }
    }
    int row;
    int col;
    public void solve(char[][] board) {
        row = board.length;
        if (row == 0) return;
        col = board[0].length;
        boolean[][] record = new boolean[row][col];

        for(int j = 0; j < col; j++){
            if(!record[0][j] && board[0][j] == 'O')
                check(board, record, 0, j);
        }
        for(int i = 1; i < row; i++){
            if(!record[i][col - 1] && board[i][col - 1] == 'O')
                check(board, record, i, col - 1);
        }
        for(int i = 1; i < row; i++){
            if(!record[i][0] && board[i][0] == 'O')
                check(board, record, i, 0);
        }
        for(int j = 1; j < col - 1; j++){
            if(!record[row - 1][j] && board[row - 1][j] == 'O')
                check(board, record, row - 1, j);
        }

        for(int i = 1; i < row - 1; i++){
            for(int j = 1; j < col - 1; j++){
                if(!record[i][j] && board[i][j] == 'O')
                    board[i][j] = change(board, record, i, j);
            }
        }
    }

    public char change(char[][] board, boolean[][] record, int indexi, int indexj){
        record[indexi][indexj] = true;

        if(indexi == 0 || indexi == row - 1 || indexj == 0 || indexj == col - 1)
            return 'O';
        board[indexi][indexj] = 'X';
        Stack<int[]> stack = new Stack<>();
        if(board[indexi - 1][indexj] == 'O'){
            if(!record[indexi - 1][indexj])
                stack.push(new int[]{indexi - 1, indexj});
            else {
                board[indexi][indexj] = 'O';
                return 'O';
            }
        }
        if(board[indexi + 1][indexj] == 'O'){
            if(!record[indexi + 1][indexj])
                stack.push(new int[]{indexi + 1, indexj});
            else {
                board[indexi][indexj] = 'O';
                return 'O';
            }
        }
        if(board[indexi][indexj - 1] == 'O'){
            if(!record[indexi][indexj - 1])
                stack.push(new int[]{indexi, indexj - 1});
            else {
                board[indexi][indexj] = 'O';
                return 'O';
            }
        }
        if(board[indexi][indexj + 1] == 'O'){
            if(!record[indexi][indexj + 1])
                stack.push(new int[]{indexi, indexj + 1});
            else {
                board[indexi][indexj] = 'O';
                return 'O';
            }
        }
        if(stack.isEmpty()) return 'X';
        while(!stack.isEmpty()){
            int[] pos = stack.pop();
            board[indexi][indexj] = change(board, record, pos[0], pos[1]);
        }
        return board[indexi][indexj];
    }

    public void check(char[][] board, boolean[][] record, int indexi, int indexj){
        record[indexi][indexj] = true;

        Stack<int[]> stack = new Stack<>();
        if(indexi > 0 && board[indexi - 1][indexj] == 'O'){
            if(!record[indexi - 1][indexj])
                stack.push(new int[]{indexi - 1, indexj});
        }
        if(indexi < row - 1 && board[indexi + 1][indexj] == 'O'){
            if(!record[indexi + 1][indexj])
                stack.push(new int[]{indexi + 1, indexj});
        }
        if(indexj > 0 && board[indexi][indexj - 1] == 'O'){
            if(!record[indexi][indexj - 1])
                stack.push(new int[]{indexi, indexj - 1});
        }
        if(indexj < col - 1 && board[indexi][indexj + 1] == 'O'){
            if(!record[indexi][indexj + 1])
                stack.push(new int[]{indexi, indexj + 1});
        }
        if(stack.isEmpty()) return;
        while(!stack.isEmpty()){
            int[] pos = stack.pop();
            check(board, record, pos[0], pos[1]);
        }
    }
}
