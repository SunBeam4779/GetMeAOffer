package yuhang.test.com;

public class RangeBitWiseAnd {
    public static void main(String[] args) {
        int m = 5;
        int n = 7;
        RangeBitWiseAnd rangeBitWiseAnd = new RangeBitWiseAnd();
        int res = rangeBitWiseAnd.rangeBitwiseAnd(m, n);
        System.out.println(res);
    }

    public int rangeBitwiseAnd(int m, int n) {
        if(m == n) return m;
        int mid = (n - m) / 2 + m;

        int left = rangeBitwiseAnd(m, mid);
        int right = rangeBitwiseAnd(mid + 1, n);

        return left & right;
    }
}
