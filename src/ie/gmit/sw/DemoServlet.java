package ie.gmit.sw;

import javax.servlet.http.*;  
import javax.servlet.*;
import javax.servlet.annotation.HttpMethodConstraint;

import java.io.*;  
public class DemoServlet extends HttpServlet
{  
	public void doGet(HttpServletRequest req,HttpServletResponse res)  
			throws ServletException,IOException  
	{  
		System.out.println("entrou");
		/*res.setContentType("text/html");//setting the content type  
		PrintWriter pw=res.getWriter();//get the stream to write the data  

		//writing html in the stream  
		pw.println("<html><body>");  
		pw.println("Welcome to servlet");  
		pw.println("</body></html>");  

		pw.close();//closing the stream  */
		
		req.getRequestDispatcher("/WEB-INF/jsp/some.jsp").forward(req, res);
	}
	
	public void doPost(HttpServletRequest req,HttpServletResponse res)  
			throws ServletException,IOException  
	{  
		System.out.println("entrou");
		/*res.setContentType("text/html");//setting the content type  
		PrintWriter pw=res.getWriter();//get the stream to write the data  

		//writing html in the stream  
		pw.println("<html><body>");  
		pw.println("Welcome to servlet");  
		pw.println("</body></html>");  

		pw.close();//closing the stream  */
		
		req.getRequestDispatcher("/WEB-INF/jsp/some.jsp").forward(req, res);
	}
}  