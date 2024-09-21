import java.util.HashMap;
import java.util.List;

public class CountPath {
    public static void main(String[] args) {
        int[][] arr = new int[23][12];
        System.out.println(pathfind(0, 0, arr));
    }

    public static int pathfind(int r, int c, int[][] arr){
        return pathfind(r, c, arr, new HashMap<>());
    }


    public static int pathfind(int r, int c, int[][] arr, HashMap<List<Integer>, Integer> memo){
        if (r==arr.length-1 && c==arr[arr.length-1].length - 1) {
            return 1;
        }

        if (r>=arr.length || c>=arr[arr.length-1].length){
            return 0;
        }

        if (arr[r][c] == -1){
            return 0;
        }

        List<Integer> pos = List.of(r,c);
        if (memo.containsKey(pos)) {
            return memo.get(pos);
        }

        int result = pathfind(r+1, c, arr, memo) + pathfind(r, c+1, arr, memo);
        List<Integer> posadd = List.of(r,c);
        memo.put(posadd, result);
        return result;

    }
    
}
