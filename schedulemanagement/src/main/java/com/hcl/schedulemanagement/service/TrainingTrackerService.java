package com.hcl.schedulemanagement.service;

import java.util.List;
import com.hcl.schedulemanagement.domain.TrainingTracker;
public interface TrainingTrackerService {
    public TrainingTracker saveOrUpdate(TrainingTracker TrainingTracker);
    public TrainingTracker create(TrainingTracker trainingTracker);
    public Iterable<TrainingTracker> findtrainingTracker();
    public TrainingTracker update(String projectName, Long scheduleId);
    public TrainingTracker delete(Long id);
    public List<TrainingTracker> search(String searchKey);
}