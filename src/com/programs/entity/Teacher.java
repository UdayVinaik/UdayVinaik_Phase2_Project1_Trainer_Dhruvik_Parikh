package com.programs.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="teacher")
public class Teacher {
	
	@Id
	@GeneratedValue
	@Column(name="teacher_id")
	private int teacherId;
	
	@Column(name="teacher_name")
	private String teacherName;
	
	@ManyToMany(cascade = CascadeType.ALL, mappedBy="teachers" )
	private List<Class> classes;
	
	@ManyToMany(cascade = CascadeType.ALL, mappedBy="teachers" )
	private List<Student> students;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name="teacher_subject_link", joinColumns = {@JoinColumn(name="teacher_id")}, inverseJoinColumns= {@JoinColumn(name="subject_id")})
	private List<Subject> subjects;

	public int getTeacherId() {
		return teacherId;
	}

	public void setTeacherId(int teacherId) {
		this.teacherId = teacherId;
	}

	public String getTeacherName() {
		return teacherName;
	}

	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}

	public List<Class> getClasses() {
		return classes;
	}

	public void setClasses(List<Class> classes) {
		this.classes = classes;
	}

	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}

	public List<Subject> getSubjects() {
		return subjects;
	}

	public void setSubjects(List<Subject> subjects) {
		this.subjects = subjects;
	}
	
	
	
}
