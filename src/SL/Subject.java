package SL;

import java.util.ArrayList;

public class Subject {
	
	private String name;
	private ArrayList<Integer> assignments = new ArrayList<>();
	private ArrayList<Integer> exams = new ArrayList<>();

	public Subject(String name) {
		super();
		this.name = name;
	}

	public Subject() {
		// TODO Auto-generated constructor stub
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void PrintAssignments() {
		int total = 0;
		int i = 1;
		for(Integer score : assignments) {
			System.out.printf("%d | %d\n", i++, score);
			total+=score;
		}
		System.out.printf("Total Score : %d\n", total);
	}
	
	public void PrintExams() {
		int total = 0;
		int i = 1;
		for(Integer score : exams) {
			System.out.printf("%d | %d\n", i++, score);
			total+=score;
		}
		System.out.printf("Total Score : %d\n", total);
	}
	
	public void PrintFinalScore() {
		int totalAssignments = 0;
		int assignmentsCount = 0;
		int totalExams = 0;
		int examsCount = 0;
		for(Integer score : assignments) {
			totalAssignments += score;
			assignmentsCount++;
		}
		for(Integer score : exams) {
			totalExams += score;
			examsCount++;
		}
		float avgAssignments = (float)totalAssignments/assignmentsCount;
		float avgExams = (float)totalExams/examsCount;
		float finalScore = (float) ((0.6*avgExams)+(0.4*avgAssignments));
		System.out.println("Final Score : " + finalScore);
		
	}
	
	public void Print() {
		System.out.println("Assignments Scores : ");
		PrintAssignments();
		System.out.println("\nExams Scores : ");
		PrintExams();
		System.out.println();
		PrintFinalScore();
	}
	
	public void AddAssignmentScore(int score) {
		assignments.add(score);
	}
	
	public void AddExamScore(int score) {
		exams.add(score);
	}

}
