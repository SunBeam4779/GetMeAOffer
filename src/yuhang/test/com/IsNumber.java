package yuhang.test.com;

public class IsNumber {
    public static void main(String[] args) {
        IsNumber isNumber = new IsNumber();
        String s = "-.";
        System.out.println(s.trim());
        System.out.println(isNumber.isNumber(s));

    }
    public boolean isNumber(String s) {
//        s = s.trim();
//        if(s.length() == 0) return false;
//        if(s.length() == 1 && s.charAt(0) == '.') return false;
//
//        boolean A;
//        boolean B;
//        boolean C = false;
//        boolean res = false;
//        String integer = scanInteger(s);
//        if(!s.equals(integer)){
//            res = true;
//            s = integer;
//        }
//        else {
//            if (integer.charAt(0) == '.')
//                s = integer;
//            else return false;
//        }
//        if(s.length() == 0) return true;
//
//        if (s.charAt(0) == '.'){
//            s = s.substring(1);
//            if (s.length() == 0) return true;
//            if (s.charAt(0) == '.') return false;
//            String integerB = scanUnsignedInteger(s);
//            if(!s.equals(integerB)){
//                res = true;
//                s = integerB;
//            }else {
////                return integerB.length() == 1;
//                return false;
//            }
//            if (s.length() == 0) return true;
//        }
//
//        if(s.charAt(0) == 'E' || s.charAt(0) == 'e'){
//            if(s.length() == 1) return false;
//            String integerC = scanInteger(s.substring(1));
//            s = integerC;
//            res = integerC.length() == 0;
//        }
//
//
//        return res && s.length() == 0;
        int length = s.length();
        boolean resA = false;
        boolean resB = false;
        boolean resC = false;
        int index = 0;
        while(index < length){
            if(s.charAt(index) == '+' || s.charAt(index) == '-' || (s.charAt(index) <= '9' && s.charAt(index) >= '0')&& !resA){
                resA = true;
                if(s.charAt(index) <= '9' && s.charAt(index) >= '0')
                    index = UnsignedInteger(s);
                else index += 1 + UnsignedInteger(s.substring(1 + index));
            }
            else if(s.charAt(index) == '.' && !resB){
                resB = true;
                index += 1 + UnsignedInteger(s.substring(1 + index));
            }
            else if(s.charAt(index) == 'E' || s.charAt(index) == 'e' && !resC){
                resC = true;
                if(!isSectionA(s.substring(index + 1))){
                    resC = false;
                    break;
                }
                else{
                    index = length - 1;
                }
            }
        }
        return (resA || resB || resC) && (index == length);
    }

    public boolean isSectionA(String string){
        if(string.charAt(0) == '+' || string.charAt(0) == '-'){
            int temp = UnsignedInteger(string.substring(1));
            return temp + 1 == string.length() - 1;
        }else{
            int temp = UnsignedInteger(string);
            return temp == string.length() - 1;
        }
    }

    public int UnsignedInteger(String s){
        int i = 0;
        for(; i < s.length() && s.charAt(i) >= '0' && s.charAt(0) <= '9'; i++);
        return i;
    }

    public String scanUnsignedInteger(String s){

        int i = 0;
        for(; i < s.length() && s.charAt(i) >= '0' && s.charAt(i) <= '9'; i++);
        return s.substring(i);
    }

    public String scanInteger(String s){
        String res;
        if(s.charAt(0) == '+' || s.charAt(0) == '-'){
            res = scanUnsignedInteger(s.substring(1));
            if(res.equals(s.substring(1))){
                if (res.length() == 0) return s;
                if (res.charAt(0) == '.')
                    return res;
                return s;
            }
        }else{
            res = scanUnsignedInteger(s);
        }
        return res;
    }
}
