import java.util.HashMap;

public class Problem14_LongestCollatzSequence {
   public int collatz(int max) {
       HashMap<Long, Integer> memo = new HashMap<>();
       int result =0;
       int starting=0;
       for (int i = 1; i <= max; i++) {
           int currentResult = collatz(i,memo);
           if (currentResult>result) {
               result = currentResult;
               starting = i;

           }

       }
       return starting;
   }

   private int collatz(long n, HashMap<Long, Integer> memo){
        //System.out.println(n);
        // Basisfall
        if (n == 1) return 1;
        // Wenn Wert schon gespeichert wurde --> gebe zurück
        if (memo.containsKey(n)) return memo.get(n);

        int length;
        // Collatz berechnen mit rekusiven Abstieg
        if (n % 2 == 0){
            length = 1+ collatz(n / 2, memo);
        }
        else {
            length = 1+ collatz(3 * n + 1, memo);
        }
        memo.put(n,length);
        return length;
    }

    public static void main(String[] args){
        Problem14_LongestCollatzSequence p = new Problem14_LongestCollatzSequence();
        int result = p.collatz(999999);
        System.out.println("Result "+result);
    }

}


