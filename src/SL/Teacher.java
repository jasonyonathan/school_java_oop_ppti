package SL;

import java.util.ArrayList;
import java.util.Scanner;

public class Teacher extends User {
	
	private ArrayList<Student> students = new ArrayList<>();
	private String subject;
	Scanner in = new Scanner(System.in);

	public Teacher(String name, String subject, String password, String username) {
		super(name, password, username);
		this.subject = subject;
	}

	public Teacher() {
		// TODO Auto-generated constructor stub
	}
	
	public void addStudent(Student student) {
		students.add(student);
	}
	
	public void teacherService() {
		System.out.println("Choose Student");
		int i = 1;
		for(Student student : students) {
			System.out.printf("%d | %s \n", i++, student.getName());
		}
		boolean valid = true;
		int choice = 0;
		do {
			try {
				valid = true;
				choice = in.nextInt();
				if(choice>i-1) valid = false;
			}
			catch (Exception e) {
				in.nextLine();
				valid = false;
			}
		}while (valid == false);
		students.get(choice-1).AddScore(this.subject);
	}

}
