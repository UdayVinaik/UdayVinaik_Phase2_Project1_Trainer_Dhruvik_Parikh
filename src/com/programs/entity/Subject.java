package com.programs.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="subject")
public class Subject {
	
	@Id
	@GeneratedValue
	@Column(name="subject_id")
	private int subjectId;
	
	@Column(name="subject_name")
	private String subjectName;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="class_id")
	private Class class1;
	
	@ManyToMany(cascade = CascadeType.ALL, mappedBy="subjects" )
	private List<Student> students;
	
	@ManyToMany(cascade = CascadeType.ALL, mappedBy="subjects" )
	private List<Teacher> teachers;

	public int getSubjectId() {
		return subjectId;
	}

	public void setSubjectId(int subjectId) {
		this.subjectId = subjectId;
	}

	public String getSubjectName() {
		return subjectName;
	}

	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}

	public int getClass1() {
		return class1.getClassId();
	}

	public void setClass1(Class class1) {
		this.class1 = class1;
	}

	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}

	public List<Teacher> getTeachers() {
		return teachers;
	}

	public void setTeachers(List<Teacher> teachers) {
		this.teachers = teachers;
	}
	
	
	
}
