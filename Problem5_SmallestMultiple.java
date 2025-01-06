import java.util.List;

public class Problem5_SmallestMultiple {
    public static void main(String[] args){
        int value = 0;
        boolean stop = false;
        while (true) {
            value +=1;
            for (int i =1; i<=20; i++){
                if (value % i != 0){
                    stop = false;
                    break;
                }
                else {
                    stop = true;
                }
            }
            if (stop == true) {
                System.out.println(value);
                break;
            }
        }
    }
}
