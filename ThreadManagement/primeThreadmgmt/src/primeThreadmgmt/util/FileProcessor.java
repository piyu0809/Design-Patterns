package primeThreadmgmt.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import primeThreadmgmt.util.IsPrime;

public class FileProcessor{
	IsPrime ip = new IsPrime();
	public ArrayList number = new ArrayList();
	public BufferedReader reader = null;
	
	public void get_file(File input){
			
		try {
			reader = new BufferedReader(new FileReader(input));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	       
	    }
	public synchronized String read_line() {
		try {
			return reader.readLine();
		}
		catch (IOException e) {
			return null;
		}
	   
	   
	   
	}

	
	
}
