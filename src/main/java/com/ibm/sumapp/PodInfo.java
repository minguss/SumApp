package com.ibm.sumapp;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/pod")
public class PodInfo extends HttpServlet {
	
	private static final long serialVersionUID = -3219193137876770651L;
	public static boolean isOK = true;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PodInfo() {
        super();    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String pod = System.getenv("HOSTNAME");
		
		if( pod != null ) {
			response.setStatus(200);
	        response.setContentType("text/plain");
	        response.getWriter().print(pod);
		} else {
			response.setStatus(400);
	        response.setContentType("text/plain");
	        response.getWriter().print("clueless");
		}
	}

}
