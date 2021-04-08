import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class Data  {
	
	//arraylist holding course registry
	private static ArrayList<Course> courses = new ArrayList<Course>();
	//arraylist holding student registry
	private static ArrayList<Student> allstudents = new ArrayList<Student>();
	
	
	
	
	

	public static ArrayList<Course> getCourses() {
		return courses;
	}
	
	public static ArrayList<Student> getAllstudents() {
		return allstudents;
	}

	public static void setCourses(ArrayList<Course> courses) {
		Data.courses = courses;
	}

	public static void setAllstudents(ArrayList<Student> allstudents) {
		Data.allstudents = allstudents;
	}
	
	//class which serializes classes and students
	public static void serialize() throws FileNotFoundException, IOException {
		
		 try{
	         FileOutputStream fosCourses= new FileOutputStream("courses.ser");
	         ObjectOutputStream oosCourses= new ObjectOutputStream(fosCourses);
	         oosCourses.writeObject(courses);
	         oosCourses.close();
	         fosCourses.close();
	         System.out.println("Courses Saved");
	         
	         FileOutputStream fosStudents= new FileOutputStream("students.ser");
	         ObjectOutputStream oosStudents= new ObjectOutputStream(fosStudents);
	         oosStudents.writeObject(allstudents);
	         oosStudents.close();
	         fosStudents.close();
	         System.out.println("Students Saved");
	         
	         System.out.println("Serialization Complete");
	       }catch(IOException ioe){
	            ioe.printStackTrace();
	        }
	}
	
	//class which deserializes classes and students
	@SuppressWarnings("unchecked")
	public static void deserialize() throws IOException, ClassNotFoundException {
	
            FileInputStream fisCourses = new FileInputStream("courses.ser");
            ObjectInputStream oisCourses = new ObjectInputStream(fisCourses);
            courses = (ArrayList<Course>) oisCourses.readObject();
            fisCourses.close();
            oisCourses.close();
            
            FileInputStream fisStudents = new FileInputStream("students.ser");
            ObjectInputStream oisStudents = new ObjectInputStream(fisStudents);
            allstudents = (ArrayList<Student>) oisStudents.readObject();
            fisStudents.close();
            oisStudents.close();
	}
		
		
	
	
	
	

}
