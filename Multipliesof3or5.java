import java.util.LinkedList;
import java.util.List;

public class Multipliesof3or5 {


    public List<Integer> getMultiplesBelow(int value, int multiples) {
        List<Integer> result = new LinkedList<>();
        for (int i = 0; i < value; i++) {
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
        }
        return result;
    }

    public static void main(String[] args){
        Multipliesof3or5 m = new Multipliesof3or5();
        List<Integer> list = m.getMultiplesBelow(1000,3);
        List<Integer> list1 = m.getMultiplesBelow(1000,5);
        long result = m.getSumOfList(list)+m.getSumOfList(list1);
        System.out.println(result);

    }

}


