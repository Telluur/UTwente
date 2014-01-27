package ss.week8;

import java.io.*;
import java.net.Socket;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * User: Rick
 * Date: 23-1-14
 * Time: 12:11
 */
public class PKIPeer implements Runnable {
    protected String name;
    protected Socket socket;
    protected BufferedReader in;
    protected BufferedWriter out;
    private String base64Message;
    private String plaintextMessage = "Hello world";


    public PKIPeer(Socket socket) throws IOException {
        this.socket = socket;
        in = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
        out = new BufferedWriter(new OutputStreamWriter(this.socket.getOutputStream()));
    }

    public void run() {
        while (true) {
            try {
                String message = in.readLine();
                System.out.println(message);
                handleMessages(message);
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ProtocolException e) {
                e.printStackTrace();
            }


        }

    }


    public void sendMessage(String message) {
        if (message.equals("exit")) {
            close();
        } else {
            try {
                out.write(message + "\n");
                out.flush();
                System.out.println("sent message: " + message);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


        try {
            out.write(message + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void close() {
        try {
            in.close();
            out.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void handleMessages(String message) throws ProtocolException {
        Scanner scanner = new Scanner(message).useDelimiter("\\s+");
        switch (scanner.next()) {
            case "PRIVKEY":
                PrivateKey privateKey = Crypto.decodePrivateKey(Crypto.decodeBase64(scanner.next()));
                System.out.println(privateKey.toString());
                base64Message = Crypto.encodeBase64(Crypto.signMessage(plaintextMessage, privateKey));
               System.out.println(base64Message);
                break;
            case "PUBKEY":
                PublicKey publicKey = Crypto.decodePublicKey(Crypto.decodeBase64(scanner.next()));
                System.out.println(publicKey.toString());
                Boolean check = Crypto.verifyMessage(Crypto.decodeBase64(base64Message), plaintextMessage, publicKey);
                System.out.println(check);
                break;
            default:
                throw new ProtocolException("Unknown protocol command.");
        }
    }
}
