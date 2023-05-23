package com.springrest.springrest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springrest.springrest.entities.Course;
import com.springrest.springrest.services.CourseService;

@RestController
public class MyController { 
	
	@Autowired
	private CourseService courseservice;
	
	@GetMapping("/home")
	public String home() {
		
		return "Welcome to courses application";
	}
	
	@GetMapping("/courses")
	public List<Course>getCourses(){
		return this.courseservice.getCourses();
	

}
	@GetMapping("/courses/{courseid}")
	public Course getCourse(@PathVariable String courseid) {
		
		return this.courseservice.getCourse(Long.parseLong(courseid));
		
	}
	
	@PostMapping("/courses")
	public Course addCourse(@RequestBody Course course) {
		
		return this.courseservice.addCourse(course);
		
	}
	
	@PutMapping("/courses")
	public Course updatecourse(@RequestBody Course course ) {
		return this.courseservice.updatecourse(course);
	}
	
	@DeleteMapping("/courses/{courseid}")
	public ResponseEntity<HttpStatus>deletecourse(@PathVariable String courseid){
		try {
			this.courseservice.deletecourse(Long.parseLong(courseid));
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
}
