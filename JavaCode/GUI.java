package JavaCode;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.annotation.Generated;
import javax.swing.*;


import org.omg.CORBA.PUBLIC_MEMBER;


import java.util.*;
import sun.net.www.content.image.jpeg;

public class GUI extends JFrame {
    private JPanel pannelTop, pannelBottom, pannelRight, pannelLeft, pannelCenter, pannelCenterCenter;
    private JButton b1, b2, b3, b4,ButtonsTopPannel[],ButtonsBottomPannel[],ButtonsRightPannel[],ButtonsLeftPanel[];
    private JLabel labelsTopPannel[], labelsBottomPannel[],labelsRightPannel[],actions,buys,coins;
    private int aantalActieKaarten = 10;
    private int aantalKaartenHand = 5;
    private ImageIcon image;
    private JScrollPane vertical;
    
    
 
    public GUI() {
        InitComponents();
        LayoutComponents();
        InitListeners();
    }

    // maakt componenten
    public void InitComponents() {
        
    	 // venster
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocation(50, 50);
        setTitle("JENS IS PRO");
        setVisible(true);
        setExtendedState(this.getExtendedState() | this.MAXIMIZED_BOTH);
    	
    	// 4 sides pannels
        pannelRight = new JPanel();
        pannelLeft = new JPanel();
        pannelTop = new JPanel();
        pannelBottom = new JPanel();
        pannelCenter = new JPanel();
        pannelCenterCenter = new JPanel();
       
 
        // buttons 10 kaarten toppanel
        ButtonsTopPannel = new JButton[aantalActieKaarten];
        for (int i = 0; i < ButtonsTopPannel.length; i++) {
        	ButtonsTopPannel[i] = new JButton(i + "");
        	ButtonsTopPannel[i].setBorder(BorderFactory.createLineBorder(Color.white));}

         // labels 5 kaarten bottompanel
        ButtonsBottomPannel = new JButton[aantalKaartenHand];
        for (int i = 0; i < ButtonsBottomPannel.length; i++) {
        	ButtonsBottomPannel[i] = new JButton(i + "");
        	ButtonsBottomPannel[i].setBorder(BorderFactory.createLineBorder(Color.white));}}
    
    // geeft waardes aan componenten
    public void LayoutComponents() {
 
        // main frame in 3 verdelen
        setLayout(new BorderLayout());
        add(pannelLeft, BorderLayout.WEST);
        add(pannelCenter, BorderLayout.CENTER);
        add(pannelRight, BorderLayout.EAST);
 
        // center in 3 delen boven elkaar verdelen
        pannelCenter.setLayout(new BorderLayout());
        pannelCenter.add(pannelTop, BorderLayout.NORTH);
        pannelCenter.add(pannelCenterCenter, BorderLayout.CENTER);
        pannelCenter.add(pannelBottom, BorderLayout.SOUTH);
 
        //left buttons generaten
        pannelLeft.setLayout(new GridLayout(3, 1));
        ButtonsLeftPanel = new JButton[3];
        for (int i = 0; i < 3; i++) {
        	ButtonsLeftPanel[i] = new JButton(i +"");
        	pannelLeft.add(ButtonsLeftPanel[i]);}
       
 
        // right buttons generaten
        pannelRight.setLayout(new GridLayout(4, 1));
        ButtonsRightPannel = new JButton[4];
        for (int i = 0; i < 4; i++) {
        	ButtonsRightPannel[i] = new JButton(i + "");
        	pannelRight.add(ButtonsRightPannel[i]);}
    
        // top buttons generaten
     
        pannelTop.setLayout(new GridLayout(2, aantalActieKaarten / 2));
        
        for (int i = 0; i < ButtonsTopPannel.length; i++) {
            pannelTop.add(ButtonsTopPannel[i]);}
 
        
        // bottom buttons generaten
        pannelBottom.setLayout(new FlowLayout());
        for (int i = 0; i < ButtonsBottomPannel.length; i++) {
            pannelBottom.add(ButtonsBottomPannel[i]);}}
 
   
    public void InitListeners() {
    	// acties (buttons/labels...etc)
    	}
    
    public void GenerateCardsHand() {
    	 LinkedList list = new LinkedList();
    	 
		 for (int i = 0; i < 7; i++) {list.add("copper");}
		 for (int j = 0; j < 3; j++) {list.add("estate");}


		 for (int i = 0; i < aantalKaartenHand; i++) {
	            Random rng = new Random();
	            int randomGetal = rng.nextInt(list.size());
	           
	            String path = "../images/" + list.get(randomGetal) + ".jpg";
	            image = new ImageIcon(getClass().getResource(path));
	            ButtonsBottomPannel[i].setIcon(image);

	        }
    }
    
    public void GenerateMoneyCards(){
    	String[] geldKaarten = {"copper","silver","gold","curse"};
    	for (int i = 0; i < geldKaarten.length; i++) {
		 
		 
    		String path = "../images/Side/" + geldKaarten[i] + ".jpg"; 
    		image = new ImageIcon(getClass().getResource(path));
		ButtonsRightPannel[i].setIcon(image);
		
	}}

    public void GenerateFieldCards(){
	String[] landKaarten = {"province","duchy","estate"};
	 for (int i = 0; i < landKaarten.length; i++) {
		 
		String path = "../images/Side/" + landKaarten[i] + ".jpg"; 
		image = new ImageIcon(getClass().getResource(path));
		ButtonsLeftPanel[i].setIcon(image);
		
	}
}
	public void GenerateActionCards(){
	LinkedList actieKaartenList = new LinkedList();
	String[] actieKaarten = { "ambassador", "cellar", "chancellor", "chapel", "councilroom", "feast",
           "festival", "laboratory", "library", "market", "militia", "moat", "moneylender", "smithy", "spy",
           "thief", "village", "witch", "woodcutter", "workshop" };
	Collections.shuffle((Arrays.asList(actieKaarten)));
	for (int i = 0; i < actieKaarten.length; i++) {actieKaartenList.add(actieKaarten[i]);}
	
	    

   for (int i = 0; i < aantalActieKaarten; i++) {
	   
       String path = "../images/Action/" + actieKaartenList.get(i) + ".jpg"; 
       image = new ImageIcon(getClass().getResource(path));
       ButtonsTopPannel[i].setIcon(image);
       
   }
	
}
 
    public void GenerateCardsField() {
    	GenerateActionCards();
    	GenerateFieldCards();
    	GenerateMoneyCards();  	 
    }
    

 
}
	
	


