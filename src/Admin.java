import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Collections;
import java.util.Scanner;

public class Admin extends User implements AdminInterface {
	
	//METHOD DEFINITIONS
	
	//CONSTRUCTOR
	public Admin(String userName, String password, String firstName, String lastName) {
		super(userName, password, firstName, lastName);
	}
	
	//ToString method (just used for testing)
	@Override
	public String toString() {
		return "Admin [userName=" + userName + ", password=" + password + ", firstName=" + firstName + ", lastName="
				+ lastName + "]";
	}

	
	@Override
	public void createCourse() {
		Scanner input = new Scanner(System.in);
		System.out.println("Please enter a name for the new Course:");
		String name = input.nextLine();
		System.out.println("Please enter an ID for the new Course:");
		String id = input.nextLine();
		System.out.println("Please enter the maximum number of students for the new Course:");
		int maxStudents = input.nextInt();
		input.nextLine();
		System.out.println("Please enter the name of the Instructor for the new Course:");
		String courseInstructor = input.nextLine();
		System.out.println("Please enter the section number for the new Course:");
		int sectionNum = input.nextInt();
		input.nextLine();
		System.out.println("Please enter the location for the new Course:");
		String location = input.nextLine();
		//The number of students in the course are empty when first created
		int numOfStudents = 0;
		for (int i = 0; i < Data.getCourses().size(); i++) {   
		    if ((Data.getCourses().get(i).getId().equals(id)) || (Data.getCourses().get(i).getName().contentEquals(name))){
		    	System.out.println("This course has already been added");
		    	return;
		    }
		} 
		Course newCourse = new Course(name,id,maxStudents, numOfStudents, courseInstructor, sectionNum, location);
		Data.getCourses().add(newCourse); 
		System.out.println(name + " has been created!");
		
	}
	
	
	@Override
	public void deleteCourse() {
		Scanner input = new Scanner(System.in);
		System.out.println("Please enter the Course name to delete a course:");
		String answer = input.nextLine();
		;
		for (int i = 0; i < Data.getCourses().size(); i++) {   
		    if ((Data.getCourses().get(i).getName().equals(answer))){
		    	Data.getCourses().remove(i); 
		    	System.out.println("The course has been deleted");
		    	return;
		    }
		} 
		System.out.println("The course was not found");
	}

	@Override
	public void editCourse() {
		int index = -1;
		Scanner input = new Scanner(System.in);
		System.out.println("Please enter the Course name to edit a course:");
		String course = input.nextLine();
		for (int i = 0; i < Data.getCourses().size();i++) {
			if (Data.getCourses().get(i).getName().equals(course)) {
				index = i;
			}
		}
		if (index == -1) {
			System.out.println("Course was not found");
			return;
		}
		System.out.println("\n1.Maximum Students\n2.Current Students\n3.Instructor\n4.Section Number\n5.Location");
		System.out.println("Enter the corresponding number for what you would like to edit: "); 
		int choice = input.nextInt();
		input.nextLine();
		if (choice == 1) { //Max Students
			System.out.println("Enter the new maximum number of students: ");
			int newMax = input.nextInt();
			Data.getCourses().get(index).setMaxStudents(newMax);
			System.out.println("Edit has been completed");
			
		}
		else if (choice == 2) {//Current Students
			System.out.println("Enter the new current number of students: ");
			int newCurrent = input.nextInt();
			if (Data.getCourses().get(index).getMaxStudents() == Data.getCourses().get(index).getNumOfStudents()) {
				Data.getCourses().get(index).setNumOfStudents(Data.getCourses().get(index).getMaxStudents()+1);
			}
			Data.getCourses().get(index).setNumOfStudents(newCurrent);
			System.out.println("Edit has been completed");
			
		}
		else if (choice == 3) { //Instructor
			System.out.println("Enter the name of the new instructor: ");
			String newTeacher = input.nextLine();
			Data.getCourses().get(index).setCourseInstructor(newTeacher);
			System.out.println("Edit has been completed");
			
		}
		else if (choice == 4) {//Section Number
			System.out.println("Enter the name of the updated section number: ");
			int newSecNum = input.nextInt();
			Data.getCourses().get(index).setSectionNum(newSecNum);
			System.out.println("Edit has been completed");
			
		}
		else if (choice == 5) {//Location
			System.out.println("Enter the name of the new location: ");
			String location = input.nextLine();
			Data.getCourses().get(index).setCourseInstructor(location);
			System.out.println("Edit has been completed");
			
		} else { System.out.println("Invalid input"); }
	}
	

	@Override
	public void displayCourse() {
		Scanner input = new Scanner(System.in);
		System.out.println("Please enter the Course Name: ");
		String name = input.nextLine();
		System.out.println("Please enter the Course section number to display the Course: ");
		int secNum = input.nextInt();
		for (int i = 0; i < Data.getCourses().size(); i++) {   
		    if (Data.getCourses().get(i).getName().equals(name) && (Data.getCourses().get(i).getSectionNum()==secNum)) {
		    	System.out.println(Data.getCourses().get(i));
		    	return;
		    }
		}
		System.out.println("Course was not found");
	}
	

