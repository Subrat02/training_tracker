package com.hcl.employee_management_tool.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="employee")
public class Employee {
 @Id
 @GeneratedValue(strategy=GenerationType.IDENTITY)
  private Long id;
  private String name;
  private String email;
  private Long phone_no;
  
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
