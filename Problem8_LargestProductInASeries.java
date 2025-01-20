import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Problem8_LargestProductInASeries {
    List<Character> array = new ArrayList<>();
    List<Long> tempArray = new ArrayList<>();

    public long calculateProduct(int length){
        return calculateProduct(length,0,1);
    }

    private long calculateProduct(int length, int start, long currentResult){
        long startValue = Character.getNumericValue(array.get(start));
        List<Long> internalArray = new ArrayList<>();

        internalArray.add(startValue);
        //End
        if (start + length == array.size()) {
            return currentResult;
        }

        // Calculate Product
        for(int i=1; i<length;i++){
            long value =Character.getNumericValue(array.get(start+i));
            startValue *= value;
            internalArray.add(value);
        }

        if (startValue > currentResult) {
            this.tempArray = internalArray;
            currentResult = startValue;
        }
        return calculateProduct(length,start+1,currentResult);

    }


    public void loadArray() {
        String filePath = "/Users/maltescharf/IdeaProjects/Project Euler/src/Problem8Input.txt"; // Replace with the path to your file
        try (FileReader fileReader = new FileReader(filePath)) {
            int character;
            while ((character = fileReader.read()) != -1) {
                if (Character.isDigit(character)){
                    this.array.add((char) character);

                }
            }
        } catch (IOException e) {
            System.out.println("An error occurred while reading the file: " + e.getMessage());
        }
    }

    public static void main(String[] args){
        Problem8_LargestProductInASeries prob = new Problem8_LargestProductInASeries();
        prob.loadArray();
        System.out.println(prob.calculateProduct(13));

        for(long i: prob.tempArray){
            System.out.println(i);
        }


    }
}
