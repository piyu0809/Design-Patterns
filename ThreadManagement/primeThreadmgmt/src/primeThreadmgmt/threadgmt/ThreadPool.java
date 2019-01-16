package primeThreadmgmt.threadgmt;

import java.util.ArrayList;
import java.util.Vector;
import primeThreadmgmt.util.FileProcessor;
import primeThreadmgmt.util.IsPrime;
import primeThreadmgmt.util.Results;

public class ThreadPool {
	int num_threads1;
	public Vector<WorkerThreads> wthreads = new Vector();
	int cnt = 0;
	

	public ThreadPool(FileProcessor fpIn, Results rIn, IsPrime ipIn) {
		
		WorkerThreads t;
		for(int i=0;i<10;i++) {
			t = new WorkerThreads(fpIn, rIn, ipIn);    //creating pool of threads.
			wthreads.addElement(t);
			}
		}
	
	public WorkerThreads borrowThread() {
		WorkerThreads wt;            // returns one thread at a time from the thread pool.
		wt = wthreads.get(cnt);
		cnt++;
		return wt;
	
		
		}
	
	
	
	

}
