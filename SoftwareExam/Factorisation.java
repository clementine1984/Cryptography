package SoftwareExam;
import java.math.BigInteger;

public class Factorisation {

        static final BigInteger ZERO = new BigInteger("0");
        static final BigInteger ONE = new BigInteger("1");

        public static void fermatFactors(BigInteger n){
            if (n.compareTo(ZERO)==-1 || n.compareTo(ZERO) == 0){
                System.out.println("Cannot be negative; Must be > 0");
                return;
            }
            //check if n is a even number;
            BigInteger temp = n.mod(new BigInteger("2"));
            if (temp.equals(ZERO)){
                System.out.print("Not an ODD number");
                return;
            }

            BigInteger a = n.sqrt().add(ONE);

            if (a.pow(2).equals(n)){
                System.out.print("[" + a + "," + a + "]");
                return;
            }
            BigInteger b;
            while(true){
                BigInteger b1 = a.pow(2).subtract(n);
                b = b1.sqrt();
                if (b.pow(2).equals(b1)){
                    break;
                }else{
                    a = a.add(ONE);
                }
            }
            System.out.print("[" + (a.subtract(b)) +"," + (a.add(b)) + "]" );

        }

        public static void main(String[] args) {
            // write your code here
            fermatFactors(new BigInteger("925545226289"));

        }
    }

