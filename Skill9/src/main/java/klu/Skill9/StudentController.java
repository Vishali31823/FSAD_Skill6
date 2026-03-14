package klu.Skill9;
	import org.springframework.web.bind.annotation.*;

	import java.util.ArrayList;
	import java.util.List;

	@RestController
	public class StudentController {

	    List<Student> students = new ArrayList<>();

	    public StudentController() {
	        students.add(new Student(1, "Ravi", "CSE"));
	        students.add(new Student(2, "Anjali", "ECE"));
	        students.add(new Student(3, "Rahul", "IT"));
	    }

	    @GetMapping("/student/{id}")
	    public Student getStudent(@PathVariable String id) {

	        int studentId;

	        try {
	            studentId = Integer.parseInt(id);
	        } catch (NumberFormatException e) {
	            throw new InvalidInputException("Student ID must be a number");
	        }

	        return students.stream()
	                .filter(s -> s.getId() == studentId)
	                .findFirst()
	                .orElseThrow(() ->
	                        new StudentNotFoundException("Student not found with id: " + studentId)
	                );
	    }

}
