package yuhang.test.com;

public class ReplaceSpaces {
    public static void main(String[] args) {
        String string = "Mr John Smith     ";
        String res = new ReplaceSpaces().replaceSpaces(string, 13);
        System.out.println(res);
    }
    public String replaceSpaces(String S, int length) {
        char[] string = new char[S.length()];
        int index = 0;
        for(int i = 0; i < length; i++){
            if(S.charAt(i) == ' '){
                string[index++] = '%';
                string[index++] = '2';
                string[index++] = '0';
            }else{
                string[index++] = S.charAt(i);
            }
        }

        return String.valueOf(string, 0, index);
    }
}
