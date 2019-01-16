package primeThreadmgmt.util;

import java.util.Vector;

public class Results implements StdoutDisplayInterface{
	public Vector num1 = new Vector<>();
	int sum = 0;
	int prime_num;
	



public void writeSumToScreen() {
	// TODO Auto-generated method stub
	for(int i=0;i<num1.size();i++) {
		MyLogger.writeMessage(num1.get(i) + this.getClass().getName(), MyLogger.DebugLevel.DATASTRUCTURE);
		prime_num = (int) num1.get(i);
		sum = sum + prime_num;
	}
	System.out.println("Sum of all prime numbers is:" + sum);
	MyLogger.writeMessage("The sum of all prime numbers is:"+ sum + this.getClass().getName(), MyLogger.DebugLevel.SUMOFPRIME);
	
}

}