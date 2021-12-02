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

import com.programs.entity.Class;
import com.programs.util.HibernateUtil;

/**
 * Servlet implementation class GetClassesMasterListServlet
 */
@WebServlet("/GetClassesMasterListServlet")
public class GetClassesMasterListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetClassesMasterListServlet() {
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
		
		List <Class> classes = session.createQuery("from Class").list();
		
		if(classes != null) {
			
			out.print("<h1>Class Master List </h1>");
			out.print("<style> table,td,th { border:2px solid red; padding:10px;}</style>");
			out.print("<table>");
			out.print("<tr>");
			out.print("<th> Class Id </th>");
			out.print("<th> Class Name </th>");
			out.print("</tr>");
			
			for(Class cl: classes) {
				out.print("<tr>");
				out.print("<td>"+cl.getClassId()+"</td>");
				out.print("<td>"+cl.getClassName()+"</td>");
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
