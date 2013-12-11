package ss.week2.hotel;

import ss.week3.pw.Password;

public class SafeTest {
	public static void main (String[] args){
		new SafeTest().run();
	}
	
	public void run(){
		Password password1 = new Password();
		password1.setWord("initialpassword", "testword1");
		Safe safe1 = new Safe(password1);
		Password password2 = new Password();
		password1.setWord("initialpassword", "testword2");
		Safe safe2 = new Safe(password2);
		
		safe1.activate("testword1");
		safe1.open("testword1");
		System.out.println(safe1.isOpen() + " : " + safe1.isActive());
	}
}
