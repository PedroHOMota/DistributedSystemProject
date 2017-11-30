package ie.gmit.sw;

import javax.servlet.http.*;  
import javax.servlet.*;
import javax.servlet.annotation.HttpMethodConstraint;
import javax.servlet.annotation.WebServlet;

import java.io.*;  

@WebServlet("/query")
public class DemoServlet extends HttpServlet
{  
	public void doGet(HttpServletRequest req,HttpServletResponse res)  
			throws ServletException,IOException  
	{  
		System.out.println("entrou");
		req.getRequestDispatcher("/WEB-INF/jsp/some.jsp").forward(req, res);
	}
	
	public void doPost(HttpServletRequest request,HttpServletResponse response)  
			throws ServletException,IOException  
	{  
		System.out.println(request.getParameter("query"));
		request.getRequestDispatcher("/WEB-INF/jsp/some.jsp").forward(request, response);
	}
}  