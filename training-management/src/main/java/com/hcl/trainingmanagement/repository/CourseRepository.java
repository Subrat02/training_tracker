package com.hcl.trainingmanagement.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.hcl.trainingmanagement.domain.Course;

@Repository
public interface CourseRepository  extends JpaRepository<Course, Integer>{
	
	@Query("SELECT cr FROM Course cr where cr.name like %:searchKey% or cr.category like %:searchKey% or cr.duration like %:searchKey%")
	List<Course> advanceSearch(@Param("searchKey") String searchKey);
}
