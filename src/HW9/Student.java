package HW9;

public class Student {
	
	//Here are the variables that we need to work with
	private int studentID;
	private String name;
	private String dateOfBirth;
	private String universityName;
	private String departmentCode;
	private String departmentName;
	private int yearOfEnrolment;
	
	public Student(int studentID, String name, String dateOfBirth, String universityName, String departmentCode,
			String departmentName, int yearOfEnrolment) {
		this.studentID = studentID;
		this.name = name;
		this.dateOfBirth = dateOfBirth;
		this.universityName = universityName;
		this.departmentCode = departmentCode;
		this.departmentName = departmentName;
		this.yearOfEnrolment = yearOfEnrolment;
	}
	
	//This function is for printing the student info inside of the tree
	public String toString() {
		return "Student ID: " + this.studentID + "\n"  + 
				"Name and surname: " + this.name + "\n" + 
				"Date of birth: " + this.dateOfBirth + "\n" + 
				"University:" + this.universityName + "\n" + 
				"Department code: " + this.departmentCode + "\n" + 
				"Department: " + this.departmentName + "\n" +
				"Year of enrolment: " + this.yearOfEnrolment;
	}
	
	//ID used for acquireing keys for the search trees
		public int getStudentID() {
			return studentID;
		}

}