package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.User;
import model.UserDao;


@WebServlet("/update")
public class UpdateUser extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	response.setContentType("text/html");
	PrintWriter out=response.getWriter();
	int uid=Integer.parseInt(request.getParameter("uid"));
	String fname=request.getParameter("fname");
	String lname=request.getParameter("lname");
	String email=request.getParameter("email");
	String mob=request.getParameter("mob");
	String web=request.getParameter("web");
	String pass=request.getParameter("pass");
	String terms=request.getParameter("term");
	UserDao db=new UserDao();
	User u=new User(uid, fname, lname, email, mob, web, pass, terms);

	try {
		if(db.update(u)>0)
			response.sendRedirect("dashboard.jsp");
		else	
			out.print("User Not Update");
			
	} catch (ClassNotFoundException | SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	
	
	
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
