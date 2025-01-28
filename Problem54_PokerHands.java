import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Problem54_PokerHands {
    List<List<Integer>> valuePlayer1 = new ArrayList<>();
    List<List<Integer>> valuePlayer2 = new ArrayList<>();
    List<List<String>> suitPlayer1 = new ArrayList<>();
    List<List<String>> suitPlayer2 = new ArrayList<>();

    List<List<Integer>> handPlayer1 = new ArrayList<>();



    public void readFile(String path) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(path));
        String line;

        while ((line = br.readLine()) != null) {

            List<Integer> valuePlayer1temp = new ArrayList<>();
            List<Integer> valuePlayer2temp = new ArrayList<>();
            List<String> suitPlayer1temp = new ArrayList<>();
            List<String> suitPlayer2temp = new ArrayList<>();

            for(int i =0; i<line.length();i++){
                if(i % 3 == 0 && i<14) addToValue(line.charAt(i),valuePlayer1temp);
                if(i % 3 == 0 && i>14) addToValue(line.charAt(i),valuePlayer2temp);
                if(i == 1) suitPlayer1temp.add(Character.toString(line.charAt(i)));
                else if ((i-1) % 3 == 0 && i<14) suitPlayer1temp.add(Character.toString(line.charAt(i)));
                if ((i-1) % 3 == 0 && i>14) suitPlayer2temp.add(Character.toString(line.charAt(i)));
            }
            valuePlayer1.add(valuePlayer1temp);
            valuePlayer2.add(valuePlayer2temp);
            suitPlayer1.add(suitPlayer1temp);
            suitPlayer2.add(suitPlayer2temp);


        }


    }

    private List<Integer> addToValue(char c, List<Integer> list){

        switch (c){
            case 'T':
                list.add(10);
                return list;
            case 'J':
                list.add(11);
                return list;
            case 'Q':
                list.add(12);
                return list;
            case 'K':
                list.add(13);
                return list;
            case 'A':
                list.add(14);
                return list;
            default:
                list.add(Integer.parseInt(String.valueOf(c)));
                return list;
        }

    }

    /**
     *
     * @param value
     * @param suit
     * @return 0 = HighCard, 1 = One Pair, 2 = Two Pairs...
     *         9 = Royal Flush
     */
    public int calculateHand(List<Integer> value, List<String> suit){
        List<List<Integer>> handPlayer1Temp = new ArrayList<>();


        // Bestimmes welches Blatt (ohne Highcard)
        if (isThreeOfaKind(value)) {

        }

        return 0;
    }

   public boolean isRoyalFlush(List<Integer> value, List<String> suit){
        String suitTemp = suit.getFirst();
        for (int i =0; i<value.size();i++) {
            if(value.get(i) == 10+i && suit.get(i).compareTo(suitTemp) == 0);
            else return false;
        }
       return true;
   }

   public int isPair(List<Integer> value){

       List<Integer> countList = countDuplicates(value);
       // zähle 2x
       int pairCounter=0;
       for(int i:countList){
           if (i == 2) pairCounter++;
       }

       return pairCounter;
   }

   public boolean isThreeOfaKind(List<Integer> value){
        if ( countDuplicates(value).contains(3) && !countDuplicates(value).contains(2)) return true;
        return false;
   }

   public boolean isStraight(List<Integer> value){
        value.sort(null);
        for (int i =0; i< value.size()-2;i++){
            if (!value.get(i).equals(value.get(i+1)-1)) return false;
        }
        return true;
   }

   public boolean isFlush(List<String> suit){
        String startingSuit= suit.getFirst();
        for(String s :suit){
            if (!s.equals(startingSuit)) return false;
        }
        return true;
   }

    public List<Integer> countDuplicates(List<Integer> value){
       value.sort(null);
       boolean wasPair=false; // war vorheriger Eintrag paar?
       // zählen wie oft einzele Werte vorkommen
       List<Integer> countList = new ArrayList<>();
       // Tracken welche Werte
        List<Integer> handList = new ArrayList<>();

        for (int i = 0; i<value.size();i++){
            int tempCounter =0;
           if(i>0 && value.get(i).equals(value.get(i-1))) {
               continue;
           }
           for(int j=0; j<value.size();j++){
               if(value.get(i).equals(value.get(j))) tempCounter++;
           }

           // Sonderfall letzter
           if (tempCounter != 0) {
               countList.add(tempCounter);
               handList.add(value.get(i));
           }
       }


        /* countList.sort(Comparator.reverseOrder()); */
        System.out.println(handList);
        System.out.println(countList);
       return countList;
   }

    public void printHands(int gameId){

        System.out.println("Player 1 Value:");
        for (int l: valuePlayer1.get(gameId)){
            System.out.print(l  +" ");
        }
        System.out.println();
        System.out.println("Player 1 Suit:");
        for (String l: suitPlayer1.get(gameId)){
            System.out.print(l  +" ");
        }
        System.out.println();
        System.out.println();
        System.out.println("Player 2 Value:");
        for (int l: valuePlayer2.get(gameId)){
            System.out.print(l  +" ");
        }
        System.out.println();
        System.out.println("Player 2 Suit:");
        for (String l: suitPlayer2.get(gameId)){
            System.out.print(l  +" ");
        }
        System.out.println();
        System.out.println();

    }

    public static void main(String[] args) throws IOException {
        Problem54_PokerHands p = new Problem54_PokerHands();
        String pathname = "/Users/maltescharf/IdeaProjects/Project Euler/src/Prob54Test";
        p.readFile(pathname);
        List<Integer> value1 = Arrays.asList(3,3,3,2,7);
        int gameId=0;
        //p.printHands(gameId);
        // RoyalFlushTest : 2
        // Pair Test: 3
        //int result = p.calculateHand(p.valuePlayer1.get(gameId),p.suitPlayer1.get(gameId));
        // System.out.println(result);
        p.countDuplicates(value1);
    }
}
