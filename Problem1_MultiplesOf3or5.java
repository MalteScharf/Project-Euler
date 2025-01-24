public class Problem1_MultiplesOf3or5 {

    public long mult(long n){
        return mult(n,0,0);
    }

    private long mult(long n, long currentN,long result){
        // Basisfall
        if (currentN == n) return  result;
        if (currentN % 3 ==0 || currentN % 5 == 0) return mult(n,currentN+1, result + currentN);
        return mult(n,currentN+1,result);
    }


    public static void main(String[] args){
        Problem1_MultiplesOf3or5 p = new Problem1_MultiplesOf3or5();
        long result = p.mult(1000);
        System.out.println(result);

    }

}
