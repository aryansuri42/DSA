import java.util.HashMap;

class FibonacciSeries{
    public static void main(String[] args) {
        System.out.println(fibo(46));
    }
    public static int fibo(int num){
        return fibo(num, new HashMap<>());
    }
    public static int fibo(int num, HashMap<Integer, Integer> memo){
        if(num==0) return 0;
        if(num==1) return 1;

        if(memo.containsKey(num)){
            return memo.get(num);
        }

        int result = fibo(num-1, memo) + fibo(num-2, memo);
        memo.put(num, result);
        return result;
    }
}