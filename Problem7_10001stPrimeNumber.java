public class Problem7_10001stPrimeNumber {

    public double getNPrimeNumber(int n){
        return getNPrimeNumber(n,0,0,0);
    }

    private double getNPrimeNumber(int n, int counter, int primeCounter, double result){
        //System.out.println(primeCounter);
        // Wenn Zahl = 0,1 -> skip
        if (n == 0 || n == 1 ) return getNPrimeNumber(n,counter+1, primeCounter,result);
        // End
        if (primeCounter == n) return result;
        // Testen ob Primzahl ist
        if (isPrime(counter,1)) {
            return getNPrimeNumber(n,counter+1, primeCounter+1,counter);
        }
        else {
            return getNPrimeNumber(n,counter+1,primeCounter,result);
        }
    }

        public boolean isPrime(double number, double divisor){
            if (number % 2 == 0) return false;
            if (divisor > Math.sqrt(number)) return true;
            if (number % divisor == 0) return false;
            return isPrime(number,divisor+1);
        }

    public static void main(String[] args){
        Problem7_10001stPrimeNumber prime = new Problem7_10001stPrimeNumber();
        //double result = prime.getNPrimeNumber(6);
       // System.out.println(result);
        System.out.println(prime.isPrime(13,1));
    }

}
