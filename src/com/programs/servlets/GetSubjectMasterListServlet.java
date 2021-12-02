package com.programs.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.programs.entity.Subject;
import com.programs.util.HibernateUtil;

/**
 * Servlet implementation class GetSubjectMasterListServlet
 */
@WebServlet("/GetSubjectMasterListServlet")
public class GetSubjectMasterListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetSubjectMasterListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		SessionFactory sf = HibernateUtil.buildSessionFactory();
		Session session = sf.openSession();
		
		List <Subject> subjects = session.createQuery("from Subject").list();
		
		if(subjects != null) {
			
			out.print("<h1>Master list of Subjects </h1>");
			out.print("<style> table,td,th { border:2px solid red; padding:10px;}</style>");
			out.print("<table>");
			out.print("<tr>");
			out.print("<th> Subject Id </th>");
			out.print("<th> Subject Name </th>");
			out.print("<th> Class Id</th>");
			out.print("</tr>");
			
			for(Subject subject: subjects) {
				out.print("<tr>");
				out.print("<td>"+subject.getSubjectId()+"</td>");
				out.print("<td>"+subject.getSubjectName()+"</td>");
				out.print("<td>"+subject.getClass1()+"</td>");
				out.print("</tr>");
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
