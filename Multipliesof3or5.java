import java.util.LinkedList;
import java.util.List;

public class Multipliesof3or5 {


    public List<Integer> getMultiplesBelow(int value, int multiples) {
        List<Integer> result = new LinkedList<>();
        for (int i = 1; i < value; i++) {
            if (multiples*i <value) {
                result.add(i*multiples);
            }
        }
        return result;
    }
    public long getSumOfList(List<Integer> list){
        long result = 0;
        for (int i =0; i<list.size();i++){
            result += list.get(i);
            System.out.println(list.get(i));
            System.out.println(result);
        }
        return result;
    }

}


