package ss.week8;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class PKITest {
    private InetAddress inetAddress;
    private Socket socket;
    public final static String SERVER = "130.89.163.155";
    public final static int PORT = 2013;


    public static void main(String[] args) {
        new PKITest().start();
        //System.out.println(Crypto.generateToken());



    }

    public void start() {
        try {
            inetAddress = InetAddress.getByName("ss-security.student.utwente.nl");
            socket = new Socket(SERVER, PORT);
            PKIPeer p = new PKIPeer(socket);
            Thread streamInputHandler = new Thread(p);
            streamInputHandler.start();
            p.sendMessage("IDPLAYER player_michiel koekje");
            p.sendMessage("PUBLICKEY player_michiel");
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
