package Controllers;

import java.io.IOException;

import javax.management.monitor.GaugeMonitor;
import javax.print.attribute.standard.RequestingUserName;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

<<<<<<< HEAD
import org.eclipse.swt.internal.ole.win32.VARDESC;
import org.json.*;
=======
//import org.json.*;
>>>>>>> 1786da204923b079111d893c9b3d61752488cd23
import engine.*;
import jdk.nashorn.internal.scripts.JO;

/**
 * Servlet implementation class DominionServlet
 */
//public class DominionServlet extends HttpServlet {
	//private static final long serialVersionUID = 1L;
	
<<<<<<< HEAD
	private GameEngine engine;			// FIXME: zou via getServletContext().get/setAttribute moeten werken
=======
	//private GameEngine engine;
>>>>>>> 1786da204923b079111d893c9b3d61752488cd23
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	  /*
    public DominionServlet() {
        super();
        engine = null;
        // TODO Auto-generated constructor stub
    }
<<<<<<< HEAD
    
    private void spelerToevoegen(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
    	// this is the call that initiates a NEWLY begun game
    	engine = new GameEngine();
    	
    	String spelerNaam = request.getParameter("spelerNaam");
		Speler speler = new Speler(spelerNaam);
		
		JSONObject jsonObj = new JSONObject();
		jsonObj.put("speler", speler.geefNaam());
=======
  
    private void addPlayer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {	
		String spelerNaam = request.getParameter("spelerNaam");
		Speler gebruiker = new Speler(spelerNaam);
		
		//JSONObject jsonObj = new JSONObject();
		jsonObj.put("speler", gebruiker.geefNaam());
>>>>>>> 1786da204923b079111d893c9b3d61752488cd23
		
		response.getWriter().write(jsonObj.toString());
    }
    
    private void kaartenInHand(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
    	
    	JSONObject jsonObj = new JSONObject();
    	jsonObj.put("Huidige kaarten in hand", engine.kaartInHand());
    	
    	response.getWriter().write(jsonObj.toString());
	}
    
    private void koperKopen(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
    	JSONObject jsonObj = new JSONObject();
    	jsonObj.put("Huidige kaarten in hand", engine.kaartInHand());
    	
    	response.getWriter().write(jsonObj.toString());
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    /*
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setHeader("Access-Control-Allow-Origin", "*");
		
		switch(request.getParameter("operation"))
		{
		case "spelerToevoegen":
			spelerToevoegen(request, response);
			break;
			
		case "kaartenInHand":
			kaartenInHand(request, response);
			break;
			
		case "koperKopen":
			koperKopen(request, response);
			break;
					
		default:
			//ErrorMsg(request, response);
			break;
		}	
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
    /*
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.getWriter().append("hello world vanuit post");
	}
}
*/