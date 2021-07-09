package yuhang.test.com;

public class ReverseWords {
    public static void main(String[] args) {
        String string = "I am a   student.";
        String[] words = string.split(" ");
        System.out.println(words.length);
        for(String item: words){
            if (item.equals("")) continue;
            System.out.print(item + "-");
        }
        System.out.println();
        ReverseWords reverseWords = new ReverseWords();
        System.out.println(reverseWords.reverseWords(string));
    }

    public String reverseWords(String s) {
        String[] words = s.split(" ");
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = words.length - 1; i >= 0; i--){
            if(words[i].equals("")) continue;
            stringBuilder.append(words[i]);
            if(i == 0) break;
            stringBuilder.append(" ");
        }
        return stringBuilder.toString();
    }
}
