package com.hcl.trainingmanagement.service;

import java.util.List;

import com.hcl.trainingmanagement.domain.Course;
import com.hcl.trainingmanagement.dto.CourseDto;

public interface CourseServices {

	Course create(CourseDto courseDto);

	public Iterable<Course> findAllCourse();

	Course update(int id, CourseDto courseDto);
	
	public Course delete(int id);
	
	public List<Course> searchCourses(String searchKey);

}
