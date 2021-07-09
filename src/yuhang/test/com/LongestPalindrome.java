package yuhang.test.com;

public class LongestPalindrome {
    public static void main(String[] args) {
        String s = "ac";
        System.out.println(new LongestPalindrome().longestPalindrome(s));
    }
//    public String longestPalindrome(String s) {
//        int length = s.length();
//        boolean[][] data = new boolean[length][length];
//        for(int i = 0; i < length; i++){
//            data[i][i] = true;
//        }
//        for(int j = 1; j < length; j++){
//            for(int i = 0; i < length - 1; i++){
//                if(j <= i) continue;
//                if(s.charAt(i) == s.charAt(j)){
//                    if(j - 1 == i) data[i][j] = true;
//                    if(data[i + 1][j - 1]) data[i][j] = true;
//                }
//
//            }
//        }
//        int len = 0;
//        int start = 0;
//        int end = length;
//        for(int i = length - 1; i >= 0; i--){
//            for(int j = length - 1; j >= 0; j--){
//                if(j >= i && data[i][j]){
////                    if(i == j) continue;
//                    if(j - i + 1 <= len){
//                        break;
//                    }else{
//                        len = j - i + 1;
//                        start = i;
//                        end = j;
//                    }
//                }
//            }
//        }
//        return s.substring(start, end + 1);
//    }

    public String longestPalindrome(String s) {
        int length = s.length();
        if(length <= 1) return s;
        boolean[][] data = new boolean[length][length];
        String ans = "";
        for(int i = 0; i < length; i++){
            data[i][i] = true;
        }
        for(int j = 0; j < length; j++){
            for(int i = 0; i < length - 1; i++){
                if(j < i) continue;
                if(s.charAt(i) == s.charAt(j)){
                    if(j - 1 == i) data[i][j] = true;
                    if(j - 1 >= 0 && data[i + 1][j - 1]) data[i][j] = true;
                }
                if(data[i][j] && j - i + 1 > ans.length()){
                    ans = s.substring(i, j + 1);
                }
            }
        }

        return ans;
    }
}
