package ss.week8;

import org.apache.commons.codec.binary.Hex;
import ss.week1.password.Password;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Passwords {
    private static final char[] ch = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
    private MessageDigest md5;
    private String alice = "c0af77cf8294ff93a5cdb2963ca9f038";

    public Passwords() {
        try {
            md5 = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }


    public void run() {
        String password;
        long startAttempt;
        long timeAttempt;
        long start = System.currentTimeMillis();
        long time;
        bruteForce:
        {
            for (char ch1 : ch) {
                for (char ch2 : ch) {
                    for (char ch3 : ch) {
                        for (char ch4 : ch) {
                            password = "" + ch1 + ch2 + ch3 + ch4;
                            startAttempt = System.currentTimeMillis();
                            md5.update(password.getBytes());
                            if (Hex.encodeHexString(md5.digest()).equals(alice)) {
                                long end = System.currentTimeMillis();
                                timeAttempt = end - startAttempt;
                                time = end - start;
                                System.out.println("Password found: '" + password + "',try took " + timeAttempt + "ms. Total time: " + time);
                                break bruteForce;
                            } else {
                                timeAttempt = System.currentTimeMillis() - startAttempt;
                                System.out.println("Password not found: '" + password + "',try took " + timeAttempt + "ms.");
                            }
                        }
                    }
                }
            }
        }
    }


    public static void main(String[] args) {
        new Passwords().run();
    }
}
