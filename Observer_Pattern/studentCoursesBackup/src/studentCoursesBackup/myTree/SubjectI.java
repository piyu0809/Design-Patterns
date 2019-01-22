package studentCoursesBackup.myTree;

public interface SubjectI {
	
	public enum Operation {
	    delete 
	}
public void Register(Node n);
public void Unregister(Node n);
public void notifyAllObs(int key,String course,Operation e);
}
