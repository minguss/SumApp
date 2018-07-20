package com.ibm.sumapp;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/add")
public class SumServlet extends HttpServlet {
       
	private static final long serialVersionUID = 6157374547335794603L;

	/**
     * @see HttpServlet#HttpServlet()
     */
    public SumServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String param_op1 = request.getParameter("op1");
		String param_op2 = request.getParameter("op2");
		
		int op1=0;
		int op2=0;
		
		String msg = null;
		
		try {
			op1 = Integer.parseInt(param_op1);
		} catch(NumberFormatException nfe) {
			msg = "'" + param_op1 + "' not a valid integer";
		}

		try {
			op2 = Integer.parseInt(param_op2);
		} catch(NumberFormatException nfe) {
			if( msg == null ) {
				msg = "'" + param_op2 + "' not a valid integer";
			} else {
				msg += ", and '" + param_op2 + "' not a valid integer";
			}
		}
		
		if( msg != null ) {
			response.setStatus(200);
	        response.setContentType("text/plain");
	        response.getWriter().print(msg);
	        System.out.println( msg );

		} else {
			Adder adder = new Adder();
			int sum = adder.add(op1,  op2);
			String res = param_op1 + " + " + param_op2 + " = " + sum;
			response.setStatus(200);
	        response.setContentType("text/plain");
	        response.getWriter().print(res);
		}
		
	}

}
