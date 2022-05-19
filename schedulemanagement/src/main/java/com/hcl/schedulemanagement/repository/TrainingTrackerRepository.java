package com.hcl.schedulemanagement.repository;


import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.hcl.schedulemanagement.domain.TrainingTracker;
@Repository
public interface TrainingTrackerRepository extends CrudRepository<TrainingTracker, Long> {
    @Query("SELECT tr FROM TrainingTracker tr where tr.projectName like %:searchKey% or tr.status like  %:searchKey%  or tr.scheduleDate like  %:searchKey% ")
    List<TrainingTracker> advanceSearch(@Param("searchKey") String searchKey);
}
