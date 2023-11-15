package Lab9_task1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Course {
	private String id;
	private String title;
	private String type;
	private String lecturer;
	private List<Student> students;

	public Course(String id, String title, String type, String lecturer, List<Student> students) {
		super();
		this.id = id;
		this.title = title;
		this.type = type;
		this.lecturer = lecturer;
		this.students = students;
	}

	@Override
	public String toString() {
		return "Course [id=" + id +  ", type=" + type ;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

}
