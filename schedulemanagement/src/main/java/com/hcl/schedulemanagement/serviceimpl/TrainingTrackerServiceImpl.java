package com.hcl.schedulemanagement.serviceimpl;


import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.hcl.schedulemanagement.domain.TrainingTracker;
import com.hcl.schedulemanagement.repository.TrainingTrackerRepository;
import com.hcl.schedulemanagement.service.TrainingTrackerService;
@Service
public class TrainingTrackerServiceImpl implements TrainingTrackerService {
    @Autowired
    private TrainingTrackerRepository trainingTrackerRepository;
    @Override
    public TrainingTracker saveOrUpdate(TrainingTracker trainingTracker) {
        return trainingTrackerRepository.save(trainingTracker);
    }
    @Override
    public TrainingTracker create(TrainingTracker trainingTracker) {
        return trainingTracker;
    }
    @Override
    public Iterable<TrainingTracker> findtrainingTracker() {
        return trainingTrackerRepository.findAll();
    }
    @Override
    public TrainingTracker update(String projectName, Long scheduleId) {
        Optional<TrainingTracker> trainingTrackerFromDb = trainingTrackerRepository.findById(scheduleId);
        if (trainingTrackerFromDb != null) {
            TrainingTracker trainingTracker = trainingTrackerFromDb.get();
            trainingTracker.setId(scheduleId);
            trainingTracker.setProjectName(projectName);
            trainingTrackerRepository.save(trainingTracker);
        }
        return trainingTrackerFromDb.get();
    }
    @Override
    public TrainingTracker delete(Long id) {
        Optional<TrainingTracker> trainingFromDb = trainingTrackerRepository.findById(id);
        TrainingTracker trainingTracker = null;
        if (trainingFromDb != null) {
            trainingTracker = trainingFromDb.get();
            trainingTracker.setId(id);
            trainingTrackerRepository.delete(trainingTracker);
        }
        return trainingTracker;
    }
    @Override
    public List<TrainingTracker> search(String searchKey) {
        try {
            List<TrainingTracker> courseList = trainingTrackerRepository.advanceSearch(searchKey);
            return courseList;
        } catch (Exception e) {
            throw e;
        }
    }
}