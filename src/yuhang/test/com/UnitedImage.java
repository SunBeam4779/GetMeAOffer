package yuhang.test.com;

public class UnitedImage {
    public static void main(String[] args) {
        UnitedImage a = new UnitedImage();
        a.fun("world");
    }
    public void fun(String s){
        String temp = s + "hello";

        fun(temp);
    }
}
