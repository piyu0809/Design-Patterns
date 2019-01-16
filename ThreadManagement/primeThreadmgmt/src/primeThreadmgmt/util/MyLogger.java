package primeThreadmgmt.util;

public class MyLogger{

   
    public static enum DebugLevel { CONSTRUCTOR, RUN, SUMOFPRIME, DATASTRUCTURE, RESULTDATASTRUCTURE, 
                                   };

    private static DebugLevel debugLevel;


   
    public static void setDebugValue (int levelIn) {

    	switch (levelIn) {
    case 4: debugLevel = DebugLevel.CONSTRUCTOR; break;
    //stdout whenever constructor is called.
	case 3: debugLevel = DebugLevel.RUN; break;
	//stdout whenever run method is called.
	case 2: debugLevel = DebugLevel.RESULTDATASTRUCTURE; break;
	//stdout everytime entry is added to result data Structure
	case 1: debugLevel = DebugLevel.DATASTRUCTURE; break;
	//stdout contents of data structure
	case 0: debugLevel = DebugLevel.SUMOFPRIME; break;
	//stdout sumofprime number is:
	//default: debugLevel = DebugLevel.NONE; break;
	}
    }

    public static void setDebugValue (DebugLevel levelIn) {
	debugLevel = levelIn;
    }

    public static void writeMessage (String     message  ,
                                     DebugLevel levelIn ) {
	if (levelIn == debugLevel)
	    System.out.println(message);
    }

    public String toString() {
	return "The debug level has been set to the following " + debugLevel;
    }
}
