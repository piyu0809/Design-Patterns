package primeThreadmgmt.threadgmt;
import primeThreadmgmt.util.IsPrime;
import primeThreadmgmt.util.Results;
import primeThreadmgmt.util.MyLogger;
import java.util.ArrayList;

import primeThreadmgmt.util.FileProcessor;

public class WorkerThreads implements Runnable {
	private FileProcessor fp;
	private Results r;
	private IsPrime ip;
	int num;
	String line;
	
	public WorkerThreads(FileProcessor fpIn1,Results rIn1,IsPrime ipIn1) {
		this.fp = fpIn1;
		this.r = rIn1;
		this.ip = ipIn1;
		MyLogger.writeMessage("Constructor invoked: " + this.getClass().getName(), MyLogger.DebugLevel.CONSTRUCTOR);
	}
	public void run(){
		
	while((line = fp.read_line()) != null) { 
		
	num	= Integer.parseInt(line);
	if((ip.isPrime(num))) {
		r.num1.add(num);      //adding prime numbers to the datastructure arraylist in results.
		MyLogger.writeMessage("Number added to result dataStructure: " + this.getClass().getName(), MyLogger.DebugLevel.RESULTDATASTRUCTURE);
		}
	MyLogger.writeMessage("Run is called: " + this.getClass().getName(), MyLogger.DebugLevel.RUN);
	}
	
	
	
	}
}
