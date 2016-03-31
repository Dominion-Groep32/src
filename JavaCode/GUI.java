package JavaCode;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.annotation.Generated;
import javax.imageio.ImageIO;
import javax.smartcardio.Card;
import javax.swing.*;

//import org.eclipse.swt.widgets.Link;
import org.omg.CORBA.PUBLIC_MEMBER;

import com.sun.javafx.geom.AreaOp.NZWindOp;

import javafx.scene.layout.Background;
import javafx.scene.layout.Border;
//import junit.framework.Test;

import java.util.*;
import sun.net.www.content.image.jpeg;

public class GUI extends JFrame {
    private JPanel pannelTop, pannelBottom, pannelRight, pannelLeft, pannelCenter, pannelCenterCenter,pannelCenterLeft,pannelCenterRight,pannelLeftTop,pannelLeftBottom,pannelRightTop,pannelRightBottom;
    private JButton ButtonsTopPannel[],ButtonsBottomPannel[],ButtonsRightPannel[],ButtonsLeftPanel[],b1,testbutton;
    private JLabel actions,buys,coins,l1,testlabel;
    private int aantalActieKaarten = 10;
    private int aantalKaartenHand = 5;
    private ImageIcon image;
    private String[] actieKaarten = { "ambassador", "cellar", "chancellor", "chapel", "councilroom", "feast",
            "festival", "laboratory", "library", "market", "militia", "moat", "moneylender", "smithy", "spy",
            "thief", "village", "witch", "woodcutter", "workshop" };
    private String[] landKaarten = {"province","duchy","estate"};
    private String[] geldKaarten = {"copper","silver","gold","curse"};
    
    DeckActions deckActions = new DeckActions();
    GameActions gameActions = new GameActions();
    LinkedList<String> playableField = new LinkedList<String>();
    
 
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
       // setLayout(new BorderLayout());
        //setContentPane(new JLabel(new ImageIcon(getClass().getResource("C:/Users/jensp/git/DominionProject/Dominion/src/images/background.jpg"))));
        
        
       
        image = new ImageIcon(getClass().getResource("../images/background.jpg"));
        
        l1=new JLabel();
        l1.setIcon(image);
        
        testbutton = new JButton();
       
      
        add(l1);
      setSize(2000,1100);
        // Just for refresh :) Not optional!
        
       
        
        
        
        
           	
    	// 4 sides pannels
        pannelRight = new JPanel();
        pannelLeft = new JPanel();
        pannelTop = new JPanel();
        pannelBottom = new JPanel();
        pannelCenter = new JPanel();
        pannelCenterCenter = new JPanel();
        pannelLeftTop = new JPanel();
        pannelLeftBottom = new JPanel();
        pannelRightTop = new JPanel();
        pannelRightBottom = new JPanel();
     
  
        
       
       
 
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
        //pannelLeft.setPreferredSize(new Dimension(30,30));
        add(pannelLeft, BorderLayout.WEST);
        add(pannelCenter, BorderLayout.CENTER);
        add(pannelRight, BorderLayout.EAST);
        
        //left in 2 delen 
        pannelLeft.setLayout(new BorderLayout());
        pannelLeft.add(pannelLeftTop, BorderLayout.NORTH);
        pannelLeft.add(pannelLeftBottom, BorderLayout.SOUTH);
       
        
        //right in 2 delen
        pannelRight.setLayout(new BorderLayout());
        pannelRight.add(pannelRightTop,BorderLayout.NORTH);
        pannelRight.add(pannelRightBottom, BorderLayout.SOUTH);
        
        
        // center in 3 delen boven elkaar verdelen
        pannelCenter.setLayout(new BorderLayout());
        pannelCenter.add(pannelTop, BorderLayout.NORTH);
        pannelCenter.add(pannelCenterCenter, BorderLayout.CENTER);
        pannelCenter.add(pannelBottom, BorderLayout.SOUTH);
 
        //left buttons generaten
        pannelLeftTop.setLayout(new GridLayout(3,1 ));
        ButtonsLeftPanel = new JButton[3];
        for (int i = 0; i < 3; i++) {
        	ButtonsLeftPanel[i] = new JButton();
        	ButtonsLeftPanel[i].setPreferredSize(new Dimension(120, 190));
        	pannelLeftTop.add(ButtonsLeftPanel[i]);}
        
       
 
        // right buttons generaten
        pannelRightTop.setLayout(new GridLayout(4, 1));
        ButtonsRightPannel = new JButton[4];
        for (int i = 0; i < 4; i++) {
        	ButtonsRightPannel[i] = new JButton();
        	ButtonsRightPannel[i].setPreferredSize(new Dimension(120, 190));
        	
        	pannelRightTop.add(ButtonsRightPannel[i]);}
    
        // top buttons generaten
     
        //pannelTop.setLayout(new GridLayout(2, aantalActieKaarten / 2));
        pannelTop.setLayout(new FlowLayout());
        for (int i = 0; i < ButtonsTopPannel.length; i++) {
            pannelTop.add(ButtonsTopPannel[i]);
           
        }
        
 
        
        // bottom buttons generaten
        pannelBottom.setLayout(new FlowLayout());
        for (int i = 0; i < ButtonsBottomPannel.length; i++) {
            pannelBottom.add(ButtonsBottomPannel[i]);
            
       ;}}
 
   
    public void InitListeners() {
    	// acties (buttons/labels...etc)
    	
    	

    	
    	}
	public void getNameButton(){
		for (int i = 0; i < ButtonsTopPannel.length; i++) {
			int getal = i;
			ButtonsTopPannel[i].addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					gameActions.getCardDetails(ButtonsTopPannel[getal].getName());

					}
			} ); 
		}
		
	}
	public void getNameDrawhand(){
		for (int i = 0; i < ButtonsBottomPannel.length; i++) {
			int getal = i;
			
			ButtonsBottomPannel[i].addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
				String selectedCardName = ButtonsBottomPannel[getal].getName();
				playableField.add(selectedCardName);
				gameActions.getCardDetails(selectedCardName);
				gameActions.showTypeOfPRINT("playable field");
				deckActions.displayDeck(playableField);
				
				ButtonsBottomPannel[getal].setVisible(false);
				pannelCenterCenter.add(testbutton);
				image = new ImageIcon(getClass().getResource("../images/"+ButtonsBottomPannel[getal].getName()+".jpg"));
				testbutton.setIcon(image);
				testbutton.setPreferredSize(new Dimension(190, 300));
				}
				
				
			} ); 
		}
		
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
 

	
	
    public void GenerateCardsField() {
    	displayActionCards(deckActions.GenerateActionCards());
    	GenerateFieldCards();
    	GenerateMoneyCards();  	 
    	AddDrawHandImages(deckActions.startDeckCards());
    }
    
    
  
    

 
}
	
	


