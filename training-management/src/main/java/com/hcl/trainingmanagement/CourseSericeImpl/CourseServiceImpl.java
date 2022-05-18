package com.hcl.trainingmanagement.CourseSericeImpl;

import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.hcl.trainingmanagement.domain.Course;
import com.hcl.trainingmanagement.dto.CourseDto;
import com.hcl.trainingmanagement.exception.TrainingManagementException;
import com.hcl.trainingmanagement.repository.CourseRepository;
import com.hcl.trainingmanagement.service.CourseServices;
import com.hcl.trainingmanagement.validation.CourseValidation;

@Service
public class CourseServiceImpl implements CourseServices {

	@Autowired
	private CourseRepository courseRepository;

	@Autowired
	private CourseValidation courseValidation;

	@Override
	public Course create(CourseDto courseDto) {
		try {
			courseValidation.validateCategory(courseDto);
			Course course = new Course();
			course.setName(courseDto.getName());
			course.setDescription(courseDto.getDescription());
			course.setCategory(courseDto.getCategory());
			course.setCreatedDate(new Date());
			course.setUpdatedDate(new Date());
			course.setCode(UUID.randomUUID().toString());
			Course savedCourse = courseRepository.save(course);
			return savedCourse;

		} catch (TrainingManagementException e) {
			throw e;
		} catch (Exception e) {
			throw new TrainingManagementException("CRS-002", "Somthing Went Wrong",
					HttpStatus.INTERNAL_SERVER_ERROR.value());
		}

	}

	@Override
	public Iterable<Course> findAllCourse() {
		try {
			return courseRepository.findAll();
		} catch (Exception e) {
			throw new TrainingManagementException("CRS-002", "Somthing Went Wrong",
					HttpStatus.INTERNAL_SERVER_ERROR.value());
		}
	}

	@Override
	public Course update(int id, CourseDto courseDto) {
		try {
			Optional<Course> courseFromDb = courseRepository.findById(id);
			if (courseFromDb.isEmpty()) {
				throw new TrainingManagementException("CRS-003", "course does not exist",
						HttpStatus.INTERNAL_SERVER_ERROR.value());
			}
			Course course = courseFromDb.get();
			course.setId(id);
			if (Objects.nonNull(courseDto.getName())) {
				course.setName(courseDto.getName());
			}
			if (Objects.nonNull(courseDto.getDuration())) {
				course.setDuration(courseDto.getDuration());
			}
			if (Objects.nonNull(courseDto.getDescription())) {
				course.setDescription(courseDto.getDescription());
			}
			if (Objects.nonNull(courseDto.getCategory())) {
				courseValidation.validateCategory(courseDto);
				course.setCategory(courseDto.getCategory());
			}

			course.setUpdatedDate(new Date());
			return courseRepository.save(course);

		} catch (TrainingManagementException e) {
			throw e;
		} catch (Exception e) {
			throw new TrainingManagementException("CRS-002", "Somthing Went Wrong",
					HttpStatus.INTERNAL_SERVER_ERROR.value());
		}
	}

	@Override
	public Course delete(int id) {
		try {
			Optional<Course> courseFromDb = courseRepository.findById(id);
			if (courseFromDb.isEmpty()) {
				throw new TrainingManagementException("CRS-004", "training is not deleted",
						HttpStatus.INTERNAL_SERVER_ERROR.value());
			}
			Course course = courseFromDb.get();
			course.setId(id);
			courseRepository.delete(course);
			return course;
		} catch (Exception e) {
			throw new TrainingManagementException("CRS-002", "Somthing Went Wrong",
					HttpStatus.INTERNAL_SERVER_ERROR.value());
		}
		
	}

	@Override
	public List<Course> searchCourses(String searchKey) {
		try {
			List<Course> courseList = courseRepository.advanceSearch(searchKey);
			return courseList;
		} catch (Exception e) {
			throw new TrainingManagementException("CRS-002", "Somthing Went Wrong",
					HttpStatus.INTERNAL_SERVER_ERROR.value());
		}
	}

}
