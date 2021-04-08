import java.util.Scanner;

public interface AdminInterface {
	
	
	
	//Creates a new Course
	public abstract void createCourse();
	
	//Deletes a course
	public abstract void deleteCourse();
	
	/*Edit a course (this will allow the admin to edit any information
	on the course except for course ID and name)*/
	public abstract void editCourse();
	
	//Display information for a given course (by course ID)
	public abstract void displayCourse();
	
	/*Allows Admin to register a student */
	public abstract void registerStudent();
	
	
	
	
	
	
	/*Displays all courses (for every course the admin should be able to see the 
	list of enrolled student’s names, enrolled student’s ids, number of students 
	registered, and the maximum number of students allowed to be registered)*/
	public abstract void viewAllCourses();
	
	//Displays all courses that are FULL
	public abstract void viewAllFullCourses();
	
	//Writes all the courses that are full to a file
	public abstract void writeFullCourses();
	
	//Displays the names of the students that are registered in a specific course
	public abstract void viewStudentsOfCourse();
	
	//
	public abstract void viewCoursesOfStudents();
	
	//Sorts the courses based on the current number of students registered
	public abstract void sortCourses();
	
	//Turns off the system and after serializing all objects
	public abstract void systemExit();
	

}
