import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;


public class Problem11_LargestProductinAGrid {
    ArrayList<String> stringList;
    ArrayList<ArrayList<Integer>> intList;
    ArrayList<Integer> maxDiaRight;


    /** Load data from given path
     * @return an 2D ArrayList with Input in rows and columns*/
    void loadData(String path) {
        //ArrayList array = new ArrayList<>();
        stringList = new ArrayList<>();

        try {
            BufferedReader br = new BufferedReader(new FileReader(path));
            try {
                String line;
                while ((line = br.readLine()) != null) {
                    this.stringList.add(line);
                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            } finally {
                br.close();
                convertStringArrayToIntArray();
            }
        } catch (IOException e) {
            System.out.println("Datei nicht gefunden");
        }
    }

    private void convertStringArrayToIntArray(){
        intList = new ArrayList<>();
        // Für jede Zeile im StringArray
        for(String s:stringList){
            // Jeden Eintrag in der Zeile durchgehen
            ArrayList<Integer> tempList = new ArrayList<>();
            for(int i =0; i<s.length();i++){
                if (i%3 == 0){
                    //System.out.println("String: "+ s.substring(i,i+2)+ " + Int: " + Integer.parseInt(s.substring(i,i+2)) + " ");
                    tempList.add(Integer.parseInt(s.substring(i,i+2)));
                }

            }
            intList.add(tempList);

        }
    }


    public long findMax(){
        return findMax(0,0,0);
    }

    private long findMax(int x,int y, long currentMax){
        int xLength = intList.get(0).size();
        int yLength= xLength;

        // Basisfall: letzte Zeile und letzte Spalte erreicht
        if (x==xLength-3 && y == yLength-3) return currentMax;

        // neue Spalte
        if (x==xLength) return findMax(0,y+1,currentMax);

        // Maximums suchen und in Liste Schreiben
        ArrayList<Long> tempMaxs = new ArrayList<Long>();

        if(x<=xLength-3) tempMaxs.add(maxHorizontal(x,y));
        if(y<=yLength-3) tempMaxs.add(maxVertical(x,y));
        if(y<yLength-3 && x<xLength-3) tempMaxs.add(maxDiagonalRight(x,y));
        if(y<yLength-3 && x>3 )tempMaxs.add(maxDiagonalLeft(x,y));


        // get Max from TempMaxs ArrayList
       tempMaxs.sort(Collections.reverseOrder());
       for (long l:tempMaxs){
           System.out.println(l);
       }
       System.out.println("--------");

       long tempMax = tempMaxs.getFirst();



        if(tempMax>currentMax) {
            currentMax = tempMax;
            maxDiaRight = new ArrayList<>();
            maxDiaRight.add(x);
            maxDiaRight.add(y);
        }

        return findMax(x+1,y,currentMax);
    }


    private long maxDiagonalRight(int x, int y){
        long tempMax = intList.get(y).get(x);

        for(int i=1;i<=3;i++){
            tempMax *= intList.get(y+i).get(x+i);
        }
        return tempMax;
    }
    private long maxDiagonalLeft(int x, int y){
        long tempMax = intList.get(y).get(x);

        for(int i=1;i<=3;i++){
            tempMax *= intList.get(y+i).get(x-i);
        }
        return tempMax;
    }

    private long maxVertical(int x, int y){
        long tempMax = intList.get(y).get(x);

        for(int i=1;i<=3;i++){
            tempMax *= intList.get(y+1).get(x);
        }
        return tempMax;
    }

    private long maxHorizontal(int x, int y){
        long tempMax = intList.get(y).get(x);

        for(int i=1;i<=3;i++){
            tempMax *= intList.get(y).get(x+1);
        }
        return tempMax;
    }

    public long maxDown(){
        return maxDown(0,0,0);
    }

    private long maxDown(int x, int y, long currentMax){
        // Laufvariable definieren:
        int xLength = intList.get(0).size()-3;
        int yLength= xLength;

        // Basisfall: letzte Zeile und letzte Spalte erreicht
        if (x==xLength && y == yLength) return currentMax;

        // Ende der Spalte erreicht:
        if (x==xLength) return maxDown(0,y+1,currentMax);


        long tempMax = intList.get(y).get(x);
        for(int i=1;i<=3;i++){
                    tempMax *= intList.get(y+1).get(x);
                }
        if (tempMax>currentMax) currentMax = tempMax;
        return maxDown(x+1,y,currentMax);
    }

    public long maxHorizontal(){
        return maxHorizontal(0,0,0);
    }

    private long maxHorizontal(int x, int y, long currentMax){
        // Laufvariable definieren:
        int xLength = intList.get(0).size()-3;
        int yLength= intList.get(0).size();

        // Basisfall: letzte Zeile und letzte Spalte erreicht
        if (x==xLength && y == yLength) return currentMax;

        // Zeilensprung wenn letzter Eintrag erreicht
        if (x == xLength) return maxHorizontal(x,y+1,currentMax);

        long tempMax = intList.get(y).get(x);

        for(int i=1;i<=3;i++){
            tempMax *= intList.get(y).get(x+1);
        }
        if (tempMax>currentMax) currentMax = tempMax;
        return maxHorizontal(x+1,y,currentMax);
    }


    public void printIntList(){
        for(int i=0; i<intList.size();i++){
            ArrayList<Integer> tempList = intList.get(i);
            for(Integer n: tempList){
                System.out.print(n + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args){
        Problem11_LargestProductinAGrid grid = new Problem11_LargestProductinAGrid();
        String pathname = "/Users/maltescharf/IdeaProjects/Project Euler/src/Problem11_Input.txt";
        grid.loadData(pathname);
        long maxDown = grid.maxDown();
        long maxHorizontal = grid.maxHorizontal();
        long max = grid.findMax();

        System.out.println(maxDown);
        System.out.println(maxHorizontal);
        System.out.println("total Max: "+ max);
        System.out.println("X: "+ grid.maxDiaRight.get(0));
        System.out.println("Y: "+ grid.maxDiaRight.get(1));



    }

}
