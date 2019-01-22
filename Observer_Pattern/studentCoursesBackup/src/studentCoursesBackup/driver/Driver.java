package studentCoursesBackup.driver;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import studentCoursesBackup.myTree.Node;
import studentCoursesBackup.myTree.SubjectI.Operation;
import studentCoursesBackup.util.FileDisplayInterface;
import studentCoursesBackup.util.FileProcessor;
import studentCoursesBackup.util.Results;
import studentCoursesBackup.util.StdoutDisplayInterface;
import studentCoursesBackup.util.TreeBuilder;

public class Driver {
	static String inputfileName, deletefileName;

	public static String getFileName() {
		return inputfileName;
	}

	public static void setFileName(String fileName) {
		Driver.inputfileName = fileName;
	}

	public static String getFileName1() {
		return deletefileName;
	}

	public static void setFileName1(String fileName) {
		Driver.deletefileName = fileName;
	}

	public static void validateCommandLine(String[] args) {

		if (args.length < 5) {
			System.out.println("invalid cmd line arguments");
			System.exit(1);
		}

	}

	public static void main(String[] args) {

		validateCommandLine(args); // validating command line arguments
		inputfileName = args[0];
		setFileName(inputfileName);
		deletefileName = args[1];
		setFileName1(deletefileName);
		String out1 = args[2];
		String out2 = args[3];
		String out3 = args[4];

		FileProcessor p = new FileProcessor();
		TreeBuilder tree = new TreeBuilder();
		StdoutDisplayInterface r1 = new Results();
		FileDisplayInterface r2=new Results();

		p.Read_inputFile(); // Reading input file and populating the trees
		for (int c = 0; c < p.arr_id_insert.length; c++) {
			tree.insert(p.arr_id_insert[c], (String) p.arr_course.get(c));
		}

		tree.nodeRegistration(); // setting backup node 1 and backup node 2 as listeners

		p.Read_deleteFile(); // Processing delete file
		for (int c1 = 0; c1 < p.arr_id_delete.length; c1++) {
			tree.searchKey(p.arr_id_delete[c1], p.arr_course_del.get(c1));
		}

		tree.inorder_Traversal();

		r1.writeToConsole();
		r2.writeToFile(out1, out2, out3); // Printing results to files

	}
}
