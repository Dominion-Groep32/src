package Controllers;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class homeServlet
 */
public class homeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public homeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            response.setContentType("text/html");
            response.setHeader("Cache-Control", "no-cache");
            PrintWriter out = response.getWriter();
            out.print("<h3>DATA HAS BEEN CHANEGD</h3>");
            System.out.println("I WAS HERE");
        	}
        catch (IOException io) {
            io.printStackTrace();
        	}
    }

    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
<<<<<<< HEAD
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
        PrintWriter out = response.getWriter();
        out.println("Hello World");
=======
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html");
		response.getWriter().write("<h1>Dit Werkt!</h1>");
>>>>>>> 9f986dd5efa5ae6f96ae59a463ac3d8c439103ac
	}
	*/
    
    
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
