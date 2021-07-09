package yuhang.test.com;

public class Clumsy {
    public static void main(String[] args) {
        Clumsy clumsy = new Clumsy();
        System.out.println(clumsy.clumsy(10));
    }
    public int clumsy(int N) {
        int result = calc(N);
        int pos = N - 3;
        while(pos >= 1){
            result += pos;
            result -= calc(pos - 1);
            pos -= 4;
        }
        return result;
    }
    public int calc(int N){
        int res = 0;
        if(N >= 3){
            int nums1 = N - 1;
            int nums2 = N - 2;

            res += N * nums1 / nums2;
        }
        else{
            res = N;
        }
        return res;
    }
}
