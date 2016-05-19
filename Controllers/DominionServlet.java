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
	private SpelFuncties engine = new SpelFuncties();
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
		jsonObj.put("Speler1", spelers[0]);
		jsonObj.put("Speler2", spelers[1]);
		response.getWriter().write(jsonObj.toString());
		
    }
	
    private void geefKaartenInHandVanDeHuidigeSpeler(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	//huidigeSpeler = engine.geefHuidigeSpeler();
    	JSONArray arrayObj = new JSONArray();


    	engine.trekKaart(huidigeSpeler.trekStapel(), 5);
    	
		for(int i=0; i<huidigeSpeler.trekStapel().size();i++){
			arrayObj.put(i, huidigeSpeler.trekStapel().get(i).naam());
		}
		response.getWriter().write(arrayObj.toString());
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setHeader("Access-Control-Allow-Origin", "*");
		// FIXME: zou via getServletContext().get/setAttribute moeten werken
		//get servlet context
		
		if(engine == null){
			engine = new SpelFuncties();
			 //set servlet context
		}
		switch(request.getParameter("operation"))
		{
		case "spelerToevoegen":
			spelersToevoegen(request, response);
			break;
			
		case "huidigeSpeler":
			geefKaartenInHandVanDeHuidigeSpeler(request, response);
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