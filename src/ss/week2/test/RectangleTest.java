package ss.week2.test;

import ss.week2.Rectangle;

public class RectangleTest {
	
    /** Number of errors. */
    private int errors;
    /** Notice belonging to test method. */
    private boolean isPrinted;
    /** Indication that an errors was found in test method. */
    private String description;

	public static void main(String[] args){
		new RectangleTest().run();
	}
	
	public void run(){
		description = "Rectangle test";
		Rectangle rectangle = new Rectangle(5,4);
		assertEquals("Area", 20, rectangle.area());
		assertEquals("Perimeter", 18, rectangle.perimeter());
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
