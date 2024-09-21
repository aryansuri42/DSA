import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class SumPossible {
    public static void main(String[] args) {
        List<Integer> list=Arrays.asList(4, 6, 10);
        System.out.println(sumPos(15, list));
    }

    public static boolean sumPos(int amount, List<Integer> numbers){
        return sumPos(amount, numbers, new HashMap<>());
    }
    public static boolean sumPos(int amount, List<Integer> numbers, HashMap<Integer, Boolean> memo){
        if (amount==0) return true;
        if (amount<0) return false;

        if (memo.containsKey(amount)) return memo.get(amount);

        for (int num : numbers) {
            int subAmount = amount - num;
            if (sumPos(subAmount, numbers, memo)) {
                memo.put(subAmount, true);
                return true;
            }
        }
        memo.put(amount, false);
        return false;
    }
}
