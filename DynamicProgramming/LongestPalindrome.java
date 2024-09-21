import java.util.HashMap;

public class LongestPalindrome {
    public static void main(String[] args) {
        System.out.println(longString("abbcccbbbcaaccbababcbcabca"));
    }

    public static boolean checkpalindrome(String check){
        return checkpalindrome(check, new HashMap<>());
    }

    public static boolean checkpalindrome(String check, HashMap<String, Boolean> memo2){
        if (memo2.containsKey(check)) return memo2.get(check);
        String checkreverse = "";
        for (int i = check.length()-1; i>=0; i--){
            char a = check.charAt(i);
            checkreverse = checkreverse + a;
        }

        if (check.equals(checkreverse)) {
            memo2.put(check, true);
            return true;
        }
        memo2.put(check, false);
        return false;
    }

    public static String longString(String word){
        return longString(word, new HashMap<>());
    }

    public static String longString(String word, HashMap<String, String> memo){
        if(word.length()==1 || checkpalindrome(word)){
            return word;
        }

        if (memo.containsKey(word)){
            return memo.get(word);
        }

        int s = 0;
        int e = word.length();


        String string1 = longString(word.substring(s+1, e));
        String string2 = longString(word.substring(s, e-1));
        int maxlength = string1.length();
        if (string2.length()>=maxlength) {
            memo.put(word, string2);
            return string2;
        }
        memo.put(word, string1);
        return string1;
        
    }

}
