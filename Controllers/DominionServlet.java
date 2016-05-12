package Controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.*;
import engine.*;

/**
 * Servlet implementation class DominionServlet
 */
public class DominionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private GameEngine engine;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DominionServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    private void addPlayer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {	
		String spelerNaam = request.getParameter("spelerNaam");
		Speler gebruiker = new Speler(spelerNaam);
		
		JSONObject jsonObj = new JSONObject();
		jsonObj.put("speler", gebruiker.geefNaam());
		
		response.getWriter().write(jsonObj.toString());
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setHeader("Access-Control-Allow-Origin", "*");
		
		switch(request.getParameter("operation"))
		{
		case "addPlayer":
			addPlayer(request, response);
			break;
			
		case "ietsanders":
			break;
					
		default:
			// ErrorMsg(request, response);
			break;
		}	
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.getWriter().append("hello world vanuit post");
	}
}
