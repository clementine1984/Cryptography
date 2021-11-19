import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Base64;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import javax.crypto.Cipher;

public class App {
    public static void main(String[] args) throws Exception {
        // String messageToSend = "Hello crypto!";

        // // Key generator type
        // KeyGenerator keygen = KeyGenerator.getInstance("DES");

        // // Key generator initialization with 64 bit
        // keygen.init(56);

        // // Get generated key
        // SecretKey originalKey = keygen.generateKey();

        // // prepare encoded key for transmission
        // byte[] raw = originalKey.getEncoded();

        // // to generate key from encoded key
        // SecretKey key = new SecretKeySpec(raw, "DES");

        // Cipher encryptCipher = Cipher.getInstance("DES");
        // encryptCipher.init(Cipher.ENCRYPT_MODE, key);

        // byte[] cipherMessage = encryptCipher.doFinal(messageToSend.getBytes());

        // System.out.println("Message: " + messageToSend);
        // // System.out.println(new String(cipherMessage, StandardCharsets.UTF_8));
        // // System.out.println(cipherMessage.length);
        // System.out.println("Encrypted message: " + byteArrayToHex(cipherMessage));

        // Cipher decryptCipher = Cipher.getInstance("DES");
        // decryptCipher.init(Cipher.DECRYPT_MODE, key);

        // byte[] decryptedMessage = decryptCipher.doFinal(cipherMessage);

        // System.out.println("Decrypted message: " + new String(decryptedMessage));

        // ------------------------------------------------------------------------------

        // String[] passwords = { "Cork", "Dublin", "Wexford", "Kerry", "Kildare",
        // "Kilkenny", "Mayo", "Galway",
        // "Waterford", "Meath", "Limerick" };

        // String hash64 =
        // "2PTGEi98+px2aL7vd0MEE5oRfdjliw/ISSvLEl1QB6VRY63zi5z/kTUfTX4bJ6Z7KfOr9Ehpj1a8q4WSp7q5UQ==";

        // MessageDigest sha = MessageDigest.getInstance("SHA-512");
        // byte[] hash = Base64.getDecoder().decode(hash64);
        // System.out.println(hash.length);

        // for (String p : passwords) {
        // int salt = 0;
        // for (salt = 0; salt <= 0xffff; salt++) { // bruteforce all the possibilities
        // of 2 byte salt 0x0000 to 0xffff
        // byte[] b = { (byte) ((salt >> 8) & 0xff), (byte) (salt & 0xff) };// seperate
        // the salt to byte array

        // sha.update(b); // add salt before digest
        // byte[] newHash = sha.digest(p.getBytes());

        // String newHash64 = Base64.getEncoder().encodeToString(newHash);
        // System.out
        // .println(p + ": " + newHash64 + " : " + String.format("%x", b[0]) +
        // String.format("%x", b[1]));
        // if (newHash64.equals(hash64)) {
        // System.out.println(p + ", Salt: " + String.format("%x", b[0]) +
        // String.format("%x", b[1]));
        // }
        // }
        // }

        // ------------------------------------------------------------------------------
        /* full AES 128 bit key */

        byte[] key = {(byte) 0xc0, (byte) 0xc1, (byte) 0xc7, (byte) 0xca, (byte)
                0x60, (byte) 0x31, (byte) 0x7b,
                (byte) 0xd8, (byte) 0x27, (byte) 0xfb, (byte) 0x1b, (byte) 0xee, (byte) 0x01,
                (byte) 0x30, (byte) 0x00,
                (byte) 0x00,};

        // CO C1 C7 CA 60 31 7B D8 27 FB 1B EE 01 30 A4 47
        String cipherMessage1 = "5XWvgqrISJZ+DCXEryChjQ==";
        // String cipherMessage2 = "5XWvgqrlSJZ+DCXEryChjQ==";
        // String cipherMessage3 = "5XWvgqr1SJZ+DCXEryChjQ==";
        String message = "codebreaker";
        int i = 0, j = 0;

        for (i = 0; i <= 0xff; i++) {
            for (j = 0; j <= 0xff; j++) {
                key[key.length - 1] = (byte) j;
                key[key.length - 2] = (byte) i;

                SecretKey sk = new SecretKeySpec(key, "AES");

                Cipher encrypt = Cipher.getInstance("AES/ECB/PKCS5Padding");
                encrypt.init(Cipher.ENCRYPT_MODE, sk);

                byte[] cipherText = encrypt.doFinal(message.getBytes());
                String cipher64 = Base64.getEncoder().encodeToString(cipherText);

                if (cipher64.equals(cipherMessage1)) {
                    System.out.println(String.format("%x", i) + ":" + String.format("%x", j));
                }
            }
        }

        // ------------------------------------------------------------------------------

        // BigInteger px = new BigInteger("19632307");
        // BigInteger py = new BigInteger("4810020");
        // BigInteger qx = new BigInteger("2905405");
        // BigInteger qy = new BigInteger("38180");
        // BigInteger avaSecret = new BigInteger("10007");
        // BigInteger saoSecret = new BigInteger("797161");
        // BigInteger p = new BigInteger("56214887");
        // BigInteger y1x = new BigInteger("30504791");
        // BigInteger y1y = new BigInteger("0");
        // BigInteger y2 = new BigInteger("42704371");
        // BigInteger s = new BigInteger("32964282");

        // ElepticCurve ep = new ElepticCurve("24163456", "45001710", "56214887");
        // BigInteger[] res = ep.nP(px, py, avaSecret);
        // System.out.println("Ava: " + res[0] + ", " + res[1]);
        // res = ep.nP(px, py, saoSecret);
        // System.out.println("Sao: " + res[0] + ", " + res[1]);
        // res = ep.nP(res[0], res[1], avaSecret);
        // System.out.println("both: " + res[0] + ", " + res[1]);
        // System.out.println(p.bitLength()); // 26
        // BigInteger[] y1Decompress = { null, null };
        // BigInteger[] R = { null, null };
        // y1Decompress = ep.uncompressPoint(y1x, y1y);
        // R = ep.nP(y1Decompress[0], y1Decompress[1], s);

        // MessageDigest md = MessageDigest.getInstance("SHA3-256");

        // byte[] h_R =
        // md.digest(R[0].add(ep.TWO.pow(p.bitLength()).multiply(R[1])).toByteArray());
        // BigInteger m = y2.subtract(new BigInteger(h_R));
        // System.out.println(m);

        // ------------------------------------------------------------------------------

        // String plainText = "jan11";
        // String cipherText = "NuhXLH6RVLs=";
        // byte[] key = new byte[] { (byte) 0xaa, (byte) 0xaa, (byte) 0xaa, (byte) 0xaa,
        // (byte) 0xaa, (byte) 0xaa,
        // (byte) 0x00, (byte) 0x00, };

        // for (int i = 0; i <= 0xff; i++) {
        // for (int j = 0; j <= 0xff; j++) {
        // key[key.length - 1] = (byte) j;
        // key[key.length - 2] = (byte) i;
        // SecretKey sk = new SecretKeySpec(key, "DES");

        // Cipher encrypt = Cipher.getInstance("DES/ECB/PKCS5Padding");
        // encrypt.init(Cipher.ENCRYPT_MODE, sk);

        // byte[] message = encrypt.doFinal(plainText.getBytes());
        // String message64 = Base64.getEncoder().encodeToString(message);
        // if (message64.equals(cipherText)) {
        // System.out.println(String.format("%x", i) + ":" + String.format("%x", j));
        // }
        // }
        // }

        // ------------------------------------------------------------------------------

        // String IVStr64 = "65U3jGXzxm84mVzT";
        // byte[] aesByteArr = new byte[] { (byte) 0x71, (byte) 0xde, (byte) 0x54,
        // (byte) 0x0c, (byte) 0x34, (byte) 0x95,
        // (byte) 0xa3, (byte) 0xc6, (byte) 0xc1, (byte) 0x41, (byte) 0x48, (byte) 0xc5,
        // (byte) 0x38, (byte) 0xcb,
        // (byte) 0xfe, (byte) 0xa5, (byte) 0x44, (byte) 0x08, (byte) 0x37, (byte) 0x68,
        // (byte) 0xcd, (byte) 0x2c,
        // (byte) 0xed, (byte) 0x60, (byte) 0x48, (byte) 0xfb, (byte) 0x8c, (byte) 0x37,
        // (byte) 0x29, (byte) 0x2e,
        // (byte) 0xdd, (byte) 0x70, };
        // byte[] aadArr = new byte[] { (byte) 0x61, (byte) 0x62, (byte) 0x00 };
        // String cipherText64 = "wv9bPRIQhm5C5uCHpHg7HruTpJfb";
        // int GCM_TAG_LENGTH = 128;

        // byte[] IVStr = Base64.getDecoder().decode(IVStr64);
        // byte[] cipherText = Base64.getDecoder().decode(cipherText64);

        // SecretKey sk = new SecretKeySpec(aesByteArr, "AES");
        // GCMParameterSpec g = new GCMParameterSpec(GCM_TAG_LENGTH, IVStr);
        // Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");
        // cipher.init(Cipher.DECRYPT_MODE, sk, g);
        // for (int i = 0; i <= 0xff; i++) {
        // aadArr[aadArr.length - 1] = (byte) i;
        // cipher.updateAAD(aadArr);
        // try {
        // byte[] message = cipher.doFinal(cipherText);
        // String plainText = new String(message);
        // System.out.println(plainText);
        // System.out.println(String.format("%x", i));
        // System.out.println((char) i);
        // } catch (Exception e) {

        // }
        // }

        // ------------------------------------------------------------------------------
        // // decrypt base64 text from a .ser file containing the AES key

        // String cipherText64 =
        // "IqvMIevP1PCO0W4UXgYvU+JSDayZBrKj+uk6GQU8Y03N2gvliaD8dYG2cbyT0WRO";

        // byte[] cipherText = Base64.getDecoder().decode(cipherText64);

        // FileInputStream fs = new FileInputStream(
        // "C:\\Users\\Shihab\\Documents\\VScode\\Java\\CryptoTest1\\DefaultAES256Key.ser");
        // ObjectInputStream os = new ObjectInputStream(fs);

        // Object ob1 = os.readObject();
        // SecretKey sk = (SecretKeySpec) ob1;
        // System.out.println(sk.getAlgorithm());
        // System.out.println(sk.getFormat());
        // System.out.println(cipherText.length);

        // Cipher decrypt = Cipher.getInstance("AES/ECB/PKCS5Padding");
        // decrypt.init(Cipher.DECRYPT_MODE, sk);

        // byte[] message = decrypt.doFinal(cipherText);
        // String plaintext = new String(message);
        // System.out.println(plaintext);

        // The password you require is Kunoichi
        // ------------------------------------------------------------------------------

        // String cipherText64 =
        // "L4JwZr1hziItX2EqVzQeWPjGxgaAuMKWPl6LhNCKszztIn+ekxR9DQCIeZS77VJ0";
        // String cipherText641 =
        // "L4JwZrIhziltX2EqVzQeWPjGxgaAuMKWP16LhNCKszztin+ekxR9DQCleZS77VJ0";
        // byte[] aesByteArr = new byte[] { (byte) 0xee, (byte) 0xee, (byte) 0xee,
        // (byte) 0xee, (byte) 0xee, (byte) 0xee,
        // (byte) 0xee, (byte) 0xee, (byte) 0xee, (byte) 0xee, (byte) 0xee, (byte) 0xee,
        // (byte) 0xee, (byte) 0xee,
        // (byte) 0xee, (byte) 0xee, (byte) 0xaa, (byte) 0xaa, (byte) 0xaa, (byte) 0xaa,
        // (byte) 0xaa, (byte) 0xaa,
        // (byte) 0xaa, (byte) 0xaa, (byte) 0xee, (byte) 0xee, (byte) 0xee, (byte) 0xee,
        // (byte) 0xee, (byte) 0xee,
        // (byte) 0xee, (byte) 0xee };
        // byte[] cipherText = Base64.getDecoder().decode(cipherText641);

        // SecretKey sk = new SecretKeySpec(aesByteArr, "AES");
        // Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");

        // cipher.init(Cipher.DECRYPT_MODE, sk);

        // byte[] messageArr = cipher.doFinal(cipherText);
        // System.out.println(new String(messageArr));

        // // cipher.init(Cipher.ENCRYPT_MODE, sk);
        // // System.out.println(
        // // Base64.getEncoder().encodeToString(cipher.doFinal("The password you
        // require is Kunoichi".getBytes())));

        // ------------------------------------------------------------------------------

//        BigInteger px = new BigInteger("8160070");
//        BigInteger py = new BigInteger("13649469");
//        BigInteger qx = new BigInteger("1695569");
//        BigInteger qy = new BigInteger("28093181");
//        BigInteger p = new BigInteger("29526661");
//        BigInteger y1x = new BigInteger("29366043");
//        BigInteger y1y = new BigInteger("0");
//        BigInteger y2 = new BigInteger("17595690");
//        BigInteger s = new BigInteger("14418581");
//
//        ElepticCurve ep = new ElepticCurve("28208962", "9040486", "29526661");
//        int bitLength = p.bitLength();
//        System.out.println("bitLength: " + bitLength); // 26
//        BigInteger[] y1Decompress = { null, null };
//        BigInteger[] R = { null, null };
//        y1Decompress = ep.uncompressPoint(y1x, y1y);
//        R = ep.nP(y1Decompress[0], y1Decompress[1], s);
//
//        MessageDigest md = MessageDigest.getInstance("SHA3-256");
//        byte[] h_R = md.digest(R[0].add(R[1]).toByteArray());
//        System.out.println(h_R.length);
//        long x = (long) h_R[0];
//        x = x << 8;
//        x = x | h_R[1];
//        x = x << 8;
//        x = x | h_R[2];
//        x = (x << 1) | (h_R[3] >> 7);
//        System.out.println(y2.subtract(BigInteger.valueOf(x)).mod(p));
        // byte[] h_R =
        // md.digest(R[0].add(ep.TWO.pow(p.bitLength()).multiply(R[1])).toByteArray());
        // BigInteger m = y2.subtract(new BigInteger(h_R));
        // System.out.println(m);
    }

    public static String byteArrayToHex(byte[] a) {
        StringBuilder sb = new StringBuilder(a.length * 2);
        for (byte b : a)
            sb.append(String.format("%02x:", b));
        return sb.toString();
    }
}
