package com.programs.servlets;

import com.programs.entity.Class;
import com.programs.entity.Subject;
import com.programs.entity.Student;
import com.programs.entity.Teacher;
import com.programs.util.HibernateUtil;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 * Servlet implementation class AddClassServlet
 */
@WebServlet("/AddClassServlet")
public class AddClassServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddClassServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("add-class.html").include(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Class classInstance = populateValue(request);
		
		SessionFactory sf = HibernateUtil.buildSessionFactory();
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		
		session.save(classInstance);
		
		tx.commit();
		
		PrintWriter out = response.getWriter();
		out.append("Class registered successfully");
	}

	private Class populateValue(HttpServletRequest request) {
		String className = request.getParameter("className");
		
		String courseName1 = request.getParameter("course1");
		String courseName2 = request.getParameter("course2");
		String courseName3 = request.getParameter("course3");
		String courseName4 = request.getParameter("course4");
		
		String studentName1 = request.getParameter("student1");
		String studentName2 = request.getParameter("student2");
		String studentName3 = request.getParameter("student3");
		String studentName4 = request.getParameter("student4");
		
		String teacherName1 = request.getParameter("teacher1");
		String teacherName2 = request.getParameter("teacher2");
		
		Class classInstance = new Class();
		classInstance.setClassName(className);
		
		Subject subject1 = new Subject();
		subject1.setSubjectName(courseName1);
		subject1.setClass1(classInstance);
		
		Subject subject2 = new Subject();
		subject2.setSubjectName(courseName2);
		subject2.setClass1(classInstance);
		
		Subject subject3 = new Subject();
		subject3.setSubjectName(courseName3);
		subject3.setClass1(classInstance);
		
		Subject subject4 = new Subject();
		subject4.setSubjectName(courseName4);
		subject4.setClass1(classInstance);
		
		List<Subject> subjects = new ArrayList<>();
		subjects.add(subject1);
		subjects.add(subject2);
		subjects.add(subject3);
		subjects.add(subject4);
		
		classInstance.setSubjects(subjects);
		
		Student student1 = new Student();
		student1.setStudentName(studentName1);
		student1.setClass2(classInstance);
		
		Student student2 = new Student();
		student2.setStudentName(studentName2);
		student2.setClass2(classInstance);
		
		Student student3 = new Student();
		student3.setStudentName(studentName3);
		student3.setClass2(classInstance);
		
		Student student4 = new Student();
		student4.setStudentName(studentName4);
		student4.setClass2(classInstance);
		
		List<Student> students = new ArrayList<>();
		students.add(student1);
		students.add(student2);
		students.add(student3);
		students.add(student4);
		
		classInstance.setStudents(students);
		
		List<Class> classes = new ArrayList<>();
		classes.add(classInstance);
		
		Teacher teacher1 = new Teacher();
		teacher1.setTeacherName(teacherName1);
		teacher1.setClasses(classes);
		
		Teacher teacher2 = new Teacher();
		teacher2.setTeacherName(teacherName2);
		teacher2.setClasses(classes);
		
		List<Teacher> teachers = new ArrayList<>();
		teachers.add(teacher1);
		teachers.add(teacher2);
		
		classInstance.setTeachers(teachers);
		return classInstance;
		
	}

}
