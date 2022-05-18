package com.hcl.trainingmanagement.validation;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import com.hcl.trainingmanagement.dto.CourseDto;
import com.hcl.trainingmanagement.exception.TrainingManagementException;

@Component
public class CourseValidation {

	@Value("#{'${supported.categories}'.split(',')}")
	private List<String> categories;

	public void validateCategory(CourseDto courseDto) {

		if (!categories.contains(courseDto.getCategory())) {
			throw new TrainingManagementException("CRS-001", "category not supported, Supported Categories are " + String.join(", ", categories), HttpStatus.BAD_REQUEST.value());

		}

	}

}
