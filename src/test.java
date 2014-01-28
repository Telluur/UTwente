import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * Created by Rick on 28-1-14.
 */
public class test {
    public static void main(String[] args){
        new test().test();

    }

    public final static String AUTH_SERVER = "ss-security.student.utwente.nl";

    void test(){
        try {
            System.out.println(InetAddress.getByName(AUTH_SERVER).toString());
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }
}
