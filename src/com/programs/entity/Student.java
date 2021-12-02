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
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="student")
public class Student {
	
	@Id
	@GeneratedValue
	@Column(name="student_id")
	private int studentId;
	
	@Column(name="student_name")
	private String studentName;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="class_id")
	private Class class2;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name="student_subject_link", joinColumns = {@JoinColumn(name="student_id")}, inverseJoinColumns= {@JoinColumn(name="subject_id")})
	private List<Subject> subjects;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name="student_teacher_link", joinColumns = {@JoinColumn(name="student_id")}, inverseJoinColumns= {@JoinColumn(name="teacher_id")})
	private List<Teacher> teachers;

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public int getClass2() {
		return class2.getClassId();
	}

	public void setClass2(Class class2) {
		this.class2 = class2;
	}

	public String getSubjects() {
		StringBuffer sb = new StringBuffer();
		
		if(subjects != null) {
			for(Subject s: subjects) {
				sb.append(s.getSubjectName()+", ");
			}
		}
		return sb.toString();
	}

	public void setSubjects(List<Subject> subjects) {
		this.subjects = subjects;
	}

	public String getTeachers() {
		StringBuffer sb = new StringBuffer();
		
		if(teachers != null) {
			for(Teacher s: teachers) {
				sb.append(s.getTeacherName()+", ");
			}
		}
		return sb.toString();
	}

	public void setTeachers(List<Teacher> teachers) {
		this.teachers = teachers;
	}
	
	
}
