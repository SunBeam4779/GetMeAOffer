package yuhang.test.com;

public class IsMatch {
    public static void main(String[] args) {
        String string = "a";
        String pattern = ".*..a*";
        IsMatch isMatch = new IsMatch();
        System.out.println(isMatch.isMatch(string, pattern));
    }

    public boolean isMatch(String s, String p){
        if (s.equals("") || p.equals(""))
            return false;

        return matchCore(s, p);
    }

    public boolean matchCore(String s, String p){
        if (s.length() == 0 && p.length() == 0)
            return true;
        if (s.length() != 0 && p.length() == 0) return false;

        if (p.length() == 1) {
            return s.length() == 1 && (p.charAt(0) == s.charAt(0) || p.charAt(0) == '.');
        }

        if (p.charAt(1) == '*') {
            if(s.length() == 0) return matchCore(s, p.substring(2));
            if (s.charAt(0) == p.charAt(0) || (p.charAt(0) == '.' && !s.equals(""))) {
                return matchCore(s.substring(1), p) || matchCore(s.substring(1), p.substring(2)) || matchCore(s, p.substring(2));
            }
            else {
                return matchCore(s, p.substring(2));
            }
        }

        if (s.length() == 0) return false;
        if (s.charAt(0) == p.charAt(0) || (p.charAt(0) == '.' && !s.equals(""))) {
            return matchCore(s.substring(1), p.substring(1));
        }

        return false;
    }
}
