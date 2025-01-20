import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Problem11_LargestProductinAGrid {

    /** Load data from given path
     * @return an 2D ArrayList with Input in rows and columns*/
    ArrayList loadData(String path) throws IOException {
        ArrayList array = new ArrayList<>();

        BufferedReader br = new BufferedReader(new FileReader(path));
        try{
            String line;
            //while ()

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        finally {
            br.close();
        }

        return null;

    }

    public void printList(ArrayList<Long> array){
        for (long l:array) {
            System.out.print(l + "");
        }
    }



}
