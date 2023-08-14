package com.infinite.college;

import javax.faces.bean.ManagedBean;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@ManagedBean(name = "studentdetails")
@Entity
@Table(name = "StudentDetails")

public class StudentDetails {

	@Id
	@Column(name = "StudentId")
	private String studentId;

	@Column(name = "Studentname")
	private String studentname;

	@Column(name = "DateOfJoin")
	private int dateOfJoin;

	public String getStudentId() {
		return studentId;
	}

	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}

	public String getStudentname() {
		return studentname;
	}

	public void setStudentname(String studentname) {
		this.studentname = studentname;
	}

	public int getDateOfJoin() {
		return dateOfJoin;
	}

	public void setDateOfJoin(int dateOfJoin) {
		this.dateOfJoin = dateOfJoin;
	}

}
