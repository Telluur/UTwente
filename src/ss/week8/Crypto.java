package ss.week8;


import com.sun.org.apache.xml.internal.security.exceptions.Base64DecodingException;
import com.sun.org.apache.xml.internal.security.utils.Base64;


import java.security.*;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

public class Crypto extends PKITest {


    public static byte[] decodeBase64(String message) {
        byte[] bytes = null;
        try {
            bytes = Base64.decode(message);
        } catch (Base64DecodingException e) {
            e.printStackTrace();
        }
        return bytes;
    }

    public static String encodeBase64(byte[] bytes) {
        return Base64.encode(bytes);
    }

    public static PrivateKey decodePrivateKey(byte[] rawKey) {
        PKCS8EncodedKeySpec keySpec;
        KeyFactory fact;
        PrivateKey privateKey = null;
        try {
            keySpec = new PKCS8EncodedKeySpec(rawKey);
            fact = KeyFactory.getInstance("RSA");
            privateKey = fact.generatePrivate(keySpec);
        } catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
            e.printStackTrace();
        }
        return privateKey;
    }

    public static PublicKey decodePublicKey(byte[] rawKey) {
        X509EncodedKeySpec keySpec;
        KeyFactory fact;
        PublicKey publicKey = null;
        try {
            keySpec = new X509EncodedKeySpec(rawKey);
            fact = KeyFactory.getInstance("RSA");
            publicKey = fact.generatePublic(keySpec);

        } catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
            e.printStackTrace();
        }
        return publicKey;
    }

    public static byte[] signMessage(String message, PrivateKey privateKey) {
        Signature sig = null;
        byte[] signature = null;
        try {
            sig = Signature.getInstance("SHA1withRSA");
            sig.initSign(privateKey);
            sig.update(message.getBytes());
            signature = sig.sign();
        } catch (NoSuchAlgorithmException | SignatureException | InvalidKeyException e) {
            e.printStackTrace();
        }
        return signature;
    }

    public static boolean verifyMessage(byte[] signature, String message, PublicKey publicKey) {
        Boolean check = false;
        try {
            Signature sig = Signature.getInstance("SHA1withRSA");
            sig.initVerify(publicKey);
            sig.update(message.getBytes());
            check = sig.verify(signature);
        } catch (NoSuchAlgorithmException | SignatureException | InvalidKeyException e) {
            e.printStackTrace();
        }
        return check;
    }

    public static byte[] generateNonce() {
        SecureRandom secureRandom = new SecureRandom();
        byte[] b1 = new byte[128 / 8];
        secureRandom.nextBytes(b1);
        return b1;

    }

/*
    public static void byteTest(byte[] bytes){
        String string = new String(bytes);
        byte[] b = string.getBytes();
        System.out.println(bytes.equals(b));
    }

    public static void byteTest(){
        String m1 = "Hello world!";
        byte[] bytes = m1.getBytes();
        String m2 = new String(bytes);
        System.out.println(m2.equals(m1));

    }
*/

}
