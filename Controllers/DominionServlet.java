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
	private SpelFuncties engine = new SpelFuncties();	// FIXME: zou via getServletContext().get/setAttribute moeten werken
	private Speler huidigeSpeler;
	
	
    public DominionServlet() {
        super();
    }
  
    private void spelersToevoegen(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
    	JSONObject jsonObj = new JSONObject();
    	
    	String spelerNaam = request.getParameter("speler1");
    	String spelerNaam2 = request.getParameter("speler2");
    	String spelers[] = {spelerNaam, spelerNaam2};
    	engine.maakSpelersAan(spelers);
    	huidigeSpeler = engine.geefHuidigeSpeler();
		jsonObj.put("Speler1", huidigeSpeler.geefNaam());
		jsonObj.put("Speler2", spelers[1]);
		response.getWriter().write(jsonObj.toString());
		
    }
	
    private void huidigeSpeler(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
    	JSONObject jsonObj = new JSONObject();
    	String[] spelers = {"jos","silke"};
    	
    	engine.maakSpelersAan(spelers);
    	//bovenstaande dient ter testen
    	
    	engine.trekKaart(engine.geefHuidigeSpeler().trekStapel(), 5);
    	
    	String kaartenInHand = "";
    	for (int i = 0; i < engine.geefHuidigeSpeler().kaartenInHand().size(); i++) 
    	{
    		kaartenInHand += engine.geefHuidigeSpeler().kaartenInHand().get(i).naam() + ",";
		}
    	jsonObj.put("kaartenInHand", kaartenInHand);
    	response.getWriter().write(kaartenInHand);
    }
    
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
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.getWriter().append("hello world vanuit post");
	}
}