
public interface StudentInterface {
	
	//Displays all courses
	public abstract void viewAllCourses();
	
	//Displays all courses that are not full
	public void viewOpenCourses();

	
	/*Using inputs of course name and section this method will register a 
	 student in a course (name not necessary for efficiency) */
	public void registerCourse();
	
	/*Using inputs of course name,  and 
	 student full name, this method will withdraw a
	 student from a course*/
	public void withdrawCourse();
	
	//Displays all courses that the student is registered in
	public void viewRegisteredCourses();
	
	//Turns off the system and after serializing all objects
	public abstract void systemExit();

	
	
	
	
	
	
	
	
	
	
	

}
