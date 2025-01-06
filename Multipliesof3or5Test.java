import java.util.List;

public class Multipliesof3or5Test {
    public static void main(String[] args){
        Multipliesof3or5 m = new Multipliesof3or5();
        List<Integer> list = m.getMultiplesBelow(1000,3);
        List<Integer> list1 = m.getMultiplesBelow(1000,5);
        long result = m.getSumOfList(list) + m.getSumOfList(list1);
        System.out.println(result);


    }
}
