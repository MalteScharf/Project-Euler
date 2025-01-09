public class Problem6_SumSquareDifference {
    public static void main(String[] args){
        int sumOfSquares=0;
        int squaresOfSum =0;
        for(int i =0; i<=100;i++){
            sumOfSquares += i*i;
            squaresOfSum +=i;
        }
        squaresOfSum = squaresOfSum * squaresOfSum;
        int difference = squaresOfSum-sumOfSquares;
        System.out.println(difference);
    }
}
