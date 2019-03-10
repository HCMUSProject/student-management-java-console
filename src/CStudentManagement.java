import java.util.Collections;
import java.util.Comparator;
import java.util.Vector;

public class CStudentManagement {
	private Vector<CStudent> _listStudent;
	
	// phuong thuc khoi tao
	public CStudentManagement()
	{
		this._listStudent = new Vector<CStudent>();
	}
	
//	lay danh sach cac hoc sinh
	public Vector<CStudent> getListStudents()
	{
		Vector<CStudent> clone = new Vector<CStudent>(this._listStudent);
		
		return clone;
	}
	
	public boolean ShowStudentById(int id)
	{
		int idx = this.getIndexOfStudentById(id);
		System.out.println();
		if (idx == -1)
		{
			System.out.println(">_ Khong ton tai sinh vien co ma so " + id + " !");
			return false;
		}
		else
		{
			this._listStudent.elementAt(idx).show();
			return true;
		}
	}
	
	public void ShowListStudents()
	{
		for (int i = 0; i < this._listStudent.size(); i++)
		{
			System.out.println("[+] Hoc sinh thu " + (i + 1) + " :");
			this._listStudent.elementAt(i).show();
		}
	}
	
//	lay vi tri cua hoc sinh trong mang
//	neu ton tai hoc sinh thi tra ve index cua no
//	nguoc lai tra ve -1
	public int getIndexOfStudentById(int id)
	{
		for (int i = 0; i < this._listStudent.size(); i++)
		{
			if (this._listStudent.elementAt(i).get_ID() == id)
			{
				return i;
			}
		}
		return -1;
	}
	
//	lay thong tin hoc sinh bang id
	public CStudent getStudentById(int id)
	{
		CStudent res;
		
		int idx = this.getIndexOfStudentById(id);
		
		if (idx == -1)
		{
			res = new CStudent();
		}
		else
		{
			res = this._listStudent.elementAt(idx).clone();
		}
		
		return res;
	}
	
//	them hoc sinh moi
	public boolean addNewStudent(CStudent newStudent)
	{
		// neu sinh vien co ma so nay ton tai thi return false
		if (this.getIndexOfStudentById(newStudent.get_ID()) != -1)
		{
			return false;
		}
		
		this._listStudent.add(newStudent);
		
		return true;
	}
	
	public boolean updateStudentInfo(CStudent editStudent)
	{
		// neu khong ton tai ma so nay thi return false
		int idx = this.getIndexOfStudentById(editStudent.get_ID());
		if (idx == -1)
		{
			return false;
		}
		
		// nguoc lai thi update		
		this._listStudent.elementAt(idx).update(editStudent);
		
		return true;
	}

	public boolean deleteStudentById(int id)
	{
		// kiem tra hoc sinh co ton tai hay khong
		int idx = this.getIndexOfStudentById(id);
		
		// neu ton tai
		if (idx != -1)
		{
			this._listStudent.remove(idx);
			return true;
		}
		
		return false;
	}

	public void SortByID(int type)
	{
		if (type == 1)	// type = 1 : tang dan. nguoc lai la giam dan
		{
			this._listStudent.sort(new Comparator<CStudent>() {

				@Override
				public int compare(CStudent o1, CStudent o2) {
					// TODO Auto-generated method stub
					return String.valueOf(o1.get_ID()).compareTo(String.valueOf(o2.get_ID()));
				}
				
			});
		}
		else
		{
			this._listStudent.sort(new Comparator<CStudent>() {

				@Override
				public int compare(CStudent o1, CStudent o2) {
					// TODO Auto-generated method stub
					return String.valueOf(o2.get_ID()).compareTo(String.valueOf(o1.get_ID()));
				}
				
			});
		}
	}
	
	public void SortByScore(int type)
	{
		if (type == 1)
		{
			this._listStudent.sort(new Comparator<CStudent>() {

				@Override
				public int compare(CStudent o1, CStudent o2) {
					// TODO Auto-generated method stub
					return String.valueOf(o1.get_Score()).compareTo(String.valueOf(o2.get_Score()));
				}
				
			});
		}
		else
		{
			this._listStudent.sort(new Comparator<CStudent>() {

				@Override
				public int compare(CStudent o1, CStudent o2) {
					// TODO Auto-generated method stub
					return String.valueOf(o2.get_Score()).compareTo(String.valueOf(o1.get_Score()));
				}
				
			});
		}
	}
}