package Controllers;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.*;
import engine.*;

public class DominionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	//private Speler huidigeSpeler;
	
	
    public DominionServlet() {
        super();
    }
  
    private void spelersToevoegen(HttpServletRequest request, HttpServletResponse response, SpelFuncties engine) throws ServletException, IOException {	
    	JSONObject jsonObj = new JSONObject();
    	String spelerNaam = request.getParameter("speler1");
    	String spelerNaam2 = request.getParameter("speler2");
    	
    	String spelers[] = {spelerNaam, spelerNaam2};
    	engine.maakSpelersAan(spelers);
    	//this.huidigeSpeler = engine.geefHuidigeSpeler();
		jsonObj.put("Speler1", spelers[0]);
		jsonObj.put("Speler2", spelers[1]);
		response.getWriter().write(jsonObj.toString());
		
    }
	
    private void geefKaartenInHandVanDeHuidigeSpeler(HttpServletRequest request, HttpServletResponse response, SpelFuncties engine) throws ServletException, IOException {
    	JSONArray arrayObj = new JSONArray();
    	engine.trekKaart(engine.geefHuidigeSpeler().trekStapel(), 5);
    	
		for(int i=0; i<engine.geefHuidigeSpeler().kaartenInHand().size();i++){
			arrayObj.put(i, engine.geefHuidigeSpeler().kaartenInHand().get(i).naam());
		}
		
		response.getWriter().write(arrayObj.toString());
    }

    private void genereerActieKaart(HttpServletRequest request, HttpServletResponse response, SpelFuncties engine) throws ServletException, IOException {
    	
    	JSONArray arrayObj = new JSONArray();
    	List<Kaart> actieKaarten = engine.actiekaartenGenereren();
		for(int i=0; i <10;i++){
			arrayObj.put(i, actieKaarten.get(i).naam());
		}
		response.getWriter().write(arrayObj.toString());
    }
   
    
    
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setHeader("Access-Control-Allow-Origin", "*");
		//response.setContentType("application/json");
		
		SpelFuncties gameEngine = (SpelFuncties) request.getServletContext().getAttribute("SpelFuncties");
		if(gameEngine == null)
		{
			gameEngine = new SpelFuncties();
			request.getServletContext().setAttribute("SpelFuncties", gameEngine);
			
		}
		
		switch(request.getParameter("operation"))
		{
		case "spelerToevoegen":
			spelersToevoegen(request, response, gameEngine);
			break;
			
		case "geefKaartenInHand":
			geefKaartenInHandVanDeHuidigeSpeler(request, response, gameEngine);
			break;
		case "actieKaartenGeneren":
			genereerActieKaart(request, response, gameEngine);
			break;
		case "stopBeurt":
			
			gameEngine.volgendeSpeler();
		
			
			break;
			
		
		default:
			break;
		}	
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.getWriter().append("hello world vanuit post");
	}
}