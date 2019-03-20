package SL;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	
	ArrayList<User> users = new ArrayList<>();
	Scanner in = new Scanner(System.in);
	
	private void populateUser() {
		Teacher teacherA = new Teacher("Teacher A", "Science", "123456", "teacherA");
		users.add(teacherA);
		Teacher teacherB = new Teacher("Teacher B", "Math", "123456", "teacherB");
		users.add(teacherB);
		Student studentA = new Student("Student A", "123456", "studentA");
		users.add(studentA);
		teacherA.addStudent(studentA);
		teacherB.addStudent(studentA);
	}
	
	private User login() {
		in.nextLine();
		boolean valid = true;
		String username = null;
		String password = null;
		do {
			try {
				valid = true;
				System.out.print("Enter Your Username : ");
				username = in.nextLine();
			}
			catch (Exception e) {
				in.nextLine();
				valid = false;
			}
		}while (valid == false);
		do {
			try {
				valid = true;
				System.out.print("Password : ");
				password = in.nextLine();
			}
			catch (Exception e) {
				in.nextLine();
				valid = false;
			}
		}while (valid == false);
		boolean found = false;
		for(User user : users) {
			found = user.Compare(username, password);
			if (found == true) {
				return user;
			}
		}
		if(found == false) System.out.println("User not found or password is incorrect");
		return null;
	}
	private void Service(Teacher teacher) {
		teacher.teacherService();
	}
	
	private void Service(Student student) {
		student.StudentService();
	}
	
	private void Activity() {
		User loggedIn = login();
		if (loggedIn instanceof Teacher) {
			Service((Teacher)loggedIn);
		}
		else if (loggedIn instanceof Student) {
			Service((Student)loggedIn);
		}
	}

	public Main() {
		populateUser();
		for(User user : users) {
			System.out.println(user.toString());
		}
		int choice = 0;
		do {
			
			boolean valid = true;
			do {
				try {
					valid = true;
					System.out.println("1. Login\n2. Exit");
					choice = in.nextInt();
				}
				catch (Exception e) {
					in.nextLine();
					valid = false;
				}
			}while (valid == false);
			if(choice == 1) {
				Activity();
			}
		}while (choice != 2);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Main();
	}

}
