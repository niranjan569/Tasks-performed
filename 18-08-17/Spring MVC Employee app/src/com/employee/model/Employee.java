package com.employee.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Employee {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	@Column(name="Name")
	private String pEmployeeName;
	@Column(name="Project")
	private String pProject;
	@Column(name="Salary")
	private float pSalary;


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getpEmployeeName() {
		return pEmployeeName;
	}

	public void setpEmployeeName(String EmployeeName) {
		this.pEmployeeName = EmployeeName;
	}

	public String getpProject() {
		return pProject;
	}

	public void setpProject(String Project) {
		this.pProject = Project;
	}

	public float getpSalary() {
		return pSalary;
	}

	public void setpSalary(float Salary) {
		this.pSalary = Salary;
	}

}
