package yuhang.test.com;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class IsLongPressedName {
    public static void main(String[] args) {
        String name = "alex";
        String typed = "aleee";
        IsLongPressedName isLongPressedName = new IsLongPressedName();
        System.out.println(isLongPressedName.isLongPressedName(name, typed));
        Queue<Integer> queue = new LinkedList<>();


    }

    public boolean isLongPressedName(String name, String typed) {
        int lengthOfName = name.length();
        int lengthOfTyped = typed.length();
        if(lengthOfTyped < lengthOfName) return false;
        int ptrOfName = 0;
        int ptrOfTyped = 0;
        while(ptrOfName < lengthOfName && ptrOfTyped < lengthOfTyped){
            if(name.charAt(ptrOfName) == typed.charAt(ptrOfTyped)){
                ++ptrOfTyped;
            }
            else{
                if(ptrOfName < lengthOfName - 1 && name.charAt(ptrOfName + 1) == typed.charAt(ptrOfTyped)){
                    ++ptrOfName;
                }else{
                    return false;
                }
            }
        }
        ptrOfName = lengthOfName - 1;
        ptrOfTyped = lengthOfTyped - 1;
        while(ptrOfName >=0 && ptrOfTyped >= 0){
            if(name.charAt(ptrOfName) == typed.charAt(ptrOfTyped)){
                // push = name.charAt(ptrOfName++);
                --ptrOfTyped;
            }
            else{
                if(ptrOfName > 0 && name.charAt(ptrOfName - 1) == typed.charAt(ptrOfTyped)){
                    --ptrOfName;
                }else{
                    return false;
                }
            }
        }
        return true;
    }
}
