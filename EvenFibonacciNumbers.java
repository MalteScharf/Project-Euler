import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class EvenFibonacciNumbers {
    public List<Integer> fibonacci(int end){
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        return fibonacci(list,end);
    }

    private List<Integer> fibonacci(List<Integer> currentList, int end){
       int size = currentList.size();
       int value = currentList.get(size-2) + currentList.get(size-1);

       if (value >end){
           return currentList;
       }
       else {
           currentList.add(value);
       }
       return fibonacci(currentList,end);
    }

    public int sumOfEvenTerms(List<Integer> list){
        return sumOfEvenTerms(list,0,0);
    }

    private int sumOfEvenTerms(List<Integer> list, int value, int index){

        // End
        if(index == list.size()) return value;

        if (list.get(index) % 2 == 0) {
            value += list.get(index);
        }
        return sumOfEvenTerms(list,value,index+1);
    }
}
