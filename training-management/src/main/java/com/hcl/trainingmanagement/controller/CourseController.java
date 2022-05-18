package com.hcl.trainingmanagement.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.trainingmanagement.domain.Course;
import com.hcl.trainingmanagement.dto.CourseDto;
import com.hcl.trainingmanagement.exception.TrainingManagementException;
import com.hcl.trainingmanagement.service.CourseServices;

@RestController
@RequestMapping("/course")
public class CourseController {

	@Autowired
	private CourseServices courseServices;

	@PostMapping("/create")
	public ResponseEntity<Course> create(@Valid @RequestBody CourseDto courseDto) {
		try {
			Course createdCourse = courseServices.create(courseDto);
			return new ResponseEntity<>(createdCourse, HttpStatus.OK);
		} catch (TrainingManagementException e) {
			throw e;
		}
	}

	@GetMapping("/all")
	public Iterable<Course> getAllCourse() {
		try {
			return courseServices.findAllCourse();
		} catch (Exception e) {
			throw e;
		}

	}

	@PutMapping("/update/{id}")
	public ResponseEntity<Course> update(@PathVariable("id") int id, @RequestBody CourseDto courseDto) {
		try {
			Course updatedCourseDto = courseServices.update(id, courseDto);
			return new ResponseEntity<>(updatedCourseDto, HttpStatus.OK);
		} catch (Exception e) {
			throw e;
		}
	}
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Course> delete(@PathVariable("id") int id) {
		try {
			Course deletedCourseDto = courseServices.delete(id);
			return new ResponseEntity<>(deletedCourseDto, HttpStatus.OK);
		} catch (Exception e) {
			throw e;
		}
	}
	
	@GetMapping("/search")
	public ResponseEntity<List<Course>> search(@RequestParam String searchKey) {
		try {
			List<Course> searchResult = courseServices.searchCourses(searchKey);
			return new ResponseEntity<>(searchResult, HttpStatus.OK);
		} catch (Exception e) {
			throw e;
		}
	}
}
