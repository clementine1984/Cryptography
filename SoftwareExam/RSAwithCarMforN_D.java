package SoftwareExam;

import java.math.BigInteger;

public class RSAwithCarMforN_D {
    public static BigInteger lcm(String a, String b) {
        // convert string 'a' and 'b' into BigInteger
        BigInteger s = new BigInteger(a);
        BigInteger s1 = new BigInteger(b);

        // calculate multiplication of two bigintegers
        BigInteger mult = s.multiply(s1);

        // calculate gcd of two bigintegers
        BigInteger gcd = s.gcd(s1);

        // calculate lcm using formula: lcm * gcd = x * y
        BigInteger lcm = mult.divide(gcd);
        return lcm;

    }

    public static void main(String[] args) {

        BigInteger lcmPlus1;
        BigInteger d;
        String numE = "227";

        String a = "934721999678208";
        String b = "897411054846432";
        BigInteger e = new BigInteger(numE);

        BigInteger lcm1 = lcm(a, b);
        lcmPlus1 = lcm1.add(new BigInteger("1"));

        d = lcmPlus1.divide(e);
        System.out.println("λ(n) is "+ lcm1);
        System.out.println("d is " + d);
    }


}
