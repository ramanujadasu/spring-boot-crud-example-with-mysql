package com.springbootcrudexample.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.springbootcrudexample.entity.Student;
import com.springbootcrudexample.repository.StudentRepository;
import com.springbootcrudexample.service.StudentService;

@RestController
@RequestMapping("/student")
public class StudentController {

	@Autowired
	private StudentService studentService;

	@Autowired
	private StudentRepository studentRepository;

	@PostMapping("/create")
	public Student createStudent1(@RequestBody Student student) {
		Student createResponse = studentService.save(student);
		return createResponse;
	}

	@PutMapping("/update/{id}")
	public Student updateStudentById(@RequestBody Student student, @PathVariable String id) {
		Student updateResponse = studentService.update(student);
		return updateResponse;
	}

	@PutMapping("/update")
	public Student updateStudent(@RequestBody Student student,@PathVariable String id) {
		Student getStudent = studentService.get(Long.valueOf(id));
		getStudent.setName(student.getName());
		getStudent.setRollNumber(student.getRollNumber());
		Student updateResponse = studentService.update(getStudent);
		return updateResponse;
	}
	
	@GetMapping("/{id}")
	public Student getStudent(@PathVariable String id) {
		Student getReponse = studentService.get(Long.valueOf(id));
		return getReponse;
	}

	@DeleteMapping("/delete/{id}")
	public String deleteStudent(@PathVariable String id) {
		Student student = studentService.get(Long.valueOf(id));
		studentService.delete(student);
		return "Record deleted succesfully";
	}

	@GetMapping(value = "/home")
	public ModelAndView homePage() {
		ModelAndView modelAndView = new ModelAndView("index");
		modelAndView.addObject("student", new Student());
		return modelAndView;
	}

	@GetMapping(value = "/createstudent")
	public ModelAndView createStudentView() {
		ModelAndView modelAndView = new ModelAndView("index");
		modelAndView.addObject("student", new Student());
		return modelAndView;
	}

	@PostMapping("/createstudent")
	public ModelAndView createStudent(Student student) {
		ModelAndView modelAndView = new ModelAndView();
		studentService.save(student);
		modelAndView.setViewName("savestudent");
		// logger.info("Form submitted successfully.");
		return modelAndView;
	}

	@GetMapping("/getallstudents")
	public ModelAndView getAllStudents() {
		ModelAndView modelAndView = new ModelAndView();
		List<Student> students = studentRepository.findAll();
		modelAndView.addObject("students", students);
		modelAndView.setViewName("studentinfo");
		// logger.info("Form submitted successfully.");
		return modelAndView;
	}
	
	
	@PostMapping("/bulkcreate")
	public List<Student> createStudents(@RequestBody List<Student> students) {
		List<Student> createResponse = studentService.saveAll(students);
		return createResponse;
	}

	@PutMapping("/bulkupdate")
	public List<Student> updateStudents(@RequestBody List<Student> students) {
		List<Student> updateResponse = studentService.updateAll(students);
		return updateResponse;
	}

	@GetMapping("/allstudent")
	public List<Student> getStudents() {
		List<Student> getresponse = studentService.getAll();
		return getresponse;
	}

	@DeleteMapping("/bulkdelete")
	public String deleteStudents(@RequestBody List<Student> students) {
		studentService.deleteAll(students);
		return "Records deleted succesfully";
	}

}
