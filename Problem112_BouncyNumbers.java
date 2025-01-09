import java.util.ArrayList;
import java.util.List;

public class Problem112_BouncyNumbers {

    List<Integer> listOfBouncyNumbersAmount = new ArrayList<>();
    List<Double> listOfBouncyNumbersRatio = new ArrayList<>();

    public List<Double> createListWithRatioOfBN(int end){
        listOfBouncyNumbersAmount.add(0);
        for (int i = 0; i<=end;i++){
            if (this.isBouncy(i)==true) {
                listOfBouncyNumbersAmount.add(listOfBouncyNumbersAmount.get(i)+1);
                listOfBouncyNumbersRatio.add((double) listOfBouncyNumbersAmount.get(i)/i);
            }

        }

        return this.listOfBouncyNumbersRatio;
    }


    boolean isBouncy(int input){
        if (!(this.isIncreasingNumber(input)) && !(this.isDecreasingNumber(input))) return true;
        return false;
    }

    private List<Integer> getIntergerAsList(int inputInt){
        List<Integer> list = new ArrayList<>();
        String numberAsString = String.valueOf(inputInt);
        for (char c :numberAsString.toCharArray()){
            list.add(Character.getNumericValue(c));
        }

        return list;
    }

    private boolean isIncreasingNumber(int intput){
        boolean isIncreasing = true;
        List<Integer> list = this.getIntergerAsList(intput);
        for (int i =0; i <list.size()-1; i++){
            if (list.get(i)>list.get(i+1)) return isIncreasing = false;
        }
        return isIncreasing;
    }

    private boolean isDecreasingNumber(int intput){
        boolean isDerceasing = true;
        List<Integer> list = this.getIntergerAsList(intput);
        for (int i =0; i <list.size()-1; i++){
            if (list.get(i)<list.get(i+1)) return isDerceasing = false;
        }
        return isDerceasing;
    }
}
