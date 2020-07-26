package fazluljaony;

public class MorningTeacher implements Teacher {
	
	private Student student;

	public MorningTeacher(Student student) {
		this.student = student;
	}

	@Override
	public String getTeacherName() {
		
		return "Name is abdul hamid";
	}

	@Override
	public String getTeacherPhoneNo() {
		
		return "Phone no is 01944350970";
	}

	@Override
	public String getStudentName() {
		
		return student.StudentName();
	}

	@Override
	public String getStudentAttnd() {
		
		return student.attendence();
	}


}