	@Override
	public void registerStudent() {
		Scanner input = new Scanner(System.in);
		System.out.println("Please enter the First Name of the student: ");
		String firstName = input.nextLine();
		System.out.println("Please enter the Last Name of the student: ");
		String lastName = input.nextLine();
		boolean correctCredentials = true;
		while (correctCredentials) {
			System.out.println("Please enter a Username for the student you would like to register: ");
			String username = input.nextLine();
			System.out.println("Please enter a Password for the student you would like to register: ");
			String newPswd = input.nextLine();
			for (int i = 0; i < Data.getAllstudents().size(); i++) {
				if (Data.getAllstudents().get(i).getPassword().equals(password) || Data.getAllstudents().get(i).getUserName().equals(username)) {
					System.out.println("The USERNAME and PASSWORD must be unique for each student/nPlease Try Again.");
					correctCredentials = false;
				}
			}
			if (correctCredentials) {
				Data.getAllstudents().add(new Student(username,newPswd,firstName,lastName));
				break;
			}
		}
		System.out.println("Student has been added");			
	}

	

	@Override
	public void viewAllCourses() {
		for (int i = 0; i < Data.getCourses().size(); i++) {   
			System.out.printf("\n Course: %43s     Max Students: %d     Current # of Students: %d",
								Data.getCourses().get(i).getName(), Data.getCourses().get(i).getMaxStudents(),Data.getCourses().get(i).getNumOfStudents());
			Data.getCourses().get(i).studentsNamesToString();
					
		    }
	}

	@Override
	public void viewAllFullCourses() {
		for (int i = 0; i < Data.getCourses().size(); i++) { 
			if (Data.getCourses().get(i).getMaxStudents() == Data.getCourses().get(i).getNumOfStudents()) {
				System.out.printf("\n Course: %43s     Max Students: %d     Current # of Students: %d",
									Data.getCourses().get(i).getName(), Data.getCourses().get(i).getMaxStudents(),Data.getCourses().get(i).getNumOfStudents());
				Data.getCourses().get(i).studentsNamesToString();
			}
		}
	}

	@Override
	public void writeFullCourses() {
		
		String file = "updatedcourse.csv";
		try {
			FileWriter filewriter = new FileWriter(file);
			BufferedWriter bufferedWriter = new BufferedWriter(filewriter);
			bufferedWriter.write("Course_Name,Course_Id,Maximum_Students,Current_Students,List_Of_Names,"
					+ "Course_Instructor,Course_Section_Number,Course_Location");
			bufferedWriter.newLine();
			for (int i =1; i< Data.getCourses().size(); i++) {
				Course temp = Data.getCourses().get(i);
				bufferedWriter.write(Data.getCourses().get(i).getName() + ", " +
				Data.getCourses().get(i).getId() + ", " +
				Data.getCourses().get(i).getMaxStudents() + ", " +
				Data.getCourses().get(i).getNumOfStudents() + ", " +
				Data.getCourses().get(i).studentsNamesToString() + ", " +
				Data.getCourses().get(i).getCourseInstructor() + ", " +
				Data.getCourses().get(i).getSectionNum() + ", " +
				Data.getCourses().get(i).getLocation());
				bufferedWriter.newLine();
			}
			bufferedWriter.close();
		}	
		catch (IOException e) {
			System.out.println("Error writing file");
			e.printStackTrace();
		}
	}

	@Override
	public void viewStudentsOfCourse() {
		Scanner input = new Scanner(System.in);
		System.out.println("Please enter the Course Name: ");
		String course = input.nextLine();
		System.out.println("Please enter the Course section number: ");
		int secNum = input.nextInt();
		for (int i=0; i < Data.getCourses().size(); i++) {
			if (Data.getCourses().get(i).getName().equals(course) && (Data.getCourses().get(i).getSectionNum()==secNum)) {
				System.out.println(Data.getCourses().get(i).studentsNamesToString());
			}
		}
		;
	}

	@Override
	public void viewCoursesOfStudents() {
		Scanner input = new Scanner(System.in);
		System.out.println("Please enter the username for a student to view his/her courses: ");
		String username = input.nextLine();
		for (int i =0; i < Data.getAllstudents().size(); i++) {
			if (Data.getAllstudents().get(i).getUserName().contentEquals(username)) {
				for (int j=0; j < Data.getCourses().size(); j++ ) {
					for (int k=0; k < Data.getCourses().get(j).getStudents().size(); k++ ) {
						if (Data.getCourses().get(j).getStudents().get(k).getUserName().contentEquals(Data.getAllstudents().get(i).getUserName())) {
							System.out.println(Data.getCourses().get(j).getName());
						}
					}
				}
			}
		}
	}

	
	
	@Override
	public void sortCourses() {
			Collections.sort(Data.getCourses(),Collections.reverseOrder());
	}
	
	
	
	

}
