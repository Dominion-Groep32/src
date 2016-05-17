package Controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.*;

import com.sun.corba.se.spi.orbutil.fsm.Guard.Result;

import engine.*;

/**
 * Servlet implementation class DominionServlet
 */

public class DominionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private GameEngine engine;	// FIXME: zou via getServletContext().get/setAttribute moeten werken
	private Speler speler;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	
    public DominionServlet() {
        super();
        engine = null;
        // TODO Auto-generated constructor stub
    }
  
    private void spelerToevoegen(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
    	// this is the call that initiates a NEWLY begun game
    	engine = new GameEngine();
    	JSONObject jsonObj = new JSONObject();
    	
    	String spelerNaam = request.getParameter("spelerNaam");
    	String spelerNaam2 = request.getParameter("spelerNaam2");
    	
    	String spelers[] = new String[2];
    	spelers[0] = spelerNaam;
    	spelers[1] = spelerNaam2;
    	
    	engine.maakSpelersAan(spelers);
    	Speler huidigeSpeler = engine.geefHuidigeSpeler();
    	engine.geefHuidigeSpeler().trekKaart(huidigeSpeler.trekStapel(), 5);
    	
    	jsonObj.put("Kaarten in hand van " + huidigeSpeler , huidigeSpeler.kaartenInHand());
		response.getWriter().write(jsonObj.toString());
    	
		//Speler speler = new Speler(spelerNaam);
    	//jsonObj.put("speler", speler.geefNaam());
    }
	
    private void kaartenInHand(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	JSONObject jsonObj = new JSONObject();
    	//jsonObj.put("Huidige kaarten in hand", engine.kaartInHand());
    	    	
    	jsonObj.put("Kaarten in hand", speler.kaartenInHand());
    	response.getWriter().write(jsonObj.toString());
	}
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    
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
					
		default:
			//ErrorMsg(request, response);
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