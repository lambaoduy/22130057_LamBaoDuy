package Lab9_task1;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class Faculty {
	private String name;
	private String address;
	private List<Course> listcourse;

	public Faculty(String name, String address, List<Course> listcourse) {
		super();
		this.name = name;
		this.address = address;
		this.listcourse = listcourse;
	}

	public Course getMaxPracticalCourse() {
		Course result = null;
		int max = 0;
		for (Course course2 : listcourse) {
			if (course2.getStudents().size() > max) {
				result = course2;
				max = course2.getStudents().size();
			}
		}
		return result;
	}

	public Map<Integer, List<Student>> groupStudentByYear(){
		Map<Integer, List<Student>> result= new HashMap<Integer, List<Student>>();
		for (Course course : listcourse) {
			List<Student> list = course.getStudents();
			for (Student student : list) {
				if (result.containsKey(student.getYear())) {
					if (!result.get(student.getYear()).contains(student)) {
						result.get(student.getYear()).add(student);						
					}
				} else {
					List<Student> listStu= new ArrayList<Student>();
					listStu.add(student);
					result.put(student.getYear(), listStu);
				}
			}
		}
		return result;
	}

	public Set<Course> filterCourses(String type) {

		Set<Course> result = new TreeSet<Course>(new Comparator<>() {
			@Override
			public int compare(Course o1, Course o2) {
				// TODO Auto-generated method stub
				if (o1.getStudents().size() != o2.getStudents().size()) {
					return o1.getStudents().size() - o2.getStudents().size();

				} else {
					return o1.getId().compareTo(o2.getId());
				}
			}
		});
		for (Course course : listcourse) {
			if (course.getType().equals(type)) {
				result.add(course);
			}
		}
		return result;
	}

	public static void main(String[] args) {
		List<Course> listcourse = new ArrayList<>();
		List<Student> listStudents1 = new ArrayList<>();
		List<Student> listStudents2 = new ArrayList<>();
		Faculty fac = new Faculty("name", "address", listcourse);
		Course course1 = new Course("id1", "title1", "type1", "lecturer1", listStudents1);
		Course course3 = new Course("id6", "title1", "type1", "lecturer1", listStudents1);
		Course course4 = new Course("id3", "title1", "type1", "lecturer1", listStudents2);
		Course course5 = new Course("id4", "title1", "type1", "lecturer1", listStudents2);
		Course course6 = new Course("id5", "title1", "type1", "lecturer1", listStudents2);

		Course course2 = new Course("id2", "title2", "type2", "lecturer2", listStudents2);

		listcourse.add(course1);
		listcourse.add(course2);
//		listcourse.add(course3);
//		listcourse.add(course4);
//		listcourse.add(course5);
//		listcourse.add(course6);

		Student stu1 = new Student("id1", "name1", 2022);
		Student stu2 = new Student("id2", "name2", 2022);
		Student stu3 = new Student("id3", "name3", 2022);
		Student stu4 = new Student("id4", "name4", 2023);
		Student stu5 = new Student("id5", "name5", 2023);

		listStudents1.add(stu1);
		listStudents1.add(stu2);
		listStudents1.add(stu4);
		listStudents1.add(stu3);
		
		listStudents2.add(stu3);
		listStudents2.add(stu4);
		listStudents2.add(stu5);

//		System.out.println(fac.getMaxPracticalCourse().toString());
		System.out.println(fac.groupStudentByYear().toString());
//		System.out.println(fac.filterCourses("type1"));
		
	}
}
