package com.hcl.schedulemanagement.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class TrainingTracker {

		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private long id;     			
		private long scheduleId;
		private String projectName;		
		
		@Temporal(TemporalType.DATE)
		@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd-MM-yyyy")
		private Date scheduleDate;      
		@Temporal(TemporalType.DATE)
		@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd-MM-yyyy")
		private Date updatedDate;	
		@Temporal(TemporalType.DATE)
		@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd-MM-yyyy")
		private Date completedDate;		
		private String status;			
		
		
		
		public TrainingTracker() {
			super();
		}
		public long getId() {
			return id;
		}
		public void setId(long id) {
			this.id = id;
		}
		public long getScheduleId() {
			return scheduleId;
		}
		public void setScheduleId(long scheduleId) {
			this.scheduleId = scheduleId;
		}
		public String getProjectName() {
			return projectName;
		}
		public void setProjectName(String projectName) {
			this.projectName = projectName;
		}
		public Date getScheduleDate() {
			return scheduleDate;
		}
		public void setScheduleDate(Date scheduleDate) {
			this.scheduleDate = scheduleDate;
		}
		public Date getUpdatedDate() {
			return updatedDate;
		}
		public void setUpdatedDate(Date updatedDate) {
			this.updatedDate = updatedDate;
		}
		public Date getCompletedDate() {
			return completedDate;
		}
		public void setCompletedDate(Date completedDate) {
			this.completedDate = completedDate;
		}
		public String getStatus() {
			return status;
		}
		public void setStatus(String status) {
			this.status = status;
		}
		@PrePersist
		public void onscheduleDate() {
			this.scheduleDate =new Date();
		}
		@PreUpdate
		public void onupdatedDate() {
			this.updatedDate =new Date();
		}
		
}

