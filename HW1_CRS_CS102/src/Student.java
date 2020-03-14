import java.io.Serializable;
import java.util.Scanner;

public class Student extends User implements StudentInterface,Serializable {

	
	//METHOD DEFINITIONS
	
	//Constructor
	public Student(String userName, String password, String firstName, String lastName) {
		super(userName, password, firstName, lastName);
	}
	
	
	
	//ToString
	@Override
	public String toString() {
		return "[userName=" + userName + ", password=" + password + ", firstName=" + firstName + ", lastName="
				+ lastName + "]";
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
	public void viewOpenCourses() {
		for (int i = 0; i < Data.getCourses().size(); i++) { 
			if (Data.getCourses().get(i).getMaxStudents() > Data.getCourses().get(i).getNumOfStudents()) {
				System.out.printf("\n Course: %43s     ID: %s  Instructor: %25s  Section #: %d     Location:  %s",
									Data.getCourses().get(i).getName(), Data.getCourses().get(i).getId(),Data.getCourses().get(i).getCourseInstructor(),
									Data.getCourses().get(i).getSectionNum(),Data.getCourses().get(i).getLocation());
			}
		}
	}

	
	
	@Override
	public void registerCourse() {
		Scanner input = new Scanner(System.in);
		System.out.println("Which course would you like to register in? (enter Name): ");
		String name = input.nextLine();
		System.out.println("Which section would you like to register in? (enter number): ");
		int sec = input.nextInt();
		for (int i = 0; i < Data.getCourses().size(); i++) {   
		    if (Data.getCourses().get(i).getName().equals(name) && (Data.getCourses().get(i).getSectionNum()==sec)) {
		    	if (Data.getCourses().get(i).getMaxStudents() > Data.getCourses().get(i).getNumOfStudents()) {
		    			Data.getCourses().get(i).addStudent(this);
		    			System.out.println("Student has been added");
		    			return;
		    		} else {
		    			System.out.println("Course is full");
		    			return;
		    	}
		    }
		}
		System.out.println("Course Not Found");
	}

	
	@Override
	public void withdrawCourse() {
		Scanner input = new Scanner(System.in);
		System.out.println("Which course would you like to remove? (enter Name): ");
		String course = input.nextLine();
		System.out.println("What is section number of the course? (enter number): ");
		int sec = input.nextInt();
		
		for (int i = 0; i < Data.getCourses().size(); i++) {   
		    if (Data.getCourses().get(i).getName().equals(course) && (Data.getCourses().get(i).getSectionNum()==sec)) { 
		    		Data.getCourses().get(i).removeStudent(this);
	    			System.out.println("Student has been removed");
	    			return;
	    		} else {
	    			System.out.println("Course not found");
	    			return;
		    	}
		}
		System.out.println("Student is not in the course");
	}

	

	
	@Override
	public void viewRegisteredCourses() {
		System.out.println("You are registered in: \n");
		for (int j=0; j < Data.getCourses().size(); j++ ) {
			for (int k=0; k < Data.getCourses().get(j).getStudents().size(); k++ ) {
				if (Data.getCourses().get(j).getStudents().get(k).getUserName().contentEquals(this.getUserName())) {
					System.out.println(Data.getCourses().get(j).getName());
				}
			}
		}
	}
	
	
		
}

	
	
	


