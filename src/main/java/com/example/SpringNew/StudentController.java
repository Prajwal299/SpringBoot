package com.example.SpringNew;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {

	ArrayList<Student> arrayList=new ArrayList();
	
	StudentController(){
		
		Student student1= new Student(1,90);
		Student student2=new Student(2,80);
		arrayList.add(student1);
		arrayList.add(student2);
	}
	@GetMapping("students")
	ArrayList allstudents() {
		return arrayList;
	}
	@GetMapping("students/{rno}")
	public Student getStudent(@PathVariable int rno) {
		
		for (Student student : arrayList) {
			if(student.rno==rno) {
			return student;	
			}
		}
		return null;
		
	}
	
	@PostMapping("student")
	public ArrayList<Student> addStudent(@RequestBody Student student)
	{
		arrayList.add(student);
		return arrayList;
		
	}
	
	
	@DeleteMapping("students/{rno}")
	public String  deleteStudent(@PathVariable int rno) 
	{
		
		for (Student student : arrayList) {
			if(student.rno==rno) {
				arrayList.remove(student);
			}
		}
		return "Record Deleted";
		
	}
	
	@PutMapping("student")
	public ArrayList updateStudent(@RequestBody Student clientstudent) {
		
	for (Student student : arrayList) {
		if(student.rno==clientstudent.rno) {
			student.setMarks(clientstudent.getMarks());
			
		}
	}
		return arrayList;
	}
	
	
}
