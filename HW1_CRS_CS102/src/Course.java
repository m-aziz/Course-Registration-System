import java.io.Serializable;
import java.util.ArrayList;

public class Course implements Comparable<Course>,Serializable {
	
	//CLASS ATTRIBUTES
	
	private String name;
	
	private String courseInstructor;
	
	private String id;
	
	private int sectionNum;
	
	private String location;
	
	private int maxStudents;
	
	private int numOfStudents;
	
	private ArrayList<Student> students;

	//METHOD DEFINITIONS
	
	//CONSTRUCTOR
	public Course(String name, String id, int maxStudents, int numOfStudents,
			String courseInstructor, int sectionNum, String location) {
		setName(name);
		setId(id);
		setMaxStudents(maxStudents);
		setNumOfStudents(numOfStudents);
		setStudents(new ArrayList<Student>());
		setCourseInstructor(courseInstructor);
		setSectionNum(sectionNum);
		setLocation(location);
	}
	
	
	//ToString
	@Override
	public String toString() {
		return "Course [name=" + name + ", id=" + id + ", maxStudents=" + maxStudents + ", numOfStudents="
				+ numOfStudents + ", students=" + students + ", courseInstructor=" + courseInstructor + ", sectionNum="
				+ sectionNum + ", location=" + location + "]";
	}
	
	//Student Names only to String
	public String studentsNamesToString() {
		String finalString = "";
		for(Student s : this.students) {
			finalString += s.getFirstName() + " " + s.getLastName() + "; ";
		}
		return finalString;
	}
	
	//Compare To Method based of the number of students
	public int compareTo(Course c) {
		return (this.getNumOfStudents() < c.getNumOfStudents() ? -1 : 
            (this.getNumOfStudents() == c.getNumOfStudents() ? 0 : 1));     
	}
		
	
		
	//SETTERS
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @return the courseInstructor
	 */
	public String getCourseInstructor() {
		return courseInstructor;
	}
	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}
	/**
	 * @return the sectionNum
	 */
	public int getSectionNum() {
		return sectionNum;
	}
	/**
	 * @return the location
	 */
	public String getLocation() {
		return location;
	}
	/**
	 * @return the maxStudents
	 */
	public int getMaxStudents() {
		return maxStudents;
	}
	/**
	 * @return the numOfStudents
	 */
	public int getNumOfStudents() {
		return numOfStudents;
	}
	/**
	 * @return the students
	 */
	public ArrayList<Student> getStudents() {
		return students;
	}
	
	
	
	
	//GETTERS
	
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @param courseInstructor the courseInstructor to set
	 */
	public void setCourseInstructor(String courseInstructor) {
		this.courseInstructor = courseInstructor;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * @param sectionNum the sectionNum to set
	 */
	public void setSectionNum(int sectionNum) {
		this.sectionNum = sectionNum;
	}
	/**
	 * @param location the location to set
	 */
	public void setLocation(String location) {
		this.location = location;
	}
	/**
	 * @param maxStudents the maxStudents to set
	 */
	public void setMaxStudents(int maxStudents) {
		if (maxStudents < 0) this.maxStudents = 0;
		else this.maxStudents = maxStudents;
	}
	/**
	 * @param numOfStudents the numOfStudents to set
	 */
	public void setNumOfStudents(int numOfStudents) {
		if (numOfStudents < 0) numOfStudents = 0;
		else this.numOfStudents = numOfStudents;
		if (numOfStudents > this.maxStudents) {
			this.setMaxStudents(numOfStudents);
		}
	}
	/**
	 * @param students the students to set
	 */
	public void setStudents(ArrayList<Student> students) {
		this.students = students;
	}
	public void addStudent(Student student) {
		this.students.add(student);
		this.numOfStudents += 1;
	}
	
	public void removeStudent(Student student) {
		for (int i=0; i< Data.getAllstudents().size(); i++) {
			if (Data.getAllstudents().get(i).equals(student)) {
				this.students.remove(i);
				this.numOfStudents -= 1;
			}
		}
		
	}


	

}
