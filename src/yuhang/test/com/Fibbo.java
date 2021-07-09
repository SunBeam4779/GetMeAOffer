package yuhang.test.com;

public class Fibbo {
    public static void main(String[] args) {
        Fibbo fibbo = new Fibbo();
        System.out.println(fibbo.fib(10));
    }
    long[] data = new long[101];
    public int fib(int n) {
        if(n <= 2 && n > 0){
            data[n] = 1;
            return 1;
        }
        if(n == 0) {
            data[n] = 0;
            return 0;
        }
        if(data[n] != 0) return (int)data[n];

        long res = fib(n - 1) + fib(n - 2);
        if(res >= 1000000007)
            res = res % 1000000007;
        return (int)res;
    }
}
