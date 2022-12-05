package com.Servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DetailsDao.DetailsDao;

import com.Detailsbean.Details;

/**
 * Servlet implementation class editservlet1
 */
@WebServlet("/editservlet1")
public class editServlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public editServlet1() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		out.println("<h1>Update Employee</h1>");
		String sid=request.getParameter("id");
		int id=Integer.parseInt(sid);
		
		Details e=DetailsDao.getPersonById(id)
;
		
		out.print("<form action='editServlet2' method='post'>");
		out.print("<table>");
		out.print("<tr><td></td><td><input type='hidden' name='id' value='"+e.getId()+"'/></td></tr>");
		out.print("<tr><td>Name:</td><td><input type='text' name='name' value='"+e.getName()+"'/></td></tr>");
		out.print("<tr><td>Gender:</td><td><input type='radio' id='male' name='gender' value='male'>male || <input type='radio' id='female' name='gender' value='female'>Female</td></tr>");
		
		out.print("<tr><th>Hobbies</th>");
		out.print("<td><input type='checkbox' id='hob1' value='badminton' name='hobbies' class='hobbies'> Badminton"); 
		out.print("<input type='checkbox' id='hob2' value='Cricket' name='hobbies'class='hobbies'> Cricket ");
		out.print("<input type='checkbox' id='hob3' value='Running' name='hobbies' class='hobbies'>Running<br></td></tr>");
		out.print("<tr><td colspan='2'><input type='submit' value='Edit &amp; Save '/></td></tr>");
		out.print("</table>");
		out.print("</form>");
		
		out.close();
		
		
		
		
	}

	
	
}
