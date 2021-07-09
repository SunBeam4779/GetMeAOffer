package yuhang.test.com;

import java.math.BigInteger;

class CuttingRope {
    public static void main(String[] args) {
        CuttingRope cuttingRope = new CuttingRope();
        System.out.println(cuttingRope.cuttingRope(120));
    }
    BigInteger[] data;
    int[] k;
    public int cuttingRope(int n) {
        data = new BigInteger[n + 1];
        data[0] = new BigInteger("0");
        data[1] = new BigInteger("1");
        BigInteger bigInteger = new BigInteger("1000000007");
        return count(n, data).mod(bigInteger).intValue();
    }
    public BigInteger count(int n, BigInteger[] r){
        for (int j = 2; j <= n; j++) {
            BigInteger  res = new BigInteger("0");
            for (int i = 1; i <= j / 2; i++) {
                int lhs = data[i].intValue();
                if (lhs < i) lhs = i;
                int rhs = data[j - i].intValue();
                if (rhs < j - i) rhs = j - i;
                int temp = lhs * rhs;
                if (res.intValue() < temp) res = BigInteger.valueOf(temp);
            }
            data[j] = res;
        }
        return data[n];
    }
}
