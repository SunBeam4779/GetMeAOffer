package yuhang.test.com;

public class MyOwnPow {
    public static void main(String[] args) {
        double x = 2.000000;
        int n = -2147483648;
        double res = new MyOwnPow().myPow(x, n);
    }

    public double myPow(double x, int n){
        if(n == 0 || x == 0) return 1;
        if(x == 1) return 1;
        double res = 1;

        if(n < 0){
            res *= 1 / process(x, -(long) n);
        }
        else{
            res = process(x, n);
        }
        return res;
    }
    public double process(double x, long n){
        if(n == 1) return x;
        double res = process(x, n / 2);
        res *= res;
        if((n & 0x1) == 1) res *= x;
        return res;
    }
}
