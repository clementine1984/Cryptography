package SoftwareExam;

import java.math.BigInteger;

public class RSAwithEulerforN_D<mult> {
    public static void main(String[] args) {
        BigInteger mult;
        BigInteger multPlus1;
        BigInteger d;
        String input1 = "934721999678208";
        String input2 = "897411054846432";
        String numE = "227";

        BigInteger a = new BigInteger(input1);
        BigInteger b = new BigInteger(input2);
        BigInteger e = new BigInteger(numE);

        mult = a.multiply(b);
        System.out.println("ϕ(n) is " + mult);

        multPlus1 = mult.add(new BigInteger("1"));

        d = multPlus1.divide(e);
        System.out.println("d is " + d);
    }
}

