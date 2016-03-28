package JavaCode;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.annotation.Generated;
import javax.swing.*;

import org.eclipse.swt.widgets.Link;
import org.omg.CORBA.PUBLIC_MEMBER;


import java.util.*;
import sun.net.www.content.image.jpeg;

public class GUI extends JFrame {
    private JPanel pannelTop, pannelBottom, pannelRight, pannelLeft, pannelCenter, pannelCenterCenter;
    private JButton ButtonsTopPannel[],ButtonsBottomPannel[],ButtonsRightPannel[],ButtonsLeftPanel[];
    private JLabel actions,buys,coins;
    private int aantalActieKaarten = 10;
    private int aantalKaartenHand = 5;
    private ImageIcon image;
    private String[] actieKaarten = { "ambassador", "cellar", "chancellor", "chapel", "councilroom", "feast",
            "festival", "laboratory", "library", "market", "militia", "moat", "moneylender", "smithy", "spy",
            "thief", "village", "witch", "woodcutter", "workshop" };
    private String[] landKaarten = {"province","duchy","estate"};
    private String[] geldKaarten = {"copper","silver","gold","curse"};
    
    DeckActions deckActions = new DeckActions();
    
 
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
        	ButtonsTopPannel[i] = new JButton();
        	ButtonsTopPannel[i].setBorder(BorderFactory.createLineBorder(Color.white));}

         // labels 5 kaarten bottompanel
        ButtonsBottomPannel = new JButton[aantalKaartenHand];
        for (int i = 0; i < ButtonsBottomPannel.length; i++) {
        	ButtonsBottomPannel[i] = new JButton();
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
        	ButtonsLeftPanel[i] = new JButton();
        	pannelLeft.add(ButtonsLeftPanel[i]);}
       
 
        // right buttons generaten
        pannelRight.setLayout(new GridLayout(4, 1));
        ButtonsRightPannel = new JButton[4];
        for (int i = 0; i < 4; i++) {
        	ButtonsRightPannel[i] = new JButton();
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
    
 
    

   
    
    
    public void GenerateMoneyCards(){
    	
    	for (int i = 0; i < geldKaarten.length; i++) {

    	String path = "../images/Side/" + geldKaarten[i] + ".jpg"; 
    	image = new ImageIcon(getClass().getResource(path));
		ButtonsRightPannel[i].setIcon(image);
		
	}}

    public void GenerateFieldCards(){
	
	 for (int i = 0; i < landKaarten.length; i++) {
		 
		String path = "../images/Side/" + landKaarten[i] + ".jpg"; 
		image = new ImageIcon(getClass().getResource(path));
		ButtonsLeftPanel[i].setIcon(image);
		
	}
}
    

    
	public void displayActionCards(LinkedList<String> list){

   for (int i = 0; i < aantalActieKaarten; i++) {
	   
       String path = "../images/Action/" + list.get(i) + ".jpg"; 
       image = new ImageIcon(getClass().getResource(path));	
       
       
       ButtonsTopPannel[i].setIcon(image);
       ButtonsTopPannel[i].setName(list.get(i));
       ButtonsTopPannel[i].setBorder(BorderFactory.createEmptyBorder());
       
   }
	
   
}
	
	   
    public void AddDrawHandImages(LinkedList<String> list) {

		 for (int i = 0; i < aantalKaartenHand; i++) {
	            Random rng = new Random();
	            int randomGetal = rng.nextInt(list.size());
	            String path = "../images/" + list.get(randomGetal) + ".jpg";
	            image = new ImageIcon(getClass().getResource(path));
	            ButtonsBottomPannel[i].setIcon(image);
	           
	            ButtonsBottomPannel[i].setBorder(BorderFactory.createEmptyBorder());
	            ButtonsBottomPannel[i].setName(list.get(randomGetal).toLowerCase());

	        }
    }
 
	public void getNameButton(){
		for (int i = 0; i < ButtonsTopPannel.length; i++) {
			int getal = i;
			ButtonsTopPannel[i].addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {System.out.println("Select Card: "+ButtonsTopPannel[getal].getName());}
			} ); 
		}
		
	}
	public void getNameDrawhand(){
		for (int i = 0; i < ButtonsBottomPannel.length; i++) {
			int getal = i;
			ButtonsBottomPannel[i].addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {System.out.println("Select Card: "+ButtonsBottomPannel[getal].getName());}
			} ); 
		}
		
	}
	
	
    public void GenerateCardsField() {
    	displayActionCards(deckActions.GenerateActionCards());
    	GenerateFieldCards();
    	GenerateMoneyCards();  	 
    }
    
    
  
    

 
}
	
	


