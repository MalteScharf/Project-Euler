import java.util.ArrayList;
import java.util.List;

public class Problem112_Test {
    public static void main(String[] args){
        Problem112_BouncyNumbers bouncy = new Problem112_BouncyNumbers();
        int number = 4341;
        List<Double> list = bouncy.createListWithRatioOfBN(103);
        System.out.println(list);
        //double percentage = Math.round(list.getLast()*100.0)/100.0;
        //System.out.println(percentage);


    }
}
