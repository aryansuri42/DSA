import java.util.Arrays;
import java.util.List;
import java.util.HashMap;

public class MinChange {
    public static void main(String[] args) {
        List<Integer> list=Arrays.asList(1,2,3);
        System.out.println(MinCoins(4, list));
    }

    public static int MinCoins(int amount, List<Integer> coins){
        return MinCoins(amount, coins, new HashMap<>());
    }

    public static int MinCoins(int amount, List<Integer> coins, HashMap<Integer, Integer> memo){
        if (amount==0) return 0;
        if (amount<0) return -1;
        if(memo.containsKey(amount)){
            return memo.get(amount);
        }
        int minimumcoins = -1;
        for (int coin: coins){
            int subAmount = amount - coin;
            int subCoins = MinCoins(subAmount, coins, memo);
            if (subCoins != -1){
                int numCoins = subCoins + 1;
                if (numCoins < minimumcoins || minimumcoins == -1){
                    minimumcoins = numCoins;
                }
            }
        }
        memo.put(amount, minimumcoins);
        return minimumcoins;
    }
}
