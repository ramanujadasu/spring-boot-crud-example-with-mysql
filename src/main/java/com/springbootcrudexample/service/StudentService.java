package com.springbootcrudexample.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.springbootcrudexample.entity.Student;

@Component
public interface StudentService {

	public Student save(Student student);
	public Student update(Student student);
	public Student get(Long id);
	public void delete(Student student);
	
	public List<Student> saveAll(List<Student> student);
	public List<Student> updateAll(List<Student> student);
	public List<Student> getAll();
	public void deleteAll(List<Student> student);
}
