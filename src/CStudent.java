import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.Scanner;

public class CStudent {
	private int _ID;
	private String _Name;
	private float _Score;
	private String _Image;
	private String _Addr;
	private String _Note;
	
//	Phương thức khởi tạo
	
	public CStudent()
	{
		// default constructor
		this._ID = -1;
	}
	public CStudent(int id, String name, float score, String image, String addr, 
			String note) 
	{
		this._ID = id;
		this._Name = name;
		this._Score = score;
		this._Image = image;
		this._Addr = addr;
		this._Note = note;
	}
	
	
//	getter setter
	public int get_ID() {
		return _ID;
	}
	public void set_ID(int _ID) {
		this._ID = _ID;
	}
	public String get_Name() {
		return _Name;
	}
	public void set_Name(String _Name) {
		this._Name = _Name;
	}
	public float get_Score() {
		return _Score;
	}
	public void set_Score(float _Score) {
		this._Score = _Score;
	}
	public String get_Image() {
		return _Image;
	}
	public void set_Image(String _Image) {
		this._Image = _Image;
	}
	public String get_Addr() {
		return _Addr;
	}
	public void set_Addr(String _Addr) {
		this._Addr = _Addr;
	}
	public String get_Note() {
		return _Note;
	}
	public void set_Note(String _Note) {
		this._Note = _Note;
	}
	
	
	public CStudent clone()
	{
		CStudent res = new CStudent(this._ID, this._Name, this._Score, 
				this._Image, this._Addr, this._Note);
		
		return res;
	}
	
	public void update(CStudent source)
	{
		this._ID = source._ID;
		this._Name = source._Name;
		this._Score = source._Score;
		this._Image = source._Image;
		this._Addr = source._Addr;
		this._Note = source._Note;
	}
	
	public void show()
	{
		System.out.println("Ma hoc sinh\t: " + this._ID);
		System.out.println("Ten hoc sinh\t: " + this._Name);
		System.out.println("Diem\t\t: " + this._Score);
		System.out.println("Hinh anh\t: " + this._Image);
		System.out.println("Dia chi\t\t: " + this._Addr);
		System.out.println("Ghi chu\t\t: " + this._Note);
	}
	
	public void add() throws NumberFormatException, IOException
	{
		BufferedReader br1 = new BufferedReader(
                new InputStreamReader(System.in, "utf8"));
		
		System.out.println("Nhap thong tin hoc sinh:");
		
		System.out.print("Ma hoc sinh: ");
		this.set_ID(Integer.parseInt(br1.readLine()));
		
		System.out.print("Ten hoc sinh: ");
		this.set_Name(br1.readLine());	
		
		System.out.print("Diem: ");
		this.set_Score(Float.parseFloat(br1.readLine()));	
		
		System.out.print("Hinh anh: ");
		this.set_Image(br1.readLine());
		
		System.out.print("Dia chi: ");
		this.set_Addr(br1.readLine());
		
		System.out.print("Ghi chu: ");
		this.set_Note(br1.readLine());
		
//		br1.close();
	}
}
