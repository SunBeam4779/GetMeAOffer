package yuhang.test.com;

public class SortArrayByParity {
    public static void main(String[] args) {
        int[] array = {3, 4};
        var result = new SortArrayByParity().sortArrayByParityII(array);
        System.out.print("[");
        for(int item:result){
            System.out.print(item + " ");
        }
        System.out.print("]");
    }
    public int[] sortArrayByParityII(int[] A) {
        int even = 0;
        int odd = 1;
        int val;
        while(odd < A.length){
            if(A[odd] % 2 == 0){
                while(A[even] % 2 == 0) even += 2;
                val = A[even];
                A[even] = A[odd];
                A[odd] = val;
            }
            odd += 2;
        }
        return A;
    }
}
