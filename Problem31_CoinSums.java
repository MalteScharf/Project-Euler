public class Problem31_CoinSums {

    public static void main(String[] args){
        long counter = 0;
        for(int a = 0;a <=200; a++){ // 1p
            for(int b =0; b<=100; b++){ // 2p
                for (int c =0; c<=40;c++){ // 5p
                    for (int d = 0; d<=10;d++){ //20p
                        for (int e = 0; e<=4;e++){
                            for (int f = 0; f<=2;f++){
                                for (int g = 0; g<=1;g++){
                                    for (int h = 0; h<= 20;h++){
                                        if ((1*a + 2*b + 5*c + 10*h + d*20 + e*50 + f*100 + g*200) == 200) counter ++;

                                    }
                                }
                            }

                        }
                    }

                }
            }
        }
        System.out.println(counter);


    }
}
