package SL;

import java.util.ArrayList;
import java.util.Scanner;

public class Student extends User {
	
	private ArrayList<Subject> subjects = new ArrayList<>();
	Scanner in = new Scanner(System.in);

	public Student(String name, String password, String username) {
		super(name, password, username);
		subjects.add(new Subject("Math"));
		subjects.add(new Subject("Science"));
	}

	public Student() {
		// TODO Auto-generated constructor stub
	}
	
	public void StudentService() {
		System.out.println("Choose which subjects you want to see details");
		int i = 1;
		for(Subject subject : subjects) {
			System.out.printf("%d | %s \n", i++, subject.getName());
		}
		int choice = 0;
		boolean valid = true;
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
		subjects.get(choice-1).Print();
	}
	
	public void AddScore(String teaching) {
		Subject subjectToBeAdded = null;
		for(Subject subject : subjects) {
			if(subject.getName().equals(teaching)) {
				subjectToBeAdded = subject;
				break;
			}
		}
		System.out.println("1. Assignment Score\n2. Exam Score");
		int opr = 0;
		boolean valid = true;
		do {
			try {
				valid = true;
				System.out.print(">>");
				opr = in.nextInt();
				if(opr>2||opr<1) valid = false;
			}
			catch (Exception e) {
				in.nextLine();
				valid = false;
			}
		}while (valid == false);
		valid = true;
		int score = 0;
		do {
			try {
				valid = true;
				System.out.print("Score : ");
				score = in.nextInt();
				if(score>100||score<0) valid = false;
			}
			catch (Exception e) {
				in.nextLine();
				valid = false;
			}
		}while (valid == false);
		if(opr == 1) {
			subjectToBeAdded.AddAssignmentScore(score);
		}
		else if (opr == 2) {
			subjectToBeAdded.AddExamScore(score);
		}
	}

}
