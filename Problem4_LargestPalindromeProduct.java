public class Problem4_LargestPalindromeProduct {

    public boolean isPalingdrom(int n){
        StringBuilder sb = new StringBuilder();
        String palin = sb.append(n).reverse().toString();
        if (palin.compareTo(Integer.toString(n)) == 0) return true;
        return false;
    }

    public long palin(int k){
        StringBuilder s = new StringBuilder();
        for (int i =0; i<k;k++) {
            s.append(9);
        }
        int maxVal = Integer.parseInt(s.toString());
        return palinR(maxVal*maxVal,maxVal);
    }

    private long palinR(int n,int maxVal){

        // is Palindrom?
        if (isPalingdrom(n)){
            // Zerlegbar in zwei Faktoren?
            for (int i = maxVal; i>0; maxVal--){
                if(n % i == 0) {
                    int teilerA =i;
                    int teilerB = n/i;
                    int minVal = 10; // ToDo
                    if(teilerB>=minVal) return n;
                }
            }
        }

        return palinR(n-1,maxVal);



    }




    public int palinIter(int k){
        // Maxval berechen:
        StringBuilder max = new StringBuilder();
        StringBuilder min = new StringBuilder();
        for (int i = 0; i<k;i++) {
            if (i == 0) min.append(1);
            else min.append(0);
            max.append(9);
        }

        int maxVal = Integer.parseInt(max.toString());
        int minVal = Integer.parseInt(min.toString());

        System.out.println(minVal);
        System.out.println(maxVal);


        int largestPalindrome =0;

        for (int i = maxVal; i>minVal;i--){
            for (int j =i; j>minVal;j--){
                int product = j*i;
                if (isPalingdrom(product) && product>largestPalindrome){
                    largestPalindrome = product;
                }
            }
        }
        return largestPalindrome;
    }

    public static void main(String[] args){
        Problem4_LargestPalindromeProduct p = new Problem4_LargestPalindromeProduct();
        //long result = p.palin(2);
        int resultIter = p.palinIter(3);


        System.out.println(resultIter);
    }
}
