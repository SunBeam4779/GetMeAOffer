package yuhang.test.com;

public class StringToInt {
    public static void main(String[] args) {
        String string = "-  234";
        StringToInt stringToInt = new StringToInt();
        int value = stringToInt.strToInt(string);
        System.out.println(value);
    }
    public int strToInt(String str) {
        int length = str.length();
        if(length == 0) return 0;
        if(length == 1 && (str.charAt(0) < '0' || str.charAt(0) > '9')) return 0;
        if(str.charAt(0) == ' ') return strToInt(str.substring(1));
        if(str.charAt(0) == '-') {
            return calc(str.substring(1), true);
        }
        if(str.charAt(0) == '+') {
            return calc(str.substring(1), false);
        }
        if(str.charAt(0) > '9' || str.charAt(0) < '0') return 0;
        return calc(str, false);
    }
    public int calc(String str, boolean neg){
        int length = str.length();
        if(str.charAt(0) == ' ') return calc(str.substring(1), neg);
        if(str.charAt(0) > '9' || str.charAt(0) < '0') return 0;
        long count = 0;
        for(int i = 0; i < length; i++){
            if(str.charAt(i) < '0' || str.charAt(i) > '9') break;

            count = count * 10 + (str.charAt(i) - '0');
            if(count > Integer.MAX_VALUE){
                if(neg) return Integer.MIN_VALUE;
                else return Integer.MAX_VALUE;
            }


        }
        if(neg) count = -count;
        return (int)count;
    }
}
