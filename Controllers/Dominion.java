package Controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.*;

import com.oracle.jrockit.jfr.RequestableEvent;
import com.sun.javafx.stage.StagePeerListener;
import com.sun.org.apache.xalan.internal.xsltc.compiler.util.ErrorMsg;
import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader.Array;

import engine.*;


/**
 * Servlet implementation class Dominion
 */
public class Dominion extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// private Player ... cf huidige logica
	
	private GameEngine gameEngine;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Dominion() {
        super();
        // TODO Auto-generated constructor stub
    }

    private void initEngine(HttpServletRequest request, HttpServletResponse response)
    {
    	gameEngine = getServletContext().getAttribute("gameEngine");
    	
    	if(gameEngine == null)
    	{
    		gameEngine = new GameEngine();
    		//  dit moet gebeuren bij addplayer call      gameEngine.maakSpelersAan("test", "test");	
    	}
    }
    
    private void addPlayer(HttpServletRequest request, HttpServletResponse response)
    {
		/*JSONObject jsonke = new JSONObject();
		jsonke.put("Naam", "koentje");*/
		
		String spelerNaam = request.getParameter("spelerNaam");
		Speler gebruiker = new Speler(spelerNaam);
	
		// JM: gameEngine.addPlayer
		// dus player opgeslagen IN de engine ipv erbuiten
		// zoals je hier deed en nu ook nog in consoleversie gebeurt (daar was het een array)
		
		JSONObject jsonke = new JSONObject();
		jsonke.put("speler", gebruiker.krijgNaam());
		response.getWriter().write(jsonke.toString());

		//JSONObject jsonke2 = new JSONObject();
		//jsonke.put("trekStapel", gebruiker.kaartenInHand()); //linkedlist van kaarten
		//response.getWriter().write(jsonke.toString());
		//response.getWriter().append("hello world ");
    }
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	initEngine(request, response);
    	
		// TODO Auto-generated method stub
		response.setHeader("Access-Control-Allow-Origin", "*");
		
		switch(request.getParameter("operation"))
		{
		case "addPlayer":
			addPlayer(request, response);
			break;
			
		case "ietsanders":
			break;
					
		default:
			// ErrorMsg(request, response;
			break;
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.getWriter().append("hello world vanuit post");
	}

}
