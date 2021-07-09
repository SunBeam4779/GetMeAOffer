package yuhang.test.com;

public class ConstructArr {
    public static void main(String[] args) {
        int[] data = {1, 2, 3, 4, 5};
        int[] res = new ConstructArr().constructArr(data);
        for(int item : res){
            System.out.println(item);
        }
    }
    public int[] constructArr(int[] a) {
        int[] b = new int[a.length];
        int[] c = new int[a.length];
        int[] d = new int[a.length];
        c[0] = 1;
        d[a.length - 1] = 1;
        for(int i = 1; i < a.length; i++){
            c[i] = c[i - 1] * a[i - 1];
        }
        for(int i = a.length - 2; i >=0; i--){
            d[i] = d[i + 1] * a[i + 1];
        }
        for(int i = 0; i < a.length; i++){
            b[i] = c[i] * d[i];
        }
        return b;
    }
}
