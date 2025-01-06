import java.util.List;

public class EvenFibonacciNumbersTest {
    public static void main(String[] args){
        EvenFibonacciNumbers f = new EvenFibonacciNumbers();
        List<Integer> list = f.fibonacci(4000000);
        System.out.println(list);
        int result = f.sumOfEvenTerms(list);
        System.out.println(result);
    }
}
