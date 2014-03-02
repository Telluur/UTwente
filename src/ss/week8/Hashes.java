package ss.week8;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import org.apache.commons.codec.binary.Hex;

public class Hashes {
    private MessageDigest md5;
    private MessageDigest sha1;
    private MessageDigest sha256;
    private byte[] helloWorld = "Hello World".getBytes();

    public Hashes() {
        try {
            md5 = MessageDigest.getInstance("MD5");
            sha1 = MessageDigest.getInstance("SHA-1");
            sha256 = MessageDigest.getInstance("SHA-256");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }


    public void run() {
        md5.update(helloWorld);
        byte[] md5bytes = md5.digest();
        System.out.println("MD5: " + Hex.encodeHexString(md5bytes));

        sha1.update(helloWorld);
        byte[] sha1bytes = sha1.digest();
        System.out.println("SHA-1: " + Hex.encodeHexString(sha1bytes));

        sha256.update(helloWorld);
        byte[] sha256bytes = sha256.digest();
        System.out.println("SHA-256: " + Hex.encodeHexString(sha256bytes));

    }


    public static void main(String[] args) {
        new Hashes().run();
    }
}
