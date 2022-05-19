package com.hcl.schedulemanagement.web;

import java.util.List;
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
import com.hcl.schedulemanagement.domain.TrainingTracker;
import com.hcl.schedulemanagement.service.TrainingTrackerService;
@RestController
@RequestMapping("/TrainingTracker")
public class TrainingTrackerController {
    @Autowired
    private TrainingTrackerService trainingTrackerService;
    @PostMapping("/create")
    public TrainingTracker createNewProject(@RequestBody TrainingTracker traininTracker) {
        TrainingTracker savedProject = trainingTrackerService.saveOrUpdate(traininTracker);
        return savedProject;
    }
    @GetMapping("/all")
    public Iterable<TrainingTracker> getAllTrainingTracker() {
        return trainingTrackerService.findtrainingTracker();
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<TrainingTracker> update(@PathVariable("id") long id,
            @RequestParam String projectName) {
        TrainingTracker updatedProject = trainingTrackerService.update(projectName, id);
        return new ResponseEntity<>(updatedProject, HttpStatus.OK);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<TrainingTracker> delete(@PathVariable("id") long id) {
        try {
            TrainingTracker deteltedProject = trainingTrackerService.delete(id);
            return new ResponseEntity<>(deteltedProject, HttpStatus.OK);
        } catch (Exception e) {
            throw e;
        }
    }
    @GetMapping("/search")
    public ResponseEntity<List<TrainingTracker>> search(@RequestParam String searchKey) {
        try {
            List<TrainingTracker> searchResult = trainingTrackerService.search(searchKey);
            return new ResponseEntity<>(searchResult, HttpStatus.OK);
        } catch (Exception e) {
            throw e;
        }
    }
}
