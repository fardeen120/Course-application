package com.springrest.springrest.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springrest.springrest.dao.CourseDao;
import com.springrest.springrest.entities.Course;

@Service
public class CourseServiceimpl implements CourseService {
	
	
	@Autowired
	private CourseDao coursedao;
	
	
	public CourseServiceimpl() {
		
		
	}

	@Override
	public List<Course> getCourses() {
		
		return coursedao.findAll(); 
	}

	public Course getCourse(Long courseid) {
		
		
		return coursedao.getOne(courseid);

		
		
		
		
	}

	public Course addCourse(Course course) {
		
		coursedao.save(course);
		return course;
	}

	@Override
	public Course updatecourse(Course course) {
		coursedao.save(course);
		return course;
	}

	@Override
	public void deletecourse(Long parselong) {
		
		Course entity=coursedao.getOne(parselong);
		coursedao.delete(entity);
		
		
	}

}
