package com.hcl.employee_management_tool.domain;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name="employee")
public class Employee {
 @Id
 @GeneratedValue(strategy=GenerationType.IDENTITY)
  private Long id;
 @NotBlank(message = "Employee Name is required")
 @Column(name = "Employee_Name")
  private String name;
 @NotBlank(message = "Employee email_id is required")
 @Column(name = "Email_Id")
  private String email;
 @Column (name = "phone_no")
  private Long phone_no;
 
 public Employee(@NotBlank(message = "Employee Name is required") String name,
			@NotBlank(message = "Employee email_id is required") String email,Long phone_no) {
	 super();
		this.name = name;
		this.email = email;
		this.phone_no = phone_no;
 }
  
public Employee() {
	super();
	// TODO Auto-generated constructor stub
}


public Long getId() {
	return id;
}


public void setId(Long id) {
	this.id = id;
}


public String getName() {
	return name;
}


public void setName(String name) {
	this.name = name;
}


public String getEmail() {
	return email;
}


public void setEmail(String email) {
	this.email = email;
}



public Long getPhone_no() {
	return phone_no;
}


public void setPhone_no(Long phone_no) {
	this.phone_no = phone_no;
}


@Override
public String toString() {
	return "Employee [id=" + id + ", name=" + name + ", email=" + email + ", phone_no=" + phone_no + "]";
}




}
