package primeThreadmgmt.threadgmt;
import primeThreadmgmt.util.FileProcessor;
import primeThreadmgmt.util.IsPrime;
import primeThreadmgmt.util.Results;
import primeThreadmgmt.util.MyLogger;
import primeThreadmgmt.threadgmt.ThreadPool;




public class CreateWorkers{
	private FileProcessor fp;
	private Results r;
	private IsPrime ip;
	ThreadPool t;
	public CreateWorkers(FileProcessor fpIn, Results rIn, IsPrime ipIn){
		this.fp = fpIn;
		this.r = rIn;
		this.ip = ipIn;
		t = new ThreadPool(fpIn, rIn, ipIn);
		
		MyLogger.writeMessage("Constructor called: " + t + "____ "+ this.getClass().getName(), MyLogger.DebugLevel.CONSTRUCTOR);
	}
	
	
	
	public void startWorkers(int num_threadsIn) {
		
	
		for(int i=0;i<num_threadsIn;i++) {
		WorkerThreads workerthread = t.borrowThread(); //borrowing threads from threadpool
		Thread thread = new Thread(workerthread);
		thread.start(); //starting thread
		try {
			thread.join(); // joining thread
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
		
		
		
	}
}