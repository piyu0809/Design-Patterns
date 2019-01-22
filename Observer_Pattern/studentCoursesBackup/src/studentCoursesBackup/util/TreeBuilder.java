package studentCoursesBackup.util;

import studentCoursesBackup.myTree.*;
import java.awt.List;

import java.util.ArrayList;
import java.util.Arrays;

import studentCoursesBackup.myTree.Node;
import studentCoursesBackup.myTree.SubjectI.Operation;

public class TreeBuilder {

	Node node_origin, backup_Node_1, backup_Node_2, temp;

	// This method mainly calls insertRec()
	public void insert(int key, String value) {
		Node tmp=search(node_origin,key);
		Node tmp1=search(backup_Node_1,key);
		Node tmp2=search(backup_Node_2,key);
		
		if(tmp==null && tmp1==null && tmp2==null) {
		node_origin = insertRec(node_origin, key, value);
		backup_Node_1 = insertRec(backup_Node_1, key, value);
		backup_Node_2 = insertRec(backup_Node_2, key, value);
		}
		else
		{
			tmp.course=tmp.course+","+value;
			tmp1.course=tmp.course;
			tmp2.course=tmp.course;
		}

	}

	public void nodeRegistration() {
		node_origin.observers.add(backup_Node_1);
		node_origin.observers.add(backup_Node_2);

	}

	public static String removeChar(String st, int index) {
		return st.substring(0, index) + st.substring(index + 1);
	}

	public void searchKey(int key, String course_del) {
		temp = search(node_origin, key);
		ArrayList list = new ArrayList();
		String origin_course = temp.course;

		course_del = course_del.replaceAll(",", "");
		origin_course = origin_course.replaceAll(",", "");
		for (int i = 0; i < course_del.length(); i++) {
			for (int j = 0; j < origin_course.length(); j++) {
				if (course_del.charAt(i) == origin_course.charAt(j)) {
					origin_course = removeChar(origin_course, j);

				}

			}
		}
		if (origin_course.isEmpty()) {
			temp.course = "Empty";

		} else {
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

		// String course=delete(temp);
		node_origin.notifyAllObs(key, course_del, Operation.delete);

	}

	/*
	 * public String delete(Node n) { String t=n.course; n.course = "Empty"; return
	 * t; }
	 */

	/* A recursive function to insert a new key in BST */
	Node insertRec(Node root, int key, String course) {

		/* If the tree is empty, return a new node */
		if (root == null) {
			root = new Node(key, course);
			return root;
		}

		/* Otherwise, recur down the tree */
		if (key < root.key)
			root.left = insertRec(root.left, key, course);
		else if (key > root.key)
			root.right = insertRec(root.right, key, course);

		/* return the (unchanged) node pointer */
		return root;
	}

	public Node search(Node root, int key) {
		// Base Cases: root is null or key is present at root
		if (root == null || root.key == key)
			return root;

		// val is greater than root's key
		if (root.key > key)
			return search(root.left, key);

		// val is less than root's key
		return search(root.right, key);
	}

	// This method mainly calls InorderRec()
	public void inorder_Traversal() {

		inorderRec1(node_origin);
		inorderRec2(backup_Node_1);
		inorderRec3(backup_Node_2);

	}

	// A utility function to do inorder traversal of BST

	void inorderRec1(Node root) {
		if (root != null) {
			inorderRec1(root.left);
			String t = String.valueOf(root);
			Results.result_origin.add(t);
			inorderRec1(root.right);
		}
	}

	void inorderRec2(Node root) {
		if (root != null) {
			inorderRec2(root.left);
			String t = String.valueOf(root);
			Results.result_node1.add(t);
			inorderRec2(root.right);
		}
	}

	void inorderRec3(Node root) {
		if (root != null) {
			inorderRec3(root.left);
			String t = String.valueOf(root);
			Results.result_node2.add(t);
			inorderRec3(root.right);
		}
	}

}
