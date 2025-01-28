import junit.framework.TestCase;

import java.util.Arrays;
import java.util.List;

public class Problem54_Test extends TestCase {
    Problem54_PokerHands p;

    public void setUp(){
        p = new Problem54_PokerHands();
    }

    public void testIsPair() {
        List<Integer> value1 = Arrays.asList(2,2,3,6,8);
        List<Integer> value2 = Arrays.asList(2,4,3,6,8);
        List<Integer> value3 = Arrays.asList(2,2,3,3,5);
        List<Integer> value4 = Arrays.asList(2,2,4,3,3);
        List<Integer> value5 = Arrays.asList(2,2,2,3,3);
        List<Integer> value6 = Arrays.asList(2,2,2,2,2);

        assertEquals("Einzelnes Paar nicht erkannt. Rückgabewert ist " + p.isPair(value1) + " und nicht 1.", 1, p.isPair(value1));
        assertEquals("Rückgabewert ist " + p.isPair(value2) + " und sollte 0.", 0, p.isPair(value2));
        assertEquals("2 Paare werde nicht erkannt. Rückgabewert ist " + p.isPair(value3) + " und sollte 2.", 2, p.isPair(value3));
        assertEquals("Rückgabewert ist " + p.isPair(value4) + " und sollte 2.", 2, p.isPair(value4));
        assertEquals("(2,2,2,3,3) falsch erkannt. Rückgabewert ist " + p.isPair(value5) + " und sollte 1.", 1, p.isPair(value5));
        assertEquals("Rückgabewert ist " + p.isPair(value6) + " und sollte 0.", 0, p.isPair(value6));


    }

    public void testIsThreeOfAKind() {
        List<Integer> value1 = Arrays.asList(2,2,2,6,8);
        List<Integer> value2 = Arrays.asList(2,3,1,3,3);
        List<Integer> value3 = Arrays.asList(2,2,3,3,5);
        List<Integer> value4 = Arrays.asList(2,2,3,3,3);
        List<Integer> value5 = Arrays.asList(2,2,2,2,2);

        assertEquals( true, p.isThreeOfaKind(value1));
        assertEquals( true, p.isThreeOfaKind(value2));
        assertEquals( false, p.isThreeOfaKind(value3));
        assertEquals( false, p.isThreeOfaKind(value4));
        assertEquals( false, p.isThreeOfaKind(value5));
    }

    public void testIsStraight() {
        List<Integer> value1 = Arrays.asList(2,3,4,5,6);
        List<Integer> value2 = Arrays.asList(5,6,7,8,9);
        List<Integer> value3 = Arrays.asList(2,2,3,3,5);
        List<Integer> value4 = Arrays.asList(2,2,3,3,3);
        List<Integer> value5 = Arrays.asList(2,2,2,2,2);

        assertEquals( true, p.isStraight(value1));
        assertEquals( true, p.isStraight(value2));
        assertEquals( false, p.isStraight(value3));
        assertEquals( false, p.isStraight(value4));
        assertEquals( false, p.isStraight(value5));
    }

    public void testIsFlush() {
        List<String> value1 = Arrays.asList("S","S","S","S","S");
        List<String> value2 = Arrays.asList("U","U","S","S","S");


        assertEquals( true, p.isFlush(value1));
        assertEquals( false, p.isFlush(value2));

    }

    public void testCountDuplicates() {
        List<Integer> value1 = Arrays.asList(2, 2, 3, 6, 8);

        List<Integer> value2 = Arrays.asList(2, 2, 2, 3, 3);

        List<Integer> value3 = Arrays.asList(2, 2, 2, 2, 2);
        List<Integer> value4 = Arrays.asList(1, 2, 2, 2, 2);

        List<Integer> countList1 = p.countDuplicates(value1);
        int ct1 = countList1.get(0);
        int ct2 = countList1.get(1);
        List<Integer> countList2 = p.countDuplicates(value2);
        int ct3 = countList2.get(0);

        List<Integer> countList3 = p.countDuplicates(value3);
        int ct4 = countList3.get(0);
        List<Integer> countList4 = p.countDuplicates(value4);
        int ct5 = countList4.get(0);



        assertEquals("Test",2, ct1);
        assertEquals("Test",1, ct2);
        assertEquals("Test",3, ct3);
        assertEquals("Test",5, ct4);






    }

    public void testIsRoyalFlush() {
        List<Integer> value1 = Arrays.asList(10,11,12,13,14);
        List<String> suit1 = Arrays.asList("S","S","S","S","S");
        List<Integer> value2 = Arrays.asList(10,11,11,13,14);
        List<String> suit2 = Arrays.asList("S","S","S","S","S");




        assertEquals("RoyalFlush wurde nicht erkannt.", true, p.isRoyalFlush(value1,suit1));
        assertEquals("RoyalFlush falsch erkannt.", false, p.isRoyalFlush(value2,suit2));


    }

}
