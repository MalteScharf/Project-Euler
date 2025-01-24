import java.math.BigInteger;

public class Problem16_PowerDigitSum {

    public static void main(String[] args){
        Problem16_PowerDigitSum p = new Problem16_PowerDigitSum();
        BigInteger t = BigInteger.valueOf(2).pow(1000);
        String s = String.valueOf(t);
        char[] c = s.toCharArray();
        long result = 0;
        for (char f:c){
            result +=Integer.parseInt(Character.toString(f));
        }
        System.out.println(result);
    }

}
