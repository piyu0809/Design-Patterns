package studentCoursesBackup.myTree;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import studentCoursesBackup.myTree.SubjectI.Operation;
import studentCoursesBackup.util.TreeBuilder;

public class Node implements ObserverI, SubjectI {
	public int key;
	public String course = null;
	public Node left;
	public Node right;
	Node temp;

	TreeBuilder t = new TreeBuilder();
	public List<Node> observers = new ArrayList<Node>();

	@Override
	public String toString() {
		return "" + key + ":" + course + "";
	}

	public Node(int item, String value) {
		key = item;
		course = value;
		left = right = null;
	}

	@Override
	public void Register(Node n) {
		observers.add(n);
	}

	@Override
	public void Unregister(Node n) {
		// TODO Auto-generated method stub

	}

	@Override
	public void notifyAllObs(int key, String course, Operation e) {

		if (e == Operation.delete) {
			for (int j = 0; j < observers.size(); j++) {
				update(observers.get(j), key, course);
			}
		}
	}

	@Override
	public void update(Node n, int key, String course) {
		temp = t.search(n, key);
		ArrayList list = new ArrayList();
		String origin_course = temp.course;

		course = course.replaceAll(",", "");
		origin_course = origin_course.replaceAll(",", "");
		for (int i = 0; i < course.length(); i++) {
			for (int j = 0; j < origin_course.length(); j++) {
				if (course.charAt(i) == origin_course.charAt(j)) {
					origin_course = t.removeChar(origin_course, j);

				}
			}
		}
		if (origin_course.isEmpty()) {
			temp.course = "Empty";
		}

		else {
			String r = "";
			for (int y = 0; y < origin_course.length(); y++) {
				char s = origin_course.charAt(y);
				r = r + s + ",";
			}
			if (r.endsWith(",")) {
				r = r.substring(0, r.length() - 1);
				origin_course = r;
			}
			temp.course = origin_course;
		}

	}
}
