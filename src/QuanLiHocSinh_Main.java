import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.Scanner;

public class QuanLiHocSinh_Main {

	
	public static void main(String[] args) throws IOException {
		
		CStudentManagement CSManagement = new CStudentManagement();

		int nChoose = -1;
		
		BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in, "utf8"));
		
		do {
			System.out.println("Chon tinh nang:");
			System.out.println("1. Them hoc sinh.");
			System.out.println("2. Cap nhat thong tin hoc sinh.");
			System.out.println("3. Xoa hoc sinh.");
			System.out.println("4. Xem danh sach hoc sinh theo ma hoc sinh tang dan.");
			System.out.println("5. Xem danh sach hoc sinh theo ma hoc sinh giam dan.");
			System.out.println("6. Xem danh sach hoc sinh theo diem tang dan.");
			System.out.println("7. Xem danh sach hoc sinh theo diem giam dan.");
			System.out.println("8. Import file csv.");
			System.out.println("9. Export file csv.");
			System.out.println("0. Thoat.");
			System.out.print("Lua chon: ");
			
			nChoose = Integer.parseInt(br.readLine());
			
			System.out.println("============================================");;
			
			if (nChoose == 0)
			{
				return; 
			}
			
			CStudent newStudent;
			
			switch(nChoose)
			{
			case 1:
				newStudent = new CStudent();
				
				newStudent.add();
				
				boolean bRes = CSManagement.addNewStudent(newStudent);
				
				if (bRes == true)
				{
					System.out.println(">_ Them hoc sinh thanh cong!");
				}
				else
				{
					System.out.println(">_ Them hoc sinh that bai!");
				}
				break;
			case 2:
				System.out.print("Nhap ma hoc sinh can sua: ");
				int id2 = Integer.parseInt(br.readLine());
				
				// kiem tra hoc sinh co ton tai hay khong
				CStudent temp2 = CSManagement.getStudentById(id2);
				
				if (temp2.get_ID() == -1)
				{
					System.out.println(">_ Khong ton tai hoc sinh co ma so" + id2 + " !");
				}
				else
				{
					// neu ton tai hoc sinh
					// show thong tin hoc sinh va hoi co muon sua hay khong
					temp2.show();
					
					System.out.print("Ban co muon sua thong tin? (Y/N) : ");
					
					String strChoose = br.readLine();
					
					if (strChoose.equals("N") || strChoose.equals("n"))
					{
						break;
					}
					
					// neu nguoi dung muon tiep tuc sua
					newStudent = new CStudent();
					
					newStudent.add();
					
					boolean bRes2 = CSManagement.updateStudentInfo(newStudent);
					
					if (bRes2 == true)
					{
						System.out.println(">_ Sua hoc sinh thanh cong!");
					}
					else
					{
						System.out.println(">_ Sua hoc sinh that bai!");
					}
				}
				break;
				
			case 3:
				System.out.print("Nhap ma hoc sinh can xoa: ");
				int id3 = Integer.parseInt(br.readLine());
				
				boolean bRes3 = CSManagement.deleteStudentById(id3);
				
				if (bRes3 == true)
				{
					System.out.println(">_ Xoa hoc sinh thanh cong!");
				}
				else
				{
					System.out.println(">_ Xoa hoc sinh that bai!");
				}
				break;
			case 4:
				CSManagement.SortByID(1);
				CSManagement.ShowListStudents();
				break;
			case 5:
				CSManagement.SortByID(0);
				CSManagement.ShowListStudents();
				break;
			case 6:
				CSManagement.SortByScore(1);
				CSManagement.ShowListStudents();
				break;
			case 7:
				CSManagement.SortByScore(0);
				CSManagement.ShowListStudents();
				break;
			case 8:	// import csv
				break;
			case 9:	// export csv
				break;
			}
			
			System.out.print("Ban co muon tiep tuc? (Y/N) : ");
			String strChoose = br.readLine();
			
			if (strChoose.equals("N") || strChoose.equals("n"))
			{
				break;
			}
		}
		while (nChoose != 0);
		
		br.close();
	}
}
