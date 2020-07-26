package fazluljonymvc;

import javax.validation.constraints.Max; 
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import fazluljonymvc.validation.CourseCode;


public class Customer {
	
	private String firstName;
	
	@NotNull(message="Is required")
	@Size(min =2,message="Is required")
	private String lastName;
	
	@NotNull(message="Is required")
	@Min(value=1, message="Must be greater than or equal to zero" )
	@Max(value=10, message="Must be breater than or equal to 10" )
	private Integer freePasses;
	
	@CourseCode
	private String courseCode;
	
	
	public String getCourseCode() {
		return courseCode;
	}

	public void setCourseCode(String courseCode) {
		this.courseCode = courseCode;
	}

	@Pattern(regexp="^[a-zA-Z0-9]{4}", message="Only 4 charecter/digits" )
	private String postalCode;
	
	
	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getFirstName() {
		return firstName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Integer getFreePasses() {
		return freePasses;
	}

	public void setFreePasses(Integer freePasses) {
		this.freePasses = freePasses;
	}
	
	
	

}
