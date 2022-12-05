package com.Servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DetailsDao.Save;

import com.Detailsbean.Details;


@WebServlet("/SaveServlet")
public class SaveServlet extends HttpServlet  {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		String name = request.getParameter("name");
		String gender = request.getParameter("gender");
		String hobbies = request.getParameter("hobbies");
		String city = request.getParameter("city");

		Details e = new Details();
		e.setName(name);
		e.setGender(gender);
		e.sethobbies(hobbies);
		e.setcity(city);
		
		Save s=new Save();
		int status = s.save(e);
		if (status > 0) {
			out.print("<p>Record saved successfully!</p>");
			request.getRequestDispatcher("index.jsp").include(request, response);
		} else {
			out.println("Sorry! unable to save record");
		}

		out.close();
	}

}
