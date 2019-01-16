package primeThreadmgmt.driver;
import java.io.IOException;
import primeThreadmgmt.util.FileProcessor;
import primeThreadmgmt.util.Results;
import primeThreadmgmt.util.IsPrime;
import primeThreadmgmt.util.MyLogger;
import primeThreadmgmt.threadgmt.CreateWorkers;
import primeThreadmgmt.threadgmt.WorkerThreads;
import java.util.Scanner;
import java.io.File;

public class Driver{
    
    
    
    public static void main(String[] args){
        if(args.length != 3){
            System.err.println("Invalid number of arguments");
            System.exit(1);
        }
            String inputfile = args[0];
            File input = new File(inputfile);
            int num_threads = Integer.parseInt(args[1]);
            if(!(input.exists())) {
            	System.err.println("Input File does not exist");
            	System.exit(1);
            }
            
            if(!(num_threads >= 1 && num_threads <= 5)){
                System.err.println("Invalid number of threads");
                System.exit(1);
            }
            int debug_value = Integer.parseInt(args[2]);
            if(!(debug_value >= 0 && debug_value <= 4)){
                System.err.println("Invalid Debug_Value");
                System.exit(1);
            }
            
            FileProcessor fp = new FileProcessor();
            Results r = new Results();
            IsPrime ip = new IsPrime();
            fp.get_file(input);
            CreateWorkers cw = new CreateWorkers(fp,r,ip);
            MyLogger.setDebugValue(debug_value);
            cw.startWorkers(num_threads);
            r.writeSumToScreen();
            
            
    }
    
}