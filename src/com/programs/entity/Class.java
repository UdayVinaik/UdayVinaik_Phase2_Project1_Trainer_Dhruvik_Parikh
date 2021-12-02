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
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="class")
public class Class {
	
	@Id
	@GeneratedValue
	@Column(name="class_id")
	private int classId;
	
	@Column(name="class_name")
	private String className;
	
	@OneToMany(cascade= CascadeType.ALL, mappedBy="class1")
	private List<Subject> subjects;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy="class2")
	private List<Student> students;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name="class_teacher_link", joinColumns = {@JoinColumn(name="class_id")}, inverseJoinColumns= {@JoinColumn(name="teacher_id")})
	private List<Teacher> teachers;

	public int getClassId() {
		return classId;
	}

	public void setClassId(int classId) {
		this.classId = classId;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
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

	public String getStudents() {
		StringBuffer sb = new StringBuffer();
		
		if(students != null) {
			for(Student s: students) {
				sb.append(s.getStudentName()+", ");
			}
		}
		return sb.toString();
	}

	public void setStudents(List<Student> students) {
		this.students = students;
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
