package HW9;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws IOException {
		Student[] students = new Student[1000000];
		int i = 0;
		
		//BufferedReader - reading the csv file with the given student database
		BufferedReader csvReader = new BufferedReader(new FileReader("src/GlobalUniversityStudentsList.csv"));
		while (i < students.length) {

			String row = csvReader.readLine();

		    String[] rowSplit = row.split(";");

		    students[i] = new Student(Integer.parseInt(rowSplit[0]), rowSplit[1], rowSplit[2], rowSplit[3], 
		    		rowSplit[4], rowSplit[5], Integer.parseInt(rowSplit[6]));
		    i++;
	
		}

		csvReader.close();
		
		BTree<Integer, Student> bst = new BTree<Integer, Student>();
		
		//First part was putting the students with their appropriate information into arrays
		//From that part, the information gathered into arrays is not shifted to the tree
		for (int j = 0; j < students.length; j++) {
			bst.put(students[j].getStudentID(), students[j]);
		}
		
		System.out.println("Welcome! Please enter the ID of the student you require: ");
		Scanner scan = new Scanner(System.in);
		int id = scan.nextInt();
		scan.close();
		Student student = bst.get(id);
		if (student != null) {
			System.out.println("The student you are looking for was found. Here is the result: " + student);
		} else {
			System.out.println("The student with the given ID does not exist");
		}

	}

}