package primeThreadmgmt.util;

public class IsPrime{
	
	int number;
	
	public boolean isPrime(int number) {
		if(number%2 == 0) {
			return false;
		}
		else {
			return true;
		}
	}
}