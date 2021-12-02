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
import com.programs.entity.Teacher;
import com.programs.util.HibernateUtil;

/**
 * Servlet implementation class GetTeacherMasterListServlet
 */
@WebServlet("/GetTeacherMasterListServlet")
public class GetTeacherMasterListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetTeacherMasterListServlet() {
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
		
		List <Teacher> teachers = session.createQuery("from Teacher").list();
		
		if(teachers != null) {
			
			out.print("<h1>Master list of Teachers </h1>");
			out.print("<style> table,td,th { border:2px solid red; padding:10px;}</style>");
			out.print("<table>");
			out.print("<tr>");
			out.print("<th> Teacher Id </th>");
			out.print("<th> Teacher's Name </th>");
			out.print("</tr>");
			
			for(Teacher teacher: teachers) {
				out.print("<tr>");
				out.print("<td>"+teacher.getTeacherId()+"</td>");
				out.print("<td>"+teacher.getTeacherName()+"</td>");
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
