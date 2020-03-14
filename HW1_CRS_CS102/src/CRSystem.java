import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class CRSystem {
	
	//this method allows access to the two main menus
	public static void adminSystem(Admin firstAdmin, Scanner input) {
		
		boolean continueRunning = true;
		while (continueRunning) {
			System.out.println("____________________________________________________________________");
			System.out.println("\n\tMAIN MENU\n\n\t1.COURSE MANAGEMENT\n\t2.REPORTS\n\t3.SYSTEM OFF");
			System.out.println("\n\nInput corresponding number to access:\n ");
			int choice = input.nextInt();
			input.nextLine();
			if (choice == 1) {
				courseManagementMenu(firstAdmin,input);
			}
			else if (choice == 2) {
				reportsMenu(firstAdmin,input);
			}
			else if (choice == 3) {
				continueRunning = false;
				firstAdmin.systemExit(); 
			} else System.out.println("Invalid Input, Try Again");
		}
	}
	
	//this method allows access to course management menus
	public static void courseManagementMenu(Admin firstAdmin,Scanner input) {
		boolean continueMenu = true;
		int choice;
		while (continueMenu) {
			System.out.println("\n____________________________________________________________________");
			System.out.println("\n\tCOURSE MANAGEMENT\n\n1.Create A Course\n2.Delete A Course\n3.Edit A Course\n"
					+ "4.Display A Course\n5.Register a Student\n6.Exit ");
			System.out.println("\nEnter the corresponding number for the selected option: ");
			choice = input.nextInt();
			if (choice == 1) {
				firstAdmin.createCourse();
				}
			else if (choice == 2) {
				firstAdmin.deleteCourse();
				}
			else if (choice == 3 ) {
				firstAdmin.editCourse();
				}
			else if (choice == 4) {
				firstAdmin.displayCourse();
				}
			else if (choice == 5) {
				firstAdmin.registerStudent();
				}
			else if (choice == 6 ) {
				continueMenu = false;
				}
			else { System.out.println("Invalid Input, Try Again");
			}
		}
	}
	
	//this method allows access to report menus
	public static void reportsMenu(Admin firstAdmin,Scanner input) {
		boolean continueMenu = true;
		while (continueMenu) {
			System.out.println("\n____________________________________________________________________");
			System.out.println("\n\tREPORTS MENU\n\n1.View all Courses\n2.View all Full Courses\n3.Write Courses to a File\n"
					+ "4.View Students in a Course\n5.View Courses of a Student\n"
					+ "6.Sort Courses based on Number of Students\n7.Exit Report Menu ");
			System.out.println("Enter the corresponding number for the selected option: ");
			int choice = input.nextInt();
			if (choice == 1) {
				firstAdmin.viewAllCourses();
				}
			else if (choice == 2) {
				firstAdmin.viewAllFullCourses();
				}
			else if (choice == 3 ) {
				firstAdmin.writeFullCourses();
				}
			else if (choice == 4) {
				firstAdmin.viewStudentsOfCourse();
				}
			else if (choice == 5) {
				firstAdmin.viewCoursesOfStudents();
				}
			else if (choice == 6 ) {
				firstAdmin.sortCourses();
				}
			else if (choice == 7 ) {
				continueMenu = false;
				}
			else { System.out.println("Invalid Input, Try Again");
			}
		}
	}
	
	
	
	//This method allows access to all student methods
	public static void StudentSystem(Student student,Scanner input) {
		
		boolean continueRunning = true;
		while (continueRunning) {
			System.out.println("\n____________________________________________________________________");
			System.out.println("\n\tSTUDENT MENU\n\n1.View All Courses\n2.View Open Courses\n3.Register For Course\n"
					+ "4.Withdraw From A Course\n5.View Registered Courses\n6.System Off");
			System.out.println("Enter the corresponding number for the selected option: ");
			int choice = input.nextInt();
			switch(choice) {
			case 1:
				student.viewAllCourses();
				break;
			case 2:
				student.viewOpenCourses();
				break;
			case 3:
				student.registerCourse();
				break;
			case 4:
				student.withdrawCourse();
				break;
			case 5:
				student.viewRegisteredCourses();
				break;
			case 6:
				student.systemExit(); 
				return;
			default:
				System.out.println("Invalid Input, Try Again");
			}
		}
	}
	


	public static void main(String[] args) throws IOException {
		
		
		/*Some helper code for printing out all courses:
		 * for(int i = 0; i < Data.getCourses().size(); i++) {   
	     *		System.out.print("\n"+Data.getCourses().get(i));}
		 */
		
		
		
		//VARIABLES
		
		//Flag for while loop for system
		boolean systemOn = true;
		Scanner input = new Scanner(System.in);
		
		//CHECKS IF THERE ARE PREVIOSLY SERIALIZED COURSE AND STUDENT FILES
		try { 
			Data.deserialize();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException ioe) { //IF NO EXISTING BYTE CODE
			
			//CREATES COURSE OBJECTS FROM CSV FILE
			System.out.println("Starting New Program...");
			//initialize variables
			//a counter for the number of courses created in the CSV file including the header
			int rowCount = 0; 
			String row;
			//This will input the current CSV File full of courses and create and append courses to the arraylist
			BufferedReader csvReader = new BufferedReader(new FileReader("MyUniversityCourses.csv"));
			while ((row = csvReader.readLine()) != null) {
				if (rowCount > 0) {
					String[] line = row.split(",");
					String name = line[0];
					String id = line[1];
					int maxStudents = Integer.parseInt(line[2]);
					int numOfStudents = Integer.parseInt(line[3]);
					//List of names will be empty for a new course so null value passed
					//ArrayList<Student> students = null;
					String courseInstructor = line[5];
					int sectionNum = Integer.parseInt(line[6]);
					String location = line[7];
					Course newCourse = new Course(name, id, maxStudents, numOfStudents, courseInstructor, sectionNum, location);
					Data.getCourses().add(newCourse);
				}
				rowCount++;
			}
			csvReader.close();
		} 
		
		
		//Creates Initial Administrator User
		Admin firstAdmin = new Admin("Admin","Admin001","Default" ,"Default" );
		
		//Initiates User Controls
		while (systemOn) {
			System.out.println("Enter Username: ");
			String username = input.nextLine();
			System.out.println("Enter Password: ");
			String password = input.nextLine();
			if (username.equals("Admin") && password.equals("Admin001")) {
			adminSystem(firstAdmin,input);
			systemOn = false;
			break;
		    }
		    for (int i =0; i <Data.getAllstudents().size(); i++) {
		    	System.out.println(i);
		    	if ((username.equals(Data.getAllstudents().get(i).getUserName()) && (password.equals(Data.getAllstudents().get(i).getPassword())))) {
				StudentSystem(Data.getAllstudents().get(i),input);
				systemOn = false;
				break;
		    	}
		    }
		}

		input.close();
		System.out.println("System has been shut down.");
	}
}

