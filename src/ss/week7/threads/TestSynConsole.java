package ss.week7.threads;

public class TestSynConsole extends Thread{
	
	public void run(){
		sum();
	}

	private void sum(){
		int n1 = SynConsole.readInt(getName() + ": get number 1? ");
		int n2 = SynConsole.readInt(getName() + ": get number 2? ");
		SynConsole.println(getName() + ": "+ n1 + " + " + n2 + " = " + (n1+n2));
	}
	
	public static void main(String[] args){
		new TestSynConsole().start();
		new TestSynConsole().start();		
	}
}
