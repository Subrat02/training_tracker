package com.hcl.schedulemanagement.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.hcl.schedulemanagement.domain.TrainingTracker;


@Repository
public interface TrainingTrackerRepository extends CrudRepository<TrainingTracker, Long> {
	
	
	
	
	
}
