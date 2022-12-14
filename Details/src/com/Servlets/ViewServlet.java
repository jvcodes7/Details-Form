package com.Servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DetailsDao.DetailsDao;

import com.Detailsbean.Details;

/**
 * Servlet implementation class ViewServlet
 */
@WebServlet("/ViewServlet")
public class ViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ViewServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<a href='index.jsp'>Add New Employee</a>");
		out.println("<h1>Employees List</h1>");

		List<Details> list = DetailsDao.getAllEmployees();

		out.print("<table border='1' width='100%'");
		out.print("<tr><th>Id</th><th>Name</th><th>Password</th><th>Email</th><th>Country</th><th>Edit</th><th>Delete</th></tr>");
		for (Details e : list) {
			out.print("<tr><td>" + e.getId() + "</td><td>" + e.getName()
					+ "</td><td>" + e.getGender() + "</td><td>" + e.getcity()
					+ "</td><td>" + e.gethobbies()
					+ "</td><td><a href='editservlet1?id=" + e.getId()
					+ "'>edit</a></td><td><a href='DeleteServlet?id="
					+ e.getId() + "'>delete</a></td></tr>");
		}
		out.print("</table>");

		out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
