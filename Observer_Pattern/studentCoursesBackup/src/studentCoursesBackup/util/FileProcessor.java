package studentCoursesBackup.util;

import java.io.BufferedReader;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import studentCoursesBackup.driver.Driver;

public class FileProcessor {

	public ArrayList arr_course = new ArrayList();
	public int[] arr_id_insert;
	public ArrayList<String> arr_course_del = new ArrayList();
	public int[] arr_id_delete;

	List<String> list = new ArrayList<String>();
	List<String> list_add;

	public void possibleCourses() {
		list.add("A");
		list.add("B");
		list.add("C");
		list.add("D");
		list.add("E");
		list.add("F");
		list.add("G");
		list.add("H");
		list.add("I");
		list.add("J");
		list.add("K");
	}

	public void Read_inputFile() {
		possibleCourses();
		ArrayList arr_id = new ArrayList();
		String file = Driver.getFileName();
		file="\\src\\Data\\"+file;
		BufferedReader in = null;
		File f = new File(file);

		try {
			in = new BufferedReader(new FileReader(file));
			if (f.length() == 0) {
				String e = null;
				throw new IOException(e);
			}

		} catch (FileNotFoundException e) {
			System.out.println("File not found");
			System.exit(1);
		} catch (IOException e) {
			System.out.println("File is empty");
			System.exit(1);
		}
		String str, str1, str2;
		try {
			while ((str = in.readLine()) != null) {
				str2 = str.substring(0, 4);
				str1 = str.substring(5);
				String c = CourseCheck(str1);
				int result = Integer.parseInt(str2);
				arr_id.add(result);
				arr_course.add(c);
			}

		} catch (IOException e) {
			System.out.println("Error in processing input file");
		}
		arr_id_insert = new int[arr_id.size()];
		for (int i = 0; i < arr_id.size(); i++) {
			arr_id_insert[i] = ((Integer) arr_id.get(i)).intValue();
		}
	}

	public String CourseCheck(String str) {

		String[] list_add = new String[100];
		for (int i = 0; i < str.length(); i++) {
			char c1 = str.charAt(i);
			list_add[i] = c1 + "";
		}
		String s = "";
		for (int i = 0; i < list_add.length; i++) {
			if (list.contains(list_add[i])) {
				String f = list_add[i];
				s = s + f + ",";
			}
		}
		if (s.endsWith(",")) {
			s = s.substring(0, s.length() - 1);
		}
		return s;
	}

	public void Read_deleteFile() {
		ArrayList arr_del = new ArrayList();
		String file = Driver.getFileName1();
		file="\\src\\Data\\"+file;
		BufferedReader in = null;
		try {
			in = new BufferedReader(new FileReader(file));
		} catch (FileNotFoundException e1) {
			System.out.println("File not found");
			System.exit(1);
		}
		String str, str1, str2;

		try {
			while ((str = in.readLine()) != null) {
				str2 = str.substring(0, 4);
				str1 = str.substring(5);
				int result = Integer.parseInt(str2);
				arr_del.add(result);
				arr_course_del.add(str1);
			}
		} catch (IOException e) {
			System.out.println("Error in processing delete file");

		}

		arr_id_delete = new int[arr_del.size()];
		for (int i = 0; i < arr_del.size(); i++) {
			arr_id_delete[i] = ((Integer) arr_del.get(i)).intValue();
		}
	}
}
