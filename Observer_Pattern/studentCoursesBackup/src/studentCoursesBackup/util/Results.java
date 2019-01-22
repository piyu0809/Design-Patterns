package studentCoursesBackup.util;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import studentCoursesBackup.myTree.Node;

public class Results implements FileDisplayInterface, StdoutDisplayInterface {

	static ArrayList<String> result_origin = new ArrayList();
	static ArrayList<String> result_node1 = new ArrayList();
	static ArrayList<String> result_node2 = new ArrayList();
	TreeBuilder tree1 = new TreeBuilder();

	@Override
	public void writeToConsole() {
		System.out.println("Original Tree  : ");
		for (int y = 0; y < result_origin.size(); y++) {
			System.out.println(result_origin.get(y));
		}
		System.out.println("Backup Tree 1  : ");
		for (int y = 0; y < result_node1.size(); y++) {
			System.out.println(result_node1.get(y));
		}
		System.out.println("Backup tree 2  : ");
		for (int y = 0; y < result_node2.size(); y++) {
			System.out.println(result_node2.get(y));
		}

	}

	@Override
	public void writeToFile(String fileName1, String fileName2, String fileName3) {
		BufferedWriter bufferedWriter1 = null;
		BufferedWriter bufferedWriter2 = null;
		BufferedWriter bufferedWriter3 = null;
		fileName1="\\src\\Data\\"+fileName1;
		fileName2="\\src\\Data\\"+fileName2;
		fileName3="\\src\\Data\\"+fileName3;
		try {

			bufferedWriter1 = new BufferedWriter(new FileWriter(fileName1));
			bufferedWriter1.write("Original Tree:");
			bufferedWriter1.newLine();
			for (int i = 0; i < result_origin.size(); i++) {
				String st = result_origin.get(i);
				bufferedWriter1.write(st);
				bufferedWriter1.newLine();
			}

			bufferedWriter2 = new BufferedWriter(new FileWriter(fileName2));
			bufferedWriter2.write("Backup Tree 1:");
			bufferedWriter2.newLine();
			for (int i = 0; i < result_node1.size(); i++) {
				String st = result_node1.get(i);
				bufferedWriter2.write(st);
				bufferedWriter2.newLine();
			}

			bufferedWriter3 = new BufferedWriter(new FileWriter(fileName3));
			bufferedWriter3.write("Backup Tree 2:");
			bufferedWriter3.newLine();
			for (int i = 0; i < result_node2.size(); i++) {
				String st = result_node2.get(i);
				bufferedWriter3.write(st);
				bufferedWriter3.newLine();

			}

		} catch (IOException e) {
			e.printStackTrace();

		} finally {
			try {
				if (bufferedWriter1 != null) {
					bufferedWriter1.close();
				}
				if (bufferedWriter2 != null) {
					bufferedWriter2.close();
				}
				if (bufferedWriter3 != null) {
					bufferedWriter3.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

}
