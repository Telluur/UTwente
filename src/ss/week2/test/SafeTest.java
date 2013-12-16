package ss.week2.test;

import ss.week2.hotel.Password;
import ss.week2.hotel.Safe;


public class SafeTest {
    /** Number of errors. */
    private int errors;
    /** Notice belonging to test method. */
    private boolean isPrinted;
    /** Indication that an errors was found in test method. */
    private String description;
	
	public static void main (String[] args){
		new SafeTest().run();
	}
		
	public void run(){
		description = "Safe test";
		
		Password password1 = new Password();
		password1.setWord("initialpassword", "testword1");
		Safe safe = new Safe(password1);
		

		safe.activate("testword1");
		safe.open("testword1");
		
		assertEquals("Activated", true, safe.isActive());
		assertEquals("Open", true, safe.isOpen());
		
		safe.close();
		safe.deactivate();
		
		assertEquals("Closed", false, safe.isOpen());
		assertEquals("Deactivated", false, safe.isActive());
		
		description = "Wrong password safe test";
		
		safe.activate("testword2");
		safe.open("testword2");
		
		assertEquals("Activated", false, safe.isActive());
		assertEquals("Open", false, safe.isOpen());
		
        if (errors == 0) {
            System.out.println("    OK");
        }
	}
	
    private void assertEquals(String text, Object expected, Object result) {
        boolean equal;
        // tests equality between expected and result
        // accounting for null
        if (expected == null) {
            equal = result == null;
        } else {
            equal = result != null && expected.equals(result);
        }
        if (!equal) {
            // prints the description if necessary
            if (!isPrinted) {
                System.out.println("    Test: " + description);
                // now the description is printed
                isPrinted = true;
            }
            System.out.println("        " + text);
            System.out.println("            Expected:  " + expected);
            System.out.println("            Result: " + result);
            errors++;
        }
    }
}
