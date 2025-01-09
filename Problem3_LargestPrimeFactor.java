import java.util.LinkedList;
import java.util.List;

public class Problem3_LargestPrimeFactor {
    public static void main(String[] args){
        long primeNumber = 600851475143L;
        List<Integer> listPrimeNumbers = new LinkedList<>();

        for (int x = 2; x<=100000; x++){
            boolean prime = true;
            for (int i = 2; i<x;i++){
                if (x % i == 0) prime = false;
            }
            if (prime == true) listPrimeNumbers.add(x);

        }

        List<Integer> listPrimeFactor = new LinkedList<>();
        int counter = 0;
        long tempValue=primeNumber;
        while (true) {
            if (tempValue % listPrimeNumbers.get(counter) == 0) {
                tempValue = tempValue/listPrimeNumbers.get(counter);
                listPrimeFactor.add(listPrimeNumbers.get(counter));
                counter =0;
            }
            else counter +=1;

            if (listPrimeNumbers.get(counter)>tempValue){
                System.out.println(listPrimeFactor);
                break;
            }

        }
    }
}
