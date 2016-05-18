package Controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.jdt.internal.compiler.apt.util.Util.EncodingError;
import org.json.*;
import com.sun.media.jfxmedia.track.Track.Encoding;
import engine.*;

/**
 * Servlet implementation class DominionServlet
 */

public class DominionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private GameEngine engine = new GameEngine();	// FIXME: zou via getServletContext().get/setAttribute moeten werken
	//private Speler speler;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	
    public DominionServlet() {
        super();
        engine = null;
        // TODO Auto-generated constructor stub
    }
  
    private void spelersToevoegen(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
    	// this is the call that initiates a NEWLY begun game
    	//engine = new GameEngine();
    	JSONObject jsonObj = new JSONObject();
    	
    	String spelerNaam = request.getParameter("speler1");
    	String spelerNaam2 = request.getParameter("speler2");
    	
    	String spelers[] = {spelerNaam, spelerNaam2};
    	
    	engine.maakSpelersAan(spelers);
    	
		jsonObj.put("Speler1", engine.geefHuidigeSpeler().geefNaam());
		jsonObj.put("Speler2", spelers[1]);
		response.getWriter().write(jsonObj.toString());
    }
	
    private void huidigeSpeler(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	JSONObject jsonObj = new JSONObject();
    	
    	engine.veranderSpeler();
    	Speler huidigeSpeler = engine.geefHuidigeSpeler();
    	
    	String kaartenInHand = "";
    	for (int i = 0; i < 5; i++) {
    		kaartenInHand += huidigeSpeler.kaartenInHand().get(i).naam() + ",";
		}
    	
    	
    	//for(Kaart kaart: huidigeSpeler.trekKaart(huidigeSpeler.trekStapel(), 5)){
    	//	kaartenInHand += kaart.naam() + ",";
    	//}
    	
    	jsonObj.put("kaartenInHand", huidigeSpeler.kaartenInHand());
    	response.getWriter().write(kaartenInHand);
    }
    
    	/*
    	JSONArray arrayObj = new JSONArray();
    	Speler huidigeSpeler = engine.geefHuidigeSpeler();
    	huidigeSpeler.trekKaart(huidigeSpeler.trekStapel(), 5);
    	
    	List<Kaart> hand = huidigeSpeler.trekStapel();
    	
    	hand = engine.geefHuidigeSpeler().kaartenInHand();
		for(int i=0; i<hand.size();i++){
			arrayObj.put(i, hand.get(i).naam());
		}
		//arrayObj.put("OK", "hallo");
		
		response.getWriter().write(arrayObj.toString());
		*/
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setHeader("Access-Control-Allow-Origin", "*");
		
		switch(request.getParameter("operation"))
		{
		case "spelerToevoegen":
			spelersToevoegen(request, response);
			break;
			
		case "huidigeSpeler":
			huidigeSpeler(request, response);
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