package com.hcl.trainingmanagement.dto;

import java.util.Date;

import javax.validation.constraints.NotBlank;

public class CourseDto {

	private int id;

	@NotBlank(message = "Name can not be empty")
	private String name;

	private String description;

	private String code;
 
	@NotBlank(message = "Name can not be empty")
	private String duration;
 
	@NotBlank(message = "Name can not be empty")
	private String category;

	private Date createdDate;

	private Date updatedDate;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Date getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

	@Override
	public String toString() {
		return "Course [id=" + id + ", name=" + name + ", description=" + description + ", code=" + code + ", duration="
				+ duration + ", category=" + category + ", createdDate=" + createdDate + ", updatedDate=" + updatedDate
				+ "]";
	}

}
