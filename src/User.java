import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Serializable;

public abstract class User implements Serializable{
	
	//CLASS ATTRIBUTES
	protected String userName;
	
	protected String password;
	
	protected String firstName;
	
	protected String lastName;

	
	
	//METHOD DEFINITIONS
	
	//CONSTRUCTOR
	public User(String userName, String password, String firstName, String lastName) {
		this.userName = userName;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
	
	//METHODS
	
	public void systemExit() {//FINSHHHHsjkdnckjsdncjksdnckjsdncjksnckjsdnckjsdcnsdkjcnsdkjcnsdkj
		try {
			Data.serialize();
			System.out.println("worked");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	

	//GETTERS
	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}
	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}
	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}
	
	//SETTERS
	/**
	 * @param userName the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}
	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	
	
	
	
}
