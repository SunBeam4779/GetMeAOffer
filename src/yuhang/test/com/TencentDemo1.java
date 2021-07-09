package yuhang.test.com;

import java.util.LinkedList;

public class TencentDemo1 {
    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        int length1 = scanner.nextInt();
        int[] data1 = new int[]{6,5,4,3,2,1};
//        for(int i = 0; i < length1; i++){
//            data1[i] = scanner.nextInt();
//        }
//        int length2 = scanner.nextInt();
        int[] data2 = new int[]{6,5,3,2,1};
//        for (int i = 0; i < length2; i++){
//            data2[i] = scanner.nextInt();
//        }
        solution(data2, data1);

    }
    public static void solution(int[] data1, int[] data2){
        int row = data1.length;
        int col = data2.length;
        int[][] record = new int[row + 1][col + 1];
        int[][] mark = new int[row + 1][col + 1];
        for (int i = 0; i < col; i++){
            record[0][i] = 0;
        }
        for (int i = 0; i < row; i++){
            record[i][0] = 0;
        }
        for(int i = 1; i <= row; i++){
            int temp = data1[i - 1];
            for (int j = 1; j <= col; j++){
                if (temp == data2[j - 1]){
                    record[i][j] = record[i - 1][j - 1] + 1;
                    mark[i][j] = 2;
                }else{
                    if(record[i][j - 1] > record[i - 1][j]){
                        record[i][j] = record[i][j - 1];
                        mark[i][j] = 0;
                    }else{
                        record[i][j] = record[i - 1][j];
                        mark[i][j] = 1;
                    }
                }
            }
        }
        LinkedList<Integer> linkedList = new LinkedList<>();
        int j = col;
        int i = row;
        while(j >= 0 && i >=0){
            if(mark[i][j] == 2) {
                linkedList.addFirst(data1[i - 1]);
                i--;
                j--;
            }else if(mark[i][j] == 1){
                i--;
            }else{
                j--;
            }
        }
        for (int item:linkedList){
            System.out.print(item + " ");
        }
    }
}
