import java.util.*;

public class shortestPalindromeProblem {
    public static void main(String[] args) {
        String s = "";
        System.out.println(s.length());
    }

    public static String shortestPalindrome(String s) {
        String newstring = createString(s, 1, s.length()-1, 1);
        return newstring;
    }

    public static String createString(String s, int i, int j, int counter){
        String string1 = new StringBuilder(s.substring(i, i+counter)).reverse().toString() + s;
        String string2 = s + new StringBuilder(s.substring(j-counter, j)).reverse().toString();
        if (palindrome(string1, 0, string1.length()-1)){
            return string1;
        }
        if (palindrome(string2, 0, string2.length()-1)){
            return string2;
        }
        counter+=1;
        return createString(s, i, j, counter);
    }

    public static boolean palindrome(String str, int i, int j){
        return palindrome(str, i, j, new HashMap<>());
    }


    public static boolean palindrome(String str, int i, int j, HashMap<String, Boolean> memo){
        if (i>=j) {
            return true;
        }

        if (memo.containsKey(str)){
            return memo.get(str);
        }

        if (str.charAt(i) != str.charAt(j)){
            memo.put(str, false);
            return false;
        }
        return palindrome(str, i+1, j-1);
    }
}
