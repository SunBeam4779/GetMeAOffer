package yuhang.test.com;

import java.util.ArrayList;
import java.util.List;

public class NQueens {
    public static void main(String[] args) {
        NQueens nQueens = new NQueens();
        List<List<String>> res = nQueens.solveNQueens(6);
        int i = 1;
        System.out.println(res.size());
        for(List<String> item:res){
            System.out.println("answer" + i++);
            for (String s:item){
                char[] data = s.toCharArray();
                for(char index:data){
                    System.out.print(index + " ");
                }
                System.out.println();
            }
        }
        ArrayList<Character> arrayList = new ArrayList<>();
    }
    List<List<String>> res;
    public List<List<String>> solveNQueens(int n) {
        boolean[] pos = new boolean[n];
        boolean[] check = new boolean[n];

        res = new ArrayList<>();
//        StringBuilder line = new StringBuilder();
//        line.append(".".repeat(Math.max(0, n)));
//        List<StringToInt> board = new ArrayList<>();
        char[][] board = new char[n][n];
        for(int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                board[i][j] = '.';
            }
//            board.add(line.toString());
        }
        process(board, 0);
        return res;
    }
    public void process(char[][] board, int line){
        if(line == board.length) {
            List<String> temp = new ArrayList<>();
            for (char[] chars : board) {
                temp.add(String.valueOf(chars));
            }
            res.add(temp);
            return;
        }
        // List<String> temp = new ArrayList<>(board);
        int length = board.length;
        for(int i = 0; i < length; i++){

            if(!isValid(board, line, i)) continue;

//            StringBuilder sb = new StringBuilder(board.get(line));
//            sb.setCharAt(i, 'Q');
//
            board[line][i] = 'Q';
            process(board, line + 1);
//            sb.setCharAt(i, '.');
//            board.set(line, sb.toString());
            board[line][i] = '.';
        }
    }

    public boolean isValid(char[][] board, int line, int col){
        int length = board.length;
        for(int i = 0; i < line; i++){
            if(board[i][col] == 'Q') return false;
            if((0 <= col - line + i && col - line + i  < length && board[i][col - line + i] == 'Q') ||
                    (0 <= col + line - i && col + line - i < length && board[i][col + line - i] == 'Q')) return false;
        }
        return true;
    }
}
