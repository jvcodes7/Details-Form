package com.Servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DetailsDao.Update;

import com.Detailsbean.Details;


@WebServlet("/editServlet2")
public class editServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
   

	
	

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		String sid=request.getParameter("id");
		int id=Integer.parseInt(sid);
		String name=request.getParameter("name");
		String gender=request.getParameter("gender");
		String city=request.getParameter("city");
		String hobbies=request.getParameter("hobbies");
		
		Details d=new Details();
		d.setId(id);
		d.setName(name);
		d.setGender(gender);
		d.setcity(city);
		d.sethobbies(hobbies);
		
		Update up=new Update();
		
		int status=up.update(d);
		if(status>0){
			response.sendRedirect("ViewServlet");
		}else{
			out.println("Sorry! unable to update record");
		}
		
		out.close();
		
		
	}

}
