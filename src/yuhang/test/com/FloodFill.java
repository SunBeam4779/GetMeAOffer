package yuhang.test.com;

public class FloodFill {
    public static void main(String[] args) {
        int[][] data = new int[][]{
                {0, 0, 0},
                {0, 1, 1}
        };
        int sr = 1;
        int sc = 1;
        int newColor = 1;
        data = new FloodFill().floodFill(data, sr, sc, newColor);
        for (int[] item:data){
            for (int i:item){
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
    int color;
    int row;
    int col;
    boolean[][] record;
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        color = image[sr][sc];
        row = image.length;
        if(row == 0) return image;
        col = image[0].length;
        record = new boolean[row][col];
        process(image, sr, sc, newColor);
        return image;
    }
    public void process(int[][] image, int sr, int sc, int newColor){
        image[sr][sc] = newColor;
        record[sr][sc] = true;
        if (sr > 0 && image[sr - 1][sc] == color && !record[sr - 1][sc]) process(image, sr - 1, sc, newColor);
        if (sr < row - 1 && image[sr + 1][sc] == color && !record[sr + 1][sc]) process(image, sr + 1, sc, newColor);
        if (sc > 0 && image[sr][sc - 1] == color && !record[sr][sc - 1]) process(image, sr, sc - 1, newColor);
        if (sc < col - 1 && image[sr][sc + 1] == color && !record[sr][sc + 1]) process(image, sr, sc + 1, newColor);
    }
}
