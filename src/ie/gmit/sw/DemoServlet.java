package ie.gmit.sw;

import javax.servlet.http.*;  
import javax.servlet.*;
import javax.servlet.annotation.HttpMethodConstraint;
import javax.servlet.annotation.WebServlet;

import java.io.*;
import java.rmi.RemoteException;
import java.util.HashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;  

import ie.gmit.sw.RMI.Client;

@WebServlet("/query")
public class DemoServlet extends HttpServlet
{  
	boolean keepAlive=true;
	Client cli;
	ExecutorService threadPool;
	LinkedBlockingQueue<HashMap<String,String>> inQueue = new LinkedBlockingQueue<>(10); 
	LinkedBlockingQueue<HashMap<String,String>> outQueue = new LinkedBlockingQueue<>(); 
	
	int jobID=0;
	
	public void init()
	{
		System.out.println("init was called");
		threadPool = Executors.newFixedThreadPool(1);

		for(int i=0; i<1;i++)
		{
			threadPool.execute(new Runnable() 
			{
				public void run() 
				{
					while(keepAlive) 
					{
						System.out.println("Iniciou thread: "+Thread.currentThread().getName());
						try {
							HashMap<String,String> job = inQueue.take();

							String key=(String) job.keySet().toArray()[0];
							String value=(String)job.values().toArray()[0];
							HashMap<String,String> temp = new HashMap<String,String>();

							String def=cli.getDefinition(value);
							temp.put(key, def);
							outQueue.add(temp);

							System.out.println();
						} catch (Exception e) {}
					}
				}
			});
		}


		try 
		{
			cli = new Client();
		} catch (Exception e) 
		{
			e.printStackTrace();
		}


	}
	
	public void doGet(HttpServletRequest request,HttpServletResponse response)  
			throws ServletException,IOException  
	{  
		String job = request.getParameter("jobID");
		System.out.println("Called the method "+job);
		
		for(HashMap<String,String> aux : outQueue)
		{
			if(aux.containsKey(job))
			{
				String queryResponse=aux.get(job);
				String html ="<p> <b>Response:</b> "+queryResponse+" </p>";
				response.getWriter().write(html);
				return;
			}
		}
		
		String html ="Waiting for response ...";
		response.getWriter().write(html);
	}
	
	public void doPost(HttpServletRequest request,HttpServletResponse response)  
			throws ServletException,IOException  
	{  
		if(request.getParameter("query")!="")
		{
			jobID++;
			String q=request.getParameter("query");
			System.out.println(q);
			try {
				HashMap<String,String> temp = new HashMap<String,String>();
				temp.put(Integer.toString(jobID), q);
				inQueue.put(temp);
				//inQueue.notifyAll();
								
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		else
		{
			request.getRequestDispatcher("/index.jsp").forward(request, response);
		}
		
		
		System.out.println("Redirecting...");
		request.setAttribute("jobID", jobID);
		request.getRequestDispatcher("/WEB-INF/jsp/waiting.jsp").forward(request, response);
	}
	
}  